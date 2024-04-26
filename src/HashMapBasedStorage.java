import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key,Value> implements StoragePolicy<Key,Value>{

    private int capacity;
    private Map<Key,Value> nodesMapped;


    public HashMapBasedStorage(int capacity){
        this.capacity = capacity;
        this.nodesMapped = new HashMap<>();
    }
    public void addNode(Key key,Value value) throws StorageFullException{
            if(this.capacity == this.nodesMapped.size()){
                throw new StorageFullException();
            }
            this.nodesMapped.put(key,value);
    }
    public Value getValue(Key key) throws NotPresentException{
        if(!nodesMapped.containsKey(key)){
            throw  new NotPresentException();
        }

        Value value = nodesMapped.get(key);
        return value;
    }

   public void remove(Key key) throws NotPresentException{
        if(!nodesMapped.containsKey(key)){
            throw  new NotPresentException();
        }
        nodesMapped.remove(key);
   }
}
