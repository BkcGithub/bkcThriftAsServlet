package com.myshare.optimization.pro;

import java.util.LinkedHashMap;
import java.util.Map;

public class ObjectCachePool<K, V> {
    public static final int FIFO_POLICY = 1;
    public static final int LRU_POLICY = 2;
    private static final int DEDFAULT_SIZE = 10;
    private Map<K, V> cacheObjects;

    public ObjectCachePool() {
        this(DEDFAULT_SIZE);
    }

    public ObjectCachePool(final int size) {
        this(size, FIFO_POLICY);
    }

    public ObjectCachePool(final int size, final int policy) {
        switch (policy) {
            case FIFO_POLICY:
                cacheObjects = new LinkedHashMap<K, V>(size) {
                    private static final long serialVersionUid = 1L;

                    @Override
                    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                        return size() > size;
                    }
                };
                break;
            case LRU_POLICY:
                cacheObjects = new LinkedHashMap<K, V>(size, 0.75f, true) {
                    private static final long serialVersionUid = 1L;

                    @Override
                    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                        return size() > size;
                    }
                };
            default:
                throw new IllegalArgumentException("Unkonwn policy: " + policy);
        }
    }

    public void put(K key, V value) {
        cacheObjects.put(key, value);
    }

    public V get(K key) {
        return cacheObjects.get(key);
    }

    public void remove(K key) {
        cacheObjects.remove(key);
    }

    public void clear() {
        cacheObjects.clear();
    }
}
