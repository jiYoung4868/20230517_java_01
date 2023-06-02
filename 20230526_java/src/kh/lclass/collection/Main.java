package kh.lclass.collection;

import kh.lclass.oop.sample.Car;

public class Main {
	public static void main(String[] args) {
//		new TestCollection().testArrayList();
//		new TestCollection().testHashSet();
//		new TestCollection().testHashMap();
//		new TestCollection().testSTack();
		TestCollection tc = new TestCollection();
		String str = tc.testGeneric(35.5, 2);
		System.out.println(str);
//		tc.testGeneric("안녕", 35);
		tc.testGeneric(22, "안녕");
		System.out.println(str);
//		tc.testGeneric(new Car(300), "aaa");
		tc.testGeneric(2222L, "aaa");
		System.out.println(str);
	}

}
