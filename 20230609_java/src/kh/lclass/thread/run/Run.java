package kh.lclass.thread.run;

import kh.lclass.thread.ThreadAaa;
import kh.lclass.thread.ThreadBbb;

public class Run {
	public static void main(String[] args) {

//		Runnable ra = new ThreadAaa();
//		Thread ta = new Thread(ra);
//		Runnable ta = new ThreadAaa(); //SCV 생성
//		ta의 경우 thread모양이 아니라서 ta.start로는 불가
		
		Thread ta = new Thread(new ThreadAaa());
		ta.setPriority(1);
		ta.start();
		
		ThreadBbb tb = new ThreadBbb(); //SCV 생성, upcasting
		tb.setPriority(10);
		tb.start(); //미네랄 찍는 행위
		
		Thread tbb = new ThreadBbb();
		tbb.start();
		
// 		run을 일반 메소드 호출하듯이 호출하면 안됨.		
//		ta.run();
//		tb.run();
		
		for (int i=0; i<500; i++) {
			System.out.println(i+"*");
			}
			System.out.println("=====main 끝=====");
		}
}
