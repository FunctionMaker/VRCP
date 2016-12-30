package com.carfi.vrcp2.dao.sondao;

import com.carfi.vrcp2.dao.BaseDao;
import com.carfi.vrcp2.pojo.User;

/**
 * 用户数据持久层
 * @author ltx
 *
 */
public interface UserDao extends BaseDao<User>{
    
	/**
	 * 通过用户名查询用户
	 * @param name
	 * @return
	 */
	User queryOneByName(String name);
	
}