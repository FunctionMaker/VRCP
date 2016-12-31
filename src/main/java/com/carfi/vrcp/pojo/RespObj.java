package com.carfi.vrcp.pojo;

/**
 * 
 * @author jiangliuhong
 * @CREATEDATE 2016年12月31日
 */
public class RespObj {
	
	/**返回状态*/
	private boolean success;
	
	/***/
	private String msg;
	
	/**返回数据*/
	private Object data;

	public RespObj() {
	}
	
	public RespObj(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}
	
	public RespObj(boolean success, Object data) {
		this.success = success;
		this.data = data;
	}
	
	public RespObj(boolean success, String msg, Object data) {
		super();
		this.success = success;
		this.msg = msg;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 操作成功
	 * @param msg 提示信息
	 * @return
	 */
	public static RespObj ok(String msg){
		return new RespObj(true,msg);
	}
	
	/**
	 * 操作成功、带返回数据
	 * @param msg 提示信息
	 * @param data 返回数据
	 * @return
	 */
	public static RespObj ok(String msg,Object data){
		return new RespObj(true,msg,data);
	}
	
	/**
	 * 操作成功
	 * @param data 返回数据
	 * @return
	 */
	public static RespObj ok(Object data){
		return new RespObj(true,data);
	}
	
	/**
	 * 操作失败
	 * @param msg 提示信息
	 * @return 
	 */
	public static RespObj error(String msg){
		return new RespObj(false,msg);
	}
	
	/**
	 * 构建返回信息
	 * @param success 标识
	 * @param msg 提示信息
	 * @param data 返回数据
	 * @return
	 */
	public static RespObj build(boolean success, String msg, Object data){
		return new RespObj(success,msg,data);
	}
	
}
