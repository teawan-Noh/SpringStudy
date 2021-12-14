package com.min.edu.book;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"documents","meta"})
public class KakaoBook {

	@JsonPropertyOrder("documents")
	private List<Document> documents;
	
	@JsonPropertyOrder("meta")
	private Meta meta;

	@JsonPropertyOrder("documents")
	public List<Document> getDocuments() {
		return documents;
	}
	@JsonPropertyOrder("documents")
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	@JsonPropertyOrder("meta")
	public Meta getMeta() {
		return meta;
	}
	@JsonPropertyOrder("meta")
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	
	
	
	
}
