package com.lti.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lti.app.entity.CitizenPlan;

public interface CitizenPlanRepository extends JpaRepository<CitizenPlan, Integer> {

	
	@Query("SELECT distinct(plan_name) FROM jrtp.citizen_plans_info")
	public List<String> getPlanNames();
	
	@Query("SELECT distinct(plan_status) FROM jrtp.citizen_plans_info")
	public List<String> getPlanStatus();
}
