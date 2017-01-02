package com.carfi.vrcp.service.sys;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.carfi.vrcp.query.OrganizationQuery;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SysOrganizationServiceTest {
	
	@Autowired
	private SysOrganizationService sysOrganizationService;

	@Test
	public void testQueryAllByQuery() {
		OrganizationQuery organizationQuery = new OrganizationQuery();
		organizationQuery.setName("长安");
		System.out.println(JSON.toJSONString(sysOrganizationService.queryAllByQuery(organizationQuery)));
	}

	@Test
	public void testSaveOrgAndUser() {
		
	}

	@Test
	public void testUpdateOrg() {
		
	}

	@Test
	public void testDeleteOrg() {
		
	}

	@Test
	public void testQueryOrgById() {
		
	}

}
