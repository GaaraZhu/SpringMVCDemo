package com.easys.webtest.domain.entity.crd;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CompatibilityUnit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8804628455372871321L;

	@Column(name = "name_prd_2b_compared")
	private String nameOfPrd2BCompared;

	@Column(name = "version_prd_2b_compared")
	private String versionOfPrd2BCompared;

	@Column(name = "is_compatible")
	private Boolean isCompatible;

	@Column(name = "notes")
	private String nodes;

	public String getNameOfPrd2BCompared() {
		return nameOfPrd2BCompared;
	}

	public void setNameOfPrd2BCompared(String nameOfPrd2BCompared) {
		this.nameOfPrd2BCompared = nameOfPrd2BCompared;
	}

	public String getVersionOfPrd2BCompared() {
		return versionOfPrd2BCompared;
	}

	public void setVersionOfPrd2BCompared(String versionOfPrd2BCompared) {
		this.versionOfPrd2BCompared = versionOfPrd2BCompared;
	}

	public Boolean getIsCompatible() {
		return isCompatible;
	}

	public void setIsCompatible(Boolean isCompatible) {
		this.isCompatible = isCompatible;
	}

	public String getNodes() {
		return nodes;
	}

	public void setNodes(String nodes) {
		this.nodes = nodes;
	}

}
