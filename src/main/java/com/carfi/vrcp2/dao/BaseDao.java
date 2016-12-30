package com.carfi.vrcp2.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T>{
	
	Long save(T t);
	
	void delete(Serializable id);
	
	void update(T t);
	
	T queryOne(Serializable id);
	
	List<T> queryAll();
	
}
