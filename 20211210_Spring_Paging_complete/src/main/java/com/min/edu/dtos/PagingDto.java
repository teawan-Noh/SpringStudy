package com.min.edu.dtos;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//PagingDto
public class PagingDto {
	
	@Override
	public String toString() {
		return "PagingDto [logger=" + logger + ", pageCnt=" + pageCnt + ", index=" + index + ", pageStartNum="
				+ pageStartNum + ", listCnt=" + listCnt + ", total=" + total + "]";
	}

	Logger logger = LoggerFactory.getLogger(PagingDto.class);
	
	private int pageCnt;		//출력할 페이지 번호 개수
	private int index;			//출력할 페이지 번호
	private int pageStartNum;	//출력할 페이지 시작번호
	private int listCnt;		//출력한 리스트 개수
	private int total;
	//리스트의 총 개수
	public PagingDto() {
	}
	
	{
		logger.info("=========PagingDto 초기화 블럭 실행 시간 : {}============", new Date() );
		pageCnt = 5;
		index = 0;
		pageStartNum = 1;
		listCnt = 5;
	}
	

	public PagingDto(String index, String pageStartNum, String listCnt) {
		logger.info("=========PagingDto 초기화 블럭 실행 시간 : {}============",new Date());
		//view에서 전달받은 parameter는 "" or null 객체로 판단하면
		//index의 초기값이 0일 수 있다. 하지만 parameter를 객체로 받을 경우 0과 값이 없음을 구분하기 편함.
		if(index != null) {
			this.index = Integer.parseInt(index);			
		}
		if(pageStartNum != null) {
			this.pageStartNum = Integer.parseInt(pageStartNum);
		}
		if(listCnt != null) {
			this.listCnt = Integer.parseInt(listCnt);			
		}
	}
	
	public int getStart() {
		logger.info("=========PagingDto getStart() 블럭 실행 시간 : {}============",new Date());
		return index*listCnt +1;
	}
	public int getLast() {
		logger.info("=========PagingDto getLast() 블럭 실행 시간 : {}============",new Date());
		return (index*listCnt)+listCnt;
	}
	
	public int getPageLastNum() {
		logger.info("=========PagingDto getLast() 블럭 실행 시간 : {}============",new Date());
		//전채 개수 - 출력리스트 *(시작번호-1)
		//111 - 5(1-1) = 111
		int remainListCnt = total - listCnt * (pageStartNum - 1);
		
		//
		int remainPageCnt = remainListCnt / listCnt;
		// 111%5 1= => 23
		if(remainListCnt % listCnt != 0) {
			remainPageCnt++;
		}
		
		int pageLastNum = 0;
		
		if(remainListCnt <= listCnt) {
			pageLastNum = pageStartNum;
		}else if(remainPageCnt <= pageCnt) {
			pageLastNum = remainPageCnt + pageStartNum - 1;
		}else {
			pageLastNum = pageCnt + pageStartNum -1;
		}
		
		return pageLastNum;
	}

	
	public int getPageCnt() {
		return pageCnt;
	}

	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getPageStartNum() {
		return pageStartNum;
	}

	public void setPageStartNum(int pageStartNum) {
		this.pageStartNum = pageStartNum;
	}

	public int getListCnt() {
		return listCnt;
	}

	public void setListCnt(int listCnt) {
		this.listCnt = listCnt;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
}













