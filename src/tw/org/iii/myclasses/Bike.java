package tw.org.iii.myclasses;

import java.io.Serializable;

public class Bike implements Serializable{
	protected double speed;
	protected String color;

	//Constructor: to initialize
	public Bike() {  //1. no return 2. similar name with class
//		System.out.println("Bike()");
		setColor();
	}
	private void setColor() {
		color = "yellow";
	}
	
	public String getColor() {
		return color;
	}
	
	public double getSpeed() {
		return speed;
	}

	public void upSpeed() {
		speed = speed < 1 ? 1 : speed * 1.2;
	}

	public void downSpeed() {
		speed = speed < 1 ? 1 : speed * 0.7;
	}
	@Override
	public String toString() {
		return "Bike: "+speed;
	}
	
}
