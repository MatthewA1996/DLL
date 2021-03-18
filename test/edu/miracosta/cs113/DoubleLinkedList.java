package edu.miracosta.cs113;

import java.util.*;

public class DoubleLinkedList <E>implements List<E> {


    private static class Node<E>
    {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        private Node()
        {
            data = null;
            next = null;
            prev = null;
        }
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
        private int index;

        public DoubleListIterator(int i) {
            if (i < 0 || i > size()) {
                throw new IndexOutOfBoundsException();
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

    // Begin DLL
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public DoubleListIterator listIterator()
    {
        return new DoubleListIterator();
    }

    public DoubleListIterator iterator()
    {
        return new DoubleListIterator();
    }

    public DoubleListIterator listIterator(int index)
    {
        return new DoubleListIterator(index);
    }

    public DoubleLinkedList()
    {
        tail = null;
        head = null;
        size = 0;
    }

    public void add(int index, E item)
    {
        listIterator(index).add(item);
    }




    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
       if(head == null)
       {
           return true;
       }
       else
       {
           return false;
       }
    }


    @Override
    public boolean contains(Object o)
    {
        if(indexOf(o) > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
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
        int currentSize = size;
        int targetIndex = indexOf(o);

        if(targetIndex >= size() || targetIndex < 0)
        {
            return false;
        }

        DoubleListIterator iterator = new DoubleListIterator(targetIndex);

        if(iterator.hasNext() == true)
        {
            iterator.next();
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }

        iterator.remove();

        if(currentSize == (size()-1))
        {
            return false;
        }
        else
        {
            return true;
        }
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
    public void clear()
    {
      head = null;
      tail = head;
      size = 0;
    }

    @Override
    public E get(int index)
    {
      DoubleListIterator iterator = new DoubleListIterator(index);

      if(iterator.hasNext() == false)
      {
          throw new IndexOutOfBoundsException();
      }
      else
      {
          return iterator.next();
      }
    }

    @Override
    public E set(int index, E element)
    {
       if(index > size()-1)
       {
           throw new IndexOutOfBoundsException();
       }
       DoubleListIterator iterator = new DoubleListIterator(index);
       Node<E> prevdata = new Node<E>();
       iterator.next();

       prevdata.data = iterator.lastItemReturned.data;
       iterator.set(element);

       return prevdata.data;
    }


    @Override
    public E remove(int index)
    {
        if(index >= size() || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            DoubleListIterator iterator = new DoubleListIterator(index);

            if(iterator.hasNext() == false)
            {
                throw new IllegalStateException();
            }
            else
            {
                E removed = iterator.next();
                iterator.remove();
                return removed;
            }
        }
    }

    @Override
    public int indexOf(Object o)
    {
        int position = 0;
        if(o == null)
        {
            return -1;  // empty list
        }
        Node index = head;

        while(index != null)
        {
            if(o.equals(index.data))
            {
                return position;
            }
            position++;
            index = index.next;
        }
        return -1; // not found
    }

    @Override
    public int lastIndexOf(Object o)
    {
        int pos = 0;
        if(o == null)
        {
            return -1;
        }
        Node index = head;
        while(index != null)
        {
            if(o.equals(index.data))
            {
                return (size-pos-1);
            }
            pos++;
            index = index.next;
        }
        return -1;
    }

    public boolean equals(Object other)
    {
        if(other == null || !(other instanceof LinkedList))
        {
            return false;
        }
        else
        {
            List otherList = (LinkedList) other;

            if(size() != otherList.size())
            {
                return false;
            }

            Node<E> index = head;

            while(index != null)
            {
                if(!(otherList.contains(index.data)))
                {
                    return false;
                }
                index = index.next;
            }
            return true;
        }
    }

    public String toString()
    {
       String info = "";
       Node pos = head;

       if(head == null)
       {
           info +="Empty List";
       }
       else
       {
           while(pos != null)
           {
               info += pos.data;
               pos = pos.next;
               info +=",";
           }
           info = info.substring(0,info.length()-2);
       }
       return info;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

}
