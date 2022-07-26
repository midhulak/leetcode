package Google;

import java.util.*;

public class Mountains {
 public static int visibleMountains(List<List<Integer>>mountains) {
	 List<List<Integer>>reverse = new ArrayList<>();
	 List<Integer>sub = new ArrayList<>();
//rotate coordinates by 45
	 for(List<Integer> mountain : mountains) {
		 sub.add(mountain.get(0) - mountain.get(1), mountain.get(0) + mountain.get(1));
		 System.out.println(sub);
		 reverse.add(sub);
	 }
	 //sort by x
	 // current y is higher thatn max y 
	 //increment result
	 //and update max y to current y
	 for(int i = 0; i < reverse.size(); i++) {
		 int[] l = list.get(i);
		 if()
			 
	 }
	 return 0;
 }
 public static void main(String[]args) {
	 List<List<Integer>>list = new ArrayList<>();
	 List<Integer>sub = new ArrayList<>();
	 sub.add(4, 6);
	 sub.add(7, 2);
	 sub.add(2, 5);
	 list.add(sub);
	 visibleMountains(list);
	 for(int i = 0; i < list.size(); i++) {
		 System.out.println(list);
	 }
 }
}
