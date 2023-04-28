package tw.org.iii.tutorial;

import javax.swing.JOptionPane;

public class Main4_17_03 {

	public static void main(String[] args) {
		String x = JOptionPane.showInputDialog("1111");
		String y = JOptionPane.showInputDialog("1111");
		int x1 = Integer.parseInt(x);
		int y1 = Integer.parseInt(y);
		
		JOptionPane.showMessageDialog(null, String.format("%d + %d = %d", x1, y1, x1+y1));

	}

}
