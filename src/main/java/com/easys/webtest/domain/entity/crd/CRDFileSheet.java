package com.easys.webtest.domain.entity.crd;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.easys.webtest.domain.entity.common.PersistentRoot;

@Entity
@Table(name = "CRD_FILE_SHEET")
public class CRDFileSheet extends PersistentRoot {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1908348423143717931L;

	@Id
	@SequenceGenerator(name = "CRD_FILE_SHEET_ID_GENERAOTR", sequenceName = "CRD_FILE_SHEET_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CRD_FILE_SHEET_ID_GENERAOTR")
	private long id;

	@Column(name = "sheet_name")
	private String sheetName;

	@Column(name = "general_notes")
	private String generalNotes;

	@ManyToOne
	@JoinColumn(name = "file_id")
	private CRDFile owner;

	@OneToMany(mappedBy = "owner")
	private List<CRDSheetNote> specialNotes = new ArrayList<CRDSheetNote>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public String getGeneralNotes() {
		return generalNotes;
	}

	public void setGeneralNotes(String generalNotes) {
		this.generalNotes = generalNotes;
	}

	public CRDFile getOwner() {
		return owner;
	}

	public void setOwner(CRDFile owner) {
		this.owner = owner;
	}

	public List<CRDSheetNote> getSpecialNotes() {
		return specialNotes;
	}

	public void setSpecialNotes(List<CRDSheetNote> specialNotes) {
		this.specialNotes = specialNotes;
	}

}
