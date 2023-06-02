package kh.lclass.oop.run;

import kh.lclass.oop.sample.Person;
import kh.lclass.oop.sample.Student;

public class TestArray {
	final int a = 10;

	public static void main(String[] args) {
		
		Object obj1 = new Student();
		Object obj2 = new Person();
		Person p1 = new Student();
		Student s1 = new Student();	
//		obj1.
		p1.getName();
		s1.getAge();
		
		final int b=11;
		int n=0;
		for(final int maxCnt=5; n<10; n++) {
			System.out.println("테스트 "+ n );
		}
		//방법1
		Person[] personArray2 = new Person[] {new Person(), new Person(), new Person()};
		//방법2
		Person[] personArray = new Person[22];
		for(int i=0; i<personArray.length; i++) {
			personArray[i] = new Person();
		}
		
		Person[] personArray3 = new Person[22];
		//personArray3[0].setAge(25);
		//NullPointerException 
		//원인: 점을 찾아서 점 앞에 있는 변수(객체=인스턴스)가 null상태
		//즉 personArray[0]이 null 주소값을 가지고 있었음.
		//해결방법: 변수(객체=인스턴스)에 new 생성자();를 해줌
		
		personArray3[0] = new Person();
		personArray3[0].setAge(25);
		personArray3[0].setName("김소똥");
		personArray3[0].setGender('여');
		
		personArray3[1] = new Person(19,"김개똥",'남', 5);
		personArray3[2] = new Person(25,"김말똥",'남', 10);
		
		System.out.println(personArray3[0].getName());
		
		Student[] stdArray = new Student[3]; //배열 생성
		for(int i=0; i<stdArray.length; i++) {
			stdArray[i] = new Student() {
				@Override
				public int getGrade() {
					return 0;
				}
				@Override
				public void setGrade(int grade) {
					System.out.println("학년 " + 3);
				}
			};
		}
		stdArray[0].setAge(15);
		stdArray[0].setName("김영희");
		stdArray[0].setGender('여');
		stdArray[0].setScore(85);
		stdArray[0].setGrade(3);
		System.out.println(stdArray[0].getName());
		System.out.println(stdArray[0].getAge());
		System.out.println(stdArray[0].getGender());
		System.out.println(stdArray[0].toString());
	
		Student yh = new Student("김영희", '여', 20, 1) {
		@Override
		public void setGrade(int grade) {
			System.out.println("학년 지정함 ");
		}
	};
		
//		Student [name=null, score=0, grade=0, getName()=null, getAge()=16]

		
		
	}

}
