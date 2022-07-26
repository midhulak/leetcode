
public class MinimumPathSum {
	
//	Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//
//	Note: You can only move either down or right at any point in time.
//
//	Example:
//
//	Input:
//	[
//	  [1,3,1],
//	  [1,5,1],
//	  [4,2,1]
//	]
//	Output: 7
//	Explanation: Because the path 1→3→1→1→1 minimizes the sum
	
	
//  for eg:
    
//  1,3,1
//  1,5,1
//  4,2,1
     
//      result : (1)       (1+3=4)             (1+4=5)
//               (1+1=2)   (5+(min(4,2))= 7)    1+min(5,7) = 6
//               (4+2=6)   2+min(7,6)=8         1+min(6,8)=7
 //answer is 7
  
 public int minPathSum(int[][] grid) {
     
 if(grid.length == 0)
     return 0;
     
     for(int i=1 ; i<grid[0].length; i++){
         
         grid[0][i]+= grid[0][i-1]; //initially summing up row
     }
     
     for(int j=1 ; j<grid.length; j++){
         
         grid[j][0]+= grid[j-1][0]; //summing up col
     }
     
     for(int k=1 ; k<grid.length; k++){
         for(int l=1; l<grid[0].length; l++){
             
             grid[k][l]+= Math.min(grid[k-1][l] , grid[k][l-1]); //here checking teh value which is coming from up and left
         }
     }
     
     return grid[grid.length-1][grid[0].length-1]; //returning the last element.
     
 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
