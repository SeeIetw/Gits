package tw.org.iii.myclasses;

public class Scooter extends Bike{
	private int gear;
	public Scooter() {  //1. no return 2. similar name with class
		System.out.println("Scooter()");
		color = "blue";
	}
	@Override
	public void upSpeed() {
		speed = speed < 1  ? 1 * gear : speed * gear * 1.8;
	}
	public void changeGear(int newgear) {
		if(newgear >=0 && newgear <=4) {
			gear = newgear;
		}
	}
}
