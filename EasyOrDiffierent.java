package com.imooc.扎金花;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import javax.swing.JToggleButton;

public class EasyOrDiffierent {

	private JFrame frame;
	private JTable table;
	public List<Poker> auto ;
	public PokerGrade pg ;
	public String str ; // 用来记录电脑难度
	public int g , m; //用来调整玩家选择难度以及总分数
	public int l , p ; //追踪点击的按钮
	private JCheckBox easy , normal , simple ,high ;
	private JCheckBox g10 , g20 , g30 ;
	/**
	 * Create the application.
	 */
	public  EasyOrDiffierent( final PokerGrade pg) {
		this.pg = pg ;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		Random rand = new Random() ;
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		easy = new JCheckBox("挽尊级（电脑出牌一直很小）");
		easy.setBounds(240, 47, 201, 45);
		frame.getContentPane().add(easy);
		easy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str = "easist" ;
				g = g + 1 ;
				if(g % 2 == 0){
					switch (l) {
					case 1:
						simple.doClick();
						break;
					case 2:
						normal.doClick();
						break;
					case 3:
						high.doClick();
						break;
					default:
						break;
					}
				}
				l = 4 ;
//				Initial It = new Initial();
//				It.handPoker();
//				AutoDifficult ad = new AutoDifficult(It.auto) ;
//				auto = ad.poker.get(0) ;
//				PokerWindow pw = new PokerWindow();
//				pw.poker(It.player1, auto);
//				pw.initialize();
			}
		});
		
		simple = new JCheckBox("初级（电脑出牌很随意）");
		simple.setBounds(240, 88, 208, 51);
		frame.getContentPane().add(simple);
		simple.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str = "simple" ;
				g = g + 1 ;
				if(g % 2 == 0){
					switch (l) {
					case 4:
						easy.doClick();
						break;
					case 2:
						normal.doClick();
						break;
					case 3:
						high.doClick();
						break;
					default:
						break;
					}
				}
				l = 1 ;
			}
			
//				Initial It = new Initial();
//				It.handPoker();
//				AutoDifficult ad = new AutoDifficult(It.auto) ;
//				int i = rand.nextInt(5) ;
//				auto = ad.poker.get(i) ;
//				PokerWindow pw = new PokerWindow();
//				pw.poker(It.player1, auto);
//				Deal d = new Deal(pw);
		});
		
		normal = new JCheckBox("中级（电脑出牌一般很大）");
		normal.setBounds(240, 138, 201, 36);
		frame.getContentPane().add(normal);
		normal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str = "normal" ;
				g = g + 1 ;
				if(g % 2 == 0){
					switch (l) {
					case 4:
						easy.doClick();
						break;
					case 1:
						simple.doClick();
						break;
					case 3:
						high.doClick();
						break;
					default:
						break;
					}
				}
				l = 2 ;
//				Initial It = new Initial();
//				It.handPoker();
//				AutoDifficult ad = new AutoDifficult(It.auto) ;
//				int i = rand.nextInt(10) ;
//				while(true){
//					if(i >= 5){
//						 auto = ad.poker.get(i) ;
//						 break ;
//					}
//				}
//				PokerWindow pw = new PokerWindow();
//				pw.poker(It.player1, auto);
//				pw.initialize();
			}
		});
		
		high = new JCheckBox("高级（电脑出牌一直最大）");
		high.setBounds(240, 182, 201, 36);
		frame.getContentPane().add(high);
		high.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				str = "high level" ;
				g = g + 1 ;
				if(g % 2 == 0){
						switch (l) {
						case 4:
							easy.doClick();
							break;
						case 2:
							normal.doClick();
							break;
						case 1:
							simple.doClick();
							break;
						default:
							break;
						}
					}
				l = 3 ;
//				Initial It = new Initial();
//				It.handPoker();
//				AutoDifficult ad = new AutoDifficult(It.auto) ;
//				auto = ad.poker.get(9) ;
//				PokerWindow pw = new PokerWindow();
//				pw.poker(It.player1, auto);
//				pw.initialize();
			}
		});
		
		table = new JTable();
		table.setBounds(257, 138, 1, 1);
		frame.getContentPane().add(table);
		
		JLabel lblNewLabel = new JLabel("选择电脑难度");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(240, 6, 245, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("完成");
		tglbtnNewToggleButton.setBounds(125, 230, 161, 29);
		frame.getContentPane().add(tglbtnNewToggleButton);
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				Deal d = new Deal(str);
				d.contain(pg);
				d.initialize();
			}
		});
		g10 = new JCheckBox("10");
		g10.setBounds(63, 58, 61, 23);
		frame.getContentPane().add(g10);
		g10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int s = 10 ;
				pg = new PokerGrade(s) ;
				m ++;
				if(g % 2 == 0){
					switch (p) {
					case 20:
						g20.doClick();
						break;
					case 30:
						g30.doClick();
						break;
					default:
						break;
					}
				}
				p = 10 ;
			}
		});
		
		g20 = new JCheckBox("20");
		g20.setBounds(63, 118, 48, 23);
		frame.getContentPane().add(g20);
		g20.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int s = 20 ;
				pg = new PokerGrade(s);
				m ++ ;
				if(g % 2 == 0){
					switch (p) {
					case 10:
						g10.doClick();
						break;
					case 30:
						g30.doClick();
						break;
					default:
						break;
					}
				}
				p = 20 ;
			}
		});
		
		g30 = new JCheckBox("30");
		g30.setBounds(63, 182, 128, 23);
		frame.getContentPane().add(g30);
		g30.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int s = 30 ;
				pg = new PokerGrade(s);
				m ++;
				if(g % 2 == 0){
					switch (p) {
					case 10:
						g10.doClick();
						break;
					case 20:
						g20.doClick();
						break;
					default:
						break;
					}
				}
				p = 30 ; 
			}
		});
		JLabel lblNewLabel_3 = new JLabel("选择总分：");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(46, 6, 114, 42);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
