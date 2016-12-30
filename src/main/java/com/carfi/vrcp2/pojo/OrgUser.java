package com.carfi.vrcp2.pojo;

import java.util.Date;

/** 
* @ClassName: OrgUser 
* @Description:组织的用户实体
* @author gjw 
* @date 2016年12月15日 下午4:57:34 
*  
*/
public class OrgUser {
	
    private Long id;

    private String accountName;//账号名称

    private String password;//登录密码

    private String manager;//管理人

    private String phone;//用户联系方式
    
    private Long terminalNum;//管理的终端数量
    
	private Date lastLoginTime;//最后一次登录时间
	
	private String createByCarfi;//一级组织超级管理的创建者
    
	private OrgUser createBy;//用户创建者
	
	private String isEffective;//登录时是否有效
	
    private Organization organization;//所属组织
    
    private OrgRole orgRole;//用户角色

    
    public String getIsEffective() {
		return isEffective;
	}

	public void setIsEffective(String isEffective) {
		this.isEffective = isEffective;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

   
    public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

	public OrgUser getCreateBy() {
		return createBy;
	}

	public void setCreateBy(OrgUser createBy) {
		this.createBy = createBy;
	}

	public Long getTerminalNum() {
		return terminalNum;
	}

	public void setTerminalNum(Long terminalNum) {
		this.terminalNum = terminalNum;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public OrgRole getOrgRole() {
		return orgRole;
	}

	public void setOrgRole(OrgRole orgRole) {
		this.orgRole = orgRole;
	}
    
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getCreateByCarfi() {
		return createByCarfi;
	}

	public void setCreateByCarfi(String createByCarfi) {
		this.createByCarfi = createByCarfi;
	}

}