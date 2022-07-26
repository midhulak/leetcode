package com.snc.facebook.popular;

public class RemoveDuplicates {
	
	public static int removeDuplicates(int[] nums) {
        //1,1,2
        if(nums.length == 0)
            return 0;
        
        int i=0;
        for(int j=1; j< nums.length; j++){
            if(nums[j] != nums[i]){
              i++;
            nums[i] = nums[j];
        }
        
    }
        
        return i+1;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] num = {0,0,1,1,1,2,2,3,3,4};
 removeDuplicates(num);
	}

}
