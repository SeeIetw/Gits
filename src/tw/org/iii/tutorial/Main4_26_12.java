package tw.org.iii.tutorial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;

import tw.org.iii.myclasses.Student;

public class Main4_26_12 {
	public static void main(String[] args) {
		Student s1 = new Student("SeeIe", 65, 82, 93);
		Student s2 = new Student("Miuro", 53, 91, 82);
//		System.out.println(s1.sum()+":"+s1.avg());
		try {
			FileOutputStream fout = new FileOutputStream("dir1/s1");
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			oout.writeObject(s1);
			oout.writeObject(s2);
			oout.flush();
			oout.close();
			System.out.println("Finish");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
