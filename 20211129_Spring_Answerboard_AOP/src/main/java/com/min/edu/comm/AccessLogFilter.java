package com.min.edu.comm;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 요청되는 링크 및 정보에 대한 출력 클레서
 * @author taewanNo
 * @since 2021. 11. 24
 */
public class AccessLogFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(AccessLogFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Fillter 시작");
	}
	
	@Override
	/**
	 * 요청의 객체인 ServletRequest와 ServletResponse의 정보에서 필요한 Header와 정보를 추출 출력<br>
	 * 반드시 흐름제어를 위해서는 흐름제어 코드 (RequestDispatcher, sendRedirect)를 작성해주거나 <br>
	 * 일반흐름을 만들기 위해서 chain.doFilter() 메소드를 반드시 구현해야한다.
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
//		String chk = req.getParameter("check");
//		boolean flag = Boolean.parseBoolean(chk);
//		System.out.println("필터에서 값을 확인해 봄" + chk);
//		
//		if(flag) {
//			chain.doFilter(request, response);
//		}else {
//			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//			dispatcher.forward(request, response);
//		}

		// 현재 서버에 요청하는 Client의 IP주소를 가져온다
		String remoteAddr = StringUtils.defaultString(req.getRemoteAddr(), "-");
		// Client가 요청한 호출 주소
		String uri = StringUtils.defaultIfEmpty(req.getRequestURI(), "");
		// client 요청된 주소에서 전달하는 parameter
		System.out.println(uri);
		String queryString = StringUtils.defaultIfBlank(req.getQueryString(), "");
		System.out.println(queryString);

		// Header 정보를 출력
		String referer = StringUtils.defaultString(req.getHeader("referer"), "");
		System.out.println("refer : " + referer); // 클릭해서 넘어가면 정보 나옴
		String userAgent = StringUtils.defaultString(req.getHeader("User-Agent"), "");
		System.out.println("User-Agent : " + userAgent);

		String fullUrl = uri + (StringUtils.isNotEmpty(queryString) ? "?" + queryString : queryString);

		StringBuffer sb = new StringBuffer();
		sb.append(remoteAddr).append(":").append(fullUrl).append(":").append(referer).append(":").append(userAgent);

		logger.info("[Logger Filter] {}", sb.toString());

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("Filter 종료");

	}

}
