package com.easys.webtest.domain.entity.crd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.easys.webtest.domain.entity.common.PersistentRoot;

@Entity
@Table(name = "CRD_SHEET_NOTE")
public class CRDSheetNote extends PersistentRoot {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4563467101422194995L;

	@Id
	@SequenceGenerator(name = "CRD_SHEET_NOTE_ID_GENERAOTR", sequenceName = "CRD_SHEET_NOTE_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CRD_SHEET_NOTE_ID_GENERAOTR")
	private long id;

	@Column(name = "note")
	private String note;

	@ManyToOne
	@JoinColumn(name = "sheet_id")
	private CRDFileSheet owner;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public CRDFileSheet getOwner() {
		return owner;
	}

	public void setOwner(CRDFileSheet owner) {
		this.owner = owner;
	}

}
