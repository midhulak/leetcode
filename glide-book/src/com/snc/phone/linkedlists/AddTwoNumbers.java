package com.snc.phone.linkedlists;

public class AddTwoNumbers {
	
	/**https://leetcode.com/problems/add-two-numbers/
	 * just clarify with the interviwer what is the order and how to print  
	 */
    /**
    Time complexity : O(\max(m, n))O(max(m,n)). Assume that mm and nn represents the length of l1l1 and l2l2 respectively, the algorithm above iterates at most \max(m, n)max(m,n) times.

Space complexity : O(\max(m, n))O(max(m,n)). The length of the new list is at most \max(m,n) + 1max(m,n)+1.

**/
    public static  ListNode addTwoNumbers(ListNode l1 , ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode p =l1, q=l2;
       // ListNode curr = null;
        ListNode curr = dummyHead;
        int carry=0;
        
        while(p != null || q != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            
            int sum = carry + x +y;
            carry = sum/10;
            
            /** to add nodes at the start **/
            // ListNode temp = new ListNode(sum%10);
            // temp.next=curr;
            // curr=temp;
            
            /* to add nodes at the end.**/
            curr.next = new ListNode(sum % 10);
             curr = curr.next;
            
            if(p != null)
                p = p.next;
            
           if(q != null)
                q = q.next;
            
            
        }
        
        if(carry > 0){
            // ListNode dum = new ListNode(carry);
            // dum.next=curr;
            // curr=dum;
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    
//     public static  ListNode addTwoNumbers(ListNode newA , ListNode newB){
//         if(newA == null)
// 			return newB;
// 		if(newB == null)
// 			return newA;
		
		
		
// 		//ListNode newA = reverse(A);
// 		//ListNode newB = reverse(B);
		
// 		ListNode res = null;
// 		int carry=0;
// 		int sum=0;
//         ListNode dummy = new ListNode(0);
// 		ListNode curr=dummy;
		
// 		while(newA != null || newB != null) {
// 			sum=0;
// 			if(newA != null) {
// 				sum+=newA.val;
// 				newA=newA.next;
// 			}
				
// 			if(newB != null) {
// 				sum+=newB.val;
// 				newB=newB.next;
// 			}
			
// 					sum+=carry;
					
// 			carry = sum/10;
			
			
// 		curr.next=new ListNode(sum%10);
		
// 	     curr=curr.next;
		
			
	
		
// 		}
		
// 		if(carry > 0) {
// 			curr.next=new ListNode(carry);
// 		}
		
// 		return dummy.next;
//     }
    
    
    public static ListNode reverse(ListNode n ) {
		
		ListNode newNode = null;
		
		while(n != null) {
			
			ListNode temp = n;
			n=n.next;
			
			temp.next=newNode;
			newNode=temp;
		}
		
		return newNode;
	}
    
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
