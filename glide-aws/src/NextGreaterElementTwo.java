import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementTwo {
	/**
	 * Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

Example 1:
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2.
	 * @param nums
	 * @return
	 */
	public static int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> stack = new Stack<>();
        Map<Integer , Integer> map = new HashMap<>();
        
        for(Integer num : nums){
            
            while(!stack.isEmpty() && stack.peek() < num){
                
                map.put(stack.pop() , num);
            }
            
            stack.push(num);
            
        }
        
        for(int i=0 ; i < nums.length; i++){
            
            int key = nums[i];
            
            if(map.containsKey(nums[i]))
                nums[i] = map.get(key);
            
            else
            nums[i] = -1;
        }
        
        return nums;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] nums = {17,18,5,4,6,1};
int[] res= nextGreaterElements(nums);

for(int i=0 ; i<res.length; i++) {
	System.out.println("re sis="+res[i]);
}

	}

}
