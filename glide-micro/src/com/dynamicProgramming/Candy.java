package com.dynamicProgramming;

import java.util.Arrays;

public class Candy {
	
	public int candy(int[] ratings) {
        int[] lr = new int[ratings.length];
        int[] rl = new int[ratings.length];
        Arrays.fill(lr ,1);
        Arrays.fill(rl , 1);
        //if next neighbour is grerater than prev neighbour get prevneighbour candies + 1
        int total=0;
        for(int i=1; i<ratings.length; i++){
            
            if(ratings[i] > ratings[i-1]){
                lr[i] = lr[i-1]+1;
            }
        }
        
        for(int j=ratings.length-2; j>=0; j--){
            
            if(ratings[j] > ratings[j+1]){
                rl[j] = rl[j+1]+1;
              
                }
                total+=Math.max(lr[j] , rl[j]);
        }
        total+=Math.max(lr[ratings.length-1] , rl[ratings.length-1]);
        return total;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
