package com.lti.app.serviceImpl;

import java.awt.Color;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lti.app.dto.SearchRequest;
import com.lti.app.entity.CitizenPlan;
import com.lti.app.repo.CitizenPlanRepository;
import com.lti.app.service.ReportService;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
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
	public boolean ExportExcel(HttpServletResponse response) throws Exception {
		Workbook  workbook=new HSSFWorkbook();
//		Workbook  workbook=new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("plans-data");
		Row headerRow = sheet.createRow(0);
		
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Citizen Name");
		headerRow.createCell(2).setCellValue("Plan Name");
		headerRow.createCell(3).setCellValue("Plan Status");
		headerRow.createCell(4).setCellValue("Plan Start Date");
		headerRow.createCell(5).setCellValue("Plan End Date");
		headerRow.createCell(6).setCellValue("Benfit Amt");

		
		List<CitizenPlan> records = planRepo.findAll();

		int dataRowIndex=1;
		for (CitizenPlan plan : records) {
			Row dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(plan.getCitizenId());
			dataRow.createCell(1).setCellValue(plan.getCitizenName());
			dataRow.createCell(2).setCellValue(plan.getPlanName());
			dataRow.createCell(3).setCellValue(plan.getPlanStatus());

			if(null != plan.getStartDate()) {
				dataRow.createCell(4).setCellValue(plan.getStartDate()+" ");
			}
			else {
				dataRow.createCell(6).setCellValue("N/A");
			}
			
			if(null != plan.getEndDate()) {
			dataRow.createCell(5).setCellValue(plan.getEndDate()+" ");
			}
			else {
				dataRow.createCell(6).setCellValue("N/A");
			}
			
			if( null != plan.getBenfitAmt()) {
				dataRow.createCell(6).setCellValue(plan.getBenfitAmt());
			}
			else {
				dataRow.createCell(6).setCellValue("N/A");
			}
			dataRowIndex++;
		}
		
//		FileOutputStream fos=new FileOutputStream(new File("plans.xls"));
//		workbook.write(fos);
//		workbook.close();
		
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		return true;
	}


	@Override
	public boolean ExportPdf(HttpServletResponse response) throws Exception {
		Document document=new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);
//		Paragraph p = new Paragraph("List of Users", font);
		
		Paragraph p=new Paragraph("Citizens Info",font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);
		
		PdfPTable table = new PdfPTable(6);
		table.addCell("ID");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Start Date");
		table.addCell("End date");
		
		List<CitizenPlan> plans = planRepo.findAll();
		for (CitizenPlan plan : plans) {
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			table.addCell(plan.getStartDate()+" ");
			table.addCell(plan.getEndDate()+" ");
		}
		
		document.add(table);
		document.close();
		return true;
	}

	
}
