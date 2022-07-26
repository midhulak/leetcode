package com.snc.ordering;
import java.util.LinkedList;
import java.util.List;
	public class NDigitSum {
	public static List<Integer> NdigitSum (int n , int target){
		
			List<List<Integer>> result = new LinkedList<List<Integer>>();
			
		NdigitSum(result , new LinkedList<Integer>() , n , target , 0);
		
		List<Integer> finalResult = new LinkedList<Integer>();
		
		for(List<Integer> numbers : result) {
			
			String sum ="";
			
			for(Integer i : numbers) {
				
				sum = sum+i;
			}
			
			finalResult.add(Integer.parseInt(sum));
		}
		
		return finalResult;
			
			
		}
		
		public static void NdigitSum(List<List<Integer>> result , List<Integer> path , int n , int target , int sum  ) {
			
			if(sum > target) return;
			
			if(n == 0) {
				if(sum == target) {
					result.add(new LinkedList<Integer>(path));
					return;
				}
				return;
			}
			
			for(int i=0 ; i<10 ; i++) {
				
				if(i==0 && sum == 0) continue;
				
				path.add(i);
				NdigitSum(result , path , n-1 , target , sum+i);
				path.remove(path.size() - 1);
			}
			
		}
		
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			System.out.println(NdigitSum(3 , 7));
			
		}

	}


	


