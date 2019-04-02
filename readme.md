# Spring

​	开源轻量级java se/java ee 开发应用框架，目的是**简化**企业级应用**开发**。

核心宗旨：简化开发

### 轻量级

​	零配置编程，API使用简单

### 面向Bean

​	只需要编写非常普通的 Bean

### 松耦合

​	充分利用 AOP 思想，各个模块独立开发，合并到一起运行

### 万能胶

​	与主流框架无缝集成

### 设计模式

​	将 Java 中的设计模式用的淋漓尽致

## 没用Spring之前

​	EJB 用于两个不同的应用程序之间进行数据交互，Socket，IO流，Bean的转化

代码公用的方法：

* 继承
* 类作为成员变量

使用 Spring ，只需要声明。

#### 设计初衷：简化 java 开发，4个关键策略：

* 基于POJO的轻量级和**最小侵入性编程**
* 通过依赖注入和面向接口**松耦合**
* 基于切面和惯性进行**声明式编程**
* 通过切面和模板减少样板式代码

#### 三个关键策略：

 	1. 面向 Bean
 	2. 依赖注入
 	3. 面向切面

### 面向 Bean

​	**BOP** （Bean Oriented Programming）

IOC 容器：**存储 Bean**，保留 Bean之间的依赖关系

​	控制反转

​	@Autowrite A a; // Spring 负责实例化，控制权交给 Spring

​	Spring 创建的对象 保存在 IOC 容器，类似的，web容器：用来装 Servlet

### 控制反转 - > 实现依赖注入（IOC  -> DI）

​	@Autowrite Interface A a; // 自动将 A的实现类注入进来了；

​	@Resource("aaa") A b; // 从 IOC 容器中找到 id 为 aaa 的对象自动注入到这里，而且可以区别父子类

​	@Autowrite A a; // 根据类型自动注入

##### 实例化的先后顺序：

```java
class C {
    private A a;
    private void func(){
        a.execute();
    }
}
class A {
    private B b;
}
```

Spring 识别类中的依赖关系，根据依赖链进行初始化。**依赖链中的所有对象**，都放到 IOC 容器。

##### Spring 注入方式：

* set 方法
* 构造方法
* 强制赋值（private 的也能赋值）

### 面向切面（AOP） --  解耦

​	是一种编程思想，对横切关注点进行模块化

​	先把一个整体拆开，分别开发，到发布的时候再组装到一起分别运行。

#### 面向切面用在哪？

*  Authentication 权限认证
* Logging 日志
* Transactions Manager 事务
* Lazy Loading 懒加载
* Context Process 上下文处理
* Error Handler 错误跟踪（异常捕获机制）
* Cache 缓存



# Spring 常用的设计模式

## 代理模式

1. 事情必须做，而自己没时间做或不想做
2. 持有被代理对象的引用
3. 代理关心过程，自己并不关心过程

角色：中介，黄牛，媒婆，经纪人

特点：

 	1. 执行者、被代理人
 	2. 对于被代理人来说，这件事情是一定要做的，但是自己不想做，或者没时间做。
 	3. 代理的要求：需要获取到被代理人的个人资料

实现：

​	代理类要 实现 java.lang.reflect.InnvocationHandler 类，

​	使用 innvoke() 方法

媒婆代理类：

```java
private Person target;// 被代理类
	
public Object getInstance(Person target) throws Exception{
	this.target = target; // 获取被代理类的个人信息（对象）
	//反射机制获取类
	Class clazz = target.getClass();	
	return Proxy.newProxyInstance(target.getClass().getClassLoader(), clazz.getInterfaces(), this);
    // 代理类的 getInstance() 方法返回新的 class （实现被代理对象的接口，根据被代理对象的引用动态生成新的类）
}
//代理的执行方法
@Override
public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	System.out.println("-----------代理类-------------------");
	System.out.println(this.target.getName() + "的性别是 " + this.target.getSex());
	System.out.println("开始进行海选......");
	//this.target.xiangQin();
	method.invoke(this.target, args);
	System.out.println("如果合适的话就结婚");
	return null;
}
```

### 静态代理、动态代理

JDK 动态代理

CGLib 动态代理（使用继承的方式实现，不需要接口）

### 代理总结

动态代理 & cglib 做了字节码重组，

做了什么事情？

​	<font color='red'>在每个方法执行之前，加一些代码。在方法调用之后再加一些代码</font>

##### AOP 中的代理： 事务代理、日志监听

service 方法

<font color='blue'>开启一个事务，</font>

<font color='red'>事务的执行是由我们自己写的代码完成的</font>

<font color='blue'>监听到是否有异常，可能需要根据这个异常的类型来决定这个事务是否需要回滚还是继续提交（commit/rollback）</font>

<font color='blue'>事务关闭（close）</font>

## 工厂模式

1. ##### 隐藏复杂的逻辑过程，只关心结果 - > 结果论

   与代理模式关心过程不同，工厂模式关心结果

   在 生产者消费者模型里，工厂 -> 生产者

   消费者不关心产品是怎么生产出来的，包括生产工艺，生产材料等。

   工厂对用户来说是无感知的

   工厂模式封装实现的细节，只展示结果

