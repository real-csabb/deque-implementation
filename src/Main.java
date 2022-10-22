
import java.util.NoSuchElementException;

public class Main {

	public static void main(String[] args) {

		LinkedDeque<Integer> deque = new LinkedDeque<Integer>();
		
		for (int i = 0; i < 10; i++) {
			deque.addFirst(i);
		}
		
		deque.addLast(-1);
		
		deque.printForward();
		
		deque.removeFirst();
		
		deque.printForward();
		
		deque.removeLast();
		
		deque.printForward();
		
		deque.clear();
		
		deque.addFirst(1);
		deque.addFirst(2);
		deque.addFirst(3);
		deque.addFirst(3);
		deque.addFirst(2);
		deque.addFirst(1);
		
		deque.printForward();
		
		deque.removeFirstOccurrence(2);
		
		deque.printForward();
		
		deque.removeLastOccurrence(1);
		
		deque.printForward();
		
		deque.clear();
		
		try {
			deque.removeFirst();
		} catch (NoSuchElementException e) {
			System.out.println("No first to remove!");
		}
		
		try {
			deque.removeLast();
		} catch (NoSuchElementException e) {
			System.out.println("No last to remove!");
		}
		
		deque.addLast(1);
		
		deque.printForward();
		
		deque.removeFirst();
		
		deque.printForward();
		
		deque.addFirst(1);
		
		deque.printForward();
		
		System.out.println("Removing last occurrence of 1...");
		
		deque.removeLastOccurrence(1);
		
		deque.printForward();
		
		if (!deque.removeFirstOccurrence(2)) {
			System.out.println("No first occurrence!");
		}
		
		if (!deque.removeLastOccurrence(5)) {
			System.out.println("No last occurrence!");
		}
		
		deque.addLast(5);
		deque.addFirst(3);
		deque.addLast(2);
		
		deque.printForward();
		
		deque.removeFirstOccurrence(3);
		
		deque.printForward();
		
		if (!deque.removeFirstOccurrence(-1)) {
			System.out.println("No -1 to remove!");
		}
		
		if (!deque.removeLastOccurrence(10)) {
			System.out.println("No 10 to remove!");
		}
		
		deque.printForward();
	}

}
