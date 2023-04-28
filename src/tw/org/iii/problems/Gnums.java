package tw.org.iii.problems;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Gnums extends JFrame implements ActionListener {
	private JButton guess;
	private JTextField input;
	private JTextArea log;
	private String Ans;
	private int counter = 0;

	public Gnums() {
		super("Guess numbers");

		guess = new JButton("guess");
		input = new JTextField();
		log = new JTextArea();


		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JPanel top = new JPanel(new BorderLayout());
		top.add(guess, BorderLayout.EAST);
		top.add(input, BorderLayout.CENTER);
		add(top, BorderLayout.NORTH);
		add(log, BorderLayout.CENTER);
//		guess.addActionListener(new MyListener());
		guess.addActionListener(this);
		initview();
		Ans = createAns(4);
//		log.append(Ans + "\n");

	}
	private void initview() {
		input.setFont(new Font(null,Font.BOLD,24));
		log.setFont(new Font(null,Font.ITALIC,24));
	}
	
	
	public static void main(String[] args) {
		new Gnums();
	}
	
	private void newGame() {
		Ans = createAns(4);
		log.setText("");
		input.setText("");
		counter = 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String strInput = input.getText();	
		if(isValid(strInput)) {
			
		}
		
		
		String result = checkAB(strInput);
		log.append(String.format("%d. %s => %s \n", counter, strInput, result));

		input.setText("");
		counter++;
		if(result.equals("4A0B")) {
			JOptionPane.showMessageDialog(null, "Congrat!!");
		} else if(counter == 10) {
			JOptionPane.showMessageDialog(null, "You lose, answer is "+ Ans);
			newGame();
		}
		
	}
	

	private boolean isValid(String input) {
		return true;
	}
	
	private String checkAB(String getInput) {
		int A = 0;
		int B = 0;
		for(int j=0;j<getInput.length();j++) {
			if(getInput.charAt(j) == Ans.charAt(j)) {
				A++;
			}
			if(Ans.indexOf(getInput.charAt(j))!=-1) {
				B++;
			}
		}
		B = B - A;
		
		
		return A+"A"+B+"B";
	}
	
	private String createAns(int a) {
		
		int num = 10;
		int[] poker = new int[num];
		for (int i = 0; i<poker.length; i++) poker[i] = i;
		
		for (int i = num-1; i > 0; i--) {
			int rand = (int)(Math.random()*(i+1));
			int temp = poker[rand];
			poker[rand] = poker[i];
			poker[i] = temp;
		}
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<a;i++) {
			sb.append(poker[i]);
		}
		
		return sb.toString();
	}
}

class MyListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("OK");

	}
}
