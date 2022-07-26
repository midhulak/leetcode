package Google;

public class Count1sInAString {
	public static int countOnes(String s) {
		int count = 0;
		int result = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '1') {
				count++;
				result += count;
			} else {
				count = 0;
			}
		}
		return result;
	}
	public static void main(String[]args) {
		String s = "001111110";
		System.out.println(countOnes(s));
	}
}
