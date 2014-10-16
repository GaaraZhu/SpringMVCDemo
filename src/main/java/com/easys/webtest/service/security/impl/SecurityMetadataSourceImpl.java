package com.easys.webtest.service.security.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import com.easys.webtest.domain.dao.security.ResourceDao;
import com.easys.webtest.domain.entity.security.Resource;

@Component
public class SecurityMetadataSourceImpl implements
		FilterInvocationSecurityMetadataSource {

	@Autowired
	private ResourceDao resourceDao;

	private PathMatcher matcher = new AntPathMatcher();

	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	public ResourceDao getResourceDao() {
		return resourceDao;
	}

	public void setResourcesDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

	private void loadResourceDefine() {
		if (resourceMap == null) {
			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
			List<Resource> resources = this.resourceDao.findAll();
			for (Resource resource : resources) {
				Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
				ConfigAttribute configAttribute = new SecurityConfig(
						resource.getName());
				configAttributes.add(configAttribute);
				resourceMap.put(resource.getUrl(), configAttributes);
			}
		}
	}

	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {

		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		System.out.println("requestUrl is " + requestUrl);
		int firstQuestionMarkIndex = requestUrl.indexOf("?");

		if (firstQuestionMarkIndex != -1) {
			requestUrl = requestUrl.substring(0, firstQuestionMarkIndex);
		}

		if (resourceMap == null) {
			loadResourceDefine();
		}
		for (String resPattern : resourceMap.keySet()) {
			if (matcher.match(resPattern, requestUrl)) {
				return resourceMap.get(resPattern);
			}
		}

		return null;
	}
	
}
