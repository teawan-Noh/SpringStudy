package com.min.edu.ctrl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.min.edu.dto.AnswerBoard_Dto;
import com.min.edu.dto.Member_Dto;
import com.min.edu.dto.RowNum_Dto;
import com.min.edu.model.IAnswerBoardService;

@RestController
public class PageController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IAnswerBoardService service;
	
	@PostMapping(value = "/page.do", produces = "apllication/text; charset=UTF-8;")
	public String paging(HttpSession session,RowNum_Dto rowDto) {
		logger.info("페이징 컨트롤러 세션 확인 페이지 {}",session.getAttribute("row"));
		logger.info("페이징 컨트롤러 세션 확인 로그인 {}",session.getAttribute("mem"));
		logger.info("페이징 컨트롤러 화면 요청값 {}", rowDto);
		
		Member_Dto mDto = (Member_Dto)session.getAttribute("mem");
		JSONObject json = null;
		
		if(mDto.getAuth().equalsIgnoreCase("U")) {
			rowDto.setTotal(service.userBoardListTotal());
			json = objectJSON(service.userBoardListRow(rowDto),rowDto, mDto);
		}else {
			rowDto.setTotal(service.adminBoardListTotal());
			json = objectJSON(service.adminBoardListRow(rowDto),rowDto, mDto);
		}
		
		session.removeAttribute("row");
		session.setAttribute("row", rowDto);
		
//		return "{\"test\":\"chistams\"}";
		return json.toString();
	}
	
	// 생성된 글과 전달된 페이징 값을 JSON {"lists" : [{},{}..], "row":{"","",""}}
	// 반환을 Map으로 만들고 jackson-binding을 사용하면 자동으로 JSON변환
	// text -javascript에서 JSON변환 text도 반환하고 (1) dataType:'JSON' 선언 (2) var json = JSON.parse(msg)
	@SuppressWarnings({ "unchecked", "null" })
	public JSONObject objectJSON(List<AnswerBoard_Dto> lists, //"lists" : [{},{}..],
								RowNum_Dto row,// "row",{"","",""}
								Member_Dto mem) { // 사용자 판단
		JSONObject json = new JSONObject();; // 전체 JSON 객체 {"lists": , "row":}
		JSONArray jlist = new JSONArray(); // lists의 여러개의 dto JSONObject를 담고 있는객체  [{},{}..]
		JSONObject jdto = null; // row에 관련된 JSONObject {"","",""}
		
		for (AnswerBoard_Dto o : lists) {
			jdto = new JSONObject();
			jdto.put("seq", o.getSeq());
			jdto.put("id", o.getId());
			jdto.put("title", o.getTitle());
			jdto.put("content", o.getContent());
			jdto.put("readcount", o.getReadcount());
			jdto.put("delflag", o.getDelflag());
			jdto.put("regdate", o.getRegdate());
			jdto.put("memid", mem.getId());
			jlist.add(jdto);
		}
		
		
		// 페이징에 관련된 처리
		jdto = new JSONObject();
		jdto.put("pagelist", row.getPageList());
		jdto.put("index", row.getIndex());
		jdto.put("pagenum", row.getPageNum());
		jdto.put("listnum", row.getListNum());
		jdto.put("total", row.getTotal());
		jdto.put("count", row.getCount());
		
		
		json.put("lists", jlist);
		json.put("row", jdto);
		
		
		return json;
	}
	
}
