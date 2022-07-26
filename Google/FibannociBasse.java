package Google;

import java.util.ArrayList;
import java.util.List;

public class FibannociBasse {
	public static void main(String[] args) {
		int num = 10;
		System.out.println(getNumInFiboBase(num));
		num = 17;
		System.out.println(getNumInFiboBase(num));
	}

	private static List<Integer> getNumInFiboBase(int num) {
		List<Integer> res = new ArrayList<>();
		int[] arr = getFiboArray(num);
		dfs(num, arr, res, new ArrayList<>(), arr.length - 1);
		return res;
	}

	private static void dfs(int num, int[] arr, List<Integer> res, List<Integer> tmp, int cur) {
		if(num < 0)
			return;
		if(num == 0) {
			int[] tmpArr = new int[arr.length];
			for(int i=0;i<arr.length;i++) {
				if(tmp.contains(arr[i]))
					tmpArr[arr.length - 1 - i] = 1;
				else
					tmpArr[arr.length - 1 - i] = 0;
			}
			int tmpRes = 0;
			for(int i=0;i<tmpArr.length;i++) {
				tmpRes = tmpRes * 10 + tmpArr[i];
			}
			res.add(tmpRes);
		}else {
			for(int i=cur;i>=0;i--) {
				tmp.add(arr[i]);
				dfs(num - arr[i], arr, res, tmp, i-1);
				tmp.remove(tmp.size() - 1);
			}
		}
	}

	static int[] getFiboArray(int num) {
		List<Integer> lst = new ArrayList<>();
		lst.add(1);
		lst.add(1);
		while(lst.get(lst.size() - 1) < num) {
			lst.add(lst.get(lst.size() - 2) + lst.get(lst.size() - 1));
		}
		int[] arr = new int[lst.size()-2];
		for(int i=0;i<arr.length;i++) {
			arr[i] = lst.get(i+1);
		}
		return arr;
	}
}
