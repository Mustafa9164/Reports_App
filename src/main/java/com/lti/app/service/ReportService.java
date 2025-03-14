package com.lti.app.service;

import java.util.List;

import com.lti.app.dto.SearchRequest;
import com.lti.app.entity.CitizenPlan;

public interface ReportService {
	
	public List<String> getPlanNames();
	
	public List<String> getPlanStatus();
	
	public List<CitizenPlan> search(SearchRequest request);
	
	public boolean ExportExcel();
	
	public boolean ExportPdf();

}
