package me.tingri.sorting.simple;

import java.util.Arrays;

public class ContiguousNumbers {

	public static void main(String[] s){
		byte[] sortedNumbers;
		int[] numbers2 = {15,16, 165, 21, 12, 98, 13, 22};
		
		long start = System.currentTimeMillis();
		
		Arrays.sort(numbers2);
		
		System.out.println(Arrays.toString(numbers2));
		System.out.println(System.currentTimeMillis() - start);
		
		
		start = System.currentTimeMillis();
		
		int min = 0, max = 0, size = 0;
		for(int i : numbers2){
			if(size == 0){
				min = max = i;
			} else {
				min = i < min ? i: min; 
				max = i > max ? i: max; 
			}
			size++;
		}
		
		sortedNumbers = new byte[(max - min)/8 + 1];
		
		for(int i : numbers2){
			int temp = i - min + 1;
			int temp2 = temp%8;
			if(temp2 == 0){
				sortedNumbers[temp/8] = (byte) (sortedNumbers[temp/8] | 1 ) ;
			} else {
				sortedNumbers[temp/8 + 1] = (byte) (sortedNumbers[temp/8 + 1] | ( 1 << (byte)(temp2))) ;
			}
			
		}
		
		int[] result = new int[size];
		int j=0,k =0;
		
		for (byte b : sortedNumbers){	
			for(int i = 0; i< 8; i++){
				if((b & (1 << i)) > 0){
					result[j] = k*8 + (b ^ i) + min -1; 
					j++;
				}
			}
			k++;
		}
		
		System.out.println(Arrays.toString(result));
		System.out.println(System.currentTimeMillis() - start);
	}
}
