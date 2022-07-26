package com.snc.day3.linkedlists.singleLinkedLists;

//1,2,3,4,5  k=2
//2,1,4,3,5
public class ReverseKGRoup {
	
	public class ListNode {
		      int val;
		      ListNode next;
		     ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	
public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode curr = head;
        
        ListNode newHead = null;
        ListNode KRevTail=null;
        //1 2 3 4 5 6 7 8
        while(curr != null){
            int count=0;
            
            curr=head;
            while(count < k && curr != null){
                
                curr=curr.next;
                count+=1;
            }
            
            if(count == k){
                
                ListNode rev = reverseK(head , k);
                
                if(newHead == null)
                    newHead = rev;
                
                if(KRevTail != null)
                    KRevTail.next = rev;
                
                KRevTail = head;
                head = curr;
            }
            
        }
        
        if(KRevTail != null)
            KRevTail.next = head;
        
        return newHead != null ? newHead : head;
        
        
    }
    
    public ListNode reverseK(ListNode head , int k){
        ListNode newNode = null;
        
        while( k>0){
            
            ListNode temp = head;
            head=head.next;
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
