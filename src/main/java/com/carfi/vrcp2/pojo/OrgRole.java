package com.carfi.vrcp2.pojo;

/** 
* @ClassName: OrgRole 
* @Description:组织的角色实体
* @author gjw 
* @date 2016年12月15日 下午4:56:25 
*  
*/
public class OrgRole {
    private Long id;

    private String name;

    private Long orgId;

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

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	

}