package com.carfi.vrcp2.pojo;

/** 
* @ClassName: OrgPermission 
* @Description:组织的权限实体
* @author gjw 
* @date 2016年12月15日 下午4:55:11 
*  
*/
public class OrgPermission {
    private Long id;

    private String name;

    private Organization organization;
    
    private Long orgId;
    
    /**权限章台，用于修改角色时，显示状态*/
    private Boolean state;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}
	
	
	

}