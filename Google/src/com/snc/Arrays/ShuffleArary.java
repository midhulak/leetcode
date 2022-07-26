package com.snc.Arrays;
import java.util.Random;




public class ShuffleArary {
	private int[] tempArr;
	private int[] original;
	Random rand;

    public ShuffleArary(int[] nums) {
        rand = new Random();
        original = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        
        tempArr = original.clone();
        for(int i=0; i<tempArr.length; i++){
            swap(i , getRandRange(i, tempArr.length) );
        }
        
        return tempArr;
    }
    
    public int getRandRange(int min , int max){
        return rand.nextInt(max-min)+min;
    }
    
    public void swap(int i , int j  ){
        int temp = tempArr[i];
        tempArr[i] = tempArr[j];
        tempArr[j] = temp;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
