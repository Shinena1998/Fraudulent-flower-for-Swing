package com.imooc.扎金花;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

public class AddGrade {

	private JFrame frame;
	public JCheckBox g1 , g2, g3, g5 ;
	public int b = 0 , g = 0 , d= 0 , l = 0 , n = 0 , x = 0; //d传递电脑的牌的好坏,l,n标记当前加分,x控制正确显示
	public int[] p = { 1 , 1 , 1 , 1 , 1 } ;
	public int playG = 0, autoG = 0 , autoGrade;//autoGrade选择电脑加分
	public PokerGrade pg;
	public JLabel autoG_1,playerG ,lblNewLabel_1, lblNewLabel ;
	JToggleButton tglbtnNewToggleButton ,tglbtnNewToggleButton_1;
	public List<Poker> player1 , auto ;
	public String str ;
	
	
	public int i = 3 ,j = 0;//调整完成按钮显示

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		AddGrade add = new AddGrade();
//
//		add.pg.winGrade = 0 ;
//		add.initialize();
//	}
	/**
	 * Create the application.
	 */
	public AddGrade() {
	}
	public void contain(List<Poker> player1,List<Poker> auto , final PokerGrade pg , String str){
		this.player1 = player1;
		this.auto = auto ;
		this.pg = pg ;
		this.str = str ;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	public void autoAddGradeRular(){
		Poker ah1 = auto.get(0);
		Poker ah2 = auto.get(1);
		Poker ah3 = auto.get(2);
		if(ah1.color == ah2.color && ah2.color == ah3.color){
			 d = 1 ;
		}else if(ah1.num == ah2.num && ah2.num == ah3.num){
			d = 0 ;
		}else if(ah1.num + 1 == ah2.num && ah2.num == ah3.num - 1){
			d = 2 ;
		}else{
			d = 3 ;
		}
	}
	public void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel label = new JLabel("玩家加分中~");
		label.setBounds(163, 34, 128, 16);
		frame.getContentPane().add(label);
		
		g1 = new JCheckBox("0分");
		g1.setBounds(174, 62, 128, 23);
		frame.getContentPane().add(g1);
		g1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				g = g + 1 ;
				if(g % 2 == 0){
					switch(pg.winGradeP){
					case 2 : 
						g2.doClick();
						//playG = playG - 1 ;
						break;
					case 4 : 
						g3.doClick();
						//playG = playG - 3 ;
						break;
					case 6 : 
						g5.doClick();
						//playG = playG - 5 ;
						break;
					}
				}
				pg.winGradeP = 1 ;
				l = 1;
//				playG = playG + pg.winGrade - 1 ;
//				playerG.setText("玩家目前加分"+playG);
			}
		});
		
		g2 = new JCheckBox("1分");
		g2.setBounds(174, 109, 128, 23);
		frame.getContentPane().add(g2);
		g2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				g = g + 1 ;
				if(g % 2 == 0){
					switch (pg.winGradeP) {
					case 1:
						g1.doClick();
						//playG = playG - 0 ;
						break;
					case 4:
						g3.doClick();
						//playG = playG - 3 ;
						break;
					case 6:
						g5.doClick();
						//playG = playG - 5 ;
						break;
					default:
						break;
					}
				}
				pg.winGradeP = 2 ;
				l = 2;
//				playG = playG + pg.winGrade - 1 ;
//				playerG.setText("玩家目前加分"+playG);
			}
		});
		
		g3 = new JCheckBox("3分");
		g3.setBounds(174, 157, 128, 23);
		frame.getContentPane().add(g3);
		g3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				g = g + 1 ;
				if(g % 2 == 0){
					if(g % 2 == 0){
						switch (pg.winGradeP) {
						case 1:
							g1.doClick();
							//playG = playG - 0 ;
							break;
						case 2:
							g2.doClick();
							//playG = playG - 1 ;
							break;
						case 6:
							g5.doClick();
							//playG = playG - 5 ;
							break;
						default:
							break;
						}
					}
				}
				pg.winGradeP = 4 ;
				l = 3 ;
