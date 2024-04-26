public interface StoragePolicy<Key,Value>{

    void addNode(Key key,Value value);
    Value getValue(Key key);

    void remove(Key key);
}
