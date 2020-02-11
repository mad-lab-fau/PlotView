/**
 * This file is part of the PlotView distribution (https://github.com/mad-lab-fau/PlotView).
 * Copyright (c) 2015-2020 Machine Learning and Data Analytics Lab, Friedrich-Alexander-Universität Erlangen-Nürnberg (FAU).
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3.
 * <p>
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package de.fau.mad.plotview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import junit.framework.Assert;

/**
 * @author Stefan Gradl
 */
public class BooleanValueList extends CircularValueList implements List<Boolean> {
    /**
     * The raw values
     */
    public boolean[] values = null;

    /**
     * Constructs a new PlotValueList with the given preallocated entries.
     *
     * @param cacheSize      Number of preallocated entries.
     * @param maintainMinMax Whether to maintain the min and max values.
     */
    public BooleanValueList(int cacheSize, boolean maintainMinMax) {
        super(cacheSize, maintainMinMax);
        values = new boolean[sizeMax];
    }

    /**
     * Adds a new entry to the ring, possibly overwriting the eldest entry.
     *
     * @param newValue The value to add to the list.
     * @return new head position
     */
    public int add(boolean newValue) {
        ++head;
        if (head == sizeMax)
            head = 0;

        values[head] = newValue;

        if (num < sizeMax)
            ++num;
        else {
            // if buffer is entirely filled, tail increases with head
            ++tail;
            if (tail == sizeMax)
                tail = 0;
        }

        return head;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.List#clear()
     */
    public void clear() {
        super.clear();
    }

    /**
     * Copies the contents of sourceList into this ring buffer.
     *
     * @param sourceList
     */
    public void copy(ArrayList<Boolean> sourceList) {
        num = sourceList.size();

        Assert.assertTrue(num <= sizeMax);

        head = -1;
        for (Boolean l : sourceList) {
            values[++head] = l;
        }

        tail = 0;

        if (maintainMinMax) {
            findMinMax();
        }
    }

    /**
     * Iterates over all valid elements and fills the max value.
     */
    public void findMax() {

    }

    /**
     * Iterates over all valid elements and fills the min value.
     */
    public void findMin() {

    }

    /**
     * Iterates over all valid elements and fills the min & max value.
     */
    public void findMinMax() {

    }

    /**
     * Returns the value at the current head position.
     */
    public boolean getHeadValue() {
        if (head < 0)
            return false;
        return values[head];
    }

    /**
     * Returns the value at position rIdx. It has the same effect as calling
     * this.value[normIdx(rIdx)].
     *
     * @param rIdx negative or positive index in the ring
     * @return the value at rIdx or -1 if the List doesn't contain any elements
     */
    public boolean getIndirect(int rIdx) {
        // no elements
        if (num == 0)
            return false;

        return values[normIdx(rIdx)];
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.List#add(int, java.lang.Object)
     */
    public void add(int location, Boolean object) {
        values[normIdx(location)] = object.booleanValue();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.List#addAll(java.util.Collection)
     */
    public boolean addAll(Collection<? extends Boolean> arg0) {
        // === TODO Auto-generated method stub
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.List#addAll(int, java.util.Collection)
     */
    public boolean addAll(int arg0, Collection<? extends Boolean> arg1) {
        // === TODO Auto-generated method stub
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.List#contains(java.lang.Object)
     */
    public boolean contains(Object object) {
        // === TODO Auto-generated method stub
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.List#containsAll(java.util.Collection)
     */
    public boolean containsAll(Collection<?> arg0) {
        // === TODO Auto-generated method stub
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.List#get(int)
     */
    public Boolean get(int location) {
        return getIndirect(location);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.List#indexOf(java.lang.Object)
     */
    public int indexOf(Object object) {
        throw new UnsupportedOperationException();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.List#iterator()
     */
    public Iterator<Boolean> iterator() {
        throw new UnsupportedOperationException();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.List#lastIndexOf(java.lang.Object)
     */
    public int lastIndexOf(Object object) {
        throw new UnsupportedOperationException();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.List#listIterator()
     */
    public ListIterator<Boolean> listIterator() {
        throw new UnsupportedOperationException();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.List#listIterator(int)
     */
    public ListIterator<Boolean> listIterator(int location) {
        throw new UnsupportedOperationException();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.List#remove(int)
     */
    public Boolean remove(int location) {
        throw new UnsupportedOperationException();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.List#remove(java.lang.Object)
     */
    public boolean remove(Object object) {
        throw new UnsupportedOperationException();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.List#removeAll(java.util.Collection)
     */
    public boolean removeAll(Collection<?> arg0) {
        throw new UnsupportedOperationException();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.List#retainAll(java.util.Collection)
     */
    public boolean retainAll(Collection<?> arg0) {
        throw new UnsupportedOperationException();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.List#set(int, java.lang.Object)
     */
    public Boolean set(int location, Boolean object) {
        int idx = normIdx(location);
        boolean prev = values[idx];
        values[idx] = object;
        return prev;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.List#subList(int, int)
     */
    public List<Boolean> subList(int start, int end) {
        throw new UnsupportedOperationException();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.List#toArray()
     */
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.List#toArray(T[])
     */
    public <T> T[] toArray(T[] array) {
        throw new UnsupportedOperationException();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.List#add(java.lang.Object)
     */
    public boolean add(Boolean object) {
        return add(object.booleanValue()) != -1;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.lme.plotview.CircularValueList#add(float)
     */
    @Override
    public int add(float newValue) {
        return add((long) newValue);
    }

    /*
     * (non-Javadoc)
     *
     * @see de.lme.plotview.CircularValueList#add(long)
     */
    @Override
    public int add(long newValue) {
        // === TODO Auto-generated method stub
        return 0;
    }
}
