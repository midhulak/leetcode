package com.snc.phone.backTracking;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAndOperators {
	
	List<String> res = new ArrayList<>();
	
	public List<String> getAllExp(String s , int target){
		
		doBackTrack(0 , "" , 0 , 0 , s , target);
		
		return res;
	}
	

	public void doBackTrack(int i , String path , long resSoFar , long prev , String num , int target) {
		
		
		if(i == num.length()) {
			
			if(resSoFar == target) 
				res.add(path);
			
			return;
		}
		
		
		  for(int j=i ; j<num.length(); j++){
	            
	            if(j>i && num.charAt(i) =='0')
	                break;
	            
	            long currNum = Long.parseLong(num.substring(i , j+1));
	            
	            if(i==0)
	                doBackTrack(j+1 , path+currNum , currNum , currNum , num , target);
	            
	            else{
	                doBackTrack(j+1 , path+ "+" +currNum , resSoFar+currNum , currNum , num , target);
	                doBackTrack(j+1 , path+ "-" +currNum , resSoFar-currNum , -currNum , num , target);
	                doBackTrack(j+1 , path+ "*" +currNum , resSoFar-prev+prev*currNum , prev * currNum , num , target);
	            
	            }

	            }
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExpressionAndOperators ex = new ExpressionAndOperators();
		List<String> res = ex.getAllExp("123" , 6);
		
		for(int i=0; i <res.size(); i++) {
			
			System.out.println(res.get(i));
		}
	}

}
