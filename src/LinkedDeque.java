
import java.util.NoSuchElementException;

/**
 * implementation of linked double-ended queue
 * uses dummy (aka sentinel) nodes at head and tail
 */
public class LinkedDeque<E> implements Deque<E> {
    
    private DNode<E> head;
    private DNode<E> tail;
    
    // Creates both a dummy head and a dummy tail.
    public LinkedDeque() {
        head = new DNode<>();
        tail = new DNode<>();
        head.setNext(tail);
        tail.setPrevious(head);
    }
    
    public boolean isEmpty() {
        return head.getNext() == tail;
    }
    
    public void clear() {
        head.setNext(tail);
        tail.setPrevious(head);
    }
    
    // IMPLEMENT THESE METHODS
    public void addFirst(E element) {
    	DNode<E> node = new DNode<E> (element);
    	head.getNext().setPrevious(node);
    	node.setPrevious(head);
    	node.setNext(head.getNext());
    	head.setNext(node);
    }
    
    public E removeFirst() throws NoSuchElementException {
    	DNode<E> first = head.getNext();
    	
        if (first == tail) {
        	throw new NoSuchElementException();
        }
        
        first.getNext().setPrevious(head);
        head.setNext(first.getNext());
        
        return first.getData();
    }
    
    public E getFirst() throws NoSuchElementException {
    	DNode<E> first = head.getNext();
    	
        if (first == tail) {
        	throw new NoSuchElementException();
        }

        return first.getData();
    }
    
    public boolean removeFirstOccurrence(E obj) {
    	DNode<E> current = head.getNext();
    	
        while (current != tail) {
        	if (current.getData().equals(obj)) {
        		DNode<E> prev = current.getPrevious();
        		DNode<E> next = current.getNext();
        		
        		next.setPrevious(prev);
        		prev.setNext(next);
        		
        		return true;
        	}
        	
        	current = current.getNext();
        }
        
        return false;
    }
    
    public void addLast(E element) {
    	DNode<E> node = new DNode<E> (element);
    	tail.getPrevious().setNext(node);
    	node.setNext(tail);
    	node.setPrevious(tail.getPrevious());
    	tail.setPrevious(node);
    }
    
    public E removeLast() throws NoSuchElementException {
    	DNode<E> last = tail.getPrevious();
    	
        if (last == head) {
        	throw new NoSuchElementException();
        }
        
        last.getPrevious().setNext(tail);
        tail.setPrevious(last.getPrevious());
        
        return last.getData();
    }
    
    public E getLast() throws NoSuchElementException {
    	DNode<E> last = tail.getPrevious();
    	
        if (last == head) {
        	throw new NoSuchElementException();
        }

        return last.getData();
    }
    
    public boolean removeLastOccurrence(E obj) {
    	DNode<E> current = tail.getPrevious();
    	
        while (current != head) {
        	if (current.getData().equals(obj)) {
        		DNode<E> prev = current.getPrevious();
        		DNode<E> next = current.getNext();
        		
        		next.setPrevious(prev);
        		prev.setNext(next);
        		
        		return true;
        	}
        	
        	current = current.getPrevious();
        }
        
        return false;
    }
    
    // methods to print the deque are provided:
    public void printForward() {
        System.out.println("The deque printed forward:");
        DNode<E> current = head.getNext();
        while (current != tail) {
            System.out.println(current.getData());
            current = current.getNext();
        }
        System.out.println();
    }
    
    public void printBackward() {
        System.out.println("The deque printed backward:");
        DNode<E> current = tail.getPrevious();
        while (current != head) {
            System.out.println(current.getData());
            current = current.getPrevious();
        }
        System.out.println();
    }
    
}
