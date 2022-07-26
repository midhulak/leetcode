package com.snc.sorting.searching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BusRoutes {
	
public int numBusesToDestination(int[][] routes, int source, int target) {
        
        //cretAZe adjencency map from each busstop how many busses are going
        
        Map<Integer , List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<routes.length; i++){
            for(int j=0; j<routes[i].length;j++){
                
                List<Integer> list = map.getOrDefault(routes[i][j] , new ArrayList<Integer>());
                list.add(i);
                map.put(routes[i][j] , list);
                
                
            }
             
        }
        
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visbusStop = new HashSet<>();
        HashSet<Integer> visbus = new HashSet<>();
        
   
        
        int level=0;
        
        q.add(source);
        visbusStop.add(source);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int i=0; i<size; i++){
            	 //remove each busstop from queue
                int busStop = q.poll();
               
                //if the removed value busstop is in taht bus then with in level you are able to reach.
                if(busStop == target)
                    return level;
                
                //get how many buses are going from that busstop
                    List<Integer> busLists = map.get(busStop);
                    
                    //each bus what are routes are there if not visited add it to the queue
                    for(int b =0; b<busLists.size(); b++){
                        if(visbus.contains(busLists.get(b)))
                            continue;
                    
                    int[] busRoutes = routes[busLists.get(b)];
                   
                    
                    for(int k=0; k<busRoutes.length; k++){
                        
                        if(!visbusStop.contains(busRoutes[k])){
                            q.add(busRoutes[k]);
                            visbusStop.add(busRoutes[k]);
                            
                        }
                        
                    }
                        
                    visbus.add(busLists.get(b));
                }
                
            
            
        }
            level++;
        
        
    }
        return -1;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BusRoutes br = new BusRoutes();
		
		int[][] routes = { {1,2,7}  , {3,6,7}};
		System.out.println("returnned value is"+br.numBusesToDestination(routes, 1, 6));

	}

}
