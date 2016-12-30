package com.carfi.vrcp2.service;

import com.carfi.vrcp2.pojo.User;

public interface IUserService extends IBaseService<User>{
	
	User queryOneByName(String name);
	
}