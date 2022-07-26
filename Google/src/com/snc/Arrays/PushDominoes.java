package com.snc.Arrays;

public class PushDominoes {
	
	 public String pushDominoes(String dominoes) {
	        
	        char[] domies = dominoes.toCharArray();
	        int domiesLen = dominoes.length();
	        int[] forces = new int[domiesLen];
	        StringBuffer sb = new StringBuffer();
	        
	        int force =0;
	        
	        for(int i=0; i< domiesLen; i++){
	            
	            if(domies[i] == 'R')
	                force = domiesLen;
	            else if(domies[i] == 'L')
	                force = 0;
	            else
	                force = Math.max(force-1 , 0);
	            
	            forces[i]+=force;
	        }
	        
	        force=0;
	        
	         for(int i=domiesLen-1; i>=0; i--){
	            
	            if(domies[i] == 'L')
	                force = domiesLen;
	            else if(domies[i] == 'R')
	                force = 0;
	            else
	                force = Math.max(force-1 , 0);
	            
	            forces[i]-=force;
	        }
	        
	        for(int i=0; i<forces.length; i++){
	            if(forces[i] > 0)
	                sb.append('R');
	            else if(forces[i] < 0)
	                sb.append('L');
	            else
	                sb.append('.');
	        }
	        
	        return sb.toString();
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
