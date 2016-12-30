package com.carfi.vrcp2.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.carfi.vrcp2.constant.Constant;
import com.carfi.vrcp2.pojo.OrgUser;

public class OrgLoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		OrgUser orgUser = (OrgUser)request.getSession().getAttribute(Constant.ORG_USER_IN_SESSION);
		if(orgUser == null){
			response.sendRedirect(request.getServletContext().getContextPath()+"/org/login/index");
			return false;
		}
		return true;
	}

}
