package com.carfi.vrcp2.pojo;

import java.util.List;

/**
 * 角色实体对象
 * @author ltx
 *
 */
public class Role {
    private Long id;

    private String name;
    
    private List<Menu> menus;

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

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
}