package com.imooc.扎金花;

import java.util.List;

public class CompareHandPokerWindow {
	private List<Poker> player1;
	private List<Poker> auto;
	public int compareHandPoker(){
		Poker ph1 = player1.get(0);
		Poker ph2 = player1.get(1);
		Poker ph3 = player1.get(2);
		Poker ah1 = auto.get(0);
		Poker ah2 = auto.get(1);
		Poker ah3 = auto.get(2);
		if(ph1.num == ph2.num && ph2.num == ph3.num){
			if(ah1.num == ah2.num && ah2.num == ah3.num){
				if(ph1.num > ah1.num)
				return 1;
				else if(ph1.num == ah1.num)
				return 0;
				else
				return -1;
			}else {
				return 1;
			}
		}else if(ph1.color == ph2.color && ph2.color == ph3.color 
				&& ph2.num + 1 == ph3.num && ph2.num - 1 == ph1.num){
			if(ah1.num == ah2.num && ah2.num == ah3.num)
			return -1;
			else if(ah1.color == ah2.color && ah2.color == ah3.color 
					&& ah2.num + 1 == ah3.num && ah2.num - 1 == ah1.num){
				if(ph3.num > ah3.num){
					return 1;
				}else if(ph3.num == ah3.num){
					return 0;
				}else {
					return -1;
				}
			}else{
				return 1;
			}
		}
		else if((ph1.color == ph2.color && ph2.color == ph3.color) && (ph2.num != ph1.num + 1 || ph2.num != ph3.num - 1)){
			if(ah1.num == ah2.num && ah2.num == ah3.num)
			return -1;
			else if(ah1.color == ah2.color && ah2.color == ah3.color&& (ah2.num + 1 == ah3.num && ah2.num - 1 == ah1.num)){
				return -1 ;
			}else if(ah1.color == ah2.color && ah2.color == ah3.color&& (ah2.num + 1 != ah3.num || ah2.num - 1 != ah1.num)){
				
//				if(ph3.num > ah3.num){
//					System.out.println("玩家赢");
//				}else if(ph1.num == ah3.num){
//					System.out.println("平局");
//				}else{
//					System.out.println("电脑赢");
//				}
				if((ph3.num > ah3.num) || (ph3.num == ah3.num && ph2.num > ah2.num) 
						|| (ph3.num == ah3.num && ph2.num == ah2.num && ph1.num > ah1.num)){
					return 1;
				}else if(ph3.num == ah3.num && ph2.num == ah2.num && ph1.num == ah1.num){
					return 0;
				}else if((ph3.num < ah3.num) || (ph3.num == ah3.num && ph2.num < ah2.num) 
						|| (ph3.num == ah3.num && ph2.num == ah2.num && ph1.num < ah1.num)){
					return -1;
				}
			}else{
				return 1;
			}
		}else if(ph2.num + 1 == ph3.num && ph2.num - 1 == ph1.num){
			if(ah1.num == ah2.num && ah2.num == ah3.num){
				return -1;
			}else if(ah1.color == ah2.color && ah2.color == ah3.color){
				return -1;
			}else if(ah2.num + 1 == ah3.num && ah2.num - 1 == ah1.num){
					if(ph3.num > ah3.num){
						return 1;
					}else if(ph3.num == ah3.num){
						return 0;
					}else{
						return -1;
					}
			}else {
				return 1;
			}
		}else if((ph1.num == ph2.num && ph1.num != ph3.num) || (ph2.num == ph3.num && ph1.num != ph3.num)){
			if(ah1.num == ah2.num && ah2.num == ah3.num){
				return -1;
			}else if(ah1.color == ah2.color && ah2.color == ah3.color){
				return -1;
			}else if(ah2.num + 1 == ah3.num && ah2.num - 1 == ah1.num){
				return -1;
			}else if((ah1.num == ah2.num && ah1.num !=ah3.num) || (ah2.num == ah3.num && ah1.num != ah3.num)){
				if(ph2.num > ah2.num){
					return 1;
				}else if(ph2.num == ah2.num){
					if(ph1.num != ph2.num){
						if(ah1.num != ah2.num){
							if(ph1.num > ah1.num){
								return 1;
							}else if(ph1.num == ah1.num){
				
								return 0;
							}else if(ph1.num < ah1.num){
							
								return -1;
							}
						}else if(ah3.num != ah2.num){
							if(ph1.num > ah3.num){
							
								return 1;
							}else if(ph1.num == ah3.num){
								
								return 0;
							}else if(ph1.num < ah3.num){
								
								return -1;
							}
						}
					}else if(ph3.num != ph2.num){
							if(ah1.num != ah2.num){
								if(ph3.num > ah1.num){
									
									return 1;
								}else if(ph3.num == ah1.num){
									
									return 0;
								}else{
									
									return -1;
								}
							}else if(ah3.num != ah2.num){
								if(ph3.num > ah3.num){
									
									return 1;
								}else if(ph3.num == ah3.num){
								
									return 0;
								}else{
									return -1;
								}
							}
			        }
				}else if (ph2.num < ah2.num){
		        	return -1;
		        }
			}else {
				return 1;
			}
		}else{
			if(ah1.num == ah2.num && ah2.num == ah3.num){
				
				return -1;
			}else if(ah1.color == ah2.color && ah2.color == ah3.color){
				
				return -1;
			}else if(ah2.num + 1 == ah3.num && ah2.num - 1 == ah1.num){
				
				return -1;
			}else if((ah1.num == ah2.num && ah1.num !=ah3.num) || (ah2.num == ah3.num && ah1.num != ah3.num)){
				
				return -1;
			}else{
				if((ph3.num > ah3.num) || (ph3.num == ah3.num && ph2.num > ah2.num) 
						|| (ph3.num == ah3.num && ph2.num == ah2.num && ph1.num > ah1.num)){
					
					return 1;
				}else if(ph3.num == ah3.num && ph2.num == ah2.num && ph1.num == ah1.num){
					
					return 0;
				}else{
					
					return -1;
			    }
		    }
		}
		return 0;
	}
	public CompareHandPokerWindow(List<Poker> player1 , List<Poker> auto){
		this.player1 = player1 ;
		this.auto = auto ;
	}

}
