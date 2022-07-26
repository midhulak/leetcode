import java.util.List;

public class ReverseKGroup {
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x , ListNode next) { val = x; }
	  }

	   public ListNode reverseKGroup(ListNode head, int k){
		   
			
	        
	        ListNode current = head;
	        ListNode root = new ListNode(0 , head);
	        ListNode prev = root;
	        
	        
	        while(current != null){
	            
	            ListNode tail = current;
	            int listIndex=0;
	            //move list until k and if listindex less than k just add it to the result otherwise 
	            //reverse it and add.
	            while(current != null && listIndex < k){
	                 current = current.next;
	                listIndex++;
	            }
	            
	            if(listIndex != k)
	                prev.next = tail;
	              
	            else{
	                prev.next = reverse(tail , k);
	                prev = tail;
	            }
	                    
	            }
	        
	        return root.next;
	        }
	        
	    public ListNode reverse(ListNode head , int k){
	        
	        ListNode curr = head;
	        ListNode prev = null;
	        
	        while(curr != null && k > 0){
	            ListNode temp = curr.next;
	            curr.next=prev;
	            prev=curr;
	            curr=temp;
	            k--;
	        }
	       
	        return prev;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
