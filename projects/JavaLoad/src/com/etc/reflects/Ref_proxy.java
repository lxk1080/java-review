package com.etc.reflects;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Ref_proxy {
	public static void main(String[] args) {
		UserDao ud = new UserDaoImpl();
		ud.add();
		ud.delete();
		ud.update();
		ud.find();
		System.out.println("-----------");
		// 我们要创建一个动态代理对象，只可用来代理接口
		// Proxy类中有一个方法可以创建动态代理对象
		// public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
		MyInvocationHandler handler = new MyInvocationHandler(ud);
		UserDao proxy = (UserDao) Proxy.newProxyInstance(ud.getClass().getClassLoader(), ud.getClass().getInterfaces(), handler);
		proxy.add();
		proxy.delete();
		proxy.update();
		proxy.find();
	}
}

/*
 * 创建代理对象的一个参数
 */
class MyInvocationHandler implements InvocationHandler {
	private Object target; // 目标对象

	public MyInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("权限校验");
		Object result = method.invoke(target, args);
		System.out.println("日志记录");
		return result; // 返回的是代理对象
	}
}

/*
 * 用户操作接口
 */
interface UserDao {
	public abstract void add();

	public abstract void delete();

	public abstract void update();

	public abstract void find();
}

/*
 * 实现接口
 */
class UserDaoImpl implements UserDao {

	@Override
	public void add() {
		System.out.println("添加功能");
	}

	@Override
	public void delete() {
		System.out.println("删除功能");
	}

	@Override
	public void update() {
		System.out.println("修改功能");
	}

	@Override
	public void find() {
		System.out.println("查找功能");
	}

}

