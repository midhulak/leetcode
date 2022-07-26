
public class LastStoneWeightTwo {
	
	/**
	 * We have a collection of rocks, each rock has a positive integer weight.

Each turn, we choose any two rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the smallest possible weight of this stone (the weight is 0 if there are no stones left.)

1 <= stones.length <= 30
1 <= stones[i] <= 100
	 * @param stones
	 * @return
	 */
	
	/*
	 * We have a collection of rocks, each rock has a positive integer weight.

Each turn, we choose any two rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the smallest possible weight of this stone (the weight is 0 if there are no stones left.)

 

Example 1:

Input: [2,7,4,1,8,1]
Output: 1
Explanation: 
We can combine 2 and 4 to get 2 so the array converts to [2,7,1,8,1] then,
we can combine 7 and 8 to get 1 so the array converts to [2,1,1,1] then,
we can combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we can combine 1 and 1 to get 0 so the array converts to [1] then that's the optimal value.
	 */

//  If we choose any two rocks, we could divide the rocks into 2 groups.

//And calculate the minimum diff between 2 groups' total weight.

//Since stones.length <= 30, stone weight <= 100, maximum total weight could be 3000.

//Let dp[i] denotes whether or not smaller group weight could be i. smaller goupe total weight is limited to 1500. Thus dp size is 1501. It becomes knapsack problem.

//dp[0] = true. We don't need to choose any stone, and we could get group weight as 0.

//For each stone, if we choose it we track dp[i-w] in the previoius iteration. If we don't choose it, track dp[i] from last iteration. Thus it is iterating from big to small.

//Time Complexity: O(n*sum). n = stones.length. sum is total weight of stones.

//Space: O(sum).
	public int lastStoneWeightII(int[] stones) {
		          if(stones == null || stones.length == 0){
		              return 0;
		          }
		          
		          int sum = 0;
		          boolean [] dp = new boolean[1501];
		          dp[0] = true;
		        
		         for(int w : stones){
		             sum += w;
	             
		             for(int i = Math.min(sum, 1501); i>=w; i--){
		                 dp[i] = dp[i] | dp[i-w];
		            }
	         }
		         
		         for(int i = sum/2; i>=0; i--){
		             if(dp[i]){
		                 return sum-i-i;
		             }
		         }
		         
		         return 0;
		     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
