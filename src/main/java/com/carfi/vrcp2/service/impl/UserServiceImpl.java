package com.carfi.vrcp2.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carfi.vrcp2.dao.sondao.UserDao;
import com.carfi.vrcp2.pojo.User;
import com.carfi.vrcp2.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public Long save(User t) {
		return userDao.save(t);
	}

	@Override
	public void delete(Serializable id) {
		userDao.delete(id);
	}

	@Override
	public void update(User t) {
		userDao.update(t);
	}

	@Override
	public User queryOne(Serializable id) {
		return userDao.queryOne(id);
	}

	@Override
	public List<User> queryAll() {
		return userDao.queryAll();
	}

	@Override
	public User queryOneByName(String name) {
		return userDao.queryOneByName(name);
	}

}
