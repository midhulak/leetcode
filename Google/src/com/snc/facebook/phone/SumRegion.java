package com.snc.facebook.phone;

public class SumRegion {
	
public int sumRegion(int row1, int col1, int row2, int col2) {
        
        if(row1 > numMatrix.length)
            return 0;
        
        if(col2 > numMatrix[0].length)
            return 0;
        if(col2 < col1)
            return 0;
        if(row2 < row1)
            return 0;
        
        int sum=0;
        
        for(int i=row1; i<=row2; i++){
            for(int j=col1; j<=col2; j++){
                sum+=numMatrix[i][j];
            }
        }
        
        return sum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
