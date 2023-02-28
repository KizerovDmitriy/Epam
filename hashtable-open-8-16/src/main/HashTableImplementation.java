package com.epam.rd.autocode.hashtableopen816;


import java.util.Arrays;

public class HashTableImplementation implements HashtableOpen8to16 {
    private static final int MAX_CAPACITY = 16;
    private static final int INITIAL_CAPACITY = 8;
    private static final int flag = Integer.MAX_VALUE;
    private int capacity;
    private int size;
    private int[] keys;
    private Object[] values;

    public HashTableImplementation() {
        this.capacity = INITIAL_CAPACITY;
        this.size = 0;
        this.keys = new int[capacity];
        this.values = new Object[capacity];
        fillArray(keys);
    }

    @Override
    public void insert(int key, Object value) {
        int index = hash(key);
        if (keys[index] == key) {
            values[index] = value;
        }
        if (contains(key)) {
            return;
        } else {
            if (size == capacity) {
                resize(capacity * 2);
            }
            index = hash(key);
            while (keys[index] != flag) {
                index = (index + 1) % capacity;
            }
            keys[index] = key;
            values[index] = value;
            size++;
        }
    }

    @Override
    public Object search(int key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key) {
                if (values[i] == null) {
                    return null;
                }
                return values[i];
            }
        }
        return null;
    }

    @Override
    public void remove(int key) {
        int index = hash(key);
        int count = 0;
        while (keys[index] != key) {
            if (count > MAX_CAPACITY) {
                return;
            }
            index = (index + 1) % capacity;
            count++;
        }
        if (values[index] != null) {
            values[index] = null;
            keys[index] = flag;
            size--;
            if (size > 0 && size <= capacity / 4) {
                shrink();
            }
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int[] keys() {
        int[] result = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            if (keys[i] == flag) {
                result[i] = 0;
            } else result[i] = keys[i];
        }
        return result;
    }

    private int hash(int key) {
        int index = key % capacity;
        return index < 0 ? index * -1 : index;
    }

    private void resize(int newCapacity) {
        if (newCapacity > MAX_CAPACITY) {
            throw new IllegalStateException();
        }

        int[] oldKeys = keys;
        Object[] oldValues = values;
        int oldCapacity = capacity;

        keys = new int[newCapacity];
        fillArray(keys);
        values = new Object[newCapacity];
        capacity = newCapacity;
        size = 0;

        for (int i = 0; i < oldCapacity; i++) {
            if (oldKeys[i] != flag) {
                insert(oldKeys[i], oldValues[i]);
            }
        }
    }

    private void fillArray(int[] array) {
        Arrays.fill(array, flag);
    }

    private boolean contains(int key) {
        for (int j : keys) {
            if (j == key) {
                return true;
            }
        }
        return false;
    }

    private void shrink() {
        if (capacity == 2) {
            return;
        }
        Object[] oldValues = values;
        int[] oldKeys = keys;
        int oldCapacity = capacity;
        capacity /= 2;
        values = new Object[capacity];
        keys = new int[capacity];
        fillArray(keys);
        size = 0;
        for (int i = 0; i < oldCapacity; i++) {
            if (oldValues[i] != null) {
                insert(oldKeys[i], oldValues[i]);
            }
        }
    }
}