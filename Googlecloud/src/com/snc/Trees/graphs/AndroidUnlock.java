package com.snc.Trees.graphs;

public class AndroidUnlock {
	
	public int numberOfPatterns(int m, int n) {
	        
	        //sizek, flexity
	        int cnt = 0; 
	        for(int num = m; num<= n; num++){
	            cnt += dfs(-1, num,  new boolean[9]);
	        }
	        return cnt;
	    }
	    //DFS
	    private int dfs(int prekey, int num, boolean[] visited){
	        //base case;
	        if(num == 0){
	            return 1;
	        }
	        int path = 0;
	        for(int i = 0; i < 9; i++){// {1 2 3 4 5 6 7 8 9}
	            if(!visited[i] && valid(prekey, i, visited)){
	                visited[i] = true;
	                path += dfs(i, num -1, visited);
	                visited[i] = false;
	            }
	        }
	        return path;
	    }
	    private boolean valid(int prekey, int i, boolean[] visited){
	        if(prekey == -1){
	            return true;
	        }
	        //adjacent 
	        if((prekey + i) % 2 == 1){
	            return true;
	        }
	        //diagonal
	         if(Math.abs(prekey / 3 - i / 3) == 1 && Math.abs(prekey % 3  - i % 3) == 1){
	             return true;
	         }
	          return visited[(prekey + i) / 2];
	    }
	
	// 1. [m, n], combination， [2, 6],  --> size is a combination of K numbers
	// combination of two numbers ，12， 23， 56
	// combination of three numbers，123，456，987，
	// combination of four number， 1234，5432
	// combination of five numbers
	// combination of six numbers，123456，589632

	// 2. validation： legal
	// - adjacent or knight
//	    (a + b) %2 == 1, 
	// - diagonal 
//	     Math.abs(a/3 - b/3) == 1 && Math.abs(a%3 - b%3) == 1
	// - c , (a + b) / 2
	    

	// 3.high level: using DFS backtracking algorithm to enumerate all possible k combinations of numbers
	// recursion tree: 
	// size 2
//	      1 2 3 4 5 6 7 8 9
//	       1                       2
//	     2 3 4 5 6 7 8 9       1 3 4 5 6 7 8 9

	// siez 3:
//	     1
//	     2                3 4 5 6 7 8 9 
	// 3 4 5 6 7 8 9         2 4 5 6 7 8 9
	        
	// time O(n!)， space O(n)



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
