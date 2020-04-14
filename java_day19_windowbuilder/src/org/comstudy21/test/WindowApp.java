package org.comstudy21.test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowApp {

	private JFrame frame;
	private String func="ADD";
	private double firstNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowApp window = new WindowApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 270, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel answer = new JLabel("0");
		answer.setFont(new Font("굴림", Font.PLAIN, 30));
		answer.setHorizontalAlignment(SwingConstants.RIGHT);
		answer.setBounds(12, 10, 229, 58);
		frame.getContentPane().add(answer);
		
		JButton btn7 = new JButton("7");
		btn7.setFont(new Font("굴림", Font.PLAIN, 25));
		btn7.setBounds(12, 78, 50, 50);
		frame.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setFont(new Font("굴림", Font.PLAIN, 25));
		btn8.setBounds(71, 78, 50, 50);
		frame.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setFont(new Font("굴림", Font.PLAIN, 25));
		btn9.setBounds(129, 78, 50, 50);
		frame.getContentPane().add(btn9);
		
		JButton btnplus = new JButton("+");
		btnplus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String curr = answer.getText();
				firstNumber = Double.parseDouble(curr);
				answer.setText("0");
				func="ADD";
			}
		});
		btnplus.setFont(new Font("굴림", Font.PLAIN, 25));
		btnplus.setBounds(191, 78, 50, 50);
		frame.getContentPane().add(btnplus);
		
		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("굴림", Font.PLAIN, 25));
		btn4.setBounds(12, 140, 50, 50);
		frame.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("굴림", Font.PLAIN, 25));
		btn5.setBounds(71, 140, 50, 50);
		frame.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setFont(new Font("굴림", Font.PLAIN, 25));
		btn6.setBounds(129, 140, 50, 50);
		frame.getContentPane().add(btn6);
		
		JButton btnminus = new JButton("-");
		btnminus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String curr = answer.getText();
				firstNumber = Double.parseDouble(curr);
				answer.setText("0");
				func="SUB";
			}
		});
		btnminus.setFont(new Font("굴림", Font.PLAIN, 25));
		btnminus.setBounds(191, 140, 50, 50);
		frame.getContentPane().add(btnminus);
		
		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("굴림", Font.PLAIN, 25));
		btn1.setBounds(12, 200, 50, 50);
		frame.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("굴림", Font.PLAIN, 25));
		btn2.setBounds(71, 200, 50, 50);
		frame.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("굴림", Font.PLAIN, 25));
		btn3.setBounds(129, 200, 50, 50);
		frame.getContentPane().add(btn3);
		
		JButton btnmul = new JButton("x");
		btnmul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String curr = answer.getText();
				firstNumber = Double.parseDouble(curr);
				answer.setText("0");
				func="MUL";
			}
		});
		btnmul.setFont(new Font("굴림", Font.PLAIN, 25));
		btnmul.setBounds(191, 200, 50, 50);
		frame.getContentPane().add(btnmul);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer.setText("");
			}
		});
		btnC.setFont(new Font("굴림", Font.BOLD, 22));
		btnC.setBounds(12, 259, 50, 50);
		frame.getContentPane().add(btnC);
		
		JButton btn0 = new JButton("0");
		btn0.setFont(new Font("굴림", Font.PLAIN, 25));
		btn0.setBounds(71, 259, 50, 50);
		frame.getContentPane().add(btn0);
		
		JButton btnsame = new JButton("=");
		btnsame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(func){
				case"ADD":
					Double currValue = Double.parseDouble(answer.getText());
					answer.setText(Math.round((firstNumber+currValue)*100)/100.0+"");
					break;
				case"SUB":
					currValue = Double.parseDouble(answer.getText());
					answer.setText(Math.round((firstNumber-currValue)*100)/100.0+"");
					break;
				case"MUL":
					currValue = Double.parseDouble(answer.getText());
					answer.setText(Math.round((firstNumber*currValue)*100)/100.0+"");
					break;
				case"DIV":
					currValue = Double.parseDouble(answer.getText());
					if(currValue==0){
						answer.setText("0");
					}else{
						answer.setText(Math.round((firstNumber/currValue)*100)/100.0+"");
					}
					break;
				}
			}
		});
		btnsame.setFont(new Font("굴림", Font.PLAIN, 25));
		btnsame.setBounds(129, 259, 50, 50);
		frame.getContentPane().add(btnsame);
		
		JButton btndiv = new JButton("/");
		btndiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String curr = answer.getText();
				firstNumber = Double.parseDouble(curr);
				answer.setText("0");
				func="DIV";
			}
		});
		btndiv.setFont(new Font("굴림", Font.PLAIN, 25));
		btndiv.setBounds(191, 259, 50, 50);
		frame.getContentPane().add(btndiv);
		
		btn0.addActionListener(new NumberActionListener(answer,"0")); 
		btn1.addActionListener(new NumberActionListener(answer,"1")); 
		btn2.addActionListener(new NumberActionListener(answer,"2")); 
		btn3.addActionListener(new NumberActionListener(answer,"3")); 
		btn4.addActionListener(new NumberActionListener(answer,"4")); 
		btn5.addActionListener(new NumberActionListener(answer,"5")); 
		btn6.addActionListener(new NumberActionListener(answer,"6")); 
		btn7.addActionListener(new NumberActionListener(answer,"7")); 
		btn8.addActionListener(new NumberActionListener(answer,"8")); 
		btn9.addActionListener(new NumberActionListener(answer,"9")); 
		
	}
}
class NumberActionListener implements ActionListener{
	private JLabel label;
	private String text;
	public NumberActionListener(JLabel l, String s) {
		label = l;
		text= s;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String curr = label.getText();
		if(curr.equals("0")){
			label.setText(text);
		}else{
			label.setText(label.getText()+text);
		}
	}
	
}
