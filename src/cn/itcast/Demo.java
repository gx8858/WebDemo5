package cn.itcast;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import cn.itcast.domain.User;

/**
 * 关于beanutils底层实现
 */
public class Demo {

	public static void main(String[] args) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {

	}

	// 使用内省完成
	@Test
	public void fun2() throws IntrospectionException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		// 1.定义一个 Map集合
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", "tom");
		map.put("password", "123");
		// 2.定义javaBean
		User user = new User();

		// 3.使用内省完成操作
		BeanInfo bif = Introspector.getBeanInfo(User.class);
		//得到当前这个bean的所有的属性描述器
		PropertyDescriptor[] pds = bif.getPropertyDescriptors();
		//得到每一个属性描述器
		for(PropertyDescriptor pd:pds){
			//得到bean属性名称
			//System.out.println(pd.getName());
			
			//Method setMethod=pd.getWriteMethod();
			//if(setMethod!=null){
				//得到这些setXxx方法
				//System.out.println(setMethod.getName());
			//}
			
			String propertyName=pd.getName(); // username password
			
			if(map.containsKey(propertyName)){
				pd.getWriteMethod().invoke(user, map.get(propertyName));
			}
			
		}
		
		System.out.println(user);
	}

	// 使用反射操作
	public void fun1() throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		// 1.定义一个 Map集合
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", "tom");
		map.put("password", "123");
		// 2.定义javaBean
		User user = new User();

		// 3.使用map集合key与bean对象的属性一致，使用key对应的value给bean属性赋值。
		// 3.1得到map集合的所有的key
		Set<String> keys = map.keySet();

		// 3.2得到user中的所有的setXxx方法.
		Method[] methods = user.getClass().getDeclaredMethods();
		// 遍历所有方法
		for (Method method : methods) {
			String methodName = method.getName();// 得到所有的方法的名称。

			for (String key : keys) {
				if (methodName.equalsIgnoreCase("set" + key)) { // 使用方法名称与set+key的名称去比较，不区分大小写

					// 调用setXxx方法完成赋值操作
					method.invoke(user, map.get(key)); // user.setUsername(map.get("username"));
				}
			}

		}
		System.out.println(user);
	}
}
