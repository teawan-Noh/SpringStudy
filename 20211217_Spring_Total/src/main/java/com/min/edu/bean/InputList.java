package com.min.edu.bean;

import java.util.Iterator;
import java.util.List;

import com.min.edu.dto.AnswerBoard_Dto;
import com.min.edu.dto.Member_Dto;

public class InputList {

	private List<AnswerBoard_Dto> lists;
	private Member_Dto mem;
	
	public void setLists(List<AnswerBoard_Dto> lists) {
		this.lists = lists;
	}
	public void setMem(Member_Dto mem) {
		this.mem = mem;
	}
	

	//전체리스트
	public String getListForm() {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < lists.size(); i++) {
			sb.append(trform(lists.get(i))); // 한 <tr>의 내용을 작성하는 메소드
		}
		return sb.toString();
	}
	
	// 화면을 구성
	private Object trform(AnswerBoard_Dto dto) {
		StringBuffer sb = new StringBuffer();
		
		int n = 0;
		if(mem.getAuth().equals("A")) {
			n = 7;
		}else {
			n = 5;
		}
		
			sb.append("	<tr>                                                                                   ") ;
			if(mem.getAuth().equals("A")) {
				sb.append("	<td><input type='checkbox' name='chkVal' value='"+dto.getSeq()+"'> </td>                ") ;
			}
			
			sb.append("	<td>"+dto.getSeq()+"</td>                                                               ") ;
			sb.append("	<td>                                                                                   ") ;
			sb.append("		<a data-toggle='collapse' href='#collapse"+dto.getSeq()+"' onclick='collapse(\""+dto.getSeq()+"\")'>"+dto.getTitle()+"</a>   ") ;
			sb.append("	</td>                                                                                  ") ;
			sb.append("	<td>"+dto.getId()+"</td>                                                                ") ;
			sb.append("	<td>"+dto.getReadcount()+"</td>                                                         ") ;
			if(mem.getAuth().equals("A")) {
				sb.append("	<td>"+dto.getDelflag()+"</td>                                                           ") ;
			}
			sb.append("	<td>"+dto.getRegdate()+"</td>                                                           ") ;
			sb.append("</tr>                                                                                   ") ;
			sb.append("<tr>                                                                                    ") ;
			sb.append("	<td colspan='"+n+"'>                                                                       ") ;
			sb.append("		<div id='collapse"+dto.getSeq()+"' class='panel-collapse collapse'>                 ") ;
			sb.append("			<div class='form-group'>                                                       ") ;
			sb.append("				<label>내용</label>                                                        ") ;
			sb.append("				<textarea rows='5'  class='form-control' >"+dto.getContent()+"</textarea>   ") ;
			sb.append("			</div>                                                                         ") ;
			sb.append("			<div class='form-group'>                                                       ") ;
			
			if(mem.getId().equals(dto.getId())) {
				sb.append("					<input type='button' class='btn btn-success' value='글수정' onclick='modify(\""+dto.getSeq()+"\")'>          ") ;
			}
			if(mem.getId().equals(dto.getId()) ||  mem.getAuth().equals("A")) {
				sb.append("					<input type='button' class='btn btn-warning' value='글삭제' onclick='del(\""+dto.getSeq()+"\")'>          ") ;
			}
			if(mem.getAuth().equals("U")) {
				sb.append("					<input type='button' class='btn btn-info' value='답글' onclick='reply(\""+dto.getSeq()+"\")'>               ") ;
			}
			sb.append("			</div>                                                                         ") ;
			sb.append("		</div>                                                                             ") ;
			sb.append("	</td>                                                                                  ") ;
			sb.append("</tr>                                                                                   ") ;
		
		return sb.toString();
	}
	
	
}









