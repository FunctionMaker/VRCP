package com.carfi.vrcp2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carfi.vrcp2.pojo.OrgPermission;
import com.carfi.vrcp2.pojo.RespObj;
import com.carfi.vrcp2.service.IOrgPermissionService;

/**
 * 组织权限控制器
 * @author jiangliuhong
 * @CREATEDATE 2016年12月21日
 */
@Controller
@RequestMapping("/org/permission")
public class OrgPermissionController {

	@Autowired
	private IOrgPermissionService permissionService;
	/**
	 * 
	 * @param orgId 组织ID
	 * @return
	 */
	@RequestMapping("/list/{orgId}")
	@ResponseBody
	public Object list(@PathVariable("orgId") Long orgId){
		List<OrgPermission> list = permissionService.queryPermissionByOrgId(orgId);
		return RespObj.ok(list);
	}
	
}
