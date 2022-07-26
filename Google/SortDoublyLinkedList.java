package Google;

public class SortDoublyLinkedList {
	public class DoubleLinkedList {
		int data;
		DoubleLinkedList head;
		DoubleLinkedList next;
		DoubleLinkedList(){
			
		}
	}
	/*public static void bubbleSort(DoubleLinkedList list) //static method used to sort the linked list using bubble sort {
	int i = 0;
	Node currentNode = list.head;
	Node auxNode;
	int foundChange = 1;
	while(foundChange) {
		foundChange = 0;
		for(i=0; i<list.getSize()-1; i++) {
			if (currentNode.getData() > currentNode.getNext().getData()) {
				auxNode.setData(currentNode.getData());
				currentNode.setData(currentNode.getNext.getData());
				currentNode.getNext.setData(auxNode.getData());
				foundChange = 1;
			}
			currentNode = currentNode.getNext();
		}

	}
}*/
	 class Node{  
	        int data;  
	        Node previous;  
	        Node next;  
	          
	        public Node(int data) {  
	            this.data = data;  
	        }  
	    }  
	      
	    //Represent the head and tail of the doubly linked list  
	    Node head = null;
	    Node tail = null;  
	      
	    //addNode() will add a node to the list  
	    public void addNode(int data) {  
	        //Create a new node  
	        Node newNode = new Node(data);  
	          
	        //If list is empty  
	        if(head == null) {  
	            //Both head and tail will point to newNode  
	            head = tail = newNode;  
	            //head's previous will point to null  
	            head.previous = null;  
	            //tail's next will point to null, as it is the last node of the list  
	            tail.next = null;  
	        }  
	        else {  
	            //newNode will be added after tail such that tail's next will point to newNode  
	            tail.next = newNode;  
	            //newNode's previous will point to tail  
	            newNode.previous = tail;  
	            //newNode will become new tail  
	            tail = newNode;  
	            //As it is last node, tail's next will point to null  
	            tail.next = null;  
	        }  
	    }  
	      
	    //sortList() will sort the given list in ascending order  
	    public void sortList() {  
	        Node current = null, index = null;  
	        int temp;  
	        //Check whether list is empty  
	        if(head == null) {  
	            return;  
	        }  
  
	            //Current will point to head  
	        for(current = head; current.next != null; current = current.next) {  
	                //Index will point to node next to current  
	            for(index = current.next; index != null; index = index.next) {  
	                    //If current's data is greater than index's data, swap the data of current and index  
	                    if(current.data > index.data) {  
	                        temp = current.data;  
	                        current.data = index.data;  
	                        index.data = temp;  
	                    }  
	                }  
	            }  
	         
	    }  
	      
	    //display() will print out the nodes of the list  
	    public void display() {  
	        //Node current will point to head  
	        Node current = head;  
	        if(head == null) {  
	            System.out.println("List is empty");  
	            return;  
	        }  
	        while(current != null) {  
	            //Prints each node by incrementing the pointer.  
	  
	            System.out.print(current.data + " ");  
	            current = current.next;  
	        }  
	        System.out.println();  
	    }  
	      
	    public static void main(String[] args) {  
	          
	    	SortDoublyLinkedList dList = new SortDoublyLinkedList();  
	        //Add nodes to the list  
	        dList.addNode(7);  
	        dList.addNode(1);  
	        dList.addNode(4);  
	        dList.addNode(5);  
	        dList.addNode(2);  
	          
	        //Displaying original list  
	        System.out.println("Original list: ");  
	        dList.display();  
	          
	        //Sorting list  
	        dList.sortList();  
	          
	        //Displaying sorted list  
	        System.out.println("Sorted list: ");  
	        dList.display();  
	    }  
}
