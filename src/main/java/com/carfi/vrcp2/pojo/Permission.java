package com.carfi.vrcp2.pojo;

/**
 * 权限实体对象
 * @author ltx
 *
 */
public class Permission {
    private Long id;

    private String name;

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
}