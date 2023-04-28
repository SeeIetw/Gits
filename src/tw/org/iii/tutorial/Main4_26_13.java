package tw.org.iii.tutorial;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import tw.org.iii.myclasses.Student;

public class Main4_26_13 {
	public static void main(String[] args) {
		try {
			ObjectInputStream oin = new ObjectInputStream(
					new FileInputStream("dir1/s1"));
			Object obj = oin.readObject();
			if(obj instanceof Student) {
				Student st1 = (Student)obj;
				System.out.println(st1.avg());
			}else {
				System.out.println("Not");
			}
			Object obj2 = oin.readObject();
			if(obj2 instanceof Student) {
				Student st2 = (Student)obj2;
				System.out.println(st2.avg());
			}else {
				System.out.println("Not");
			}
			oin.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
