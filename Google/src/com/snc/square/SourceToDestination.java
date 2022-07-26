package com.snc.square;
/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
--------------------------------------
Write a function that given the following information:
- Square grid of size N
- Initial starting coordinates
- A list of steps (Up, Down, Left, Right)

The function should return
- The destination coordinates by navigating the grid using the list of steps provided.

Notes
- If a step takes the current coordinate out of bounds, then reset that specific dimension to the opposite side of the grid.
- There may be *multiple* obstacles in the grid, if an obstacle is encountered, return the coordinate of the cell just before the obstacle was encountered.

*Example*
- 5x5 Grid
- Starting coordinate (0, 1)
- Steps: [L, D, D, R]
┌───┬───┬───┬───┬───┐
│ . ← S │   │   │  S │
├─↓─┼───┼───┼───┼───┤
│ . │   │   │   │   │
├─↓─┼───┼───┼───┼───┤
│ . → D │   │   │   │
├───┼───┼───┼───┼───┤ 
│   │   │   │   │   │
├───┼───┼───┼───┼───┤
│   │   │   │   │   │
└───┴───┴───┴───┴───┘
Answer: (2, 1)

*Example*
- 5x5 Grid
- Starting coordinate (0, 1)
- Steps: [L, L, U, U]
┌───┬───┬───┬───┬─↑─┐
← . ← S │   │   │ . ←   
├───┼───┼───┼───┼───┤
│   │   │   │   │   │
├───┼───┼───┼───┼───┤
│   │   │   │   │   │
├───┼───┼───┼───┼───┤
│   │   │   │   │ D │
├───┼───┼───┼───┼─↑─┤
│   │   │   │   │ . │
└───┴───┴───┴───┴─↑─┘
Answer: (3, 4)

*Example*
- 5x5 Grid
- Starting coordinate (0, 1)
- Obstacle at (0, 2)
- Steps: [R, R, D]
┌───┬───┬───┬───┬───┐
│  X │ S →  │   │   │
├───┼───┼───┼───┼───┤
│   │   │   │ X │   │
├───┼───┼───┼───┼───┤
│   │   │   │   │   │
├───┼───┼───┼───┼───┤
│   │   │   │   │   │
├───┼───┼───┼───┼───┤
│   │   │   │   │   │
└───┴───┴───┴───┴───┘
Answer: (0, 1) (0,3)
--------------------------------------



 */

class Solution {
  
  
//working solution ran for all tets cases
  
  //time complexity: o(n) where n is teh size of steps
  //space complexity o(1) 
  
  
  public static int[] getDestination(char[] charArr ,int size ,char[][] mat , int[] start){
    
    
    // [2,2], [L, L]
   
    int[] currentPosition = new int[]{start[0] , start[1]};
    int[] nextPositon = new int[2];
    
  for(int i=0 ; i<charArr.length; i++){
    
//     if(charArr[i] == 'L'){
//        if(start[1] < 0 ){  ///out of bounds
//          if(mat[start[0]][mat.length-1] == 'X'){
//            return start;
//          }
//          else{
//           start[1] = mat.length-1; 
//          }
         
//        }
//       else{
//         start[1] = start[1]-1; 
//         if(mat[start[0]][start[1]] == 'X'){
//          start[1] = start[1]+1;
//           return start;
//         }
//       }  
//     }
    
    
    if(charArr[i] == 'L'){
      nextPositon[1] = currentPosition[1]-1 < 0
        ? mat.length-1
        : start[1]-1;
    }
    else if(charArr[i] == 'R'){
      nextPositon[1] = start[1]+1 >= mat.length
        ? 0
        : currentPosition[1]+1;
    }
    
    else if(charArr[i] == 'D'){
      nextPositon[0] = currentPosition[0]+1 >= mat.length
        ? 0
        : currentPosition[0]+1;
    }
    
     else if(charArr[i] == 'U'){
      nextPositon[0] = start[0]-1 < 0
        ? mat.length-1
        : currentPosition[0]-1;
    }
    

    // obstacle check
    if (mat[nextPositon[0]][nextPositon[1]] == 'X') {
      return currentPosition;
    } else {
      currentPosition[0] = nextPositon[0];
      currentPosition[1] = nextPositon[1];
    }
  }
    
    return currentPosition;
    
  }
  
  
  
    
    
  
  public static void main(String[] args) {
    
//     5x5 Grid
// - Starting coordinate (0, 1)
// - Steps: [L, D, D, R]
    
    char[] ch = {'R' , 'R' , 'D' };
    int[] start = {0 ,1};
    
//     5x5 Grid
// - Starting coordinate (0, 1)
// - Obstacle at (0, 2)
// - Steps: [R, R, D]
    
    char[][] mat = new char[5][5];
    mat[0][2] = 'X';
   int[] cuur = getDestination(ch , 5 , mat , start);
    System.out.println("destination row:"+cuur[0]);
    System.out.println("destination col:"+cuur[1]);
    
  }
}
