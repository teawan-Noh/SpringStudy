package com.min.edu.bookctrl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.edu.model.IUserService;

@Controller
public class RegistAjaxController_3 {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUserService service;
	
	/*
	 * Spring 3.x 버전에서는 일반적인 Controller에 특정 RequestMapping을 비동기처리하기(Rest) 위해서
	 * RequestMapping의 메소드에 @ResponseBody 작성 => HttpServletResponse response.getWriter().println()
	 * 해당 Mapping을 처리하는 값을 response(응답, 요청한 페이지에 값을 전달+mime) 처리할 수 있다
	 * 
	 * 이전 방식에서는 반환되는 text의 형태를 json으로 만들기 위해 JSONObject(simple-json.jar)를 통해서 JSON형태의 text를 전송하고
	 * 처리되는 javascript에서 JSONParse를 통해서 JSON객체로 변환 했음
	 * 
	 * 지금 방식에서는 반환되는 형태를 Map으로 반환하면, Pom.xml의 jackjson-bind를 통해서 자동으로 JAVA의 객체가 변환됨
	 * 값을 전송하기 위해서는 
	 * <context:component-scan> MVC의 동작을 위해서 <mvc:annotation-driven>을 사용해야 한다
	 */
	
	@ResponseBody
	@RequestMapping(value="/duplicateAjax3.do", method = RequestMethod.POST)
	public Map<String, Boolean> duplicationAjax(String chkid){
		Map<String, Boolean> map = new HashMap<String, Boolean>();
//		map.put("val", true);  //test
		boolean isc = false;
		
		String chk = service.getCheckUser(chkid);
		logger.info("\"RegistAjaxController_3 {}", chk);
		if(chk == null) {
			isc = true;
		}
		map.put("isc", isc);
		
		return map;
	}
	
}
