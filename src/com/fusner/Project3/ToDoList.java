package com.fusner.Project3;

import java.util.*;

public class ToDoList<T> implements Iterable<T>
{
    private ArrayList<T> values;

    public ToDoList(ArrayList<T> values)
    {
        this.values = values;
    }

    public ToDoList()
    {
        this.values = new ArrayList<>();
    }

    class ArrayIterator implements Iterator<T>
    {
        int current = 0;

        public boolean hasNext()
        {
            if (current < ToDoList.this.values.size())
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public T next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }
            return values.get(current++);
        }
    }

    public T get(int index)
    {
        return values.get(index);
    }

    public void add(T item)
    {
        values.add(item);
    }

    public void set(int index, T value)
    {
        values.set(index, value);
    }

    public int size()
    {
        return values.size();
    }

    public Iterator<T> iterator()
    {
        return new ArrayIterator();
    }

    public void remove(int index)
    {
        values.remove(index);
    }




}
