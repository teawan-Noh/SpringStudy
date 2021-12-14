package com.min.edu;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.edu.dtos.ListDto;
import com.min.edu.dtos.PagingDto;
import com.min.edu.model.IListService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PagingController {
	
	private static final Logger logger = LoggerFactory.getLogger(PagingController.class);
	
	@Autowired
	private IListService service;
	
	@RequestMapping(value = "/paging.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String paging(Model model, HttpServletRequest req) {
		PagingDto paging = new PagingDto(
				req.getParameter("index"), 
				req.getParameter("pageStartNum"), 
				req.getParameter("listCnt")
				);
		paging.setTotal(service.selectTotalPaging());
		List<ListDto> lists = service.selectPaging(paging);
		
		model.addAttribute("lists",lists);
		model.addAttribute("paging",paging);
		logger.info("페이징 DTO 값 : {}", paging.toString());
		return "paging";
	}
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public String list(int num) {
		Random ran = new Random();
		for(int i = 0; i<num; i++) {
			service.listInsert(new ListDto(ran.nextInt(1000000)+""));
		}
		
		return "redirect:/paging.do";
	}
	
	@RequestMapping(value = "/remove.do", method = RequestMethod.GET)
	public String remove() {
		service.deleteAll();
		return "redirect:/paging.do";
		
	}
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
