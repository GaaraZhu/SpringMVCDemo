package com.easys.webtest.service;

import java.util.List;

import com.easys.webtest.domain.entity.VisitRecord;

public interface VisitRecordService {

	public List<VisitRecord> findVisitRecords();

	public void addVisitRecord(VisitRecord record);
}
