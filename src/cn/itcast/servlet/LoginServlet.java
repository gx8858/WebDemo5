package cn.itcast.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import cn.itcast.domain.User;
import cn.itcast.utils.MyDateConverter;

/**
 * ʹ��beanutils��������װ����
 */
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// // 1.�õ��������
		// String username = request.getParameter("username");
		// String password = request.getParameter("password");
		//
		// // 2.��װ���������javaBean
		// User user = new User();
		// user.setUsername(username);
		// user.setPassword(password);
		//
		// System.out.println(user);

		// ʹ��beanutils�����������������.

		User user = new User();

		//ע������ת����
		ConvertUtils.register(new MyDateConverter(), java.util.Date.class);
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		System.out.println(user);
	}

}
