package kh.lclass.oop.sample;

public class Person {

 private String name;
 private int age;
 private char gender; //남, 여
 
//기본 생성자 만들어주세요
// allAr all arguments constructor
// getter/setter

 	public Person () {} //기본생성자
 	public Person (int age, String name, char gender, final int maxCnt) { //매개인자 받는 생성자라 값을 넣을 수 없음
 		this.age=age;
 		this.name=name;
 		this.gender=gender;
 	} //all Arguments Constructor = 모든 매개인자 받아서 처리하는 생성자
 	
 //1. aAC가 없으면 기본생성자 생략 가능 2. class 필드 변수와 이름 같아야 함 3. 리턴값이 없음 4. 생성자는 여러개일 수 있음
 	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	};

}
 	
