package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE = 10;
    private final K[] keys;
    private final V[] values;

    public StorageImpl() {
        this.keys = (K[]) new Object[SIZE];
        this.values = (V[]) new Object[SIZE];
    }

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        if (index != -1) {
            values[index] = value;
            return;
        }

        int currentSize = size();
        if (currentSize < SIZE) {
            keys[currentSize] = key;
            values[currentSize] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = findKeyIndex(key);
        if (index == -1) {
            return null;
        }
        return values[index];
    }

    @Override
    public int size() {
        int length = 0;
        for (int i = 0; i < SIZE; i++) {
            if (keys[i] != null || values[i] != null) {
                length++;
            }
        }
        return length;
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < SIZE; i++) {
            K itemKey = keys[i];
            if (itemKey == key || (itemKey != null && itemKey.equals(key))) {
                return i;
            }
        }
        return -1;
    }
}
