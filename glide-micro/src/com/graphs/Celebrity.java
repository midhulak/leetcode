package com.graphs;

public class Celebrity {

	 
    public int findCelebrity(int n){
        
        int candidate = 0;
        //if candidate knows exactly 1 person that person might be celebrity
        for(int i=1 ; i<n; i++){
            if(knows(candidate , i))
                candidate=i;
        }
        
        //and checking that celebrity does not know any one and every one know that celebrity
        for(int i=0 ; i< n; i++){
            if(i != candidate && knows(candidate , i) || !knows(i, candidate))
                return -1;
        }
        
        return candidate;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
