package com.carfi.vrcp.constant;

/**
 * 类别
 * @author jiangliuhong
 * @CREATEDATE 2016年12月29日
 */
public interface Type {
	
	/** 权限类型  */
	enum Permission implements Type{
		RESOUCE("0"),MENU("1"), BUTTON("2");
		/**类别id*/
		private String id;
		private Permission(String id){
			this.id = id;
		}
		/**得到类别id*/
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
	}
	
}
