package com.easys.webtest.domain.entity.security;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_SPRING_ROLE")
public class Role implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_role_id", sequenceName = "test_spring_role_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_role_id")
	private Integer id;

	@Column(name = "enable")
	private Integer enable;

	@Column(name = "name")
	private String name; 

	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<User>();

	@ManyToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY)
	@JoinTable(name = "TEST_SPRING_ROLE_RESOURCE", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "resource_id", referencedColumnName = "id"))
	private Set<Resource> resources = new HashSet<Resource>();

	public Role() {
	}

	public Role(Integer enable, String name) {
		super();
		this.enable = enable;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Resource> getResources() {
		return resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

	public void addResource(Resource resource) {
		if (!this.resources.contains(resource)) {
			this.resources.add(resource);
//			resource.getRoles().add(this);
		}

	}

}
