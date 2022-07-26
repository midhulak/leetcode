package com.linkedlists;

public class MergeKSortedLists {
	
	static class ListNode{
		ListNode next;
		int val;
		
		ListNode(int val){
			this.val = val;
		}
	}
	
	 public ListNode mergeKLists(ListNode[] lists) {
	        if(lists == null || lists.length ==  0)
	            return null;
	        
	        return mergeKlist(lists, 0 , lists.length-1);
	    
	    
	}
	    
	    
	    private ListNode mergeKlist(ListNode[] lists , int start , int end){
	        
	        if(start == end)
	            return lists[start];
	        
	        int mid = start + (end-start)/2;
	        ListNode left = mergeKlist(lists , start , mid);
	        ListNode right = mergeKlist(lists , mid+1 , end);
	        
	        return merge(left , right);
	    }
	    
	    
	    private ListNode merge(ListNode left , ListNode right){
	        
	        ListNode head = new ListNode(0);
	        ListNode curr = head;
	        
	        while(left != null && right != null){
	            if(left.val < right.val){
	                curr.next = left;
	                left = left.next;
	            }
	            else if(left.val == right.val){
	                curr.next = left;
	                left=left.next;
	            }
	            
	           else {
	                curr.next = right;
	                right = right.next;
	            }
	          
	            curr = curr.next;
	            
	        }
	        
	        if(left != null){
	            curr.next = left;
	            left=left.next;
	        }
	        
	        if(right != null){
	            curr.next = right;
	            right=right.next;
	        }
	        
	        return head.next;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
