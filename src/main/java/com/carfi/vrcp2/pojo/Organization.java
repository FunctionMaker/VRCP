package com.carfi.vrcp2.pojo;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 组织
 * @author ltx
 *
 */
public class Organization {
	
	private Long id;
	
	private String alias;
	
	private String fullName;
	
	private String contactMan;
	
	private String contactTel;
	
	private String fixedTel;
	
	private String spareContact;
	
	private String email;
	
	private String address;
	
	private Long terminalNum;
	
	private String remark;
	
	private Boolean hasSonNode;
	
	private Integer level;
	
	private Boolean isEffective;
	
	private Organization parent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getContactMan() {
		return contactMan;
	}

	public void setContactMan(String contactMan) {
		this.contactMan = contactMan;
	}

	public String getContactTel() {
		return contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public Long getTerminalNum() {
		return terminalNum;
	}

	public void setTerminalNum(Long terminalNum) {
		this.terminalNum = terminalNum;
	}

	public Boolean getHasSonNode() {
		return hasSonNode;
	}

	public void setHasSonNode(Boolean hasSonNode) {
		this.hasSonNode = hasSonNode;
	}

	public Organization getParent() {
		return parent;
	}

	public void setParent(Organization parent) {
		this.parent = parent;
	}

	@JsonIgnore
	public String getFixedTel() {
		return fixedTel;
	}

	public void setFixedTel(String fixedTel) {
		this.fixedTel = fixedTel;
	}

	@JsonIgnore
	public String getSpareContact() {
		return spareContact;
	}

	public void setSpareContact(String spareContact) {
		this.spareContact = spareContact;
	}

	@JsonIgnore
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonIgnore
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@JsonIgnore
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Boolean getIsEffective() {
		return isEffective;
	}

	public void setIsEffective(Boolean isEffective) {
		this.isEffective = isEffective;
	}
	
	
	
	

}
