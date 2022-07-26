package com.snc.facebook.onsite;

public class KMissingPositiveInteger {
//  1 2 3  : k =2 result = 5
    //3 4 5 : k=2. result=2
    // 3 4 5 9   k=3 result =6
    public int findKthPositive(int[] arr, int k) {
        
        int missed=0;
        
        for(int i=0 ; i<arr.length; i++){
            
            //check if any starting numbers are missing
            if(i == 0){
                missed+= arr[0] - 1;
                
                if(missed >= k)
                    return k;
            }
            //check if missing numbers are in middle
            else{
                
                missed+=arr[i] - arr[i-1] - 1;
                if(missed >= k){
                    int result = arr[i-1];
                    missed-=arr[i] - arr[i-1] - 1;
                    
                    while(missed++ < k){
                        result++;
                    }
                    
                    return result;
                }
               
                
                
            }
           
            //check if  missing numbers are at the end
           
        }
          int result = arr[arr.length-1];
        
                
                 while(missed++ < k){
                        result++;
                    }
                    
                    return result;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
