package com.lti.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
		return planRepo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {
		return planRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		
		//copy binding obj to entity obj
		CitizenPlan entity=new CitizenPlan();
//		BeanUtils.copyProperties(request, entity);
		
		if(null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		if(null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if(null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		if(null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		if(null != request.getStartDate()) {
			entity.setStartDate(request.getStartDate());
		}
		if(null != request.getEndDate()) {
			entity.setEndDate(request.getEndDate());
		}
		return planRepo.findAll(Example.of(entity));
	}

	@Override
	public boolean ExportExcel() {
		return false;
	}

	@Override
	public boolean ExportPdf() {
		return false;
	}
}
