package com.snc.onsite.set1;

public class MoveStonesRemRowCol {
	
	 class DSU{
		    int[] rank;
		        int[] childParent ;
		        int count ;
		    public DSU(int N){
		       
		        rank = new int[N];
		        childParent = new int[N];
		        count = N;
		        for(int i=0; i<N; i++){
		            childParent[i] = i;
		        }
		    }
		    
		    
		    public int find(int val){
		        if(childParent[val] != val)
		         childParent[val] = find(childParent[val]);
		        
		        return  childParent[val];
		        
		    }
		    
		    public void union(int x , int y){
		        
		        int xRootParent = find(x);
		        int yRootParent = find(y);
		        
		        if(xRootParent == yRootParent)  //they both belong to same set and it form a cycle so just ignore
		            return;
		        
		        //if not equal have to combine those two by looking which parent has more rank
		        
		        
		        if(rank[xRootParent] <= rank[yRootParent]){  //making x is child of Y
		            
		            childParent[xRootParent] = yRootParent;
		            rank[yRootParent]++;
		            
		        }
		        else{
		            childParent[yRootParent] = xRootParent;
		            rank[xRootParent]++;
		            
		        }
		         count--;
		    }
		    }
		   
		    public int removeStones(int[][] stones) {
		       int N=stones.length;
		        DSU d = new DSU(N);
		        
		        for(int i=0; i<N; i++){
		            for(int j=i+1; j<N; j++){
		                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])
		                    d.union(i, j);
		                
		            }
		        }
		        
		        return N - d.count;
		    }
		    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
