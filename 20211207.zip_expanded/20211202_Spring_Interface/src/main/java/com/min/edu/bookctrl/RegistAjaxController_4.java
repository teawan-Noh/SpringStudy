package com.min.edu.bookctrl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.min.edu.model.IUserService;

@RestController
public class RegistAjaxController_4 {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUserService service;
	
	@RequestMapping(value="/duplicateAjax4.do", method = RequestMethod.POST)
	public Map<String, Boolean> duplicationAjax(String chkid){
		Map<String, Boolean> map = new HashMap<String, Boolean>();
//		map.put("val", true);  //test
		boolean isc = false;
		
		String chk = service.getCheckUser(chkid);
		logger.info("\"RegistAjaxController_4 {}", chk);
		if(chk == null) {
			isc = true;
		}
		map.put("isc", isc);
		
		return map;
	}
}
