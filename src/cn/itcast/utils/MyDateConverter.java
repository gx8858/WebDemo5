package cn.itcast.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

public class MyDateConverter implements Converter {

	// ��������������������ת���ķ���
	public Object convert(Class type, Object value) {
		// System.out.println(type);  java.util.Date
		// System.out.println(value); 
		String st = (String) value;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(st);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
