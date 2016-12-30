package com.carfi.vrcp2.pojo;

/** 
* @ClassName: OrgRolePermission 
* @Description:组织的角色权限实体
* @author gjw 
* @date 2016年12月15日 下午4:56:52 
*  
*/
public class OrgRolePermission {
    private Long id;

    private OrgRole orgRole;

    private OrgPermission orgPermission ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public OrgRole getOrgRole() {
		return orgRole;
	}

	public void setOrgRole(OrgRole orgRole) {
		this.orgRole = orgRole;
	}

	public OrgPermission getOrgPermission() {
		return orgPermission;
	}

	public void setOrgPermission(OrgPermission orgPermission) {
		this.orgPermission = orgPermission;
	}
    
    
}