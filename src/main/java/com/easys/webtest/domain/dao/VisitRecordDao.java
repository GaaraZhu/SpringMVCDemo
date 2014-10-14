package com.easys.webtest.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.easys.webtest.domain.entity.VisitRecord;

public interface VisitRecordDao extends JpaRepository<VisitRecord, Long> {

}
