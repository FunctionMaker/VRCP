package com.carfi.vrcp.shiro;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.carfi.vrcp.pojo.SessionUser;
import com.carfi.vrcp.pojo.SysMenu;
import com.carfi.vrcp.pojo.SysRole;
import com.carfi.vrcp.pojo.SysUser;
import com.carfi.vrcp.service.sys.SysMenuService;
import com.carfi.vrcp.service.sys.SysPermissionService;
import com.carfi.vrcp.service.sys.SysRoleService;
import com.carfi.vrcp.service.sys.SysUserService;

/**
 * 自定义的Realm
 * 
 * @author jiangliuhongO
 * @createTime 2016年7月16日 上午11:54:15
 * @function
 */
public class CustomRealm extends AuthorizingRealm {

	@Autowired
	private SysUserService userService;
	@Autowired
	private SysPermissionService permissionService;
	@Autowired
	private SysMenuService menuService;
	@Autowired
	private SysRoleService roleService;
	
	@Override
	public String getName() {
		return "customRealm";
	}

	/**
	 * 授权 只有通过认证方法后，才会执行该方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//super.doClearCache(principals);
		// 获取用户身份信息
		SessionUser sessionUser = (SessionUser) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		// TODO 设置用户登录时间与登录ip
		//从数据中获取权限与菜单
		List<String> pers = permissionService.queryPerCodeByUserId(sessionUser.getUser().getUserId());
		sessionUser.setPers(pers);
		simpleAuthorizationInfo.addStringPermissions(pers);
		List<SysMenu> menus = menuService.queryByUserId(sessionUser.getUser().getUserId());
		sessionUser.setMenus(menus);
		if(StringUtils.isNotBlank(sessionUser.getUser().getRoleId())){
			SysRole role = roleService.queryById(sessionUser.getUser().getRoleId());
			simpleAuthorizationInfo.addRole(role.getName());
		}
		return simpleAuthorizationInfo;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// token 中包含用户名username 、密码 password
		// 取出用户名
		String username = (String) token.getPrincipal();
		// 从数据库中去用户
		SysUser user = userService.queryByUsername(username);
		if(user == null){
			return null;
		}
		SessionUser sessionUser = new SessionUser();
		sessionUser.setUser(user);
		sessionUser.setId(user.getUserId());
		List<SysMenu> menus = menuService.queryByUserId(sessionUser.getUser().getUserId());
		sessionUser.setMenus(menus);
		// 认证用户
		// 保存用户信息，即把user类存储在shiro的session中
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(sessionUser,
				user.getPassword(), ByteSource.Util.bytes(user.getSalt()), this.getName());
		return simpleAuthenticationInfo;
	}

	// 清除缓存
	public void clearCached() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}
}
