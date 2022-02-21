package com.min.edu.book;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/*
	"meta": {
   	"is_end": false,
   	"pageable_count": 13,
   	"total_count": 15
}
*/
//kakaoBook 검색을 통해서 나오는 JSON의 Meda값의 결과를 매핑 및 담는 객체
//xml vs html 차이점 : well-formed, valid
//JSON도 XML의 Nodetree의 순서가 valid 해야한다.

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(
		{
			"is_end", 
		   	"pageable_count",
		   	"total_count",
		}
)
public class Meta {

	@JsonPropertyOrder("is_end")
	private Boolean isEnd;
	@JsonPropertyOrder("pageable_count")
	private Integer pageableCount;
	@JsonPropertyOrder("total_count")
	private Integer totalCount;
	
	@JsonPropertyOrder("is_end")
	public Boolean getIsEnd() {
		return isEnd;
	}
	@JsonPropertyOrder("is_end")
	public void setIsEnd(Boolean isEnd) {
		this.isEnd = isEnd;
	}
	
	@JsonPropertyOrder("pageable_count")
	public Integer getPageableCount() {
		return pageableCount;
	}
	@JsonPropertyOrder("pageable_count")
	public void setPageableCount(Integer pageableCount) {
		this.pageableCount = pageableCount;
	}
	
	@JsonPropertyOrder("total_count")
	public Integer getTotalCount() {
		return totalCount;
	}
	@JsonPropertyOrder("total_count")
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	
}
