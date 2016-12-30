package com.carfi.vrcp2.service;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<T> {
	
	Long save(T t);
	
	void delete(Serializable id);
	
	void update(T t);
	
	T queryOne(Serializable id);
	
	List<T> queryAll();
	
}
