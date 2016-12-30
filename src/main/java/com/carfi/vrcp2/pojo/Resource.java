package com.carfi.vrcp2.pojo;

/**
 * 资源实体对象
 * @author ltx
 *
 */
public class Resource {
    private Long id;

    private String name;

    private String fullname;
    
    private String url;

    private Long permissionId;
    

    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname == null ? null : fullname.trim();
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

	@Override
	public String toString() {
		return "Resource [name=" + name + ", fullname=" + fullname + ", url=" + url + "]";
	}

	
    
}