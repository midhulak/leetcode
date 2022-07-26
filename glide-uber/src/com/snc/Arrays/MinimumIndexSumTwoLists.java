package com.snc.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*https://leetcode.com/problems/minimum-index-sum-of-two-lists/ 
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

 

Example 1:

Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".
Example 2:

Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 * 
 * */
public class MinimumIndexSumTwoLists {
	
public String[] findRestaurant(String[] list1, String[] list2) {
        
        List<String> list = new ArrayList<>();
        Map<String , Integer> map = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;
        int sum=0;
        
       for(int i=0; i<list1.length; i++){
           map.put(list1[i] , i);
       }
        
     
        for(int j=0; j<list2.length && j<=minIndex ; j++){
            
            if(map.containsKey(list2[j])){
                sum = j+map.get(list2[j]);
                if(sum < minIndex){
                    list.clear();
                    list.add(list2[j]);
                    minIndex = sum;
                }
                else if(sum == minIndex)
                list.add(list2[j]);
            }
            
        }
        return list.toArray(new String[list.size()]);
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
