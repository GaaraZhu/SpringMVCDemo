package com.easys.webtest.domain.entity.security;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_SPRING_RESOURCE")
public class Resource implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_resource_id", sequenceName = "test_spring_resource_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_resource_id")
	private Long id;

	@Column(name = "url")
	private String url;

	@Column(name = "priority")
	private Integer priority;

	@Column(name = "type")
	private Integer type;

	@Column(name = "name")
	private String name;

	@Column(name = "memo")
	private String memo;

	@ManyToMany(mappedBy = "resources")
	private Set<Role> roles = new HashSet<Role>();

	public Resource() {
	}

	public Resource(String url, Integer priority, Integer type, String name,
			String memo) {
		super();
		this.url = url;
		this.priority = priority;
		this.type = type;
		this.name = name;
		this.memo = memo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