#### 简单工厂模式

```java
public interface Car {
	//汽车产品接口
	//汽车的生产需要满足一定标准
	String getBrand();
}
public class BMW implements Car {
	@Override
	public String getBrand() {
		// TODO Auto-generated method stub
		return "BMW";
	}
}
public class Audi implements Car {
	@Override
	public String getBrand() {
		// TODO Auto-generated method stub
		return "Audi";
	}
}
public class SimpleCarFactory {
	// 实现 统一化，专业化管理
	// 如果没有工厂模式 - > 小作坊，三无产品
    // 存在的问题：这种工厂竟然能生产各种品牌的车，不合实际
	public Car getCar(String name) {
		if ("BMW".equals(name.toUpperCase())) {
			return new BMW();
		}else if("AUDI".equals(name.toUpperCase())) {
			return new Audi();
		}else {
			return null;
		}
	}
}
public class SimpleFactoryTest {
	public static void main(String[] args) {
		//用户只关心车，不关心车怎么生产的
		Car car = new SimpleCarFactory().getCar("BMW");
		System.out.println(car.getBrand());
	}
}
```

##### 简单工厂模式实际中并不存在，只是让大家了解工厂模式

#### 工厂方法模式

```java
//工厂接口定义了 所有工厂的执行标准
public interface Factory {
	// 符合汽车的标准
	// 尾气排放标准
	// 必须配备安全气囊
	// 轮胎耐磨
	Car getCar();
}
public class BMWFactory implements Factory {
	@Override
	public Car getCar() {
		// TODO Auto-generated method stub
		return new BMW();
	}
}
public class AudiFactory implements Factory {
	@Override
	public Car getCar() {
		// TODO Auto-generated method stub
		return new Audi();
    }
}
public class MethodFactoryTest {
	public static void main(String[] args) {
		Factory factory = new AudiFactory();
		Car car = factory.getCar();
		System.out.println(car.getBrand());
		
		// 问题：用户开始需要关心，这个产品的生产商
		factory = new BMWFactory();
	}
}
```

#### 抽象工厂模式（Spring中用到很多）

```java
public abstract class AbstractFactory {
	// 抽象的工厂方法不直接用，使用DefaultFactory
	protected abstract Car getCar();
	
	public Car getCar(String name) {
		if ("BMW".equals(name.toUpperCase())) {
			return new BMWFactory().getCar();
		}else if("AUDI".equals(name.toUpperCase())) {
			return new AudiFactory().getCar();
		}else {
			return null;
		}
	}
}
public class AudiFactory extends AbstractFactory {
	@Override
	protected Car getCar() {
		// TODO Auto-generated method stub
		return new Audi();
	}
}
public class BMWFactory extends AbstractFactory {
	@Override
	protected Car getCar() {
		// TODO Auto-generated method stub
		return new BMW();
	}
}
public class DefaultFactory extends AbstractFactory{
	private AudiFactory defaultFactory = new AudiFactory();
	@Override
	protected Car getCar() {
		// TODO Auto-generated method stub
		return defaultFactory.getCar();
	}
}
public class AbstractFactoryTest {
	public static void main(String[] args) {
		DefaultFactory def = new DefaultFactory();
		System.out.println(def.getCar("bmw").getBrand());
	}
}
```

### 总结

工厂模式的特点：

​	把复杂的逻辑处理过程隐藏，只关心执行结果

##### Spring中的工厂模式：

​	生产 Bean -> BeanFactory

* 单例的 Bean
* 被代理过的 Bean
* 最原始的 Bean （原型）
* List 类型的 Bean
* 作用域不同的 Bean

getBean() 方法可以获取所有Bean，但是会导致紊乱，逻辑复杂，维护困难。



## 单例模式 Singleton

#### 是什么？

* 保证从系统启动到停止，全过程只会产生一个实例

#### 为什么要有单例模式？

* 举例：
  * 配置文件：如果两个配置文件内容一样，不用单例就导致有一个浪费。如果不一样导致冲突。
  * 公司领导：两个领导将会导致管理冲突。 
* 当我们在应用中遇到功能性冲突的时候，需要使用单例模式。

#### 怎么实现单例模式？

单例模式的7种写法（推荐使用静态内部类的懒汉式（Lazy Loading）模式）



## 委派模式 Delegate

1. 类似于中介的功能（委托机制）
2. 只有被委托人的引用

##### 什么是委派模式？

两个角色：受托人，委托人（社会上是平等的关系）

例如：项目经理，普通员工（法律上是平等的关系，但工作上的职责不一样）

​	项目经理（委托人）：安排任务

​	普通员工（受托人）：执行任务

**特点**：

1. 干活是你的（受托人），功劳是我的（委托人）。
2. 类似于中介（委托）。
3. 持有被委托人的引用。
4. 不关心过程，只关心结果。结果有多样性（不同的受托人做，结果不一样，受托人找到合适的委托人去执行）。

