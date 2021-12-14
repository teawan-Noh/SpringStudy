package com.min.edu.bookctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.min.edu.book.KakaoBook;

@Controller
public class APIController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static String kakao_book_rest_uri = "https://dapi.kakao.com/v3/search/book?target=title";
	public static String kakao_rest_apo_appkey = "e1a4b4b6e1061da0c4afcaf0bc806ccc";
	
	@RequestMapping(value = "/kakao_book.do", method = RequestMethod.GET)
	public String kakaoBook(Model model,@RequestParam String searchWord) {
		logger.info("카카오 검색(북) {}", searchWord);
		
		RestTemplate restTemplate = new RestTemplate();
		KakaoBook kakaoBook = null;
		
		// kakao 전송을 위한 헤더정보인 Authorization : KakaoAK {appkey}를 요청할 때 보내줌
		MultiValueMap<String, String> header = new LinkedMultiValueMap<String, String>();
		header.add("Authorization", "KakaoAK " + kakao_rest_apo_appkey);
		
		//Response 객체를 보내줘야한다
		//처리방식 GET, URL, Header정보, 받는 객체kakaoBook
		ResponseEntity<KakaoBook> kakaoBookResponseEntity =  //응답 body값 
				restTemplate.exchange(
						kakao_book_rest_uri + "&query=" + searchWord, 
						HttpMethod.GET,
						new HttpEntity<>(header),
						KakaoBook.class);
		
		kakaoBook = kakaoBookResponseEntity.getBody(); // jackson이 property에 담아줌
		logger.info("카카오 북에 요청된 결과 값 \n {}", kakaoBook);
		
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("kakaoBook", kakaoBook);
		
		return "book/kakaoBook";
	}
}
