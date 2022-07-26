package com.snc.gotanoffer.treesgraphs;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * 
 * Time Complexity: \mathcal{O}(|E| \log{\frac{|E|}{|V|}})O(∣E∣log 
∣V∣
∣E∣
​	
 ) where |E|∣E∣ is the number of edges (flights) in the input.

As one can see from the above algorithm, during the DFS process, we would traverse each edge once. Therefore, the complexity of the DFS function would be |E|∣E∣.

However, before the DFS, we need to sort the outgoing edges for each vertex. And this, unfortunately, dominates the overall complexity.

It is though tricky to estimate the complexity of sorting, which depends on the structure of the input graph.

In the worst case where the graph is not balanced, i.e. the connections are concentered in a single airport. Imagine the graph is of star shape, in this case, the JFK airport would assume half of the flights (since we still need the return flight). As a result, the sorting operation on this airport would be exceptionally expensive, i.e. N \log{N}NlogN, where N = \frac{|E|}{2}N= 
2
∣E∣
​	
 . And this would be the final complexity as well, since it dominates the rest of the calculation.

Let us consider a less bad case, or an average case, where the graph is less clustered, i.e. each node has the equal number of outgoing flights. Under this assumption, each airport would have \frac{|E|}{(2\cdot|V|)} 
(2⋅∣V∣)
∣E∣
​	
  number of flights (still we need the return flights). Again, we can plug it into the N \log NNlogN minimal sorting complexity. In addition, this time, we need to take into consideration all airports, rather than the superhub (JFK) in the above case. As a result, we have |V| \cdot (N \log N)∣V∣⋅(NlogN), where N = \frac{|E|}{2\cdot|V|}N= 
2⋅∣V∣
∣E∣
​	
 . If we expand the formula, we will obtain the complexity of the average case as \mathcal{O}(\frac{|E|}{2} \log{\frac{|E|}{2\cdot|V|}}) = \mathcal{O}(|E| \log{\frac{|E|}{|V|}})O( 
2
∣E∣
​	
 log 
2⋅∣V∣
∣E∣
​	
 )=O(∣E∣log 
∣V∣
∣E∣
​	
 )

Space Complexity: \mathcal{O}(|V| + |E|)O(∣V∣+∣E∣) where |V|∣V∣ is the number of airports and |E|∣E∣ is the number of flights.

In the algorithm, we use the graph, which would require the space of |V| + |E|∣V∣+∣E∣.

Since we applied recursion in the algorithm, which would incur additional memory consumption in the function call stack. The maximum depth of the recursion would be exactly the number of flights in the input, i.e. |E|∣E∣.

As a result, the total space complexity of the algorithm would be \mathcal{O}(|V| + 2\cdot|E|) = \mathcal{O}(|V| + |E|)O(∣V∣+2⋅∣E∣)=O(∣V∣+∣E∣).
 */

//constrct map like this
//[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]

//JFK -> SFO,ATL,
//SFO->ATL
//ATL->JFK,SFO
//go to every path and poll it and go that and al=dd keys//
public class ReConstructItenary {
	
	 public List<String> findItinerary(List<List<String>> tickets) {
	        HashMap<String, PriorityQueue<String>> hm = new HashMap<>();
	        for(int i =0; i <tickets.size(); i++){
	            String key   = tickets.get(i).get(0);
	            String value = tickets.get(i).get(1);
	            if(!hm.containsKey(key)){
	                PriorityQueue<String> temp = new PriorityQueue<>();
	                hm.put(key, temp);
	            }
	            hm.get(key).add(value);
	        }
	        
	        LinkedList<String> res = new LinkedList<>();
	        dfs("JFK", hm, res);
	        return res;
	    }

	    public void dfs(String dep, Map<String, PriorityQueue<String>> hm, LinkedList<String> res) {
	        PriorityQueue<String> arrivals = hm.get(dep);
	        while (arrivals != null && !arrivals.isEmpty()) {
	            dfs(arrivals.poll(), hm, res);
	        }

	        res.addFirst(dep);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
