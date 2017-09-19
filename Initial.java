package com.imooc.扎金花;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.imooc.Iphone;
import com.imooc.simplePook.Deal;

public class Initial extends Thread{
	public Scanner console ;
	
	public List<Player> playerInformation;
	public List<Poker> pokerList ;
	public List<Poker> player1; 
	public List<Poker> player2; 
	public List<Poker> auto; 
	//public List<PlayerBigPoker> compare;
	  public void run() {  
	        synchronized (this) {  
	            try {                         
	                Thread.sleep(1000); //  使当前线阻塞 1 s，确保主程序的 t1.wait(); 执行之后再执行 notify()  
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }             
	            System.out.println(Thread.currentThread().getName()+" call notify()");  
	            // 唤醒当前的wait线程  
	            this.notify();  
	        }  
	    }  
	public Initial(){
		playerInformation = new ArrayList<Player>();
		pokerList = new ArrayList<Poker>();
		player1 = new ArrayList<Poker>();
		player2 = new ArrayList<Poker>();
		auto = new ArrayList<Poker>();
		console = new Scanner(System.in);
		//compare = new ArrayList<PlayerBigPoker>();
	}
	
	public void setPoker(){
		System.out.println("--------游戏开始---------");
		System.out.println("————-创建扑克牌红桃1~k————");
		System.out.println("-----创建扑克牌黑桃1~k----");
		System.out.println("-----创建扑克牌梅花1~k----");
		System.out.println("-----创建扑克牌方块1~k----");
	}
	public void handPoker(){
//		System.out.println("开始发牌：");
//		Player p1 = new Player();
//		//p1 = playerInformation.get(0);
//		Poker p2 = new Poker();
//		//p2 = playerInformation.get(1);
//		
//		for(int i = 0 ; i < 2 ; i ++){
//			System.out.println("玩家-拿牌");
//			System.out.println("电脑-拿牌");
//		}
//		//Poker contain = new Poker();
//		
//		System.out.println("发牌结束！！！");
//		System.out.println("开始游戏！！！");		
//		
		/**
		 * 用于防止多次出现同一张牌
		 */
		for(int i = 0 ; i < 10 ; i ++){
			Poker d1 = new Poker();
			do{
				d1.deal();
			}while(pokerList.contains(d1));
			pokerList.add(d1);
		}
		
		/**
		 * 给参与玩家进行发牌
		 */
		for(int i = 0 ; i < 10 ; i ++ ){
			Poker d = new Poker();
			d = pokerList.get(i);
			if(i % 2 == 0){
				player1.add(d);
			}else{
				auto.add(d);
			}
		}
		
		/**
		 * 显示玩家手牌
		 */
		
//		for (Poker poker : player1) {
//			System.out.print(poker.colour + poker.Num+"   ");
//		}
//		System.out.println();
//		
//		for (Poker poker : auto) {
//			System.out.print(poker.colour + poker.Num+"   ");
//		}
//		System.out.println();
//		
	}
	public void throwPoker2(){
		Random rand = new Random();

		
		int a,b;
	    while(true){
	    	a = rand.nextInt(5);
		    b = rand.nextInt(5);
		    if(a != b)
		    	break;
		    else
		    	continue;       
	    }
	    //System.out.println(a+""+b+" ");
	    Poker[] aut = {auto.get(a),auto.get(b)};
	    auto.removeAll(Arrays.asList(aut));
		Collections.sort(auto);
	    Poker[] play = {player1.get(a) , player1.get(b)};
	    player1.removeAll(Arrays.asList(play));
		Collections.sort(player1);
	}
	
	public void throwPoker1(){
		Random rand = new Random();

		
		int a,b;
	    while(true){
	    	a = rand.nextInt(5);
		    b = rand.nextInt(5);
		    if(a != b)
		    	break;
		    else
		    	continue;       
	    }
	    //System.out.println(a+""+b+" ");
	    Poker[] aut = {auto.get(a),auto.get(b)};
	    auto.removeAll(Arrays.asList(aut));
		Collections.sort(auto);
		
//		CompareHandPoker chp = new CompareHandPoker(player1, auto);
//		chp.compareHandPoker();
	}
	public void throwPoker(){
		Random rand = new Random();
		System.out.println("请弃两张牌");
		System.out.println("输入1~5相应序号即可");
		
		int a,b;
		a = console.nextInt();
	    b = console.nextInt();
	    
	    Poker p1 = new Poker();
	    
	    Poker[] play = {player1.get(a-1),player1.get(b-1),p1,null};
	    player1.removeAll(Arrays.asList(play));
	    while(true){
	    	a = rand.nextInt(5);
		    b = rand.nextInt(5);
		    if(a != b)
		    	break;
		    else
		    	continue;       
	    }
	    //System.out.println(a+""+b+" ");
	    
	    Poker[] aut = {auto.get(a),auto.get(b)};
	    auto.removeAll(Arrays.asList(aut));
		
		System.out.println("您现在的手牌是:");
		for (Poker poker : player1) {
			System.out.print(poker.colour + poker.Num+"   ");
		}
		System.out.println();
		Collections.sort(player1);
		
		System.out.println("电脑现在的手牌是：");
		for (Poker poker : auto) {
			System.out.print(poker.colour + poker.Num+"   ");
		}
		System.out.println();
		Collections.sort(auto);
		
		CompareHandPoker chp = new CompareHandPoker(player1, auto);
		chp.compareHandPoker();
	}
	public static void unix(){
//		while(true){
//			Date date=new Date(System.currentTimeMillis());
//			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			System.out.println(date);
//			System.out.println("asda");
			//每一秒刷新下时间
			try {
			Thread.sleep(2000);//sleep是以ms为单位
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
//		}
//		String inputTime1 = null ;
//		String Time = "2000-01-01 10:10:10" ;
//       
//		
//		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            inputTime1 =  String.valueOf(sdf.parse(Time).getTime() / 1000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//		
//		long time1 = System.currentTimeMillis();
//        String nowTimeStamp = String.valueOf(time1 / 1000);
//
//        
//        int nowTime = Integer.parseInt(nowTimeStamp);
//        int inputTime = Integer.parseInt(inputTime1);
//        
//        int a = nowTime;
//        System.out.println(a);
//        int i = 0 ;
//        while(i < 1000000){
//        	int b = Integer.parseInt(nowTimeStamp) ;
//        	System.out.println(b);
//        	i ++ ;
//
//        }
//        	System.out.println("asda");
	}
//	public static void main(String[] args) {
//		unix();
//		Initial it = new Initial();
//		it.handPoker();
//		AutoDifficult ad = new AutoDifficult(it.auto) ;
//		ad.pokerGroup() ;
	}
	

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Initial it = new Initial();
//		it.setPoker();
//		//it.number();
//		it.handPoker();
//		it.throwPoker();
////		Initial333 a = new Initial333();
////		Deal d = new Deal();
////		d.deal();
//		//a.come();
//		//it.compareHandPoker();
//	}


