import java.util.ArrayDeque;
import java.util.Queue;

public class BasicCalculatorII {
	
	public int calculate(String s) {
        Queue<Character> q = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                q.offer(c);
            }
        }

        q.offer(' ');
        return helper(q);
    }
//3+2*2
    private int helper(Queue<Character> q) {
        int num = 0;
        int prev = 0, sum = 0;
        char prevOp = '+';

        while (!q.isEmpty()) {
            char c = q.poll();

            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '(') {
                num = helper(q);
            } else {
                switch (prevOp) {
                case '+':
                    sum += prev;
                    prev = num;
                    break;
                case '-':
                    sum += prev;
                    prev = -num;
                    break;
                case '*':
                    prev *= num;
                    break;
                case '/':
                    prev /= num;
                    break;
                }

                if (c == ')') break;

                num = 0;
                prevOp = c;
            }
        }

        return sum + prev;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BasicCalculatorII basic = new BasicCalculatorII();
		System.out.println(basic.calculate("3+2*2"));
		
	}

}
