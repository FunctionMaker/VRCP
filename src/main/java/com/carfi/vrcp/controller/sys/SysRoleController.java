package com.carfi.vrcp.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carfi.vrcp.pojo.PageDomain;
import com.carfi.vrcp.pojo.RespObj;
import com.carfi.vrcp.pojo.SysPermission;
import com.carfi.vrcp.pojo.SysRole;
import com.carfi.vrcp.service.sys.SysPermissionService;
import com.carfi.vrcp.service.sys.SysRoleService;
import com.carfi.vrcp.util.CarfiUserUtil;

/**
 * 系统角色控制层
 * @author jiangliuhong
 * @CREATEDATE 2016年12月30日
 */
@Controller
@RequestMapping("/sys/role")
public class SysRoleController {

	@Autowired
	private SysRoleService roleService;
	@Autowired
	private SysPermissionService permissionService;
	
	
	/**
	 * 获取组织下的角色列表
	 * @param draw
	 * @param start
	 * @param length
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Object list(Integer draw,Integer start,Integer length){
		List<SysRole> list = roleService.queryListByOrgId(CarfiUserUtil.getSysUser().getOrganizationId(),start,length);
		PageDomain<SysRole> result = new PageDomain<>();
		result.setDraw(draw);
		result.setRecordsTotal(list.size());
		result.setRecordsFiltered(list.size());
		result.setData(list);
		return result;
	}
	
	/**
	 * 获取角色信息
	 * @param func 方法类型 1 查看 2 修改
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/info/{func}/{id}")
	@ResponseBody
	public Object info(@PathVariable("func") Long func,@PathVariable("id") String id,HttpServletRequest request){
		//查询角色
		SysRole role = roleService.queryById(id);
		//查询角色权限信息
		List<SysPermission> pers = null;
		Map<String,Object> data = new HashMap<>();
		data.put("role", role);
		if(func == 1){
			//查看时
			pers = permissionService.queryListByRoleId(id);
		}else if(func == 2){
			//修改时
//			pers = permissionService.queryPermissionByRoleId(id, orgUser.getOrganization().getId());
		}
		data.put("pers", pers);
		return RespObj.ok( data);
	}
	
}
