package com.lti.app.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.lti.app.entity.CitizenPlan;
import com.lti.app.repo.CitizenPlanRepository;

//@Component
public class DataLoader implements ApplicationRunner{
	
	@Autowired
	private CitizenPlanRepository repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		//Cash plan
		CitizenPlan c1=new CitizenPlan();
		c1.setCitizenName("John");
		c1.setGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setStartDate(LocalDate.now());
		c1.setEndDate(LocalDate.now().plusMonths(6));
		c1.setBenfitAmt(5000.00);
		
		CitizenPlan c2=new CitizenPlan();
		c2.setCitizenName("Smith");
		c2.setGender("Male");
		c2.setPlanName("Cash");
		c2.setPlanStatus("Denial");
		c2.setDanialReson("Rental Income");
		
		CitizenPlan c3=new CitizenPlan();
		c3.setCitizenName("Adam");
		c3.setGender("Male");
		c3.setPlanName("Cash");
		c3.setPlanStatus("Terminated");
		c3.setStartDate(LocalDate.now().minusMonths(3));
		c3.setEndDate(LocalDate.now().plusMonths(6));
		c3.setTerminatedDate(LocalDate.now());
		c3.setTerminatedReson("Employeed");
		
		
		//food
		CitizenPlan c4=new CitizenPlan();
		c4.setCitizenName("cathy");
		c4.setGender("Female");
		c4.setPlanName("Food");
		c4.setPlanStatus("Approved");
		c4.setStartDate(LocalDate.now());
		c4.setEndDate(LocalDate.now().plusMonths(6));
		c4.setBenfitAmt(5000.00);
		
		CitizenPlan c5=new CitizenPlan();
		c5.setCitizenName("sruthi");
		c5.setGender("Female");
		c5.setPlanName("Food");
		c5.setPlanStatus("Denial");
		c5.setDanialReson("Rental Income");
		
		CitizenPlan c6=new CitizenPlan();
		c6.setCitizenName("Orlen");
		c6.setGender("Female");
		c6.setPlanName("Food");
		c6.setPlanStatus("Terminated");
		c6.setStartDate(LocalDate.now().minusMonths(3));
		c6.setEndDate(LocalDate.now().plusMonths(6));
		c6.setTerminatedDate(LocalDate.now());
		c6.setTerminatedReson("Employeed");
		
		//medical
		CitizenPlan c7=new CitizenPlan();
		c7.setCitizenName("David");
		c7.setGender("Male");
		c7.setPlanName("Medical");
		c7.setPlanStatus("Approved");
		c7.setStartDate(LocalDate.now());
		c7.setEndDate(LocalDate.now().plusMonths(6));
		c7.setBenfitAmt(5000.00);
		
		CitizenPlan c8=new CitizenPlan();
		c8.setCitizenName("Robert");
		c8.setGender("Male");
		c8.setPlanName("Medical");
		c8.setPlanStatus("Denial");
		c8.setDanialReson("Proprty Income");
		
		CitizenPlan c9=new CitizenPlan();
		c9.setCitizenName("Neal");
		c9.setGender("Female");
		c9.setPlanName("Medical");
		c9.setPlanStatus("Terminated");
		c9.setStartDate(LocalDate.now().minusMonths(3));
		c9.setEndDate(LocalDate.now().plusMonths(6));
		c9.setTerminatedDate(LocalDate.now());
		c9.setTerminatedReson("Govt Job");
		//Employement plan data
		
		CitizenPlan c10=new CitizenPlan();
		c10.setCitizenName("Stive");
		c10.setGender("Male");
		c10.setPlanName("Employment");
		c10.setPlanStatus("Approved");
		c10.setStartDate(LocalDate.now());
		c10.setEndDate(LocalDate.now().plusMonths(6));
		c10.setBenfitAmt(5000.00);
		
		CitizenPlan c11=new CitizenPlan();
		c11.setCitizenName("Smith");
		c11.setGender("Male");
		c11.setPlanName("Employment");
		c11.setPlanStatus("Denial");
		c11.setDanialReson("Proprty Income");
		
		CitizenPlan c12=new CitizenPlan();
		c12.setCitizenName("Baby");
		c12.setGender("Female");
		c12.setPlanName("Employment");
		c12.setPlanStatus("Terminated");
		c12.setStartDate(LocalDate.now().minusMonths(3));
		c12.setEndDate(LocalDate.now().plusMonths(6));
		c12.setTerminatedDate(LocalDate.now());
		c12.setTerminatedReson("Govt Job");
		
		List<CitizenPlan> list = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
		repo.saveAll(list);
		
	}

}
