package kh.lclass.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.function.UnaryOperator;

import kh.lclass.oop.sample.Car;

public class TestCollection {
	
	public <E extends Number, J> String testGeneric(E a, J b){
		System.out.println(a.getClass().getName());
		System.out.println(b.getClass().getName());
		return a.toString()+"결과값" + b.toString();
		
	}
	
	public void testSTack() { //LIFO
		Stack<String> strStack = new Stack<String>();
		strStack.push("안녕");
		strStack.add("하");
		strStack.push("세요");
		System.out.println(strStack);
		System.out.println(strStack.get(1));//가져오기
		System.out.println(strStack);
		System.out.println(strStack.peek());//꺼내서 읽고 제거는 안함
		System.out.println(strStack);
		System.out.println(strStack.pop());//꺼내서 읽고 제거함
		System.out.println(strStack);
		
	}

	public void testHashMap() {
		Map<String, Object> objMap = new HashMap<String, Object>(); // K=자료형
		objMap.put("ej", 35);
		objMap.put("jy", "지영이네");
		objMap.put("hj", new Car(5000));
		System.out.println(objMap.toString());
		System.out.println("jy" + ":" + objMap.get("jy"));
		Set<String> keyset = objMap.keySet();// key 찾는 법
		System.out.println(keyset);
		System.out.println("=====map: enhanced for=====");
		for (String item : keyset) {
			Object value = objMap.get(item);
			System.out.println(item + " : " + value);
		}
		System.out.println("=====map: Iterator for=====");
		
		Iterator<String> itr = keyset.iterator();
		while (itr.hasNext()) {
		String item = itr.next();
		Object value = objMap.get(item);
		System.out.println(item + " : " + value);
		}
	}

	public void testHashSet() {
		Set<Integer> integerSet = new HashSet<Integer>(); // interface는 object 상속받지 않음x100
		integerSet.add(11);
		integerSet.add(22);
		integerSet.add(33);
		integerSet.add(11); // 중복값은 하나만 표현
		System.out.println(integerSet.toString());
		System.out.println("=====set:enhanced for=====");

		for (Integer item : integerSet) {
			System.out.println(item);
		}
		System.out.println("=====set:Iterator 사용=====");
		Iterator<Integer> itr = integerSet.iterator();
		System.out.println(itr);
		while (itr.hasNext()) {
			Integer item = itr.next();
			System.out.println(item);
		}

	}

	public void testArrayList() {
		String[] strArr1 = new String[3];
		strArr1[0] = "바나나";
		strArr1[1] = "딸기";
//		strArr1[3] = "수박";
		strArr1.clone();
//		System.out.println(strArr1[3]);

		/*
		 * public class ArrayList implements List{ public boolean add(object e){ // }
		 * public boolean add(String e){ // } public boolean add(Integer e){ // } public
		 * boolean add(Double e){ // } public boolean add(Car e){ // } }
		 */

		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<Integer> list2 = new ArrayList<Integer>(); // int라 안쓰고 integer, why? 참조형
		ArrayList<Car> list3 = new ArrayList<Car>();
		list3.add(new Car(3000));
		list2.add(25);
		list2.add(26);
		list2.add(null);
		list2.add(27);
		list2.add(55);
		list2.add(2, 56); // 끼워넣기시, index가 현재 size보다 클 수 없음
		System.out.println(list2.get(2));
		System.out.println(list2.get(3));

//		배열 ==> for문과 짝궁
		System.out.println("=====list.get=====");

		for (int i = 0; i < list2.size(); i++) { // 배열은 length List는 size()
			Integer item = list2.get(i);
			System.out.println(item);
		}
		for (int i = 0; i < strArr1.length; i++) {
			String item = strArr1[i];
			System.out.println(strArr1[i]);
		}

		System.out.println("=====enhanced for=====");

		// enhanced-for
		for (Integer item : list2) {
			System.out.println(item);
		}
		for (String item : strArr1) {
			System.out.println(item);
		}

		list1.add("2번"); // 0번 인덱스
		if (list1.add("7번")) {
			System.out.println("list1에 추가 성공했습니다.");
		}
		list1.add("1번"); // 1번 인덱스
		list1.add("2번"); // 2번 인덱스
		list1.add("3번"); // 3번인덱스
		list1.add(1, "2번대신끼워넣기"); // 만약에 여기서 2번인덱스에 넣는다면 2번이 3번이됨
//		list1.remove("2번");//값이 2번인 첫번째 애를 삭제
		Collection<String> collection1 = new ArrayList<String>();
		collection1.add("2번"); // 2번 다 지워버림 (but collection이어야함)
//		collection1.add("3번");
		list1.removeAll(collection1);
		((ArrayList<String>) list1).clone();

		if (list1 instanceof ArrayList) {
			ArrayList<String> copyList = (ArrayList<String>) (((ArrayList<String>) list1).clone()); // 다운캐스팅 #얘의 모양을
																									// 물어보기
			System.out.println(copyList);
		}

//		list.remove(0);
//		list.clear();
		System.out.println(list1);
	}
}
