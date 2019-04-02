package com.evergrande.designpattern.delegate;

public class Dispatcher implements IExecutor{
	
	// 委托人类
	
	IExecutor executor;
	
	Dispatcher(IExecutor executor){
		this.executor = executor;
	}
	//项目经理也执行，但是工作职责不一样
	public void doing() {
		this.executor.doing();
	}
	
}
