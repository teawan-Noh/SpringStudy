package com.min.edu.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.min.edu.dto.AnswerBoard_Dto;
import com.min.edu.dto.Member_Dto;
import com.min.edu.dto.RowNum_Dto;
import com.min.edu.model.IAnswerBoardService;

@Controller
public class BoardController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IAnswerBoardService service;
	
	//TODO 005. 004에서 Redirect로 요청하여 정보를 출력하는 페이지
	//TODO 011. 게시글 전체 보기
	@GetMapping(value = "/boardList.do")
	public String boardList(Model model, HttpSession session,
										@SessionAttribute("mem2") Member_Dto mdto) {
		logger.info("BoardController boardList @SessionAttribute {}", mdto);
		logger.info("BoardController boardList HttpSession {}" , (Member_Dto)session.getAttribute("mem"));
		
		List<AnswerBoard_Dto> lists = null;
		RowNum_Dto rowDto = null;
		
		if(session.getAttribute("row") == null) {
			rowDto = new RowNum_Dto();
		}else {
			rowDto = (RowNum_Dto)session.getAttribute("row");
		}
		
		if(mdto.getAuth().equals("U")) {
			rowDto.setTotal(service.userBoardListTotal());
			lists = service.userBoardListRow(rowDto);
		}else if(mdto.getAuth().equals("A")) {
			rowDto.setTotal(service.adminBoardListTotal());
			lists = service.adminBoardListRow(rowDto);
		}
		model.addAttribute("lists", lists);
		model.addAttribute("row", rowDto);
		return "boardList";
	}

	
	//TODO 012. 다중삭제
	@PostMapping(value="/multiDel.do")
	public String multiDel(@RequestParam ArrayList<String> chkVal) {
		logger.info("BoardController multiDel 관리자 다중삭제 {}",chkVal);
		boolean isc = service.deleteBoard(chkVal);
		return isc?"redirect:/boardList.do":"redirect:/logout.do";
	}
	
	//TODO 013. 게시글 수정
	@SuppressWarnings("unchecked")
	@PostMapping(value="/modifyForm.do", produces = "application/text; charset=UTF-8;")
	@ResponseBody
	public String modifyForm(String seq) {
		AnswerBoard_Dto dto = (AnswerBoard_Dto) service.getOneBoard(seq);
		JSONObject json = new JSONObject();
		json.put("seq", dto.getSeq());
		json.put("id", dto.getId());
		json.put("title", dto.getTitle());
		json.put("content", dto.getContent());
		json.put("regdate", dto.getRegdate());
		
		System.out.println("toString 출력"+json.toString());
		System.out.println("toJSONString 출력"+json.toJSONString());
		
		return json.toString();
	}
	
	//TODO 014. 게시글 수정값 DB에 반영
	@PostMapping(value="/modify.do")
	public String modify(AnswerBoard_Dto dto) {
		logger.info("BoardController modify 수정값 반영 {}", dto);
		boolean isc = service.modifyBoard(dto);
		return isc ? "redirect:/boardList.do":"redirect:/logout.do";
	}
	
	//TODO 015. 자신의 글 삭제 delflag
	@GetMapping(value="/del.do")
	public String del(String[] seq, HttpServletResponse resp, HttpSession session) throws IOException {
		
		logger.info("BoardController del 삭제될 SEQ값 {}", Arrays.toString(seq));
		logger.info("BoardController 삭제할 대상자 {}", (Member_Dto)session.getAttribute("mem"));
		Member_Dto sDto = (Member_Dto)session.getAttribute("mem");
		
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs", seq);
		
		AnswerBoard_Dto dto = service.getOneBoard(seq[0]);
		if(dto.getId().equals(sDto.getId())||sDto.getAuth().equals("A")) {
			boolean isc = service.delflagBoard(map);
			if(isc) {
				return "redirect:/boardList.do";
			}else {
				resp.setContentType("text/html; charset=UTF-8");
				PrintWriter out = resp.getWriter();
				out.println("<script>alert('처리가 잘못되었습니다.'); location.href='./logout.do';</script>");
				out.flush();
				return null;
			}
		}
		return null;
	}
	
	//TODO 016. 사용자 새 게시글 작성
	@PostMapping(value="/write.do")
	public String write(AnswerBoard_Dto dto, HttpSession session, HttpServletResponse resp) throws IOException {
		logger.info("BoardController 새 글 입력 {}", dto);
		Member_Dto mdto = (Member_Dto)session.getAttribute("mem");
		dto.setId(mdto.getId());
		
		boolean isc = service.writeBoard(dto);
		if(isc) {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('성공적으로 입력이 완료되었습니다.'); location.href='./boardList.do';</script>");
			out.flush();
			return null;
		}else {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('입력 처리가 잘못되었습니다.'); location.href='./logout.do';</script>");
			out.flush();
			return null;
		}
	}
	
	//TODO 017. 게시글의 답글을 작성
	@PostMapping(value="/replyForm.do")
	@ResponseBody
	public Map<String, Object> replyForm(String seq, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		logger.info("BoardController 답글 입력 기준 부모 {}",seq);
		
		Member_Dto mdto = (Member_Dto)session.getAttribute("mem");
		AnswerBoard_Dto adto = service.getOneBoard(seq);
		
		map.put("session_id", mdto.getId());
		map.put("obj", adto);
		
		logger.info("BoardController replyForm 반환1 {}",map.get("session_id"));
		logger.info("BoardController replyForm 반환2 {}",map.get("obj"));
		
		return map;
		
	}
	
	//TODO 018. 사용자 답글 작성
	@PostMapping(value="/reply.do")
	public String reply(AnswerBoard_Dto dto, HttpSession session, @ModelAttribute("mem2") Member_Dto mdto, @SessionAttribute("mem2") Member_Dto sdto) {
		logger.info("BoardController 답글 전달 값{}" ,dto);
		logger.info("BoardController HttpSession {}" ,(Member_Dto)session.getAttribute("mem"));
		logger.info("BoardController @ModelAttribute {}" ,mdto);
		logger.info("BoardController  @SessionAttribute {}" ,sdto);
		
		dto.setId(sdto.getId());
		
		boolean isc = service.reply(dto);
		return isc?"redirect:/boardList.do":"redirect:/logout.do";
	}
}













