package com.imooc.扎金花;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JOptionPane;

public class PokerWindow {

	private JFrame frame;
	public JCheckBox g1 , g2, g3, g5 ;
	public String p1 , p2 , p3 , p4 , p5 ;
	public Poker pp1 , pp2 , pp3 , pp4 , pp5 ;
	public int b = 0 , g = 0; 
	public int[] p = { 1 , 1 , 1 , 1 , 1 } ;
	private JToggleButton Finash;
	public PokerGrade pg;
	public List<Poker> player1 , auto ;
	Random rand = new Random();
	public Initial It ;
	public String str ;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * 
	 */
	public PokerWindow() {
		It = new Initial();
		It.handPoker();
	}
	public void contain(final PokerGrade pg , String str){
		this.pg = pg;
		this.str = str ;
	}
//	public void poker(List<Poker> player1 , List<Poker> auto){
//		this.player1 = player1 ;
//		this.auto = auto ;
//	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void makeAutoPoker(){
		if(str.equals("easist")){
			AutoDifficult ad = new AutoDifficult(It.auto) ;
			ad.pokerGroup();
			int i = rand.nextInt(5) ;
			auto = ad.poker.get(i) ;
		}else if(str.equals("simple")){
			AutoDifficult ad = new AutoDifficult(It.auto) ;
			ad.pokerGroup();
			int i = rand.nextInt(5) ;
			auto = ad.poker.get(i) ;
		}else if(str.equals("normal")){
			AutoDifficult ad = new AutoDifficult(It.auto) ;
			ad.pokerGroup();
			int i = rand.nextInt(10) ;
			while(true){
				if(i >= 5){
					 auto = ad.poker.get(i) ;
					 break ;
				}
				i = rand.nextInt(10) ;
			}
		}else if(str.equals("high level")){
			AutoDifficult ad = new AutoDifficult(It.auto) ;
			ad.pokerGroup();
			auto = ad.poker.get(9) ;
		}
	}
	public void initialize() {
//		Initial it = new Initial();
//		It.handPoker();
		this.p1 = It.player1.get(0).colour + It.player1.get(0).Num;
		this.p2 = It.player1.get(1).colour + It.player1.get(1).Num;
		this.p3 = It.player1.get(2).colour + It.player1.get(2).Num;
		this.p4 = It.player1.get(3).colour + It.player1.get(3).Num;
		this.p5 = It.player1.get(4).colour + It.player1.get(4).Num;
//		this.p1 = player1.get(0).colour + player1.get(0).Num;
//		this.p2 = player1.get(1).colour + player1.get(1).Num;
//		this.p3 = player1.get(2).colour + player1.get(2).Num;
//		this.p4 = player1.get(3).colour + player1.get(3).Num;
//		this.p5 = player1.get(4).colour + player1.get(4).Num;
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		
		JLabel lblNewLabel = new JLabel("你的手牌为：");
		lblNewLabel.setBounds(44, 34, 90, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(this.p1);
		lblNewLabel_1.setBounds(73, 62, 61, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(this.p2);
		lblNewLabel_2.setBounds(73, 101, 61, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(this.p3);
		lblNewLabel_3.setBounds(73, 136, 61, 23);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(this.p4);
		lblNewLabel_4.setBounds(73, 171, 61, 23);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(this.p5);
		lblNewLabel_5.setBounds(73, 206, 61, 23);
		frame.getContentPane().add(lblNewLabel_5);
		
		JCheckBox P1 = new JCheckBox("");
		P1.setForeground(Color.BLUE);
		P1.setBounds(44, 62, 28, 23);
		frame.getContentPane().add(P1);
		P1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//pp1 = it.player1.get(0);
				p[0] = p[0] + 1 ;
				if(p[0] % 2 == 0){
					b = b + 1 ;
				}else {
					b = b - 1 ;
				}
				if(b > 2){
				  JOptionPane.showMessageDialog(null, "最多只能弃两张牌");
				  P1.doClick();
				}
			}
		});
		
		JCheckBox P2 = new JCheckBox("");
		P2.setForeground(Color.BLUE);
		P2.setBounds(44, 100, 28, 23);
		frame.getContentPane().add(P2);
		P2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//pp2 = it.player1.get(1);
				p[1] = p[1] + 1 ;
				if(p[1] % 2 == 0){
					b = b + 1 ;
				}else {
					b = b - 1 ;
				}
				if(b > 2){
				  JOptionPane.showMessageDialog(null, "最多只能弃两张牌");
				  P2.doClick();
				}
			}
		});
		
		JCheckBox P3 = new JCheckBox("");
		P3.setForeground(Color.BLUE);
		P3.setBounds(44, 136, 28, 23);
		frame.getContentPane().add(P3);
		P3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//pp3 = it.player1.get(2);
				p[2] = p[2] + 1;
				if(p[2] % 2 == 0){
					b = b + 1 ;
				}else {
					b = b - 1 ;
				}
				if(b > 2){
				  JOptionPane.showMessageDialog(null, "最多只能弃两张牌");
				  P3.doClick();
				}
			}
		});
		
		JCheckBox P4 = new JCheckBox("");
		P4.setBackground(Color.BLUE);
		P4.setForeground(Color.BLUE);
		P4.setBounds(44, 171, 28, 23);
		frame.getContentPane().add(P4);
		P4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//pp4 = it.player1.get(3);
				p[3] = p[3] + 1 ;
				if(p[3] % 2 == 0){
					b = b + 1 ;
				}else {
					b = b - 1 ;
				}
				if(b > 2){
				  JOptionPane.showMessageDialog(null, "最多只能弃两张牌");
				  P4.doClick();
				}
			}
		});
		
		JCheckBox P5 = new JCheckBox("");
		P5.setForeground(Color.BLUE);
		P5.setBackground(Color.BLUE);
		P5.setBounds(44, 206, 28, 23);
		frame.getContentPane().add(P5);
		P5.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//pp5 = it.player1.get(4);
				p[4] = p[4] + 1 ;
				if(p[4] % 2 == 0){
					b = b + 1 ;
				}else {
					b = b - 1 ;
				}
				if(b > 2){
				  JOptionPane.showMessageDialog(null, "最多只能弃两张牌");
				  P5.doClick();
				}
			}
		});
		JLabel finash = new JLabel("请弃两张牌（选中即可）");
		finash.setBounds(44, 240, 143, 32);
		frame.getContentPane().add(finash);

		
		Finash = new JToggleButton();
		Finash.setText("操作完成");
		Finash.setBounds(306, 133, 111, 26);
		frame.getContentPane().add(Finash);
		Finash.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				int i = 0 ;
				if(p[0] % 2 == 0){
					pp1 = It.player1.get(0);
					i ++;
				}
				if(p[1] % 2 == 0){
					pp2 = It.player1.get(1);
					i ++;
				}
				if(p[2] % 2 == 0){
					pp3 = It.player1.get(2);
					i ++;
				}
				if(p[3] % 2 == 0){
					pp4 = It.player1.get(3);
					i ++;
				}
				if(p[4] % 2 == 0){
					pp5 = It.player1.get(4);
					i ++;
				}
				if(i == 2){
					frame.dispose();
					Poker[] play = {pp1,pp2,pp3,pp4,pp5};	
					It.player1.removeAll(Arrays.asList(play));
					Collections.sort(It.player1);
					ThrowHandPoker thp = new ThrowHandPoker();
					//thp.contain(PokerWindow.this);
					thp.save(It.player1,auto,pg,str);
					thp.initialize();
				}else{
					JOptionPane.showMessageDialog(null, "请弃两张牌");
				}
				
			}
		});
		
		JLabel label = new JLabel("选择加分");
		label.setBounds(199, 34, 61, 16);
		frame.getContentPane().add(label);
		
		g1 = new JCheckBox("0分");
		g1.setBounds(199, 62, 128, 23);
		frame.getContentPane().add(g1);
		g1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				g = g + 1 ;
				if(g % 2 == 0){
					switch(pg.winGrade){
					case 2 : g2.doClick();break;
					case 4 : g3.doClick();break;
					case 6 : g5.doClick();break;
					}
				}
				pg.winGrade = 1 ;
			}
		});
		
		g2 = new JCheckBox("1分");
		g2.setBounds(199, 111, 128, 23);
		frame.getContentPane().add(g2);
		g2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				g = g + 1 ;
				if(g % 2 == 0){
					switch (pg.winGrade) {
					case 1:
						g1.doClick();
						break;
					case 4:
						g3.doClick();
						break;
					case 6:
						g5.doClick();
						break;
					default:
						break;
					}
				}
				pg.winGrade = 2 ;
			}
		});
		
		g3 = new JCheckBox("3分");
		g3.setBounds(199, 160, 128, 23);
		frame.getContentPane().add(g3);
		g3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				g = g + 1 ;
				if(g % 2 == 0){
					if(g % 2 == 0){
						switch (pg.winGrade) {
						case 1:
							g1.doClick();
							break;
						case 2:
							g2.doClick();
							break;
						case 6:
							g5.doClick();
							break;
						default:
							break;
						}
					}
			
				}
				pg.winGrade = 4 ;
			}
		});
		
		g5 = new JCheckBox("5分");
		g5.setBounds(199, 206, 128, 23);
		frame.getContentPane().add(g5);
		g5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				g = g + 1 ;
				if(g % 2 == 0){
					if(g % 2 == 0){
						switch (pg.winGrade) {
						case 1:
							g1.doClick();
							break;
						case 4:
							g3.doClick();
							break;
						case 2:
							g2.doClick();
							break;
						default:
							break;
						}
					}
				}
				pg.winGrade = 6 ;
			}
		});	
	}
}
