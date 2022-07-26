package Google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/*
 Adding my understanding here.
The logic here is to first store the data in a map with the keys sorted (so using Treemap) and for each key, store the list of elements it is associated with.
for an element associated with a key, the key could be starting of the range or end of the range. So, using a Node class to store the value of character whether it is associated with key for start of range or end of range.

After populating the tree map, we would have a sorted keys as the range numbers and for them each a list of characters either ending at that number or starting at that number.

using this data, iterate over the tree map in order and each time keeping track of the previous key, store the elements in a set in each key into a set if node element is a start of range else remove the element from set if it is end of range.

Print in each key iteration from 2nd key just before altering the values of the set. with previous key, current key and the values in set.
Time : O(nlogn)
Space : O(n)
 */
public class MergeIntervalsWithLabels {
	
	    public static void main(String[] args) {
		int[][] nums1 = {{0, 3}, {2, 4}, {5,6}};
		char[] chars1 = {'A', 'B', 'C'};
		int[][] nums2 = {{0, 3}, {0, 3}, {2, 4}, {5, 6}};
		char[] chars2 = {'A', 'B', 'C', 'D'};
		for(String s : solve(nums1, chars1))
			System.out.println(s);
		System.out.println("---------------");
		for(String s : solve(nums2, chars2))
			System.out.println(s);
	}

	private static List<String> solve(int[][] nums, char[] chars) {
		List<String> res = new ArrayList<>();
		TreeMap<Integer, List<Node>> tm = new TreeMap<>();
		for(int i=0;i<nums.length;i++) {
			Node n1 = new Node(chars[i], true);
			Node n2 = new Node(chars[i], false);
			tm.putIfAbsent(nums[i][0], new ArrayList<>());
			tm.putIfAbsent(nums[i][1], new ArrayList<>());
			List<Node> lst1 = tm.get(nums[i][0]);
			List<Node> lst2 = tm.get(nums[i][1]);
			lst1.add(n1); lst2.add(n2);
		}
		Set<Character> tmp = new HashSet<>();
		int prev = 0;
		int cnt = 0;
		for(Map.Entry<Integer, List<Node>> e : tm.entrySet()) {
			// if(cnt++ == 0) {
			// 	for(Node n : e.getValue()) {
			// 		tmp.add(n.c);
			// 	}
			// 	prev = e.getKey(); 
			// 	continue;
			// }
			if(tmp.size() > 0)
				res.add("(" + prev + ", " + e.getKey() + "): " + tmp);
			for(Node n : e.getValue()) {
				if(!n.isAdd) {
					tmp.remove(n.c);
				}else {
					tmp.add(n.c);
				}
			}
			prev = e.getKey();
		}
		return res;
	}


	 static class Node{
		
		char c;
		boolean isAdd;
		
		public Node(char c, boolean isAdd) {
			super();
			this.c = c;
			this.isAdd = isAdd;
		}

	}
	
}
