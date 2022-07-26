package com.snc.arrays;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
/**
 * A group fo friends are playing video game together 
 * Duritng the game, each player earns a number of points
 * 
 * Notwe: players with equal scores will have equal ranks but teh player
 *  with the next lower score wil be ranked based on the position within the 
 *  list of all players scores. For example, if there are four players, 
 *  and three players tie for first place, their 
 *  ranks are 1,1,1, and 4
 *  Note: No player with a score of 0 can level up, regardless of rank.
 *  Example
 *  n=4
 *  k=3
 *  scores = [100,50,50,25]
 * @author midhula.kadiyala
 *
 */

public class CompetitiveGame {
	
	public static int levelUp(int k, List<Integer> score) {
        if(k <= 0) return 0;
        Collections.sort(score, Collections.reverseOrder());
        int rank = 1;
        int res = 0;
        for(int i = 0; i < ((CharSequence) score).length(); i++) {
            if(i == 0) {
                rank = 1;
            } else if(score.get(i) != score.get(i - 1)) {
                rank = i + 1;
            }
            if(rank <= k && score.get(i) > 0) res++;
            else break;
        }
        return res;
    }
	
	
	public static int solution2(int k, List<Integer> scores) {
	    PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
	    for (int i : scores) heap.offer(i);
	    int prev = heap.peek();
	    int rank = 0;
	    int res = 0;

	    while (rank <= k && !heap.isEmpty()) {

	        if (heap.peek() == 0) break;

	        if (rank == 0) {
	            rank = 1;
	        } else if (heap.peek() != prev) {
	            rank = res + 1;
	        }

	        if (rank <= k) {
	            prev = heap.poll();
	            res++;
	        } else break;
	    }

	    return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
