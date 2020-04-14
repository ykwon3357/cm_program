package org.comstudy21.test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class WindowApp2 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowApp2 window = new WindowApp2();
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
	public WindowApp2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 325, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 309, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("이름:");
		label.setBounds(12, 59, 57, 15);
		panel.add(label);
		
		JLabel lblId = new JLabel("I D:");
		lblId.setBounds(12, 97, 57, 15);
		panel.add(lblId);
		
		JLabel lblPswrd = new JLabel("PW:");
		lblPswrd.setBounds(12, 135, 57, 15);
		panel.add(lblPswrd);
		
		JLabel label_3 = new JLabel("나이:");
		label_3.setBounds(12, 175, 57, 15);
		panel.add(label_3);
		
		textField = new JTextField();
		textField.setBounds(49, 56, 130, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(49, 94, 130, 21);
		panel.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(49, 172, 130, 21);
		panel.add(textField_3);
		
		JButton btnNewButton = new JButton("가입");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				String text1 = textField_1.getText();
				String text2 = textField_2.getText();
				String text3 = textField_3.getText();
				//System.out.printf("%s, %s, %s, %s\n",text,text1,text2,text3);
				
				textArea.append(text+","+text1+","+text2+","+text3+"\n");
			}
		});
		btnNewButton.setForeground(Color.ORANGE);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setBounds(49, 210, 61, 23);
		panel.add(btnNewButton);
		
		JButton button = new JButton("다시");
		button.setBounds(118, 210, 61, 23);
		panel.add(button);
		
		textField_2 = new JTextField();
		textField_2.setBounds(49, 132, 130, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(191, 55, 106, 178);
		panel.add(textArea);
	}
}
