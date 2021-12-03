package com.min.edu.aop;

import java.util.Iterator;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//메소드 호출할때 실행됩니다
public class LogExecute {
	
	public void before(JoinPoint j) {
		Logger log = LoggerFactory.getLogger(j.getTarget()+"");
		log.debug("&&&& 메소드 실행 전 &&&&");
		
		Object[] arg = j.getArgs();
		if(arg != null) {
			log.debug("method명 : " + j.getSignature().getName());
			for (int i = 0; i < arg.length; i++) {
				log.debug(i+"번째: \t"+arg[i]);
			}
			log.debug("method명 : " + j.getSignature().getName());
		}
	}
	
	public void afterReturning(JoinPoint j) {
		Logger log = LoggerFactory.getLogger(j.getTarget()+"");
		log.debug("&& 종료: \t{} &&", j.getSignature().getName());
	}
	
	public void daoError(JoinPoint j, Exception exception) {
		Logger log = LoggerFactory.getLogger(j.getTarget()+"");
		log.debug("&& 예외발생: &&", j.getSignature().getName());
		log.debug("&& 예외발생: &&", exception.getMessage());
		
	}
}
