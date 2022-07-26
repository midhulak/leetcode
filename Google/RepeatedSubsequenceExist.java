package Google;

import java.util.Map;

//https://programmersought.com/article/6208830603/

/*we can use divide and conquer to solve the problem.

 The first problem to be solved is how to quickly find whether a certain number is the only number in the sequence. 
 Record the coordinates of the nearest same number to the left and right of each number separately,
 can determine whether an element is unique in any continuous subsequence with O(1).
 Just simply search from the left and the right, the worst case is located on the far right and left, 
 so the worst complexity is O(N^2). But we search from both sides at the same time, 
 the worst case is located In the middle, such complexity is O(nlgn)
 for this question, we have to find the position of the sub-problem, rather than simply dividing it.*/
public class RepeatedSubsequenceExist {
	static int maxn= 10;
    static int a[] = new int[maxn];
    static int l[] = new int[maxn];
    static int r[] = new int[maxn];
    
    static Map<Integer,Integer> map;
    int n;
    
    static boolean judge(int left,int right) {
        if(left >= right) {
            return true;
        }
        int mid = (right - left) / 2;
        for(int i = 0; i <= mid; i++) {
            if(l[left + i] < left && r[left + i] > right) {
                return judge(left,left + i - 1) && judge(left + i + 1, right);
            }
            if(l[right - i] < left && r[right - i] > right) {
                return judge(left, right - i - 1) && judge(right - i + 1, right);
            }
        }
        return false;
    }
    public static void pre(int[]arr) {
    	 map.clear();
         for(int i = 0; i < arr.length; i++) {
         	if(map.containsKey(a[i])) {
                 l[i] = map.get(a[i]);
         	} else {
                 l[i] = -1;
         	}
         	map.put(a[i], i);
         }
         // Record the position of the first identical element to the right of the i-th element
         map.clear();
         for(int i = arr.length - 1; i >= 0; i--) {
         	if(map.containsKey(a[i])) {
                 r[i]=map.get(a[i]);
         	} else {
                 r[i] = arr.length - 1;
         	}    
         	map.put(a[i], i);
         }
    }
    
   public static void main(String [] args) {
       int[]arr = {1,2,1};
       int i = 0;
       pre(arr);
            if(judge(0, arr.length - 1)) {
            	System.out.println("non-boring");
            } else {
            	System.out.println("boring");
            }
         
    }
}




//https://nbviewer.jupyter.org/github/grezesf/Research/blob/master/Fun/Find_AZ.ipynb


