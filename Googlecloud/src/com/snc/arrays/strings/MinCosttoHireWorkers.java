package com.snc.arrays.strings;

import java.util.PriorityQueue;

public class MinCosttoHireWorkers {
	
	 public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
	        //make captain of each worker and see the wage of 1 quality then with athat captain quality get the wage of all workers and check the wage of each worker is greater tahn or equal to the wage of the currnet worker, if it is less than then skip that worker(do not hire) 
	        
	       double ans= 1e9;
	       return  calculateWage(quality , wage , k , ans);
	        
	      
	        
	    }
	    
	    public double calculateWage(int[] quality , int[] wage , int k, double ans){
	       
	            //PriorityQueue<Double> minOffer = new PriorityQueue<>();
	            
	        for(int i=0; i<quality.length; i++){
	             PriorityQueue<Double> pq =new PriorityQueue<>((x, y) -> Double.compare(y, x));
	            double captainWage = (double)wage[i]/quality[i];
	            double sum = 0.0;
	            for(int j=0; j<quality.length; j++){
	                
	                double comp = quality[j] * captainWage;
	                
	                if(comp < wage[j])
	                    continue;
	                sum+=comp;
	                pq.add(comp);
	                
	               if(pq.size() > k)
	                   sum = sum-pq.remove();
	            }
	            
	           
	            if(pq.size() >= k)
	            ans = Math.min(ans , sum);
	           
	            
	        }
	        
	        return ans == 1e9 ? 0.0 : ans;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
