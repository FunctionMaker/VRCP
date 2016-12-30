package com.carfi.vrcp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转
 * @author jiangliuhong
 * @CREATEDATE 2016年12月31日
 */
@Controller
public class PageController {

	
	/**
	 * 跳转到指定页面
	 * @param pack pages下的文件夹
	 * @param page 文件夹下的jsp页面名称
	 * @return
	 */
	@RequestMapping("/p/{pack}/{page}")
	public String page(@PathVariable("pack") String pack,@PathVariable("page") String page){
		return pack+"/"+page;
	}
	
}
