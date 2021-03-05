package edu.miracosta.cs113;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DoubleLinkedList <E>implements List<E> {

    private Node<E> nextItem;
    private Node<E> lastItemReturned;
    private int index = 0;
    private int size = 0;

    private static class Node<E>
    {
        private E data;
        private Node<E> prev = null;
        private Node<E> next = null;

        private Node (E item)
        {
            data = item;
        }
    }


    public class DoubleLinkedList<E>
    {
        private Node<E> head = null;
        private Node<E> tail = null;
        private int size = 0;
    }

    public DoubleListIterator(int i)
    {
        if(i < 0 || i > size)
        {
           throw new IndexOutOfBoundsException("Invalid index " + i);
        }
        lastItemReturned = null;

        if(i == size)
        {
            index = size;
            nextItem = null;
        }
        else
        {
            nextItem = head;
            for(index = 0; index < i; index++)
            {
                nextItem = nextItem.next;
            }
        }
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
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
    public boolean add(E e) {
       return false;
    }

    @Override
    public boolean remove(Object o)
    {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
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
    public void clear() {

    }

    @Override
    public E get(int index) {
        return listIterator(index).next();
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {
       listIterator(index).add(element);
    }

    @Override
    public E remove(int index) {
        listIterator(index).remove();
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator()
    {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index)
    {
       return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

}
