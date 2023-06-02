package kh.lclass.oop.sample;

import java.awt.im.spi.InputMethod;
import java.io.Serializable;

public interface TestInterface{ //extends InputMethod, Serializable{
	public final int MAXCUT = 10;
	public static final int MAXCUT2 = 10; //static과 final이 내포되어있음
	public void method1(); //능력단위별 평가보기
	public String method2(); //평가안내
	public int method3(int a, int b); //평가리뷰
	public int method();
	

	
}
