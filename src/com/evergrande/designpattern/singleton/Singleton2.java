package com.evergrande.designpattern.singleton;

public class Singleton2 {
	//饿汉式，静态代码块，可用
	private static Singleton2 instance;

    static {
        instance = new Singleton2();
    }

    private Singleton2() {}

    public static Singleton2 getInstance() {
        return instance;
    }
    /**
     *	 这种方式和 1 其实类似，只不过将类实例化的过程放在了静态代码块中，也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例。优缺点和上面是一样的。
     */
}
