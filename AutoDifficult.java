package com.imooc.扎金花;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AutoDifficult {
	public List<Poker> auto ;
	public List<List<Poker>> poker ;
	public int i , j , k;

	public void pokerGroup(){
//		for (Poker poker : auto) {
//			System.out.print(poker.colour +poker.Num + " ");
//		}
		for( i = 0 ; i < 3 ; i ++){
			for( j = i+1 ; j < 4 ; j ++){
				for(k = j + 1 ; k < 5 ; k ++){
					Poker[] p = {auto.get(i) , auto.get(j) , auto.get(k) };
				    List<Poker> autoGroup = new ArrayList<Poker>();
				    autoGroup.addAll(Arrays.asList(p));
				    Collections.sort(autoGroup);
					poker.add(autoGroup);
				}
			}
		}
		Collections.sort(poker , new Compare());
	}
		
	public AutoDifficult(List<Poker> auto){
		//this.player1 = player1 ;
		this.auto = auto ;	
		poker = new ArrayList<List<Poker>>() ;
	}

}
