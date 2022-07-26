package Google;

import java.util.LinkedList;
import java.util.Queue;

public class Bags {
	public static int[]luggageOrdering(int[]arr) {
		int currentWeight = 0;
		Queue<Integer> airCarftStorage = new LinkedList<>();
		Queue<Integer> result1 = new LinkedList<>();
		int[]result = new int[arr.length];
		int index = 0;
		for(int i = 0; i < arr.length; i++) {
			currentWeight += arr[i];
			if(currentWeight > 40) {
				airCarftStorage.add(arr[i]);
				System.out.println("air" + airCarftStorage);
				currentWeight = 0;
			} else {
				result1.add(arr[i]);
				System.out.println(result1);
			}
		}
		
		while(!airCarftStorage.isEmpty()) {
			result[index] = airCarftStorage.poll();
			index++;
		}
		while(!result1.isEmpty()) {
			result[index] = result1.poll();
			index++;
		}
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		return result;
	}
	public static void main(String[]args) {
		int[]arr = {30, 5, 6};
		luggageOrdering(arr);
		
	}
}
