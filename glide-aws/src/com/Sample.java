package com;

import java.util.PriorityQueue;

public class Sample {
	
	public class Process {
		private int start,end;
		private long cpuUsage;
		private long memUsage;
		private long processId;

		private long formula; //need to ask intevriwer for which parameter you need to sort
		//based on what you want to sort. ask interviewer for formula based on that you just sort using
		//priority queu
		
		PriorityQueue<Process> queue=new PriorityQueue<Process>(3, new Comparator<Process>() {
		    public int compare(Process p1, Process p2) {
		        if (p1.formula < p2.formula) return -1;
		        if (p1.formula > p2.formula) return 1;
		        return 0;
		    }		});

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
