package com.imooc.扎金花;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

public class ThrowHandPoker{

	public JFrame frame;
	public List<Poker> player1 ;

	public List<Poker> player2; 
	public List<Poker> auto ;
	public String p1,p2,p3,a1,a2,a3,winner;
	public int a;//用作传递赢或输的量
	
	public PokerGrade  pg ;
	public String str ;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ThrowHandPoker(){
		
	}
public void save(List<Poker> player1,List<Poker> auto , final PokerGrade pg , String str){
		this.player1 = player1;
		this.auto = auto ;
		this.pg = pg ;
		this.str = str ;
		CompareHandPokerWindow chp = new CompareHandPokerWindow(player1, auto);
		a = chp.compareHandPoker();
		if (a == 1){
			pg.b = a ;
		    a = pg.pokerGrade();
			winner = "恭喜你胜利了!!!你目前的分数为" +  pg.startPlayerGrade + "电脑的分数为：" + pg.startAutoGrade;		
		}else if(a == -1){
			pg.b = a;
		    a = pg.pokerGrade();
			winner = "真菜啊，再接再厉吧!!!你目前的分数为" +  pg.startPlayerGrade + "电脑的分数为：" + pg.startAutoGrade;
		}else {
			pg.b =  0 ;
		    a = pg.pokerGrade();
			winner = "不错啊，旗鼓相当的对手!!!你目前的分数为" +  pg.startPlayerGrade + "电脑的分数为：" + pg.startAutoGrade;

		}
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		p1 = player1.get(0).colour + player1.get(0).Num;
		p2 = player1.get(1).colour + player1.get(1).Num;
		p3 = player1.get(2).colour + player1.get(2).Num;
		a1 = auto.get(0).colour + auto.get(0).Num;
		a2 = auto.get(1).colour + auto.get(1).Num;
		a3 = auto.get(2).colour + auto.get(2).Num;
		
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("玩家现在手牌：");
		lblNewLabel.setBounds(47, 22, 99, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel P1 = new JLabel(p1);
		P1.setBounds(47, 50, 61, 16);
		frame.getContentPane().add(P1);
		
		JLabel P2 = new JLabel(p2);
		P2.setBounds(165, 50, 61, 16);
		frame.getContentPane().add(P2);
		
		JLabel P3 = new JLabel(p3);
		P3.setBounds(283, 50, 61, 16);
		frame.getContentPane().add(P3);
		
		JLabel lblNewLabel_4 = new JLabel("电脑现在手牌：");
		lblNewLabel_4.setBounds(47, 84, 128, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel A1 = new JLabel(a1);
		A1.setBounds(47, 112, 61, 16);
		frame.getContentPane().add(A1);
		
		JLabel A2 = new JLabel(a2);
		A2.setBounds(165, 112, 61, 16);
		frame.getContentPane().add(A2);
		
		JLabel A3 = new JLabel(a3);
		A3.setBounds(283, 112, 61, 16);
		frame.getContentPane().add(A3);
		
		JLabel lblNewLabel_1 = new JLabel(winner);
		lblNewLabel_1.setBounds(47, 153, 362, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		JToggleButton yes = new JToggleButton("结束游戏");
		yes.setBounds(47, 210, 161, 29);
		frame.getContentPane().add(yes);
		yes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		
		JToggleButton no = new JToggleButton("继续游戏");
		no.setBounds(233, 210, 161, 29);
		frame.getContentPane().add(no);
		no.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				if(a == 0){
					Deal d = new Deal(str);
					d.contain (pg);
					d.initialize();		
				}else{
					EndWindow ed = new EndWindow();
					ed.contain(a);
					ed.initialize();
				}
	
			}
		});
	}
}
