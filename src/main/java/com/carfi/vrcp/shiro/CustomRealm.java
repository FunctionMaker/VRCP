package com.carfi.vrcp.shiro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
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
import com.carfi.vrcp.pojo.SysPermission;
import com.carfi.vrcp.pojo.SysRole;
import com.carfi.vrcp.pojo.SysUser;
import com.carfi.vrcp.service.sys.SysMenuService;
import com.carfi.vrcp.service.sys.SysPermissionService;
import com.carfi.vrcp.service.sys.SysRoleService;
import com.carfi.vrcp.service.sys.SysUserService;

/**
 * 自定义的Realm
 * 
 * @author jiangliuhong
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
		// 获取用户身份信息
		SessionUser sessinoUser = (SessionUser) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		// TODO 设置用户登录时间与登录ip
		//从数据中获取权限与菜单
		List<String> pers = permissionService.queryPerCodeByUserId(sessinoUser.getUser().getUserId());
		sessinoUser.setPers(pers);
		simpleAuthorizationInfo.addStringPermissions(pers);
		List<SysMenu> menus = menuService.queryByUserId(sessinoUser.getUser().getUserId());
		sessinoUser.setMenus(menus);
		if(StringUtils.isNotBlank(sessinoUser.getUser().getRoleId())){
			SysRole role = roleService.queryById(sessinoUser.getUser().getRoleId());
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
		// 认证用户
		// 保存用户信息，即吧user类存储在shiro的session中
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(sessionUser,
				user.getPassword(), ByteSource.Util.bytes(user.getSalt()), this.getName());
		return simpleAuthenticationInfo;
	}

}
