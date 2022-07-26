
public class MinRotatedSortedArarydup {
	
	//TC: O(logn)
	
	  public int findMin(int[] nums) {
	        int low=0;
	        int high = nums.length-1;
	         // Find the index of the smallest value using binary search.
	        // Loop will terminate since mid < hi, and low or high 
	        // will shrink by at least 1.
	        
	        // Proof by contradiction that mid < high: if mid==high, 
	        // then low == high and loop would have been terminated.
	        
	        while(low < high){
	            int mid = low+(high - low)/2;
	            if(nums[mid] > nums[high]){
	                low = mid+1;
	            }
	            else if(nums[mid] < nums[high]){
	                high = mid;
	            }
	            else
	                high--;
	        }
	        System.out.println("low is="+low);
	         System.out.println("hiugh is="+high);
	        return nums[low];
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
