package com.easys.webtest.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_SPRING_VISIT_RCD")
public class VisitRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_vst_rcd_id", sequenceName = "test_spring_vst_rcd_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vst_rcd_id")
	private Long id;

	@Column(name = "time")
	private String time;

	@Column(name = "visitorName")
	private String visitorName;

	@Column(name = "notes")
	private String notes;

	public VisitRecord() {
	}

	public VisitRecord(String time, String visitorName, String notes) {
		super();
		this.time = time;
		this.notes = notes;
		this.visitorName = visitorName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
