
public class DNode<E> {
    private E data;
    private DNode<E> previous;
    private DNode<E> next;

    public DNode(E data, DNode<E> previous, DNode<E> next) {
      this.data = data;
      this.previous = previous;
      this.next = next;
    }

    public DNode(E data) {
      this(data, null, null);
    }

    public DNode() {
      this(null, null, null);
    }
    
    public void setNext(DNode<E> node) {
        next=node;
    }
    
    public DNode<E> getNext() {
        return next;
    }
    
    public void setPrevious(DNode<E> node) {
        previous=node;
    }
    
    public DNode<E> getPrevious() {
        return previous;
    }
    
    public E getData() {
        return data;
    }
}
