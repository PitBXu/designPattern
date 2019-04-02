package com.evergrande.designpattern.proxy;

import java.io.FileOutputStream;

import sun.misc.ProxyGenerator;

public class TestFindLove {
	public static void main(String[] args) {
		try {
			Person obj = (Person) new Meipo().getInstance(new ZhangSan());
			
			System.out.println("���������ǣ�" + obj.getClass());
			
			/*
			 * ����person�����װ�����ˣ�����obj��xiangqin����ʱ�Զ�ִ�д���
			 * 
			 */
			obj.xiangQin();	//������obj��ʲô����ִ�д���������ִ��ԭ����xiangQin()����
			
			//��ȡ�ֽ�������
			byte [] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});//���ڴ��ж�����
			FileOutputStream os = new FileOutputStream("D:\\test\\designPattern\\src\\com\\evergrande\\designpattern\\proxy\\$Proxy0.class");
			os.write(data);
			os.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
