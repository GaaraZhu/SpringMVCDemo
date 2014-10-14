package com.easys.webtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.easys.webtest.controller.dto.MaintainRecordDTO;
import com.easys.webtest.domain.entity.VisitRecord;
import com.easys.webtest.service.VisitRecordService;

@Controller
@RequestMapping("/maintainCRD.do")
public class MaintainCRDController {

	@Autowired
	private VisitRecordService visitRecordService;

	@RequestMapping("/addCRD")
	public void addCRD(MaintainRecordDTO maintainDTO) {
		VisitRecord record = new VisitRecord(maintainDTO.getTime(),
				maintainDTO.getVisitorName(), maintainDTO.getNotes());
		getVisitRecordService().addVisitRecord(record);
	}

	public VisitRecordService getVisitRecordService() {
		return visitRecordService;
	}

	public void setVisitRecordService(VisitRecordService visitRecordService) {
		this.visitRecordService = visitRecordService;
	}

}
