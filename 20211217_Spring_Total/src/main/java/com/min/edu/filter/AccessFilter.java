package com.min.edu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccessFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//WAS에 요청하는 Client의 정보를 출력
		HttpServletRequest req = (HttpServletRequest)request;
		
		//접속URL, 접속정보(Header)
		String remote = StringUtils.defaultString(req.getRemoteAddr(),"-");
		String url= StringUtils.defaultString(req.getRequestURL().toString(), "-");
		String queryString = StringUtils.defaultString(req.getQueryString(),"");
		
		String clientInfo = url+"?"+queryString+":"+remote;
		
		String referer = StringUtils.defaultString(req.getHeader("Referer"), "-");
		String userAgent = StringUtils.defaultString(req.getHeader("User-Agent"), "-");
		clientInfo += referer +":"+userAgent;
		
		logger.info(clientInfo);
		
		chain.doFilter(request, response);
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("====== AccessFilter init ======");
	}

	@Override
	public void destroy() {
		logger.info("====== AccessFilter destroy ======");
	}

}
