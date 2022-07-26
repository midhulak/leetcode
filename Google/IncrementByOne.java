package Google;

public class IncrementByOne {
  static int[]digits;
  public IncrementByOne(int nums) {
	  digits = new int[nums];
  }
  public static boolean increment() {
	  int pos = digits.length - 1;
	  while(pos >= 0 && digits[pos] == 9) {
		  digits[pos--] = 0;
	  }
	  if(pos < 0) {
		  return false;
	  }
	  digits[pos]++;
	  return true;
  }
  public String toString() {
	  StringBuilder sb = new StringBuilder();
	  for(int i = 0; i < digits.length; i++) {
		  sb.append(digits[i]);
	  }
	  return sb.toString();
  }
  public static void main(String[]args) {
	  IncrementByOne num = new IncrementByOne(10);
	  do {
		  System.out.println(num);
	  } while(increment());
  }
}
