package edu.miracosta.cs113;

import java.util.*;

public class DoubleLinkedList <E>implements List<E> {


    private int size = 0;

    private Node<E> head = null;
    private Node<E> tail = null;

    private static class Node<E>
    {
        private E data;
        private Node<E> prev = null;
        private Node<E> next = null;

        private Node (E item)
        {
            data = item;
            next = null;
            prev = null;
        }

        private Node(E item, Node<E> next, Node<E> prev)
        {
            data = item;
            this.next = next;
            this.prev = prev;
        }
    }  // End node class


    private class DoubleListIterator implements ListIterator<E>
    {
        private Node<E> nextItem;
        private Node<E> lastItemReturned;
        private int index = 0;

        public DoubleListIterator(int i) {
            if (i < 0 || i > size) {
                throw new IndexOutOfBoundsException("Invalid index " + i);
            }
            lastItemReturned = null;

            if (i == size) {
                index = size;
                nextItem = null;
            } else {
                nextItem = head;
                for (index = 0; index < i; index++) {
                    nextItem = nextItem.next;
                }
            }
        } //End DoubleListIterator

        public DoubleListIterator()
        {
            lastItemReturned = null;
            nextItem = head;

            for(index = 0; index < size(); index++)
            {
                nextItem = nextItem.next;
            }
        }

        public boolean hasNext()
        {
            return nextItem != null;
        }

        public boolean hasPrevious()
        {
            return ((nextItem == null && size!= 0) || nextItem.prev != null);
        }

        public E previous()
        {
            if(!hasPrevious())
            {
                throw new NoSuchElementException();
            }
            if(nextItem == null)
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

        public int previousIndex()
        {
            return (index-1);
        }

        public int nextIndex()
        {
            return index;
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

        public void remove()
        {
            if(head == null)
            {
                throw new IllegalStateException();
            }
            else if(nextItem == null && lastItemReturned == null)
            {
                throw new IllegalStateException();
            }
            else if(lastItemReturned.prev == null)
            {
                nextItem.prev = head;
                head = nextItem;
                size--;
                index--;
            }
            else if(nextItem == null)
            {
                lastItemReturned.prev.next = null;
                tail = lastItemReturned.prev;
                index--;
                size--;
            }
            else
            {
                lastItemReturned.prev.next = nextItem;
                nextItem.prev = lastItemReturned.prev;
                size--;
                index--;
            }
        } // end remove

        public void set(E item)
        {
            if(lastItemReturned == null)
            {
                throw new IllegalStateException();
            }
            Node<E> newNode = new Node<E>(item);
            lastItemReturned.data = newNode.data;
        }

        public void add(E item)
        {
            if(head == null)
            {
                head = new Node<E>(item);
                tail = head;
            }
            else if(nextItem == head)
            {
                Node<E> newNode = new Node<E>(item);
                newNode.next = nextItem;
                nextItem.prev = newNode;
                head = newNode;
            }
            else if(nextItem == null)
            {
                Node<E> newNode = new Node<E>(item);
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            else
            {
                Node<E> newNode = new Node<E>(item);
                newNode.prev = nextItem.prev;
                nextItem.prev.next = newNode;
                newNode.next = nextItem;
                nextItem.prev = newNode;

            }
            size++;
            index++;
            lastItemReturned = null;
        }
    } // End of DoubleListIterator



    // listIterator interface methods

    /*
    public void add(int index, E element) {
        listIterator(index).add(element);
    }*/




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
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element)
    {

    }

    @Override
    public E remove(int index) {
        return null;
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
