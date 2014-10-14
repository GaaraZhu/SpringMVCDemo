package com.easys.webtest.controller.dto;

public class MaintainRecordDTO {

	private Long id;

	private String time;

	private String visitorName;

	private String notes;

	public MaintainRecordDTO(Long id, String time, String visitorName, String notes) {
		super();
		this.id = id;
		this.time = time;
		this.visitorName = visitorName;
		this.notes = notes;
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
