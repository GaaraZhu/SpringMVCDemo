package com.easys.webtest.domain.entity.crd;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.easys.webtest.domain.entity.common.PersistentRoot;

@Entity
@Table(name = "CRD_FILE")
public class CRDFile extends PersistentRoot {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3082771136465064630L;

	@Id
	@SequenceGenerator(name = "CRD_FILE_ID_GENERAOTR", sequenceName = "CRD_FILE_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CRD_FILE_ID_GENERAOTR")
	private long id;

	@Column(name = "FILE_NAME")
	private String fileName;

	@OneToMany(mappedBy = "owner")
	private List<CRDFileSheet> sheets = new ArrayList<CRDFileSheet>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<CRDFileSheet> getSheets() {
		return sheets;
	}

	public void setSheets(List<CRDFileSheet> sheets) {
		this.sheets = sheets;
	}

}
