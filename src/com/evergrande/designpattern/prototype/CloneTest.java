package com.evergrande.designpattern.prototype;

public class CloneTest {
	
	public static void main(String[] args) {
		
		ConcretePrototype cp = new ConcretePrototype();
		cp.setAge(18);
		cp.list.add("Corey");
		
		try {
			// 克隆和 直接赋值的区别：克隆得到的是完全两个对象；
			// 克隆机制：直接复制字节码
			ConcretePrototype copy = (ConcretePrototype)cp.clone();
			System.out.println(copy.getAge() + "," + cp.list.size());
			// 发现是 true，因为只是 “浅拷贝” ，直接拷贝的地址，改进：使用list.clone();
			System.out.println(copy.list == cp.list);
			copy.list.add("Ha");
			System.out.println(cp.list.size());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		/**
		 *  原型模式： 有一个现成的对象，这个对象里面已经有设置好的值， 
		 *  现在我要新建一个对象， 并且要给新建的对象赋值，而且赋值的内容要和之前一模一样
		 */		
	}
}
