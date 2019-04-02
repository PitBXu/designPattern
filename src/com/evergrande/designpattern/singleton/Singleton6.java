package com.evergrande.designpattern.singleton;

public class Singleton6 {
	private static volatile Singleton6 singleton;

    private Singleton6() {}

    public static Singleton6 getInstance() {
        if (singleton == null) {
            synchronized (Singleton6.class) {
                if (singleton == null) {
                    singleton = new Singleton6();
                }
            }
        }
        return singleton;
    }
/**
 * Double-Check������ڶ��߳̿�������˵����İ�������������ʾ��
 *   ���ǽ���������if (singleton == null)��飬�����Ϳ��Ա�֤�̰߳�ȫ�ˡ�
 *   ������ʵ��������ֻ��ִ��һ�Σ������ٴη���ʱ���ж�if (singleton == null)��
 *   ֱ��returnʵ��������
 *   �ŵ㣺�̰߳�ȫ���ӳټ��أ�Ч�ʽϸߡ�
 */
}
