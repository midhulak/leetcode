
public class MissingElementInSortedArray {
	
	  //have to debug..
    //input array is=         4 7 9 10
    //first element + index = 4 5 6 7 
     //    minus of 2 numbers  ---------
    //                         0 2 3 3.    how many numbers are misisng until element is Actualelement-firstelement-index   
       //actual element-firstelement-index
	//0 2 3 3 --after add 2 numbers after 4 i.e 5, 6 and add 3 numbers after 6 i.e 7 , 8 , 9 like that
	//once add take the numbers out which is already in the array here just using -
	//-4 5 6 -7 8 -9 -10 11 12
	//we had 5 6 8 11 12 and add indices starting from 1
	//1->5 2 -> 6 3->8 4->11 5->12
    private int missing(int idx , int[] nums){
        return nums[idx]-nums[0]-idx;
    }
    
    public int missingElement(int[] nums, int k) {
        
       int n = nums.length;
        
        //if kth missing number is greater than the last element of the arary
        if(k > missing(n-1 , nums))
            return nums[n-1] + k-missing(n-1 , nums);
        
        
         int left = 0, right = n - 1, pivot;
    // find left = right index such that 
    // missing(left - 1) < k <= missing(left)
    while (left != right) {
      pivot = left + (right - left) / 2;

      if (missing(pivot, nums) < k) left = pivot + 1;
      else right = pivot;
    }

    // kth missing number is greater than nums[idx - 1]
    // and less than nums[idx]
    return nums[left - 1] + k - missing(left - 1, nums);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
