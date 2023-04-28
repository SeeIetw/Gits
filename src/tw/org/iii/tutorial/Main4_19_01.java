package tw.org.iii.tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main4_19_01 {

	public static void main(String[] args) {
			int[] poker = shuffle();
			// 發牌
			
			int[][] players = new int[4][13];
			for (int i=0; i<poker.length; i++) {
				players[i%4][i/4] = poker[i];
			}
			String[] suits = {"黑桃","紅心","方塊","梅花"};
			String[] values = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
			
			for(int[] arr:players) {
				Arrays.sort(arr);
				for(int i:arr) {
					int suitNums = i/13;
					int nums = i%13;
					
					System.out.print(suits[suitNums] + values[nums] + "\t");
				}
				System.out.println("\n-----------------------------------------------------------------------------------------------");
			}
				
			
			
			
			
		}
		
		static int[] shuffle() {
			// 1. 洗牌
			int count = 52;
			int[] poker = new int[count];
			boolean isRepeat;
			int temp;
			for (int i=0; i<poker.length; i++) {
				do {
					temp = (int)(Math.random()*count);
					
					// 檢查機制
					isRepeat = false;
					for (int j=0; j<i; j++) {
						if (temp == poker[j]) {
							// 重複了
							isRepeat = true;
							break;
						}
					}
				}while (isRepeat);
				
				poker[i] = temp;
//				System.out.println(poker[i]);
			}
//			System.out.println("---");
			return poker;
	}

}