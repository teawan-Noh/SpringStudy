package com.min.edu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EduVo {

	//@Data 얘가 getter,setter,tostring,생성자 다 해줌
	//@Getter : 게터
	//@Setter : 세터
	//@ToString : toString()
	//@NoArgsConstructor : 기본생성자
	//@AllArgsConstructor : 다 들어있는 생성자
	
	private int seq;
	private String id;
	private String title;
	private String content;
	private int refer;
	private int step;
	private int depth;
	private String delflag;
	private String regdate;
}
