package com.carfi.vrcp2.query;

/**
 * 组织查询条件
 * @author ltx
 *
 */
public class OrganizationQuery {
	
	//组织名称
	private String name;
	
	//开始位置
	private Integer beginIndex=0;
	
	//每页显示多少条
	private Integer pageNum=10;
	
	//父级id
	private Long parentId;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(Integer beginIndex) {
		this.beginIndex = beginIndex;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
