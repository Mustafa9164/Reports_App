package com.lti.app.service;

import java.util.List;

import com.lti.app.dto.SearchRequest;
import com.lti.app.entity.CitizenPlan;

import jakarta.servlet.http.HttpServletResponse;

public interface ReportService {
	
	public List<String> getPlanNames();
	
	public List<String> getPlanStatus();
	
	public List<CitizenPlan> search(SearchRequest request);
	
	public boolean ExportExcel(HttpServletResponse response) throws Exception;
	
	public boolean ExportPdf(HttpServletResponse response) throws Exception;

}
