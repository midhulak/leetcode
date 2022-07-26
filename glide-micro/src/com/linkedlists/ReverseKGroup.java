package com.linkedlists;

import java.util.List;

public class ReverseKGroup {
	
	static class ListNode{
		int val;
		ListNode next;
		ListNode(){};
		ListNode(int val){
			this.val = val;
		}
		ListNode(int val , ListNode next){
			this.val = val;
			this.next = next;
		}
		
	}

	 public ListNode reverseKGroup(ListNode head, int k) {
	       //reverse k nodes at atime and before reversing keep tarck of tail pointer tail pojnter will be start of node after reverse.
	        // and keep appending tail.next = reverseNode if sarting tail pointer is empty then toReturn is reversenode an dtail pointe ris head..and also before reversing 
	        //     need to check next elements are equal to k or not..if equal to k then only need to reverse otherwise dpo not reverse and return newNode is not null else return ghead
	    ListNode curr = head;
	       ListNode KrevTail = null;
	        
	        
	        ListNode newHead = null;
	        
	        while(curr != null){
	            
	            int count=0;
	            //strat counting the nodes from head
	            
	            while(count < k && curr != null){
	                
	                curr = curr.next;
	                count+=1;
	            }
	            
	            if(count == k){
	                // 1->2->3->4->5->6->7->8
	                ListNode revKNode = this.reverse(head , k);
	                
	                if(newHead == null)
	                    newHead = revKNode;
	                
	                if(KrevTail != null)
	                    KrevTail.next = revKNode;
	                
	                KrevTail = head;
	                head = curr;
	            }
	            
	        }
	        
	        if(KrevTail != null)
	            KrevTail.next = head; //if any nodes left which does not ahve have k number of nodes to reverse then appending it to the end.
	        
	        return newHead == null ? head : newHead;
	    }
	    
	    public ListNode reverse(ListNode revNode, int k){
	        
	        
	        ListNode newNode = null;
	        while( k >0){
	            ListNode temp  = revNode;
	            revNode = revNode.next;
	            temp.next = newNode;
	            newNode=temp;
	            k--;
	            
	        }
	        return newNode;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
