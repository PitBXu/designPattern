package com.evergrande.designpattern.delegate;

public class DispatcherTest {
	public static void main(String[] args) {
		
		Dispatcher dispatcher = new Dispatcher(new ExecutorA());
		//看起来好像是项目经理在干活，实际是普通员工在干活
		dispatcher.doing();
	}
}
