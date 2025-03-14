package com.lti.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.app.dto.SearchRequest;
import com.lti.app.entity.CitizenPlan;
import com.lti.app.repo.CitizenPlanRepository;
import com.lti.app.service.ReportService;
@Service
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	private CitizenPlanRepository planRepo;

	@Override
	public List<String> getPlanNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getPlanStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ExportExcel() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ExportPdf() {
		// TODO Auto-generated method stub
		return false;
	}

}
