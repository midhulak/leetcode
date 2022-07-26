package Google;

import java.util.*;

public class NegateCancel {
	public static String cal(String[]arr) {
		HashSet<String> negateSet = new HashSet<>();
		HashSet<String> cancelSet = new HashSet<>();
		for(int i = arr.length - 1; i >= 0; i--) {
			if(cancelSet.contains(arr[i])) {
				continue;
			}
			String statement = arr[i];
			String key = arr[i];
			if(statement == "cancel") {
				cancelSet.add(key);
			} else if(statement == "negate") {
				negateSet.add(key);
			} else {
				if(!negateSet.contains(key)) {
					return key;
				}
			}
		}
		return -1;
	}
	
}
