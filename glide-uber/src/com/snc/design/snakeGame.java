package com.snc.design;

import java.util.Deque;
import java.util.Queue;
import java.util.Set;
import javafx.util;




class SnakeGame {
    private int height;
    private int  width;
   
    private Set<Pair<Integer, Integer>> snakeOccupiedBoxes ;
    private Deque<Pair<Integer,Integer>> snakeBodyQueue;
    
    private Queue<Pair<Integer,Integer>> foodQueue;
    
   
    private int eatFood;
    
   
 

    public SnakeGame(int width, int height, int[][] food) {
       
        
        this.width = width;
        this.height = height;
        snakeOccupiedBoxes = new HashSet<>();
        snakeBodyQueue = new LinkedList<>();
        foodQueue = new LinkedList<>();
        snakeOccupiedBoxes.add(new Pair<Integer,Integer>(0,0)); 
        snakeBodyQueue.add(new Pair<Integer,Integer>(0 ,0));
        eatFood=0;
        
        for(int[] foo : food){
            foodQueue.add(new Pair<>(foo[0] , foo[1]));
        }
     
      
        
    }
    
    private Pair<Integer,Integer> move(Pair<Integer,Integer> snakeHead , String direction){
        
        if(direction.equals("U")){
            return new Pair<>(snakeHead.getKey()-1, snakeHead.getValue());
        }
        else if(direction.equals("D")){
            return new Pair<>(snakeHead.getKey()+1, snakeHead.getValue());
        }
            
        else if(direction.equals("L")){
             return new Pair<>(snakeHead.getKey(), snakeHead.getValue()-1);
        }
     else
         return new Pair<>(snakeHead.getKey(), snakeHead.getValue()+1);
            
            
    }
    
    public int move(String direction) {
         
        Pair<Integer,Integer> currSnakeHead = snakeBodyQueue.peekLast();
        
         Pair<Integer,Integer> nextSankeHead = move(currSnakeHead , direction);
           
        if(gameOver(nextSankeHead))
            return -1;
     
        if(!foodQueue.isEmpty() && !snakeOccupiedBoxes.contains(foodQueue.peek()) && nextSankeHead.equals(foodQueue.peek())){
            foodQueue.poll();
             snakeOccupiedBoxes.remove(snakeBodyQueue.pollFirst());
             snakeBodyQueue.addLast(nextSankeHead);
             eatFood++;
           return eatFood;
            
        }
        
        snakeOccupiedBoxes.remove(snakeBodyQueue.pollFirst());
         snakeBodyQueue.addLast(nextSankeHead);
        snakeOccupiedBoxes.add(nextSankeHead);
        
        return eatFood;
        
        
    }
    
    public boolean gameOver(Pair<Integer , Integer> nextPos){
        
        int row = nextPos.getKey();
        int col = nextPos.getValue();
        //out of bounds touch the wall
         if(row < 0 || col < 0 || row >= height || col >= width)
                return true;
        //if snake head collides with his body  and snake head is colliding to the snake tile
        if(snakeOccupiedBoxes.contains(nextPos) && snakeBodyQueue.peekFirst().equals(nextPos))
            return true;
        
        return false;
        
    }
}
