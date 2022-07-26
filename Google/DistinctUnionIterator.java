package Google;

import java.util.*;

public class DistinctUnionIterator implements Iterator<Integer> {

	    private Set<Integer> set = new HashSet<>();
	    private int returnValue;
	    private boolean hasReturnValue;

	    private Iterator<Integer> sourceA;
	    private Iterator<Integer> sourceB;
	    
	    public DistinctUnionIterator(
	            Iterator<Integer> sourceA,
	            Iterator<Integer> sourceB
	    ) {
	        this.sourceA = sourceA;
	        this.sourceB = sourceB;
	    }

	    protected boolean setReturnValue(Iterator<Integer> source) {
	        
	        hasReturnValue = false;
	        while (source.hasNext()){
	            int tmp = source.next();
	            if ( ! set.contains(tmp)) {
	                set.add(tmp);
	                hasReturnValue = true;
	                returnValue = tmp;
	                return hasReturnValue;
	            } 
	        }
	        
	        return hasReturnValue;
	    }
	    
	    
	    
	    @Override
	    public boolean hasNext() {            
	        if ( ! hasReturnValue) {
	            if ( ! setReturnValue(sourceA)) {
	                setReturnValue(sourceB);
	            }
	        } 
	            
	        return hasReturnValue;
	    }
	    
	    @Override
	    public Integer next() {
	        
	        int ret = 0;
	        
	        if (hasReturnValue) {
	            hasReturnValue = false;
	            ret = returnValue;
	        } else {
	            if ( ! setReturnValue(sourceA)) {
	                setReturnValue(sourceB);
	            }

	            if (hasReturnValue) {
	                hasReturnValue = false;
	                ret = returnValue;
	            }
	        }
	        
	        return ret;
	    }

	    public static void main(String[] args) {
	       //test
	        List<Integer> listA = new ArrayList<Integer>();
	        listA.add(2);
	        listA.add(5);
	        listA.add(2);
	        listA.add(2);
	        listA.add(6);
	        listA.add(1);        
	        Iterator sourceA = listA.iterator();

	        //test
	        List<Integer> listB = new ArrayList<Integer>();
	        listB.add(3);
	        listB.add(3);
	        listB.add(1);
	        listB.add(7);
	        listB.add(2);
	        Iterator sourceB = listB.iterator();
	        
	        DistinctUnionIterator dui = new DistinctUnionIterator(sourceA, sourceB);
	        
	        while (dui.hasNext()) {
	             System.out.println(dui.next());
	        }
	        
	    }
	}

