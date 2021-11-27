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

public class AccessLogFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(AccessLogFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter 시작");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
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
		
		//현재 서버에 요청하는 Client의 IP주소를 가져온다
		String remoteAddr = StringUtils.defaultString(req.getRemoteAddr(), "-") ;
		//Client가 요청한 호출 주소
		String uri = StringUtils.defaultIfEmpty(req.getRequestURI(), "");
		//client 요청된 주소에서 전달하는 parameter
		System.out.println("uri : " + uri);
		String queryString = StringUtils.defaultIfBlank(req.getQueryString(), "");
		System.out.println("queryString : " + queryString);
		
		//Header 정보를 출력
		String referer =  StringUtils.defaultString(req.getHeader("referer"),"");
		System.out.println("refer : " + referer); //클릭해서 넘어가면 정보 나옴
		String userAgent =  StringUtils.defaultString(req.getHeader("User-Agent"),"");
		System.out.println("User-Agent : " + userAgent);
		
		String fullUrl = uri+(StringUtils.isNotEmpty(queryString)? "?" +queryString : queryString);
		
		StringBuffer sb = new StringBuffer();
		sb.append(remoteAddr)
		.append(":")
		.append(fullUrl)
		.append(":")
		.append(referer)
		.append(":")
		.append(userAgent);
		
		logger.info("[Logger Filter] {}", sb.toString());
		
		chain.doFilter(request, response);	
	}

	@Override
	public void destroy() {
		System.out.println("Filter 종료");

	}

}
