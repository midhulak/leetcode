package com.snc.Trees.graphs;

import java.util.HashSet;
import java.util.Set;

public class CrackingSafe {

	  //https://www.youtube.com/watch?v=6VSWohXUZMQ
    //simple dfs
    Set<String> seen;
    StringBuilder ans;
    public String crackSafe(int n, int k) {
        if(n == 1 && k ==1)
            return "0";
        
        seen = new HashSet<>();
        ans = new StringBuilder();
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n-1; i++){
            sb.append("0");
        }
        
        String start = sb.toString();
        
        dfs(start , k);
        
        ans.append(start);
        
        return ans.toString();
    }
    
    public void dfs(String node , int k){
        
        for(int x=0; x < k ; x++){
            String val = node +x;
            if(!seen.contains(val)){
                seen.add(val);
                dfs(val.substring(1) , k);
                ans.append(x);
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
