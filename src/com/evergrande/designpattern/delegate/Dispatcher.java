package com.evergrande.designpattern.delegate;

public class Dispatcher implements IExecutor{
	
	// ί������
	
	IExecutor executor;
	
	Dispatcher(IExecutor executor){
		this.executor = executor;
	}
	//��Ŀ����Ҳִ�У����ǹ���ְ��һ��
	public void doing() {
		this.executor.doing();
	}
	
}
