package com.evergrande.designpattern.custom;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask; 

// 生成代理对象的代码
public class MYProxy {
	

	public static final String LN = "\r\n";
	
	
	public static Object newProxyInstance(MYClassLoader loader, Class<?>[] interfaces, MYInvocationHandler h) {
		//1.生成源代码
		String proxySrc = generateSrc(interfaces);
		//2.保存为 *.java文件
		String filePath = MYProxy.class.getResource("").getPath();
		System.out.println(filePath);
		File f = new File(filePath + "$Proxy0.java");
		FileWriter fw;
		try {
			fw = new FileWriter(f);
			fw.write(proxySrc);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//3.编译源代码，生成*.class文件
				
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
		Iterable iterable =  manager.getJavaFileObjects(f);
		CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
		task.call();
		try {
			manager.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//4.将class文件中的内容动态加载到JVM
				
		//5.返回被代理后的对象
		try {
			Class proxyClass = loader.findClass("$Proxy0");
			Constructor c = proxyClass.getConstructor(MYInvocationHandler.class);
			return c.newInstance(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	/**
	 * 生成源代码
	 * @param interfaces
	 * @return
	 */
	private static String generateSrc(Class<?>[] interfaces) {
		StringBuffer src = new StringBuffer();
		src.append("package com.evergrande.designpattern.custom; " + LN);
		src.append("import java.lang.reflect.Method; " + LN);
		src.append("public final class $Proxy0 implements " + interfaces[0].getName() + "{" + LN);
		
		src.append("MYInvocationHandler h;" + LN);
		
		src.append("public $Proxy0(MYInvocationHandler h) {" + LN);
		src.append("this.h = h;" + LN);
		src.append("}" + LN);
		
		for (Method m : interfaces[0].getMethods()) {
			src.append("public " + m.getReturnType().getName() + " " + m.getName() + "(){ " + LN);
			src.append("try{" + LN);
			src.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\", new Class[]{});" + LN);
			src.append("this.h.invoke(this,m,null);" + LN);
			src.append("}catch(Throwable e){ "+LN+"e.printStackTrace();"+LN+"}" + LN);
			if (!m.getReturnType().getName().equals("void")) {
				src.append("return null;" + LN);
			}
			src.append("}" + LN);
		}
		
		src.append("}");
		
		return src.toString();
	}
}
