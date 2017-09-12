package com.imooc.扎金花;

public class PokerGrade {
	public int  startAutoGrade , startPlayerGrade , b , winGrade ,startAllGrade;

	public int pokerGrade(){
		
		if(b == 1) {
			startPlayerGrade = startPlayerGrade + winGrade ;
			startAutoGrade = startAutoGrade - winGrade;
			if(startPlayerGrade > startAllGrade){
				startPlayerGrade = startAllGrade ;
				startAutoGrade = 0 ;
			}
		}else if(b == 0){
		}else {
			startAutoGrade = startAutoGrade + winGrade ;
			startPlayerGrade = startPlayerGrade - winGrade ;
			if(startAutoGrade > startAllGrade){
				startAutoGrade = startAllGrade ;
				startPlayerGrade = 0 ;
			}
		}
		if(startAutoGrade <= 0){
			return 1 ;
		}else if(startPlayerGrade <= 0){
			return -1 ;
		}else {
			return 0 ;
		}
	}
	public PokerGrade(int startPlayerGrade){
		this.startPlayerGrade = startPlayerGrade ;
		this.startAutoGrade = startPlayerGrade ;
		this.startAllGrade = startPlayerGrade * 2;
	}
	public PokerGrade() {
		// TODO Auto-generated constructor stub
	}
}
