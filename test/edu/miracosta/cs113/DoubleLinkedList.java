package edu.miracosta.cs113;

import java.util.*;

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

    // listIterator interface methods
    public void add(int index, E element) {
        listIterator(index).add(element);
    }

    public boolean hasNext()
    {
        return nextItem != null;
    }

    public boolean hasPrevious()
    {
        return (nextItem == null && size!= 0) || nextItem.prev != null;
    }

    public E previous()
    {
        if(!hasPrevious())
        {
            throw new NoSuchElementException();
        }
        if(nextItem = null)
        {
            nextItem = tail;
        }
        else
        {
            nextItem = nextItem.prev;
        }
        lastItemReturned = nextItem;
        index--;
        return lastItemReturned.data;
    }


    public E next()
    {
        if(!hasNext())
        {
            throw new NoSuchElementException();
        }
        lastItemReturned = nextItem;
        nextItem = nextItem.next;
        index++;
        return lastItemReturned.data;
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
