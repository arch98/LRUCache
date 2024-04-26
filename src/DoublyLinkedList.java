public class DoublyLinkedList<E>{

    private DoublyLinkedListNode<E>head;
    private DoublyLinkedListNode<E>tail;

    public DoublyLinkedList(){
        this.head = new DoublyLinkedListNode<>(null);
        this.tail = new DoublyLinkedListNode<>(null);

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void detachNode(DoublyLinkedListNode<E>node){
        if(node != null){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public void addNodeAtLast(DoublyLinkedListNode<E> node){
        DoublyLinkedListNode<E> tailPrev = tail.prev;
        tailPrev.next = node;
        node.next = tail;
        tail.prev = node;
        node.prev = tailPrev;
    }

    public DoublyLinkedListNode<E> addElementAtLast(E element) throws NotPresentException{
        if(element == null){
            throw  new NotPresentException();
        }

        DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<>(element);
        this.addNodeAtLast(newNode);

        return newNode;
    }

    private boolean NoElementPresent(){
        return this.head.next ==  this.tail;
    }

    public DoublyLinkedListNode<E> getFirstNode() throws NotPresentException{
        if(NoElementPresent()){
            throw new NotPresentException();
        }

        return this.head.next;
    }

    public DoublyLinkedListNode<E> getLastNode() throws NotPresentException{
        if(NoElementPresent()){
            throw new NotPresentException();
        }

        return this.tail.prev;
    }
}
