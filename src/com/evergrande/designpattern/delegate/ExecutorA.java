package com.evergrande.designpattern.delegate;

public class ExecutorA implements IExecutor{

	@Override
	public void doing() {
		System.out.println("员工A执行任务！");
	}

}
