package Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomGeneratorClass {
	public static void main(String[] args) {
		RandomGenerator rg = new RandomGenerator(2);
		System.out.println(rg.generate()); 
		System.out.println(rg.generate()); 
		System.out.println(rg.generate()); 
		System.out.println(rg.generate()); 
	}
//O(1) time in O(n) space is easy. Just generate a random number between start and n (start is initialized with 0) 
	//and swap the number with the start index and update the start index by 1.


/*	static class RandomGenerator {

		int[] arr;
		Random rand;
		int cur = 0;
		//Time and space - O(n)
		public RandomGenerator(int n) {
			arr = new int[n];
			rand = new Random();
			for(int i=0;i<arr.length;i++) {
				arr[i] = i;
				int next = rand.nextInt(i+1);
				if(next != i) {
					int tmp = arr[i];
					arr[i] = arr[next];
					arr[next] = tmp;
				}
			}
		}
		//Time and space - O(1) 
		public int generate() {
			if(cur < arr.length)
				return arr[cur++];
			return -1;
		}
	}
	

}*/
//folow up - O(1) time + O(k) space:


static class RandomGenerator {

	private int n;
	private Random random;
	private Map<Integer, Integer> map = new HashMap<>();

	public RandomGenerator(int n) {
    	this.n = n;
    	this.random = new Random();
	}

	public int generate() {
    	if(n == 0){
        	return -1;
    	}
    	int id = random.nextInt(n);
    	int res = map.getOrDefault(id, id);
    	map.put(id, map.getOrDefault(n, n));
    	// i think we should put n = n-1 here. then only we can save n value corresponding id. 
   		n=n-1;
    	return res;
	}
}
}



