public class Cache<Key,Value>{
    private EvictionPolicy<Key> evictionPolicy;
    private StoragePolicy<Key,Value>storagePolicy;

    public Cache(EvictionPolicy<Key>evictionPolicy,StoragePolicy<Key,Value>storagePolicy){
        this.evictionPolicy = evictionPolicy;
        this.storagePolicy = storagePolicy;
    }

    public void put(Key key,Value value){
            try{
                this.storagePolicy.addNode(key,value);
                this.evictionPolicy.keyAccessed(key);
            }catch (StorageFullException ex){
                System.out.println("System is full, going to evict one!");
                Key keytoRemove = this.evictionPolicy.evictKey();
                this.storagePolicy.remove(keytoRemove);
                this.put(key,value);
            }
    }

    public Value get(Key key){
        try{
            Value value = this.storagePolicy.getValue(key);
            this.evictionPolicy.keyAccessed(key);
            return value;
        }catch(NotPresentException exception){
            System.out.println("Key not present!");
            return null;
        }
    }
}
