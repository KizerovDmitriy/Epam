package com.efimchick.ifmo.collections;


        import java.util.*;
        import java.util.function.Consumer;
        import java.util.function.UnaryOperator;


class PairStringList implements List<String> {
    private final ArrayList<String> list;

    public PairStringList() {
        this.list = new ArrayList<>();
    }


    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.size() > 0;
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<String> iterator() {
        return list.listIterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean add(String s) {
        list.add(s);

        return list.add(s);
    }

    @Override
    public boolean remove(Object o) {
        list.remove(o);
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        List<String> result = new ArrayList<>();
        for (String s : c) {
            result.add(s);
            result.add(s);
        }
        return list.addAll(result);
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        List<String> result = new ArrayList<>();
        for (String s : c) {
            result.add(s);
            result.add(s);
        }
        if (index % 2 != 0) {
            return list.addAll(index + 1, result);
        } else return list.addAll(index, result);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<String> operator) {
        List.super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super String> c) {
        List.super.sort(c);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public String get(int index) {
        return list.get(index);
    }

    @Override
    public String set(int index, String element) {
        if (index % 2 != 0) {
            list.set(index - 1, element);
            return list.set(index, element);
        } else {
            list.set(index, element);
            return list.set(index + 1, element);
        }
    }

    @Override
    public void add(int index, String element) {
        if (index % 2 != 0) {
            list.add(index + 1, element);
            list.add(index + 1, element);
        } else {
            list.add(index, element);
            list.add(index, element);
        }
    }

    @Override
    public String remove(int index) {
        list.remove(index);
        return list.remove(index - 1);
    }

    @Override
    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<String> listIterator() {
        return list.listIterator();
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return list.listIterator(index);
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Spliterator<String> spliterator() {
        return List.super.spliterator();
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        List.super.forEach(action);
    }
}