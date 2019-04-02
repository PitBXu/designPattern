package com.evergrande.designpattern.proxy.cglib;

public class TestCGlibProxy {
	public static void main(String[] args) {
		try {
			ZhangSan obj = (ZhangSan)new Meipo().getInstance(ZhangSan.class);
			obj.findlove();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
