package com.evergrande.designpattern.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyListTest {
	public static void main(String[] args) {
		
		List<Long> list = new ArrayList<>();
		
		Collections.sort(list, new Comparator<Long>() {

			// 返回值是固定的
			// 0、-1、1
			public int compare(Long o1, Long o2) {
				// 实现不同的策略
				return 0;
			}
			
		});
	}
}
