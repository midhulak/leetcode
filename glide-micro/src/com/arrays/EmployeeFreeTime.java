package com.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeFreeTime {
	
	class Interval {
	    public int start;
	    public int end;

	    public Interval() {}

	    public Interval(int _start, int _end) {
	        start = _start;
	        end = _end;
	    }
	
	 public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
	        
	        List<Interval> freeTimes = new ArrayList<>();
	        
	        List<Interval> combineIntervals = new ArrayList<>();
	        
	        
	        for(List<Interval> list : schedule){
	            
	            for(Interval interval : list){
	                combineIntervals.add(interval);
	            }
	        }
	   
	        
	        Collections.sort(combineIntervals , new Comparator<Interval>(){
	           
	            public int compare(Interval i1 , Interval i2){
	                return i1.start - i2.start;
	            }
	        });
        
	        List<Interval> busyTimes = mergeIntervals(combineIntervals);
	        
	        
	        for(int i=1; i<busyTimes.size(); i++){
	            
	            Interval inter = new Interval();
	            
	            inter.start = busyTimes.get(i-1).end;
	            inter.end = busyTimes.get(i).start;
	            freeTimes.add(inter);
	        }
	        
	        return freeTimes;
	    }
	    
	    public List<Interval> mergeIntervals(List<Interval> combineInterval){
	        
	        List<Interval> result = new ArrayList<>();
	        
	        Interval newInter = combineInterval.get(0);
	        result.add(newInter);
	        
	        for(Interval inter : combineInterval){
	            
	            if(inter.start <= newInter.end){
	                newInter.end = Math.max(inter.end , newInter.end);
	            }
	            else{
	              newInter = inter;
	                result.add(inter);
	            }
	        }
	        return result;
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
