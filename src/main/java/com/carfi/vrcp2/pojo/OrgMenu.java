package com.carfi.vrcp2.pojo;

public class OrgMenu {
	
	private Long id;

    private String name;

    private String icon;

    private String url;
    
    private Boolean hasSonNode;

    private Menu parent;

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
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getHasSonNode() {
		return hasSonNode;
	}

	public void setHasSonNode(Boolean hasSonNode) {
		this.hasSonNode = hasSonNode;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}
    
}
