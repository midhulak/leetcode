package com.snc.recursion;

import java.util.ArrayList;
import java.util.List;

public class TargetSumOperators {
	
	 List<String> res = new ArrayList<>();
	    public List<String> addOperators(String num, int target) {
	        
	        doBackTrack(0 , "" , 0 , 0 , num , target);
	        return res;
	        
	    }
	    
	    public void doBackTrack(int i , String path , long resSoFar , long prev , String num , int target){
	        
	        if(i == num.length()){
	            
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

	}

}
