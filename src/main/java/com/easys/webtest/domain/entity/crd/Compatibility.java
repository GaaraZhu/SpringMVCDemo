package com.easys.webtest.domain.entity.crd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.easys.webtest.domain.entity.common.PersistentRoot;

@Entity
@Table(name = "CRD_COMPATIBILITY")
public class Compatibility extends PersistentRoot {

	/**
	 * 
	 */
	private static final long serialVersionUID = -679886256909638753L;

	@Id
	@SequenceGenerator(name = "COMPATIBILITY_ID_GENERAOTR", sequenceName = "COMPATIBILITY_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPATIBILITY_ID_GENERAOTR")
	private long id;

	@Column(name = "matrix_category")
	private String matrixCategory;

	@Column(name = "product_category")
	private String productCategory;

	@Column(name = "name")
	private String name;

	@Column(name = "version")
	private String version;

	@Column(name = "version_notes")
	private String versionNotes;

	@Column(name = "product_notes")
	private String productNotes;

	@Column(name = "questions")
	private String questions;

	@ElementCollection
	@MapKeyColumn(name = "name")
	@Column(name = "value")
	@CollectionTable(name = "CRD_DYNAMIC_ATTRS", joinColumns = @JoinColumn(name = "compatibility_id"))
	private Map<String, String> dynamicAttributes = new HashMap<String, String>();

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "CRD_CUSTOMER_DOCS")
	private List<String> customerFacingDocs = new ArrayList<String>();

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "CRD_COMPATIBILITY_UNIT")
	// @OrderBy("")
	private List<CompatibilityUnit> compatibilityUnits = new ArrayList<CompatibilityUnit>();

	@ManyToMany(mappedBy = "compatibilites")
	private List<ChangeHistory> changeHistory = new ArrayList<ChangeHistory>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMatrixCategory() {
		return matrixCategory;
	}

	public void setMatrixCategory(String matrixCategory) {
		this.matrixCategory = matrixCategory;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersionNotes() {
		return versionNotes;
	}

	public void setVersionNotes(String versionNotes) {
		this.versionNotes = versionNotes;
	}

	public String getProductNotes() {
		return productNotes;
	}

	public void setProductNotes(String productNotes) {
		this.productNotes = productNotes;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public Map<String, String> getDynamicAttributes() {
		return dynamicAttributes;
	}

	public void setDynamicAttributes(Map<String, String> dynamicAttributes) {
		this.dynamicAttributes = dynamicAttributes;
	}

	public List<String> getCustomerFacingDocs() {
		return customerFacingDocs;
	}

	public void setCustomerFacingDocs(List<String> customerFacingDocs) {
		this.customerFacingDocs = customerFacingDocs;
	}

	public List<CompatibilityUnit> getCompatibilityUnits() {
		return compatibilityUnits;
	}

	public void setCompatibilityUnits(List<CompatibilityUnit> compatibilityUnits) {
		this.compatibilityUnits = compatibilityUnits;
	}

	public List<ChangeHistory> getChangeHistory() {
		return changeHistory;
	}

	public void setChangeHistory(List<ChangeHistory> changeHistory) {
		this.changeHistory = changeHistory;
	}

}
