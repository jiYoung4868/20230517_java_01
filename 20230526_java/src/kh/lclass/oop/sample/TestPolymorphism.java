package kh.lclass.oop.sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TestPolymorphism {
	int grade;
	int age;
	
	public static void main(String[] args) {
		
		ArrayList<Car> carArrList = new ArrayList<Car>();
		List<Car> carList = new ArrayList<Car>();
		List<Car> carList2 = new LinkedList<Car>();
		Collection<Car> carCollection = new ArrayList<Car>();
		
		
	TestInterface kh = new Kh(); //new TestInterface(); 는 오류
	
	((Kh)kh).khSpecial();
	
	TestInterface bit;
	TestInterface bit2;

	Kh kh2 = new Kh(); //khSpecial 쓰고싶을때
	kh2.khSpecial();
	kh2.method1();
	
	Driver ej = new DriverSub();
	ej.setMoney(10000);
	ej.buy(new Avante());
	ej.buy(new Sonata());
	
	Driver jh = new Driver2Sub();
	ej.setMoney(10000);
	ej.buy(new Avante());
	ej.buy(new Sonata());

	}
}