//				playG = playG + pg.winGrade - 1 ;
//				playerG.setText("玩家目前加分"+playG);
			}
		});
		
		g5 = new JCheckBox("5分");
		g5.setBounds(174, 209, 128, 23);
		frame.getContentPane().add(g5);
		g5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				g = g + 1 ;
				if(g % 2 == 0){
					if(g % 2 == 0){
						switch (pg.winGradeP) {
						case 1:
							g1.doClick();
							//playG = playG - 0 ;
							break;
						case 4:
							g3.doClick();
							//playG = playG - 3 ;
							break;
						case 2:
							g2.doClick();
							//playG = playG - 1 ;
							break;
						default:
							break;
						}
					}
				}
				pg.winGradeP = 6 ;
				l = 4 ;
//				playG = playG + pg.winGrade - 1 ;
//				playerG.setText("玩家目前加分"+playG);
			}
		});
		
		playerG = new JLabel("玩家目前加分：");
		playerG.setBounds(57, 66, 115, 16);
		frame.getContentPane().add(playerG);
		
		autoG_1 = new JLabel("电脑目前加分：");
		autoG_1.setBounds(57, 161, 115, 16);
		frame.getContentPane().add(autoG_1);
		
		
		tglbtnNewToggleButton = new JToggleButton("完成");
		tglbtnNewToggleButton.setBounds(267, 86, 93, 29);
		frame.getContentPane().add(tglbtnNewToggleButton);
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(l > n){
					n = l ;
				}
				if(l >= n){
					if(i % 3 == 0){
						switch (pg.winGradeP) {
						case 1:
							g1.doClick();
							break;
						case 2:
							g2.doClick();
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
						playG = playG + pg.winGradeP - 1 ;
						pg.winGradeP --;
						playerG.setText("玩家目前加分："+playG);
						lblNewLabel.setText("玩家本次加分：" + pg.winGradeP);
						label.setText("电脑加分中~");
						i ++;
					}
					if(i % 3 == 1){
						Timer timer = new Timer();
						timer.schedule(new TimerTask() {
						        public void run() {
						        	while(true){
						        		Random rand = new Random();
						        		if(d == 3 ){
						        			autoGrade = l;
						        		}else if(d == 2 || d == 1){
						        			autoGrade = rand.nextInt(4) + 1;
						        		}else if(d == 0){
						        			autoGrade = 4;
						        		}
						        		if(autoGrade >= n){
						        			label.setText("玩家加分中~");
								        	switch (autoGrade) {
											case 1:
												autoG = autoG + 0 ;
												pg.winGradeP = 0 ;
												break;
											case 2:
												autoG = autoG + 1 ;
												pg.winGradeP = 1 ;
												break;
											case 3:
												autoG = autoG + 3 ;
												pg.winGradeP = 3 ;
												break;
											case 4:
												autoG = autoG + 5 ;
												pg.winGradeP = 5 ;
												break;
											default:
												break;
						        		    }
								        	n = autoGrade ;
								        	break;
						        	    }else {
						        	    	continue;
						        	    }
						        	}
									autoG_1.setText("电脑目前加分：" + autoG);	
									lblNewLabel_1.setText("电脑本次加分：" + pg.winGradeP);
						        }
						}, 2000);
					}
					if(i % 3 == 1){
						i ++ ;
						tglbtnNewToggleButton.doClick();
					}
					if(i % 3 == 2){
						i ++ ;
					}
				}else {
					if(x % 3 == 0){
						JOptionPane.showMessageDialog(null, "不能加分少于之前的");
						switch (pg.winGradeP) {
						case 1:
							g1.doClick();
							break;
						case 2:
							g2.doClick();
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
						x ++ ;
					}
					if(x % 3 == 1){
						x ++ ;
						tglbtnNewToggleButton.doClick();
					}
					if(x % 3 == 2){
						x ++ ;
					}
				}
			}
		});
		tglbtnNewToggleButton_1 = new JToggleButton("结束");
		tglbtnNewToggleButton_1.setBounds(267, 171, 93, 29);
		frame.getContentPane().add(tglbtnNewToggleButton_1);
		
		lblNewLabel = new JLabel("玩家本次加分：");
		lblNewLabel.setBounds(57, 113, 115, 16);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("电脑本次加分：");
		lblNewLabel_1.setBounds(57, 213, 115, 16);
		frame.getContentPane().add(lblNewLabel_1);
		tglbtnNewToggleButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				ThrowHandPoker thp = new ThrowHandPoker();
				//thp.contain(PokerWindow.this);
				playG = pg.winGradeP + playG ;
				pg.winGradeP = playG;
				pg.winGradeA = autoG + 1;
				thp.save(player1,auto,pg,str);
				thp.initialize();
			}
		});
	}
}
