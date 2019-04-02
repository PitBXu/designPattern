package com.evergrande.designpattern.custom;

import java.lang.reflect.Method;

public interface MYInvocationHandler {
	public Object invoke(Object proxy, Method method, Object[] args)
	        throws Throwable;
}
