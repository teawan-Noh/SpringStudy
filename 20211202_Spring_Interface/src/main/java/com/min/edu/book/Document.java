package com.min.edu.book;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(
		 {
	            "authors",
	            "contents",
	            "datetime",
	            "isbn",
	            "price",
	            "publisher",
	            "sale_price",
	            "status",
	            "thumbnail",
	            "title",
	            "translators",
	            "url"
	    }
		)
public class Document {
	@JsonPropertyOrder("authors")
	private List<String> authors = null;
	@JsonPropertyOrder("contents")
	private String contents;
	@JsonPropertyOrder("datetime")
	private String datetime;
	@JsonPropertyOrder("isbn")
	private String isbn;
	@JsonPropertyOrder("price")
	private Integer price;
	@JsonPropertyOrder("publisher")
	private String publisher;
	@JsonPropertyOrder("sale_price")
	private Integer sale_price;
	@JsonPropertyOrder("status")
	private String status;
	@JsonPropertyOrder("thumbnail")
	private String thumbnail;
	@JsonPropertyOrder("title")
	private String title;
	@JsonPropertyOrder("translators")
	private List<String> translators = null;
	@JsonPropertyOrder("url")
	private String url;
	
	@JsonPropertyOrder("authors")
	public List<String> getAuthors() {
		return authors;
	}
	@JsonPropertyOrder("authors")
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	@JsonPropertyOrder("contents")
	public String getContents() {
		return contents;
	}
	@JsonPropertyOrder("contents")
	public void setContents(String contents) {
		this.contents = contents;
	}
	@JsonPropertyOrder("datetime")
	public String getDatetime() {
		return datetime;
	}
	@JsonPropertyOrder("datetime")
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	@JsonPropertyOrder("isbn")
	public String getIsbn() {
		return isbn;
	}
	@JsonPropertyOrder("isbn")
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	@JsonPropertyOrder("price")
	public Integer getPrice() {
		return price;
	}
	@JsonPropertyOrder("price")
	public void setPrice(Integer price) {
		this.price = price;
	}
	@JsonPropertyOrder("publisher")
	public String getPublisher() {
		return publisher;
	}
	@JsonPropertyOrder("publisher")
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	@JsonPropertyOrder("sale_price")
	public Integer getSale_price() {
		return sale_price;
	}
	@JsonPropertyOrder("sale_price")
	public void setSale_price(Integer sale_price) {
		this.sale_price = sale_price;
	}
	@JsonPropertyOrder("status")
	public String getStatus() {
		return status;
	}
	@JsonPropertyOrder("status")
	public void setStatus(String status) {
		this.status = status;
	}
	@JsonPropertyOrder("thumbnail")
	public String getThumbnail() {
		return thumbnail;
	}
	@JsonPropertyOrder("thumbnail")
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	@JsonPropertyOrder("title")
	public String getTitle() {
		return title;
	}
	@JsonPropertyOrder("title")
	public void setTitle(String title) {
		this.title = title;
	}
	@JsonPropertyOrder("translators")
	public List<String> getTranslators() {
		return translators;
	}
	@JsonPropertyOrder("translators")
	public void setTranslators(List<String> translators) {
		this.translators = translators;
	}
	@JsonPropertyOrder("url")
	public String getUrl() {
		return url;
	}
	@JsonPropertyOrder("url")
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
