package com.snc.slidingWindow;

public class MaxPointsObtainFromCards {
	
	//sliding window

	
	
	 public static  int maxScoreSlidingwindow(int[] cardPoints , int k){
	        int n = cardPoints.length;
	        int tot=0;
	        for(int a: cardPoints){
	            tot+=a;
	        }
	        int winSum =0;
	        int res=0;
	        for(int i=0 ; i<n-k; i++){
	            
	            winSum+=cardPoints[i];
	            res = tot - winSum;
	            
	        }
	        
	        for(int i=n-k; i < cardPoints.length; i++){
	            
	            winSum+= cardPoints[i]-(cardPoints[i-(n-k)]); //everytime we get newvalue and taking out older value from array.
	            res = Math.max(res , tot - winSum);
	        }
	        
	        return res;
	    }
	
	
	//recursion
	static int[][] cache ;
	public static int maxScore(int[] a , int k) {
		cache = new int[a.length][a.length];
		return maxScoreHelper(a , 0 , a.length-1 , k);
		
		
	}
	
	public static int maxScoreHelper(int[] a , int left , int right , int k) {
		
		if(k == 1) {
			return Math.max(a[left] , a [right]);
		}
		
		if(cache[left][right] != 0)
			return cache[left][right];
		
		int L = maxScoreHelper(a , left+1 , right , k-1);
		
		int Lval = a[left]+L;
		
		cache[left+1][right] = Lval;
		int R = maxScoreHelper(a , left , right-1, k-1);
		int Rval = a[right]+R;
		cache[left][right-1] = Rval;
		
		cache[left][right] = Math.max(Lval ,  Rval);
		
		return Math.max(Lval ,  Rval);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] cardPoints = {1,2,3,4,5,6,1};
		int k=3;
		
		maxScoreSlidingwindow(cardPoints , k);
	}

}
