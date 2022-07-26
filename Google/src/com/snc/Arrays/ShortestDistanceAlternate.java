package com.snc.Arrays;

import java.util.ArrayList;
import java.util.List;

public class ShortestDistanceAlternate {
	
	 public static List<Integer> shortestDistanceColor(int[] color , int[][] queries){
	        
	        List<Integer> result = new ArrayList<>();
	        
	        int[][] shortestDis = new int[3][color.length];
	        
	       // Arrays.fill(shortestDis , Integer.MAX_VALUE);
	        
	        int prevColor1=Integer.MIN_VALUE/2;
	        int prevColor2=Integer.MIN_VALUE/2;
	        int prevColor3 = Integer.MIN_VALUE/2;
	        
	        for(int i=0; i<color.length; ++i){
	            if(color[i] == 1)
	                   prevColor1 = i;
	            
	            if(color[i] == 2)
	                   prevColor2 = i;
	            
	            if(color[i] == 3)
	                   prevColor3 = i;
	            
	            shortestDis[0][i] = i-prevColor1;
	            shortestDis[1][i] = i-prevColor2;
	            shortestDis[2][i] = i-prevColor3;
	            
	                
	            
	            
	        }
	        
	        for(int j=0 ; j<shortestDis.length; j++) {
	        	System.out.println(" row is="+j);
	        	for(int i=0; i<shortestDis[j].length; i++) {
	        		System.out.print(shortestDis[j][i]+" ");
	        	}
	        	System.out.println(" ");
	        }
	        
	      prevColor1=Integer.MAX_VALUE/2;
	         prevColor2=Integer.MAX_VALUE/2;
	         prevColor3 = Integer.MAX_VALUE/2;
	        
	        
	        for(int i=color.length-1; i>=0 ; --i){
	            
	             if(color[i] == 1)
	                   prevColor1 = i;
	            
	            if(color[i] == 2)
	                   prevColor2 = i;
	            
	            if(color[i] == 3)
	                   prevColor3 = i;
	            
	            
	             shortestDis[0][i] = Math.min(prevColor1-i , shortestDis[0][i]);
	            shortestDis[1][i] = Math.min(prevColor2-i , shortestDis[1][i]);
	            shortestDis[2][i] = Math.min(prevColor3-i , shortestDis[2][i]);
	            
	            
	        }
	        
	        
	        for(int[] query : queries){
	            
	            if( query[0] < 0 ||  query[0] > color.length-1 || query[1] == 0 || query[1] > 3){
	                result.add(-1);
	                continue;
	            }
	            
	            result.add(shortestDis[query[1]-1][query[0]]);
	        }
	         return result;
	    }
	    
	   
	    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] colors = {1,1,2,1,3,2,2,3,3};
		int[][] queries = { {1,3} , {2,2} , {6,1} };
		
     List<Integer> res = shortestDistanceColor(colors , queries);
     
     for(int re : res) {
    	 System.out.println(re);
     }
	}

}
