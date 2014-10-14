package com.easys.webtest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easys.webtest.domain.dao.VisitRecordDao;
import com.easys.webtest.domain.entity.VisitRecord;
import com.easys.webtest.service.VisitRecordService;

@Service
public class VisitRecordServiceImpl implements VisitRecordService {

	@Autowired
	private VisitRecordDao visitRecordDao;

	public List<VisitRecord> findVisitRecords() {
		return getVisitRecordDao().findAll();
	}

	public void addVisitRecord(VisitRecord record) {
		getVisitRecordDao().saveAndFlush(record);
	}

	public VisitRecordDao getVisitRecordDao() {
		return visitRecordDao;
	}

	public void setVisitRecordDao(VisitRecordDao visitRecordDao) {
		this.visitRecordDao = visitRecordDao;
	}

}
