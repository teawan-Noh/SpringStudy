package com.min.edu.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaoLogAOP {

	public void before(JoinPoint j) {
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		
		Object[] args = j.getArgs();
		if(args != null) {
			logger.info(j.getSignature().getName() + "메소드 Arguments");
			for (int i = 0; i < args.length; i++) {
				logger.info(i+"번째 arg\t:"+String.valueOf(args[i]));
			}
			logger.info(j.getSignature().getName() + "메소드 Arguments 출력 완료");
		}
		
		
	}
	
	public void afterReturing(JoinPoint j) {
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.info("반환 완료 {}", j.getSignature().getName());
		
	}
	
	public void afterThrowing(JoinPoint j, Exception exception) {
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.info("에러 발생 {}", j.getSignature().getName());
		logger.info("에러 발생 {}", exception.getMessage());
	}
	
}
