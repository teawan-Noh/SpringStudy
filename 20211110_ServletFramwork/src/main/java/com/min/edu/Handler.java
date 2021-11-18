package com.min.edu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Handler {

	//요청된 모든 클레스가 Servlet이 되기 위해서는 HttpServlet을 extends 해야함
	//하지만 HappyController가 Front-controller 역할을 하기 떄문에
	//기능을 담당하는 클레스들은 HttpServletRequest/HttpServletResponse만 가지고 있으면 됨
	
	public String handle(HttpServletRequest req, HttpServletResponse resp);
}
