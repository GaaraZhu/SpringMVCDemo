package com.easys.webtest.domain.entity.crd;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.easys.webtest.domain.entity.common.PersistentRoot;

@Entity
@Table(name = "CRD_CHANGE_HISTORY")
public class ChangeHistory extends PersistentRoot {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8299994753330694508L;

	@Id
	@SequenceGenerator(name = "CHANGE_HIST_ID_GENERAOTR", sequenceName = "CHANGE_HIST_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHANGE_HIST_ID_GENERAOTR")
	private long id;

	@Column(name = "matrix_category")
	private String matrixCategory;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "change_desp")
	private String changeDescription;

	@ManyToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY)
	@JoinTable(name = "CRD_HIST_COMPATIBILITY_REF", joinColumns = @JoinColumn(name = "hist_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "compatibility_id", referencedColumnName = "id"))
	private List<Compatibility> compatibilites = new ArrayList<Compatibility>();

	@Enumerated(value = EnumType.STRING)
	@Column(name = "hist_status")
	private ChangeHistoryStatus status;

	@Column(name = "approvers")
	private String approvers;

	@Column(name = "reviewers")
	private String reviewers;

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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getChangeDescription() {
		return changeDescription;
	}

	public void setChangeDescription(String changeDescription) {
		this.changeDescription = changeDescription;
	}

	public List<Compatibility> getCompatibilites() {
		return compatibilites;
	}

	public void setCompatibilites(List<Compatibility> compatibilites) {
		this.compatibilites = compatibilites;
	}

	public ChangeHistoryStatus getStatus() {
		return status;
	}

	public void setStatus(ChangeHistoryStatus status) {
		this.status = status;
	}

	public String getApprovers() {
		return approvers;
	}

	public void setApprovers(String approvers) {
		this.approvers = approvers;
	}

	public String getReviewers() {
		return reviewers;
	}

	public void setReviewers(String reviewers) {
		this.reviewers = reviewers;
	}

}
