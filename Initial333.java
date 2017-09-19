package com.imooc.扎金花;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Initial333 extends JFrame implements ActionListener{

	public Scanner console = new Scanner(System.in) ;
	public String ID , PW ;
	private JPanel contentPane;
	private JTextField id;
	private JTextField PassWord;
	private JToggleButton login ;
	JButton exit;
//	Deal d = new Deal();
	private JLabel lblNewLabel_3;
	public PokerGrade pg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Initial333 frame = new Initial333();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Initial333() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("欢迎来玩扎金花");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setBounds(109, 40, 210, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id:");
		lblNewLabel_1.setBounds(146, 107, 27, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name：");
		lblNewLabel_2.setBounds(146, 150, 49, 16);
		contentPane.add(lblNewLabel_2);
		
		id = new JTextField();
		id.setBounds(188, 104, 153, 26);
		contentPane.add(id);
		id.setColumns(10);
		
		PassWord = new JTextField();
		PassWord.setBounds(188, 145, 153, 26);
		contentPane.add(PassWord);
		PassWord.setColumns(10);
		
		login = new JToggleButton("开始");
		login.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		login.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		login.setForeground(Color.GREEN);
		login.setBackground(Color.WHITE);
		login.setBounds(89, 213, 70, 39);
		contentPane.add(login);
		login.setBorder(BorderFactory.createRaisedBevelBorder());
        login.addActionListener(this);
		
		
		exit = new JButton("退出");
		exit.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		exit.setForeground(Color.GREEN);
		exit.setBackground(Color.WHITE);
		exit.setBounds(271, 213, 70, 39);
		contentPane.add(exit);
		exit.addActionListener(this);
		exit.setBorder(BorderFactory.createRaisedBevelBorder());
		
//		lblNewLabel_3 = new JLabel("选择总分：");
//		lblNewLabel_3.setBounds(64, 182, 70, 16);
//		contentPane.add(lblNewLabel_3);
//		
//		JCheckBox g10 = new JCheckBox("10");
//		g10.setBounds(144, 178, 61, 23);
//		contentPane.add(g10);
//		g10.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				int s = 10 ;
//				pg = new PokerGrade(s) ;
//			}
//		});
//		
//		JCheckBox g20 = new JCheckBox("20");
//		g20.setBounds(227, 178, 48, 23);
//		contentPane.add(g20);
//		g20.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				int s = 20 ;
//				pg = new PokerGrade(s);
//			}
//		});
//		
//		JCheckBox g30 = new JCheckBox("30");
//		g30.setBounds(316, 178, 128, 23);
//		contentPane.add(g30);
//		g30.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				int s = 30 ;
//				pg = new PokerGrade(s);
//			}
//		});
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == login){
//			ID = id.getText();
//			PW = PassWord.getText();
			this.dispose();
//			
//			Deal d = new Deal();
//			d.contain(ID, PW , pg);
//			d.initialize();		
			EasyOrDiffierent eod = new EasyOrDiffierent(pg);
		    eod.initialize();
		}else if(e.getSource() == exit){
			dispose();
		}
	}
}
