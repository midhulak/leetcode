import java.util.TreeMap;

public class Calander3 {
	
	 TreeMap<Integer , Integer> booked;
	    public Calander3() {
	        booked = new TreeMap<>();
	    }
	    
	    public int book(int start, int end) {
	         System.out.println("start is="+start);
	         System.out.println("end is="+end);
	        booked.put(start, booked.getOrDefault(start,0)+1);
	        booked.put(end , booked.getOrDefault(end,0)-1);
	        System.out.println("value in map for "+ start+"="+booked.get(start));
	        System.out.println("value in map for "+end+"="+booked.get(end));
	        
	        int max=0;
	        int activeEvents=0;
	        for(int freq : booked.values()){
	             activeEvents+=freq;
	           max= Math.max(max , activeEvents);
	            // if(activeEvents >= 3){
	            //     booked.put(start , booked.get(start)-1);
	            //     booked.put(end , booked.get(end)+1);
	            //     return false;
	            // }
	       }
	        return max;
	    }
	    
	    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
