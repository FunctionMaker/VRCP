package com.carfi.vrcp.pojo;

public class SysOrganization {
    private String organizationId;

    private String alias;

    private String fullName;

    private String contactMan;

    private String contactTel;

    private String fixedTel;

    private String spareContact;

    private String email;

    private String address;

    private Integer terminalNum;

    private String remark;

    private Boolean hasSonNode;

    private String parentId;

    private Boolean isEffective;

    private Integer level;

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId == null ? null : organizationId.trim();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public String getContactMan() {
        return contactMan;
    }

    public void setContactMan(String contactMan) {
        this.contactMan = contactMan == null ? null : contactMan.trim();
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel == null ? null : contactTel.trim();
    }

    public String getFixedTel() {
        return fixedTel;
    }

    public void setFixedTel(String fixedTel) {
        this.fixedTel = fixedTel == null ? null : fixedTel.trim();
    }

    public String getSpareContact() {
        return spareContact;
    }

    public void setSpareContact(String spareContact) {
        this.spareContact = spareContact == null ? null : spareContact.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getTerminalNum() {
        return terminalNum;
    }

    public void setTerminalNum(Integer terminalNum) {
        this.terminalNum = terminalNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getHasSonNode() {
        return hasSonNode;
    }

    public void setHasSonNode(Boolean hasSonNode) {
        this.hasSonNode = hasSonNode;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public Boolean getIsEffective() {
        return isEffective;
    }

    public void setIsEffective(Boolean isEffective) {
        this.isEffective = isEffective;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}