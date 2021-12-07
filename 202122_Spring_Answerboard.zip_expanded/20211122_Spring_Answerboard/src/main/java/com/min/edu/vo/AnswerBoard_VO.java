package com.min.edu.vo;

/**
 * hr 계정의 Answerboard와 매핑되는 VO/DTO 클레스
 * @author taewanNoh
 * @since 2021. 11. 22
 */
public class AnswerBoard_VO {

	private int seq;
	private String id;
	private String title;
	private String content;
	private int refer;
	private int step;
	private int depth;
	private String delflag;
	private String regdate;
	
	public AnswerBoard_VO() {
	}

	public AnswerBoard_VO(int seq, String id, String title, String content) {
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRefer() {
		return refer;
	}

	public void setRefer(int refer) {
		this.refer = refer;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "AnswerBoard_VO [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + "]";
	}
	
	
	
}
