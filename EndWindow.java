package com.imooc.扎金花;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;



public class EndWindow {

	public JFrame frame;
	public String strUp , strDown ;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public EndWindow() {
		initialize();
	}
	public void contain(int a){
		if(a == 1){
			strUp = "Congratulations," ;
			strDown = "恭喜你，赢了这局游戏，真是大神啊！！！" ;
		}else if (a == -1){
			strUp = "该说什么好呢," ;
		    strDown = "再来一把把尊严找回来！！！" ;
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(64, 224, 208));
		frame.getContentPane().setForeground(Color.BLUE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(strUp);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblNewLabel.setBounds(25, 20, 363, 109);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(strDown);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(25, 141, 380, 66);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
