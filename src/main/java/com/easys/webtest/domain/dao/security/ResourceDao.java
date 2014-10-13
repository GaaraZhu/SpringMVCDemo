package com.easys.webtest.domain.dao.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easys.webtest.domain.entity.security.Resource;

public interface ResourceDao extends JpaRepository<Resource, Long> {

}
