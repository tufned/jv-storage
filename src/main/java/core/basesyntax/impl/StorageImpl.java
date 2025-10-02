package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE = 10;
    private static final int PAIR_SIZE = 2;
    private final Object[][] storage;

    public StorageImpl() {
        this.storage = new Object[SIZE][PAIR_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (Object[] item : this.storage) {
            if (Objects.equals(item[0], key)) {
                item[1] = value;
                return;
            }
        }
        int size = size();
        if (size == SIZE) {
            return;
        }
        this.storage[size() + 1] = new Object[]{ key, value };
    }

    @Override
    public V get(K key) {
        for (Object[] item : this.storage) {
            if (Objects.equals(item[0], key)) {
                return (V) item[1];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int length = 0;
        for (Object[] item : this.storage) {
            if (item[0] == null && item[1] == null) {
                continue;
            }
            length++;
        }
        return length;
    }
}
