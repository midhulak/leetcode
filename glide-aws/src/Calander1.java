import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Calander1 {
	
	List<int[]> calendar;
    public Calander1() {
        calendar = new ArrayList();
    }
    
    public boolean book(int start, int end) {
        for (int[] iv: calendar) {
            if ( iv[0] < end && start < iv[1]) return false;
        }
        calendar.add(new int[]{start, end});
        return true;
    }
	
//	 TreeMap<Integer , Integer> booked;
//	    
//	    public Calander1() {
//	        booked = new TreeMap<>();
//	    }
//	    
//	    public boolean book(int start, int end) {
//	        Integer prev = booked.floorKey(start);
//	        Integer next = booked.ceilingKey(start);
//	      
//	        System.out.println("start is="+start);
//	        System.out.println("end is="+end);
//	        System.out.println("prev is="+prev);
//	        System.out.println("next is="+next);
//	        
//	        
//	        
//	        if( (prev == null || booked.get(prev) <= start)  &&
//	           (next == null || next >= end)){
//	            booked.put(start, end);
//	            return true;
//	        }
//	        
//	        return false;
//	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
