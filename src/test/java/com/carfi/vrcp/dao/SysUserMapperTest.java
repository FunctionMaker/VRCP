package com.carfi.vrcp.dao;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SysUserMapperTest {
	
	@Autowired
	private SysUserMapper sysUserMapper;

	@Test
	public void testDeleteByPrimaryKey() {
		
	}

	@Test
	public void testInsert() {
		
	}

	@Test
	public void testInsertSelective() {
		
	}

	@Test
	public void testSelectByPrimaryKey() {
		System.out.println(JSON.toJSONString(sysUserMapper.selectByPrimaryKey("95d3384889d44bf6b0139e5991bd926b")));
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		
	}

	@Test
	public void testUpdateByPrimaryKey() {
		
	}

}
