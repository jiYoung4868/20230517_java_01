package kh.lclass.oop.sample;

public class Sonata extends Car {
	private int price;
	
	public Sonata() {
		super(4000);
	}
	@Override
	public void moveCar() {
		System.out.println("Sonata moveSonata");
	}

}
