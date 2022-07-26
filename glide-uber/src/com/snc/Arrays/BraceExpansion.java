package com.snc.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BraceExpansion {
	
	   public String[] expand(String s) {
	        
	        List<String> list = new ArrayList<>();
	        
	        for(int i=0; i<s.length(); i++){
	            
	            if(s.charAt(i) == '{'){
	                int j=i+1;
	                 StringBuilder sb = new StringBuilder();
	                while(j < s.length() && s.charAt(j) != '}'){
	                   
	                    if(s.charAt(j) == ','){
	                        j++;
	                        continue;
	                    }
	                    sb.append(s.charAt(j));
	                    j++;
	                    
	                }
	                list.add(sb.toString());
	                i=j;
	            }
	            else{
	                list.add(s.charAt(i)+"");
	            }
	            
	        }
	        List<String> toRet = new ArrayList<>();
	        dfs(list , toRet , new StringBuilder());
	        String[] res = new String[toRet.size()];
	        
	        for(int i=0; i<toRet.size(); i++){
	            res[i] = toRet.get(i);
	        }
	        
	        Arrays.sort(res);
	        return res;
	        
	    }
	    
	    
	    public void dfs(List<String> list , List<String> toRet , StringBuilder sb){
	        
	        
	        if(sb.length() == list.size()){
	            toRet.add(sb.toString());
	            return;
	        }
	        
	        String s = list.get(sb.length());
	        
	        char[] ch = s.toCharArray();
	        
	        for(char c : ch){
	            sb.append(c);
	            dfs(list , toRet , sb);
	            sb.deleteCharAt(sb.length()-1);
	            
	        }
	        
	    }
	    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
