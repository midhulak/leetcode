package com.snc.facebook.phone;

public class DotProductSparse {
	
	 private int[] array;
	    SparseVector(int[] nums) {
	        
	       array=nums;
	        
	    }
	    
		// Return the dotProduct of two sparse vectors
	    public int dotProduct(SparseVector vec) {
	       
	        int sum=0;
	        
	        for(int i=0; i<array.length; i++){
	            if(array[i] != 0 && vec.array[i] != 0){
	                sum+=array[i] * vec.array[i];
	                
	            }
	        }
	        
	        return sum;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
