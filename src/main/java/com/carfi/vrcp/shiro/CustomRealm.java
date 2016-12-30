package com.carfi.vrcp.shiro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.carfi.vrcp.pojo.SessionUser;
import com.carfi.vrcp.pojo.SysUser;

/**
 * 自定义的Realm
 * 
 * @author jiangliuhong
 * @createTime 2016年7月16日 上午11:54:15
 * @function
 */
public class CustomRealm extends AuthorizingRealm {

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
		SessionUser user = (SessionUser) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		// 从数据中获取权限
//		List<String> permissions = roleService.getPermissionByUsername(user.getUsername());
//		// 查到权限数据，返回授权信息
//		simpleAuthorizationInfo.addStringPermissions(permissions);
//		// 保存用户角色
//		List<TbRole> roles_ = roleService.getRolesByUserId(user.getId().intValue());
//		Set<String> roles = new HashSet<>();
//		for (TbRole role : roles_) {
//			roles.add(role.getName());
//		}
//		simpleAuthorizationInfo.setRoles(roles);
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
//		TbUser user = userService.getByUsername(username);
		SessionUser sessionUser = new SessionUser();
		SysUser user = new SysUser();
		user.setPassword("980665155811dde06762339f6e3a32bc");
		user.setUsername("aaa");
		sessionUser.setUser(user);
		//ZgLFk加盐密码:6a7e70a5cadad52c8c80c4ce31c5da03
		// 得到用户密码
		String password = user.getPassword();
		// 认证用户
		// 保存用户信息，即吧user类存储在shiro的session中
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, password, this.getName());
		simpleAuthenticationInfo = new SimpleAuthenticationInfo(sessionUser, password,ByteSource.Util.bytes("zeaRW") ,this.getName());
		return simpleAuthenticationInfo;
	}

}
