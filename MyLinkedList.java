
/**
 * My own linked list
 * @author Nguyen Cong Minh
 * @since 24-Aug-2017
 *
 */

public class MyLinkedList {
	private Node first;			// first node
    private Node last;			// last node
    private int N;				// number item of list
    
    public MyLinkedList() {
        first = null;
        last = null;
        N = 0;
    }
	
    /**
     * Append item (integer) at the last of linked list
     */
    public void append(int item) {
        if (!isEmpty()) {
        	// Add new item to tail of list
            Node prev = last;
            last = new Node(item, null);
            prev.next = last;
        }
        else {
        	// If list empty
            last = new Node(item, null);
            first = last;
        }
        N++;
    }
    
    /**
     * Remove tail item of linked list
     */
    public boolean removeTail() {
        if (isEmpty()) { throw new IllegalStateException("Cannot remove from an empty list."); }
        
        // if list has one item 
        if (N == 1) { first = null; last = null; N = 0; return true;}
        
        // Get Node of last index - 1
        Node newTail = get(N-2);
        
        // Set new last item of list
        newTail.next = null;
        last = newTail;
        N--;
        
        return true;
    }
    
    /**
     * Remove items that greater than number in list
     */
    public boolean removeItemGreaterThan(int val) {
        if (isEmpty()) { throw new IllegalStateException("Cannot remove from an empty list."); }
        
        int index = N;
        Node curr = first;
        Node prev = first;
        Node next = first;
    	// Interate through item of list
    	while (index > 0) {
//    		System.out.println(this.toString());
    		
    		// Check if greater than val then remove item
    		if (curr.data > val) {
    			// If list have only 1 item
    			if (N == 1) { first = null; last = null; N = 0; return true; }
    			// If first item have been remove
    			if (index == N) { first = first.next;}
    			// If remove last item
    			else if (index == 1) { last = prev; last.next = null;}
    			else { prev.next = curr.next; curr = prev; }
    			
    			// decrease number item of list
    			N--;
    		} 
    			
    		// Move to next node
    		prev = curr;
			curr = prev.next;
    		index--;
    		
    	} // end while
        
        return true;
    }
    
    
    
    /**
     * Print all item of list
     */
    public String toString() {
    	int index = N;
    	String result = "Empty List";
    	if (isEmpty()) return result;
    	
    	result = "" + N + " items: ";
    	Node curr = first;
    	// Interate through item of list
    	while (index > 0) {
    		result += curr.data + " ";
    		curr = curr.next;
    		index--;
    	}
    	return result;
    }
    
    /**
     * Return Node by index
     */
    public Node get(int index)
    {
        if (index < 0) return null;
        Node curr = first;
        while (index > 0) {
            if (curr == null) {
                return null;
            }
            curr = curr.next;
            index--;
        }
        return curr;       
    }
    
    /**
     * Size of list
     */
    public int size() {
        return N;
    }

    /**
     * Check if list is empty
     */
    public boolean isEmpty() {
        return N == 0;
    }
	
	/**
	 * Node of linked list
	 */
	private class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
	
	/**
	 * For test local
	 */
	public static void main(String[] args) {
		MyLinkedList m = new MyLinkedList();
		
		// Case 2: remove 1 item
		m.append(1);
		m.append(4);
		
		m.removeTail();
		
		System.out.println("After remove tail");
		System.out.println(m.toString());
		
		m.append(3);
		m.append(4);
		
		m.append(5);
		
		System.out.println("After append");
		System.out.println(m.toString());
		
		m.removeItemGreaterThan(3);
		
		System.out.println("After remove item great than target value");
		System.out.println(m.toString());
	}
	
}


