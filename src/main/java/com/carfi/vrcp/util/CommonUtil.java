package com.carfi.vrcp.util;

import java.util.UUID;

/**
 * 公用工具类
 * @author ltx
 *
 */
public class CommonUtil {
	
	/**
	 * 生成主键
	 * @return
	 */
	public static String generatePrimaryKey(){
		return UUID.randomUUID().toString().replace("-", "");
	}

}
