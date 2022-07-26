package Google;

import java.util.Arrays;

/*Simple explanation:

Suppose your numbers are 50,100,200,300,400. And MaxValue is 1000. Your goal is to reach 1000 or as close to it.
In simplest way, how can this be done ? If all 5 numbers are equal to 200 (the average i.e. 1000/5), then we can reach 200*5 = 1000, right ?
Let's say we pick the cutoff X as 200. Now all numbers >= 200 (200, 300 & 400) will contribute value 200 even after cutoff. So we will get up to 600 using those 3 numbers. But numbers < 200 (50, 100), will only contribute 150. So our sum will only reach 150 + 600 = 750. 
This means our initial cutoff selection X = 200 was low, and it has to be increased.

If the first 2 numbers (50 & 100) were somehow able to contribute 250 more, we can reach our target of 1000.
So we have a deficit of 250 from the first 2 numbers. Obviously, the numbers themselves cannot be increased, 
so we have to 'borrow' this extra value from the numbers greater than the cutoff. How much should we borrow ? 250. 
How many numbers are greater than 200 ? 2. so we need to borrow 125 from each of them. How do we do that ?
 we simply increase X by 125.
Now we're back to original problem with reduced set [300,400], X = 325. All numbers >= 325 will contribute 325 after cutoff. But 300 has a deficit of 25, which we need to borrow from 400, by increasing X again by 25. Thus X = 350

So, we choose X as initial cutoff to be average of maxvalue/length (assuming each number contributes the avg value). 
But the numbers that are less than average have combined a deficit of D.
This D is then borrowed from all numbers greater than X, if they can give X. 
 If not we continue down the line by increasing X*/
public class SalaryAdjustment {
	/*
	 * Algorith :
	 * 
	 * sort array keep an iterator to keep track of number of max values see if sum
	 * >= target without max element if less, find difference if diff > max element,
	 * assign (diff/#max values) to x values if diff < max element, find next
	 * largest element and repeat, iterating #max values
	 */

	/*public static void main(String[] args) {
		int[] salaries = new int[] {100, 300, 200, 400};
		int target = 1200;
		int[] a = {100, 300, 200, 400};
        int budget = 800;
		int[] newSal = solution(salaries, target);
		int[] newa = solution(salaries, target);
		for (int i = 0; i < newSal.length; i++) {
			System.out.println(newSal[i]);
		}
		for (int i = 0; i < newa.length; i++) {
			System.out.println("new a:" + newa[i]);
		}
	}

	public static int[] solution(int[] salaries, int target) {
		int maxValues = 0;
		Arrays.sort(salaries);

		int sum = 0;
		for (int val : salaries) {
			sum += val;
		}
		if (sum <= target) {
			return salaries;
		}
		// if salaries need to be reduced
		int newSum = sum - salaries[salaries.length - 1];
		int difference = target - newSum;
		int iterator = 1;

		while (salaries[salaries.length - 1 - iterator] > difference / iterator) {
			newSum -= salaries[salaries.length - 1 - iterator];
			difference = target - newSum;
			iterator++;
		}

		int newSal = difference / iterator;

		for (int i = 0; i < iterator; i++) {
			salaries[salaries.length - 1 - i] = newSal;
		}

		return salaries;
	}*/
	public static void main(String a[])
    {
        int[] salaries=new int[]{100, 300, 200, 400};
        int budget=800;
        int low=0;
        int high=Integer.MAX_VALUE;
        int mid=0;
        while(low < high) {

            mid=(low+high)/2;
            if(!isPossible(salaries,mid,budget))
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }

        System.out.println(low);
    }

    static boolean isPossible(int[] salaries, int salary, int budget)
    {
        int totalSalary=0;

        for(int i=0;i<salaries.length;i++)
        {
            if(salary < salaries[i])
            {
                totalSalary = totalSalary+salary;
            }
            else
                totalSalary = totalSalary+salaries[i];

            if(totalSalary > budget)
                return false;
        }
        return totalSalary <= budget;
    }
}
