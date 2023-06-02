package kh.lclass.oop.sample;

import java.io.Serializable;

public class Kh implements TestInterface, Serializable {
	//The serializable class Kh does not declare a static final serialVersionUID field of type long
	
	private static final long serialVersionUID = 634056038343974385L;
	//private static final long serialVersionUID(unique ID) = 1L;
	//@SuppressWarnings("serial") 
	//serializable == 직렬화


	public void khSpecial() {
		
	}
	
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String method2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int method3(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int method() {
		// TODO Auto-generated method stub
		return 0;
	}

}
