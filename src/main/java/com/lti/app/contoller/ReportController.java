package com.lti.app.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lti.app.dto.SearchRequest;
import com.lti.app.entity.CitizenPlan;
import com.lti.app.service.ReportService;
import com.lti.app.serviceImpl.ReportServiceImpl;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	@PostMapping("/search")
	public String handleSearch(@ModelAttribute("search") SearchRequest search, Model model) {
		
		List<CitizenPlan> plans = reportService.search(search);
		model.addAttribute("plans",plans );
		init(model);

//		model.addAttribute("search", request);
		return "index";
	}
	
	@GetMapping("/")
	public String indexPage(Model model) {// model:->send data from controller to view
		
		init(model);

		//binding object to ui
		SearchRequest searchObj=new SearchRequest();
		model.addAttribute("search", searchObj);
		
		return "index";
	}

	private void init(Model model) {
	    List<String> planNames = reportService.getPlanNames();
	    List<String> planStatuses = reportService.getPlanStatus();
	    

	    model.addAttribute("names", planNames);
	    model.addAttribute("status", planStatuses);
	}
	
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws Exception{
		
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment;fileName=plans.xls");
		reportService.ExportExcel(response);
	}
	
	
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception {
	    response.setContentType("application/pdf");
	    response.setHeader("Content-Disposition", "attachment; filename=plans.pdf");
	    reportService.ExportPdf(response);
	}


}
