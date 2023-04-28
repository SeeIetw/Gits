package tw.org.iii.tutorial;

public class Main4_24_02{
	public static void main(String[] args) {
		Rectangle rec = new Rectangle(10, 3);
		Circle cir = new Circle(4);
		System.out.println(m1(rec));
		System.out.println(m1(cir));
	}
	static String m1(Shape shape) {
		if(shape instanceof Rectangle) { // instanceof = is a?
			System.out.println(((Rectangle)shape).isSquare()?"OK":"XX");
		} else if(shape instanceof Circle) {
			System.out.println(((Circle)shape).getDiameter());
		}
		return shape.length() + "|" + shape.area();
	}
}
interface Shape{
	double length(); //public abstract in implicit
	double area();
}
class Rectangle implements Shape{
	int w, h;
	public Rectangle(int w, int h) {
		this.w = w;
		this.h = h;
	}
	public double length() {
		return 1;
		}
	public double area() {
		return 0;
		}
	public boolean isSquare() {
		return w == h;
		}
}

class Circle implements Shape{
	double r;
	Circle(double r){
		this.r=r;
	}
	public double length() {
		return 2*Math.PI*r;
	}
	public double area() {
		return Math.PI*r*r;
	}
	public double getDiameter() {
		return 2*r;
		}
}