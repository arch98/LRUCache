import java.util.HashMap;
import java.util.Map;

public class LRUCacheEvictionPolicy<Key> implements EvictionPolicy<Key>{


    private DoublyLinkedList<Key>doublyLinkedList;
    private Map<Key,DoublyLinkedListNode<Key>> nodeMapped;


    public LRUCacheEvictionPolicy(){
        this.doublyLinkedList = new DoublyLinkedList<>();
        this.nodeMapped = new HashMap<>();
    }

   public void keyAccessed(Key key) throws NotPresentException{
        if(!nodeMapped.containsKey(key)){
           DoublyLinkedListNode<Key> newNode = this.doublyLinkedList.addElementAtLast(key);
           this.nodeMapped.put(key,newNode);
        }else {
            DoublyLinkedListNode<Key> currNode = this.nodeMapped.get(key);
            this.doublyLinkedList.detachNode(currNode);
            this.doublyLinkedList.addNodeAtLast(currNode);
        }
   }
    public Key evictKey() throws  NotPresentException{

        DoublyLinkedListNode<Key> currNode = this.doublyLinkedList.getFirstNode();
        this.doublyLinkedList.detachNode(currNode);
        this.nodeMapped.remove(currNode.getElement());
       return currNode.getElement();
    }
}
