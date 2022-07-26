package com.snc.compass;

public class CompassCode1 {
	
  public static int maxSum(int[] nums){
    
  int left=0;
   int sum=0;    //50 60 80 90 100 30
 
   int right=0;
  while(right < nums.length && left < nums.length){
   
    
     if(right < nums.length && right+1 < nums.length && nums[right] < nums[right+1]){
      
       right++;
      
     }
   
  
  int totSum = getSum(left , right , nums);  //140
  
   sum = Math.max(totSum , sum);
  
  
  
   left++;
  
  
  
   totSum = getSum(left , right , nums);  //80
   
  
   sum = Math.max(totSum , sum);
  
  
 }
  
   return sum;

 }

 public static int getSum(int left , int right , int[] nums){
  
   int totalSum=0;
  
   for(int k=left ; k<=right; k++){
    
   totalSum+=nums[k]; 
   }
  
   return totalSum;
  
 }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {-1,-2,-3,4,5,6};
		
		System.out.println(maxSum(nums));
		
	}

}
