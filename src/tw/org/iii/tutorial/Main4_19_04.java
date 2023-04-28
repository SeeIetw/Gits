package tw.org.iii.tutorial;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main4_19_04 extends JFrame {

	private JButton bn1;
	public Main4_19_04() {
		setTitle("myframe");
		
		setLayout(new FlowLayout());
		bn1 = new JButton("Click");
		add(bn1);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new Main4_19_04();

	}

}