package tw.org.iii.tutorial;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import tw.org.iii.myclasses.FoodDB;
import tw.org.iii.myclasses.MyTable;

public class JDBC18 extends JFrame {
	private MyTable myTable;
	private JButton del;
	public JDBC18() {
		setLayout(new BorderLayout());		
		JPanel top = new JPanel(new FlowLayout());
		del = new JButton("Del");
		top.add(del);
		add(top, BorderLayout.NORTH);
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteData();
			}
		});
		try {
			myTable = new MyTable();
			JScrollPane jsp = new JScrollPane(myTable);
			add(jsp, BorderLayout.CENTER);
//			add(myTable, BorderLayout.CENTER);
			
		} catch (SQLException e) {
			System.out.println(e);
			System.exit(0);
		}
		
		
		
		
		setSize(800, 640);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new JDBC18();		
	}
	private void deleteData() {
		myTable.delRow();
	}

}
