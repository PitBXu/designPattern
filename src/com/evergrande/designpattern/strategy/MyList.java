package com.evergrande.designpattern.strategy;

public class MyList {
	public static void sort(Comparator com) {
		Object obj1 = null;
		Object obj2 = null;
		int res = com.CompareTo(obj1,obj2);
		System.out.println("Ö´ÐÐÂß¼­" + res);
	}
	public static void main(String[] args) {
		sort(new ObjectComparator());
	}
}
