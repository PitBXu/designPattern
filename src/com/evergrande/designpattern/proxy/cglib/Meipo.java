package com.evergrande.designpattern.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class Meipo implements MethodInterceptor{
	
	public Object getInstance(Class clz) throws Exception{
		// 通过反射机制 实现
		Enhancer enhancer = new Enhancer();
		// 设置父类
		enhancer.setSuperclass(clz);
		
		//设置回调，回调下面的 intercept方法
		enhancer.setCallback(this);
		// 1. 生成源代码
		// 2.编译成 .class文件
		// 3.加载到JVM 中，返回被代理对象
		return enhancer.create();
	}

	// 同样是做了字节码重组一件事
	// 不再需要接口，对于使用 API 的用户来说是无感知的
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("-----------代理类-------------------");
		System.out.println("开始进行海选......");
		
		// 如果调用 invoke 方法会陷入死循环
		Object res = proxy.invokeSuper(obj, args);
		
		//this.target.xiangQin();
		System.out.println("如果合适的话就结婚");
		return res;
	}
	
}
