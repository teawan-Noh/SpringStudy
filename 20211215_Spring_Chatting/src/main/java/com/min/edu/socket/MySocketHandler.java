package com.min.edu.socket;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component(value = "wsChat.do")
public class MySocketHandler extends TextWebSocketHandler {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 채팅에 참여하는 웹소켓 세션을 담아 놓음
	//채팅의 내용을 보내는 대상자
	private ArrayList<WebSocketSession> list; 
	
	//생성된 webSocketSession에 1:1로 매핑되는 nuckName을 가지고 있는 객체
	private Map<WebSocketSession, String> map = new HashMap<WebSocketSession, String>();
	
	public MySocketHandler() {
		list = new ArrayList<WebSocketSession>();
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.info("웹소켓 커넥션 생성 afterConnectionEstablished");
		super.afterConnectionEstablished(session);
		list.add(session); //채팅에 참여되면 생성된 websocket 객체를 담아줌
		logger.info("웹소켓에 현재 참여하고 있는 SessionID: " + session.getId() + " /참여 인원: " + list.size());
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		logger.info("웹소켓 모든 참여자에게 메세지 전달 handleTextMessage");
		String msg = message.getPayload(); // 객체에서 전달받은 text를 가지고 있는 객체 
		String msgStringToString = msg.toString(); // 사용할 수 있는 String 객체가 됨
		
		logger.info("전달된 getPayload : {}", msg);
		logger.info("전달된 toString : {}", msgStringToString);
		
		if(msg != null && !msg.equals("")) { //대화 내용이 전달됐다
			//1) 첫번째 채팅에 참여하여 map에 session과 nickName을 담아줌
			//   참여중인 다른 사람에게 입장 메세지 전송
			// 머릿말에 #$nickNam_이 포함되어 있다면 Map에 (WebSocketSession, nickName)을 담아줌 ex) #$nick_꼬끼오 -> 꼬끼오 map.put(session,"꼬끼오")
			if(msg.indexOf("#$nick_") != -1) {
				map.put(session, msg.replace("#$nick_", ""));
				logger.info("참여한 자신의 nickName의 map값 : {}", map.get(session));
				
				//입장 메세지를 보내줌
				for (WebSocketSession s : list) {
					//현재 자신은 뺴고 보내고 싶다 or 그룹 채팅을 만들고 싶다
//					if(s != session) {}
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH24:mm:ss");
					String out = sdf.format(new Date());
					s.sendMessage(new TextMessage("<font color='forestgreen' size='5px'>"+map.get(session)+"님이 입장하셨습니다.("+out+")</font>"));
				}
			}else {
				//2) 두번째 부터는 대화의 내용이 전달 될 수 있도록 한다.
				for (WebSocketSession s : list) {
					String sendMsg = "<font color='gray'>" + msg +">";
					s.sendMessage(new TextMessage(sendMsg));
				}
			}
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		logger.info("웹소켓 삭제 afterConnectionClosed");
		super.afterConnectionClosed(session, status);
		// 채팅이 닫히거나 webSocket이 close 됐다면
		// close를 요청한 websocketsession은 삭제하여 데이터가 전송되지 않도록 함
		// websocket의 전체 참여 인원은 list에 담겨있음
		list.remove(session);
		
		
		//화면에 퇴장 메세지 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH24:mm:ss");
		String out = sdf.format(new Date());
		
		for (WebSocketSession s : list) { //list에는 현재 참여중인 모든 참여자 webSocketSession이 담겨있다
			s.sendMessage(new TextMessage("<font color='tomato' size='5px'>"+map.get(session)+"님이 퇴장하셨습니다.("+out+")</font>"));
		}
		map.remove(session);
	}

}
