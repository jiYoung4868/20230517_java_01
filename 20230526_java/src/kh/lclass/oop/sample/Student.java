package kh.lclass.oop.sample;

public final /* abstract */ class Student extends Person {
	// 예약어 는 해당 클래스 내에  메소드가 0개 이상 있을 것을 의미.
	private String name;
//	private int age;
//	private char gender;
	private int score;
	private int grade;
	private static final int maxCount=10;
	
	public Student() {
		super();
		System.out.println("반가워요");
		name = "홍길동";
	}
	public Student(String name, char gender, int age, int grade) {
		super(age, name, gender, 10);
		this.name = name;
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + ", grade=" + grade + ", getName()=" + getName()
				+ ", getAge()=" + getAge() + "]";
	}
	
	@Override
	public String getName() {
		return this.name ; //student에 private으로 name 필드 생성하게 되면 super = person의 name // no super = student의 name
		}
	
	@Override
	public int getAge() {
		return super.getAge()+1;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getGrade() {
		return grade;
	}
	//변수 선언
	// 메소드 정의 // 이 기능은 이런이런 기능으로 되어 있어!
	
	//메소드 선언 // 이 기능이 있을거야, 있어야 해.
	public void setGrade(int grade); {
				this.grade = grade;
	}
//	public void setName(String name) {
//		this.name = name;
//	}





}


