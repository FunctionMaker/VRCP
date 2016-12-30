package com.carfi.vrcp.pojo;

public class OrgUserExt {
    private String userExtId;

    private String manager;

    private String phone;

    private String createBy;

    private Integer terminalNum;

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
}