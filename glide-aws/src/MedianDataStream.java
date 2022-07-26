import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
 

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
 */
public class MedianDataStream {

	

    /** initialize your data structure here. */
    List<Integer> store;
    public MedianDataStream() {
        store = new ArrayList<Integer>();
    }
    
    public void addNum(int num) {
        store.add(num);
    }
    
    public double findMedian() {
        Collections.sort(store);
        int n = store.size();
        
        if((n % 2) == 1){  //if length is odd getting middle element as median
            return store.get(n/2);
        }
        
        else{  //if length is even get the middle 2 numbers divided by 2
            return (store.get(n/2-1) + store.get(n/2))*0.5;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
