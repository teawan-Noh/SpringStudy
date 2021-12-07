package com.min.edu.comm;

/**
 * 전체글 조회에서 답글의 표기(이미지)를 위한 클레스(UseBean)
 * @author taewanNOH
 * @since 2021. 11. 24.
 */
public class ReplyPhoto {

	private int depth;

	/**
	 * JSP에서 입력받는 답글 깊이 Setter 메소드
	 * @param depth
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * JSP에서 출력하는 답글에 따른 이미지 Getter 메소드
	 * @return 깊이 + 이미지
	 */
	public String getPhoto() {
		String result = "";
		String blank = "&nbsp;&nbsp;&nbsp;&nbsp;";
		String img = "<img alt='답글' src='./imges/reply.png' title='답글'>";
		if (depth > 0) {
			for (int i = 0; i < depth; i++) {
				result += blank;
			}
			result += img;
		}
		
		return result;
	}
}
