package com.carfi.vrcp.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import com.carfi.vrcp.constant.Constant;

/**
 * 自定义的表单验证过滤器
 * 
 * @author jiangliuhong
 * @createTime 2016年7月18日 下午5:15:32
 * @function
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		// 在这里进行验证码的校验
		// 从session获取正确验证码
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session = httpServletRequest.getSession();
		// 取出session的验证码（正确的验证码）
		String validateCode = (String) session.getAttribute(Constant.VERIFY_CODE);

		// 取出页面的验证码
		// 输入的验证和session中的验证进行对比
		String randomcode = httpServletRequest.getParameter("randomcode");
		if (randomcode != null && validateCode != null && !randomcode.equals(validateCode)) {
			// 如果校验失败，将验证码错误失败信息，通过shiroLoginFailure设置到request中
			httpServletRequest.setAttribute("shiroLoginFailure", "randomCodeError");
			// 拒绝访问，不再校验账号和密码
			return true;
		}
		return super.onAccessDenied(request, response);

	}

}
