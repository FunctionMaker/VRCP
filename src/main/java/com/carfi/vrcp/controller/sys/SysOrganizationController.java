package com.carfi.vrcp.controller.sys;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carfi.vrcp.pojo.OrgUserExt;
import com.carfi.vrcp.pojo.PageDomain;
import com.carfi.vrcp.pojo.RespObj;
import com.carfi.vrcp.pojo.SysOrganization;
import com.carfi.vrcp.pojo.SysUser;
import com.carfi.vrcp.query.OrganizationQuery;
import com.carfi.vrcp.service.sys.SysOrganizationService;

@RequestMapping("/organization")
@Controller
public class SysOrganizationController {
	
	@Autowired
	private SysOrganizationService sysOrganizationService;
	
	/**
	 * 查询组织列表
	 * @param start 开始位置
	 * @param length 查询长度
	 * @param parentId 父节点id
	 * @param draw datatables需要的参数,原样返回
	 * @param req 请求对象
	 * @return datatables需要的实体对象
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/getDatas")
	@ResponseBody
	public PageDomain<SysOrganization> getDatas(Integer start,Integer length,String parentId,Integer draw,HttpServletRequest req) throws UnsupportedEncodingException{
		OrganizationQuery orgQuery = new OrganizationQuery();
		orgQuery.setBeginIndex(start);
		orgQuery.setPageNum(length);
		orgQuery.setParentId(parentId);
		String keyWord = new String(req.getParameter("search[value]").getBytes("ISO-8859-1"),"UTF-8");
		orgQuery.setName(keyWord);
		PageDomain<SysOrganization> pageDomain = sysOrganizationService.getDatas(orgQuery);
		pageDomain.setDraw(draw);
		return pageDomain;
	}
	
	/**
	 * 进行中转
	 * @param id
	 * @return
	 */
	@RequestMapping("/input")
	public String input(String id,Model model){
		//修改
		if(id != null){
			model.addAttribute("org",sysOrganizationService.queryOrgById(id));
		}
		
		return "sys/editOrgnization";
	}
	
	/**
	 * 逻辑删除组织
	 * @param id
	 */
	@RequestMapping("/del")
	@ResponseBody
	public RespObj del(String id){
		RespObj respObj = new RespObj();
		try {
			sysOrganizationService.logicDeleteOrgById(id);
			respObj.setSuccess(true);
			respObj.setData("成功");
		} catch (Exception e) {
			e.printStackTrace();
			respObj.setSuccess(false);
			respObj.setData("失败");
		}
		return respObj;
	}
	
	/**
	 * 编辑组织,包括新增和修改
	 * @param id 组织id
	 */ 
	public RespObj edit(SysOrganization sysOrg,SysUser sysUser,OrgUserExt orgUserExt){
		RespObj respObj = new RespObj();
		try {
			if(sysOrg.getOrganizationId() == null){                        //新增组织
				sysOrganizationService.saveOrgAndUser(sysOrg, sysUser,orgUserExt);
			}else{                                                         //修改组织
				sysOrganizationService.updateOrgAndUser(sysOrg, sysUser, orgUserExt);
			}
			respObj.setSuccess(true);
			respObj.setData("成功");
		} catch (Exception e) {
			e.printStackTrace();
			respObj.setSuccess(false);
			respObj.setData("失败");
		}
		return respObj;
	}
	
}
