package Google;

import java.util.*;

//all numbers are distinct numbers
//all numbers are postive only
//what is size of the array
//
/*An intuitive thought on this problem is to create an auxiliary stack. 
 * We push the numbers in the first sequence one by one, 
 * and try to pop them out according to the order in the second sequence.
*/
public class ValidateStack {
	public static boolean validateStack(int[]popped, int n) {
		Stack<Integer> stack = new Stack<>();
		int j = 0;
		for(int i = 0; i <= n; i++) {
			stack.push(i);
			while(!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]) {
				stack.pop();
				j++;
			}
		}
		return stack.empty();
	}
	public static void main(String[]args) {
		System.out.println( validateStack( new int[] { 0, 3, 2, 1 }, 3 ) );
		System.out.println( validateStack( new int[] { 0, 3, 1, 2 }, 3 ) );
		System.out.println( validateStack( new int[] { 0, 2, 1, 3 }, 3 ) );
		System.out.println( validateStack( new int[] { 0, 1, 2, 3 }, 3 ) );
		System.out.println( validateStack( new int[] { 3, 2, 1, 0 }, 3 ) );
		System.out.println( validateStack( new int[] { 1, 0, 3, 2 }, 3 ) );
		System.out.println( validateStack( new int[] { 3, 1, 0, 2 }, 3 ) );
		System.out.println( validateStack( new int[] { 3, 2, 0, 1 }, 3 ) );
		System.out.println( validateStack( new int[] { 1, 2, 3, 4 }, 3 ) );
		System.out.println( validateStack( new int[] { -1, 0, 1, 2 }, 2 ) );
	}
}
