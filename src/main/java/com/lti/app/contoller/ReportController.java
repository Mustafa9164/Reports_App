package com.lti.app.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.lti.app.service.ReportService;
import com.lti.app.serviceImpl.ReportServiceImpl;

@Controller
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	@GetMapping("/")
	public String indexPage() {
		
		return "index";
	}

}