##### 为什么用到委派模式？

​	主要目的是为了隐藏具体的实现逻辑（这一点上类似于工厂模式）

##### Spring 中哪里用到委派模式？

​	IOC 容器中，有一个 Register 的东西（为了告诉我们的容器，在这个类被初始化的过程中，需要做很多不同的逻辑处理，需要实现多个任务执行者（受托人），分别实现各自的功能）



## 策略模式

1. 过程不同，但结果一样

##### 什么是策略模式？

​	出发点和目的地是不变的，但是到达目的地有多种方法，过程多样。（数字类型如何比较，String类型如何比较）

## 原型模式

1. 过程相同，但结果不一样，模板模式（提高开发效率）

##### 什么是原型模式？

​	使用 clone 的时候，原有的对象就是原型。obj.clone() 方法是 native 的。

##### 为什么使用原型模式？

​	应用于 对象的 clone

##### 什么是深拷贝？浅拷贝?

能够直接拷贝（浅拷贝）其实际内容的的数据类型，只支持9种（八大数据类型 + String）

而对引用类型的拷贝只是复制了地址

```java
	public Object clone() {
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			//序列化
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(this);
			
			//反序列化
			bis = new ByteArrayInputStream(bos.toByteArray());
			ois = new ObjectInputStream(bis);
			TheGreatestSage copy = (TheGreatestSage) ois.readObject();
			copy.setBirthday(new Date());
			
			return copy;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				bos.close();
				oos.close();
				bis.close();
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
```



## 模板模式

1. 执行流程一样
2. 关心的是执行流程

##### 实现方式：

* 先创建抽象类定义执行流程和公共操作
* 定义子类（具体的实现），按照模板定义的流程，细化具体步骤的执行。

#### Spring JDBC

> 是 java 规范，各个数据库厂商自己去实现

1. 加载驱动 DriverManager
2. 建立连接
3. <font color='#f4c'>创建语句集（标准语句集，预处理语句集）</font>（语句集不一样，Mysql，Oracle，SQLServer，Access）
4. 执行语句集
5. 查询语句会返回结果集 ResultSet  游标
6. ORM 框架（如Hibernate）等



## Spring 思想总结

| Spring思想 | 应用场景（特点）                                             | 一句话归纳            |
| ---------- | ------------------------------------------------------------ | --------------------- |
| AOP        | 1. Aspect Oriented Programming<br/>2. 找出多个类中有一定规律可循的代码，开发时拆开，运行时再合并<br />3. 面向切面编程，即面向规则编程 | 解耦，专人<br/>做专事 |
| OOP        | 1. Object Oriented Programming<br />2. 归纳总结生活中的一切事物 | 继承、封装、多态      |
| BOP        | 1. Bean Oriented Programming<br />2. 面向Bean（普通的 java 类）设计程序 | 一切从 Bean开始       |
| IOC        | 1. Inversion of Control<br />2. 将 new 对象的动作交给 Spring 管理，并由 Spring 保存已创建的对象 | 控制反转              |
| DI/DL      | 1. Dependency Injection / Dependency Lookup<br />2. 依赖注入、依赖查找、Spring 不仅保存自己创建的对象，而且对象与对象之间的关系。<br />3. 注入即赋值，主要通过三种方式：构造方法、set 方法、直接赋值 | 先理清关系再赋值      |

## 设计模式总结

| 设计模式          | 应用场景（特点）                                             | 一句话归纳                                           |
| ----------------- | ------------------------------------------------------------ | ---------------------------------------------------- |
| 代理模式 Proxy    | 1. 两个参与角色：执行者、被代理人<br />2. 对于被代理人来说，这件事是一定要做的，但是我自己没时间做或者不想做，找代理。<br />3. 需要获取被代理人的个人资料 | 办事要求人，所以找代理                               |
| 工厂模式 Factory  | 1. 对调用者隐藏复杂的逻辑处理过程，调用者只关心执行结果<br />2. 工厂要对结果负责，保证生产出符合规范的产品 | 只对结果负责，不要三无产品                           |
| 单例模式Singleton | 1. 保证从系统启动到终止，全过程只会产生一个实例              | 保证独一无二                                         |
| 委派模式Delegate  | 1. 两个参与角色，委托人和被委托人<br />2. 委托人和被委托人在权利上完全平等（即实现同一个接口）<br />3. 委托人持有被委托人的引用<br />4. 不关心过程，只关心结果 | 干活是你的（普通员工），<br />功劳是我的（项目经理） |
| 策略模式Strategy  | 1. 执行最终结果一样<br />2. 执行过程和执行逻辑不一样         | 我行我素，达到目的就行                               |
| 原型模式Prototype | 1. 首先有一个原型<br />2. 数据内容相同，但对象实例不同（完全不同的两个内存地址） | 拔一根猴毛，吹出千万个                               |
| 模板模式Template  | 1. 执行流程固定，但中间有些步骤有细微差别。<br />2. 可实现批量生产 | 流程标准化，原料自己加                               |

