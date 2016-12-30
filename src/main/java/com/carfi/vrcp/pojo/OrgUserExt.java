package com.carfi.vrcp.pojo;

public class OrgUserExt {
    private String userExtId;

    private String manager;

    private String phone;

    private String createBycarfi;

    private String createBy;

    private Integer terminalNum;

    private Boolean isEffective;

    public String getUserExtId() {
        return userExtId;
    }

    public void setUserExtId(String userExtId) {
        this.userExtId = userExtId == null ? null : userExtId.trim();
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCreateBycarfi() {
        return createBycarfi;
    }

    public void setCreateBycarfi(String createBycarfi) {
        this.createBycarfi = createBycarfi == null ? null : createBycarfi.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Integer getTerminalNum() {
        return terminalNum;
    }

    public void setTerminalNum(Integer terminalNum) {
        this.terminalNum = terminalNum;
    }

    public Boolean getIsEffective() {
        return isEffective;
    }

    public void setIsEffective(Boolean isEffective) {
        this.isEffective = isEffective;
    }
}