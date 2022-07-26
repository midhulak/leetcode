package com.snc.sorting.searching;

/**https://www.youtube.com/watch?v=ET_HIyJTl1E **/

public class TwentyFourGame {
	
	public boolean judgePoint24(int[] cards) {
        double[] copyCards = {cards[0] , cards[1] , cards[2] , cards[3]};
        
        return backTrack(copyCards);
        
    }
    
    public boolean backTrack(double[] cards){
        
        if(cards.length == 1 )
            return Math.abs(24 - cards[0]) <0.0009; 
        
        for(int i=0; i<cards.length; i++){
            for(int j=i+1; j<cards.length; j++){
                
                double[] restCards = new double[cards.length-1];
                
                int index=0;
                
                for(int k=0; k<cards.length; k++){
                    //if it is 4,1,8,7 remove 4 and 1 and add just 8,7 
                	//and last index empty and last empty index will fill all possible combinations of 4 and 1
                    if(k!=i && k!=j)
                        restCards[index++] = cards[k];
                    
                }
                
                for(double allcomb : compute(cards[i] , cards[j])){
                    
                    restCards[restCards.length-1] = allcomb;
                   if(backTrack(restCards))
                       return true;
                }
            }
        }
        
        return false;
    }
    
    
    public double[] compute(double x , double y){
        return new double[]{x+y , x*y , x-y, y-x, x/y, y/x};
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwentyFourGame t = new TwentyFourGame();
		int[] nums = {4,1,8,7};
		t.judgePoint24(nums);
		
	}

}
