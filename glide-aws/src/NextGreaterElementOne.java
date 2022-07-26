import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementOne {
	
	/*
	 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
	 */
	 public int[] nextGreaterElement(int[] nums1, int[] nums2) {
	        
	        Stack<Integer> stack = new Stack<>();
	        Map<Integer , Integer> map = new HashMap<>();
	        
	        for(Integer num : nums2){
	            
	            while(!stack.isEmpty() && stack.peek() < num){
	                map.put(stack.pop() , num); //put elements in map and with key and nextelement. for eg: 1,3,4,2  stack , 1 if next element id == greater than 1 then in map(1,3) and pop 1 from stack
	            }
	            
	            stack.push(num);
	        }
	            
	            for(int i=0 ; i<nums1.length; i++){
	                int key = nums1[i];
	                if(map.containsKey(key)){
	                
	                    nums1[i] = map.get(key);
	                }
	                
	                else
	                    nums1[i] = -1;
	                
	            }
	            
	        return nums1;
	        }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
