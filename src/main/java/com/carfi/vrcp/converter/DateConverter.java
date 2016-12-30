package com.carfi.vrcp.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 时间转换器
 * 
 * @author jiangliuhong
 * @CREATEDATE 2016年12月29日
 */
public class DateConverter implements Converter<String, Date> {
	@Override
	public Date convert(String source) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		try {
			return dateFormat.parse(source);
		} catch (java.text.ParseException e) {
			return null;
		}
	}
}