package com.imooc.扎金花;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;
import javax.swing.JComboBox;

public class Deal{

	public JFrame deal;
	public String id , name ;
	public PokerGrade pg ;
	private String str;
	public PokerWindow pw ;

	/**
	 * Create the application.
	 */
	public Deal(String str){
		this.str = str ;
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	public void contain(final String id , final String name , final PokerGrade pg ){
		this.id = id ;
		this.name = name ;
		this.pg = pg ;
	}
	public void contain( final PokerGrade pg){
		this.pg = pg ;
	}
	public void initialize() {
		deal = new JFrame();
		deal.setVisible(true);
		deal.setBounds(100, 100, 450, 300);
		deal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		deal.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("开始发牌");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(155, 22, 109, 33);
		deal.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("建立卡牌");
		lblNewLabel_1.setBounds(182, 67, 61, 16);
		deal.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("-拿牌");
		lblNewLabel_2.setBounds(228, 95, 61, 16);
		deal.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("-拿牌");
		lblNewLabel_3.setBounds(228, 123, 61, 16);
		deal.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("玩家");
		lblNewLabel_4.setBounds(141, 95, 61, 16);
		deal.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("发牌结束");
		lblNewLabel_5.setBounds(182, 151, 61, 16);
		deal.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("电脑 ：");
		lblNewLabel_6.setBounds(141, 123, 61, 16);
		deal.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("：");
		lblNewLabel_7.setBounds(168, 95, 61, 16);
		deal.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("是否看牌(看牌底分1，不看为3）");
		lblNewLabel_8.setBounds(124, 179, 189, 16);
		deal.getContentPane().add(lblNewLabel_8);
		
		JToggleButton yes = new JToggleButton("是");
		yes.setBounds(155, 207, 42, 29);
		deal.getContentPane().add(yes);
		yes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				deal.dispose();
				PokerWindow pw = new PokerWindow();
				pw.contain(pg,str);
				pw.makeAutoPoker();
				pw.initialize();		
			}
		});
		
		JToggleButton NO = new JToggleButton("否");
		NO.setBounds(228, 207, 42, 29);
		deal.getContentPane().add(NO);
		NO.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				deal.dispose();
				Initial it = new Initial();
				it.handPoker();
				it.throwPoker2();
				pg.winGrade = 3 ;
				ThrowHandPoker thp = new ThrowHandPoker();
				thp.save(it.player1 , it.auto, pg , str);
				thp.initialize();
			}
		});
	}
}
