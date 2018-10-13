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
 * ����beanutils�ײ�ʵ��
 */
public class Demo {

	public static void main(String[] args) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {

	}

	// ʹ����ʡ���
	@Test
	public void fun2() throws IntrospectionException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		// 1.����һ�� Map����
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", "tom");
		map.put("password", "123");
		// 2.����javaBean
		User user = new User();

		// 3.ʹ����ʡ��ɲ���
		BeanInfo bif = Introspector.getBeanInfo(User.class);
		//�õ���ǰ���bean�����е�����������
		PropertyDescriptor[] pds = bif.getPropertyDescriptors();
		//�õ�ÿһ������������
		for(PropertyDescriptor pd:pds){
			//�õ�bean��������
			//System.out.println(pd.getName());
			
			//Method setMethod=pd.getWriteMethod();
			//if(setMethod!=null){
				//�õ���ЩsetXxx����
				//System.out.println(setMethod.getName());
			//}
			
			String propertyName=pd.getName(); // username password
			
			if(map.containsKey(propertyName)){
				pd.getWriteMethod().invoke(user, map.get(propertyName));
			}
			
		}
		
		System.out.println(user);
	}

	// ʹ�÷������
	public void fun1() throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		// 1.����һ�� Map����
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", "tom");
		map.put("password", "123");
		// 2.����javaBean
		User user = new User();

		// 3.ʹ��map����key��bean���������һ�£�ʹ��key��Ӧ��value��bean���Ը�ֵ��
		// 3.1�õ�map���ϵ����е�key
		Set<String> keys = map.keySet();

		// 3.2�õ�user�е����е�setXxx����.
		Method[] methods = user.getClass().getDeclaredMethods();
		// �������з���
		for (Method method : methods) {
			String methodName = method.getName();// �õ����еķ��������ơ�

			for (String key : keys) {
				if (methodName.equalsIgnoreCase("set" + key)) { // ʹ�÷���������set+key������ȥ�Ƚϣ������ִ�Сд

					// ����setXxx������ɸ�ֵ����
					method.invoke(user, map.get(key)); // user.setUsername(map.get("username"));
				}
			}

		}
		System.out.println(user);
	}
}
