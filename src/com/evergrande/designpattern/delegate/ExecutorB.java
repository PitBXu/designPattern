package com.evergrande.designpattern.delegate;

public class ExecutorB implements IExecutor{

	@Override
	public void doing() {
		System.out.println("员工B执行任务！");
	}

}
