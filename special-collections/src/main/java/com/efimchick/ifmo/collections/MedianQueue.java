package com.efimchick.ifmo.collections;

import java.util.*;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

class MedianQueue implements Queue<Integer> {
    private List<Integer> list;

    public MedianQueue() {
        this.list = new ArrayList<>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<Integer> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return Queue.super.toArray(generator);
    }

    @Override
    public boolean add(Integer integer) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeIf(Predicate<? super Integer> filter) {
        return Queue.super.removeIf(filter);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return Queue.super.spliterator();
    }

    @Override
    public Stream<Integer> stream() {
        return Queue.super.stream();
    }

    @Override
    public Stream<Integer> parallelStream() {
        return Queue.super.parallelStream();
    }

    @Override
    public boolean offer(Integer integer) {
        return list.add(integer);
    }

    @Override
    public Integer remove() {
        return null;
    }

    @Override
    public Integer poll() {
        if (list.size() == 1) {
            return list.remove(0);
        }
        Collections.sort(list);
        Integer element;
        if (list.size() % 2 == 0) {
            element = list.get((list.size() / 2) - 1);
        } else {
            element = list.get(list.size() / 2);
        }
        list.remove(element);
        list.add(0, element);
        return list.remove(0);
    }

    @Override
    public Integer element() {
        return null;
    }

    @Override
    public Integer peek() {
        Collections.sort(list);
        if (list.size() % 2 == 0) {
            return list.get((list.size() / 2) - 1);
        }
        return list.get(list.size() / 2);
    }
}