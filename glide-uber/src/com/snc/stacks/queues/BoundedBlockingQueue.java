package com.snc.stacks.queues;

import java.util.LinkedList;

//https://leetcode.com/problems/design-bounded-blocking-queue/
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue {
	
	int capacity;
    Lock queueLock;
    Condition fullCondition;
    Condition emptyCondition;
    Queue<Integer> blockingQueue;
    
    public BoundedBlockingQueue(int capacity) {
        queueLock = new ReentrantLock();
        fullCondition = queueLock.newCondition();
        emptyCondition = queueLock.newCondition();
        this.capacity = capacity;
        blockingQueue = new LinkedList<>();
    }
    
    public void enqueue(int element) throws InterruptedException {
        queueLock.lock();
        try {
            while(blockingQueue.size() == capacity) {
                fullCondition.await();
            }
            blockingQueue.offer(element);
            emptyCondition.signal();
        } finally {
            queueLock.unlock();
        }
    }
    
    public int dequeue() throws InterruptedException {
        queueLock.lock();
        try{
            while(blockingQueue.size() == 0) {
                emptyCondition.await();
            }
            int value = blockingQueue.poll();
            fullCondition.signal();
            return value;
        } finally {
            queueLock.unlock();
        }
    }
    
    public int size() {
        return blockingQueue.size();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
