package com.carfi.vrcp2.query;

/** 
* @ClassName: OrgUserQuery 
* @Description:组织用户高级查询类
* @author gjw 
* @date 2016年12月21日 下午3:27:26 
*  
*/
public class OrgUserQuery {
	//用户名
	private String name;
	
	//开始位置
	private Integer beginIndex=0;
	
	//每页显示多少条
	private Integer pageNum=10;
	
	//组织id
	private long orgId;
	
	public long getOrgId() {
		return orgId;
	}

	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}

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
	
	
}
