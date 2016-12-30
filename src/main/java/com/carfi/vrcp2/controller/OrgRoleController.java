package com.carfi.vrcp2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carfi.vrcp2.constant.Constant;
import com.carfi.vrcp2.pojo.OrgPermission;
import com.carfi.vrcp2.pojo.OrgRole;
import com.carfi.vrcp2.pojo.OrgUser;
import com.carfi.vrcp2.pojo.PageDomain;
import com.carfi.vrcp2.pojo.RespObj;
import com.carfi.vrcp2.service.IOrgPermissionService;
import com.carfi.vrcp2.service.IOrgRoleService;

/**
 * 角色管理
 * @author jiangliuhong
 * @CREATEDATE 2016年12月21日
 */
@Controller
@RequestMapping("/org/role")
public class OrgRoleController{

	@Autowired
	private IOrgRoleService roleService;
	@Autowired
	private IOrgPermissionService permissionService;
	
	/**
	 * 跳转到角色列表页面
	 * @return
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request,Model model){
		OrgUser orgUser = (OrgUser) request.getSession().getAttribute(Constant.ORG_USER_IN_SESSION);
		model.addAttribute("orgId", orgUser.getOrganization().getId());
		return "/org/roleList";
	}
	
	/**
	 * 获取角色列表数据
	 * @return
	 */
	@RequestMapping("/roleListData")
	@ResponseBody
	public Object listData(Integer draw,Integer start,Integer length,HttpServletRequest request){
		OrgUser orgUser = (OrgUser) request.getSession().getAttribute(Constant.ORG_USER_IN_SESSION);
		List<OrgRole> list = roleService.queryAllByOrgId(orgUser.getOrganization().getId());
		PageDomain<OrgRole> result = new PageDomain<>();
		result.setDraw(draw);
		result.setRecordsTotal(list.size());
		result.setRecordsFiltered(list.size());
		result.setData(list);
		return result;
	}
	
	/**
	 * 添加或者修改
	 * @param orgRole
	 * @return
	 */
	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public Object addRole(OrgRole orgRole,Long[] qxs,HttpServletRequest request){
		OrgUser orgUser = (OrgUser) request.getSession().getAttribute(Constant.ORG_USER_IN_SESSION);
		if(StringUtils.isBlank(orgRole.getName())){
			return RespObj.error("角色名称不能为空");
		}
		if(orgRole.getId() != null){
			roleService.updateOrgRole(orgRole, qxs);
		}else{
			orgRole.setOrgId(orgUser.getOrganization().getId());
			Long roleId = roleService.save(orgRole);
			roleService.saveRolePermission(roleId, qxs);
		}
		return RespObj.ok("操作成功");
	}
	
	/**
	 * 删除
	 * @param roleId
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Object deleteRole(@PathVariable("id") Long roleId){
		roleService.delete(roleId);
		return RespObj.ok("删除成功");
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
	public Object info(@PathVariable("func") Long func,@PathVariable("id") Long id,HttpServletRequest request){
		OrgUser orgUser = (OrgUser) request.getSession().getAttribute(Constant.ORG_USER_IN_SESSION);
		//查询角色
		OrgRole orgRole = roleService.query(id, orgUser.getOrganization().getId());
		//查询角色权限信息
		List<OrgPermission> pers = null;
		Map<String,Object> data = new HashMap<>();
		data.put("role", orgRole);
		if(func == 1){
			//查看时
			pers = permissionService.queryPermissionByRoleId(id);
		}else if(func == 2){
			//修改时
			pers = permissionService.queryPermissionByRoleId(id, orgUser.getOrganization().getId());
		}
		data.put("pers", pers);
		return RespObj.ok( data);
	}
}
