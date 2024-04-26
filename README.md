Developed an In Memory Cache 


Problem Statement:
LLD for a cache system.
Following operations are supported with the Cache:

1. Put : put a new value in the cache.
2. Get : Get the corresponding value to a key.
3. Evict : Remove a key from the Cache.

Extra notes;

1. The solution is extensible as the storage and eviction policies can be added.
2. The current storage is using a hashmap and the eviction policy for the cache is LRU (Least Recently Used).
3. We have a defined capacity and use of Linked list to keep track of the new elements added and to be evicted.
4. Reference : https://github.com/anomaly2104/cache-low-level-system-design/tree/master
