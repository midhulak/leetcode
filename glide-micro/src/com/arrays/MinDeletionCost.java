package com.arrays;

import java.util.PriorityQueue;

public class MinDeletionCost {
	
public int minCost(String s, int[] cost) {
        
        int result =0;
        
        for(int j=1; j<cost.length; j++){
            
            if(s.charAt(j-1) != s.charAt(j))
                continue;
            else{
                
                PriorityQueue<Integer> heap = new PriorityQueue<>();
                heap.add(cost[j-1]);
                
                while(j < cost.length && s.charAt(j) == s.charAt(j-1)){
                    heap.add(cost[j]);
                    j++;
                }
                
                while(heap.size() != 1){
                    result+= heap.remove();
                }
                
                
            }
            
        }
        return result;
    }


public int minCost1(String s, int[] cost) {
  int i = 0;
  int j = 1;

  int sum = 0;
  while (j < s.length()) {
      if (s.charAt(i) == s.charAt(j)) {
          if (cost[i] >= cost[j]) {
              sum += cost[j];
              j++;
          } else if (cost[i] < cost[j]) {
              sum += cost[i];
              i = j++;
          }
      } else {
          i = j++;
      }
  }
  return sum;
}
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
