package com.evergrande.designpattern.custom;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//代码生成，编译， 重新动态 load 到JVM中
public class MYClassLoader extends ClassLoader{

	private File baseDir;
	
	public MYClassLoader() {
		String basePath = MYClassLoader.class.getResource("").getPath(); 
		this.baseDir = new File(basePath);
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String className = MYClassLoader.class.getPackage().getName() + "." + name;
		if (baseDir != null) {
			File classFile = new File(baseDir,name.replaceAll("\\.", "/") + ".class");
			if (classFile.exists()) {
				FileInputStream in = null;
				try {
					in = new FileInputStream(classFile);
					ByteArrayOutputStream out = new ByteArrayOutputStream();
					byte [] buff = new byte[1024];
					int len;
					while((len = in.read(buff)) != -1) {
						out.write(buff, 0, len);
					}
					return defineClass(className,out.toByteArray(),0,out.size());
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					if (null != in) {
						try {
							in.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return null;
	}
	
}
