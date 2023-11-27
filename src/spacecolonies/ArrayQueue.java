// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at 
// all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- danila
package spacecolonies;

import queue.EmptyQueueException;
import queue.QueueInterface;
/**
 * ArrayQueue implementation of queue
 * 
 * @author danila
 * @version 04.11.2022
 * @param <T> generic type
 */
public class ArrayQueue<T> implements QueueInterface<T> {
    
    private T[] queue;
    /**
     * Default capacity
     */
    public static final int DEFAULT_CAPACITY = 20;
    private int enqueueIndex;
    private int dequeueIndex;
    private int size;
    /**
     * Default constructor
     */
    public ArrayQueue() {
        this(DEFAULT_CAPACITY); 
    }
    /**
     * Constructor
     * @param initialCapacity
     *              Initial Capacity
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int initialCapacity) {
        
        queue = (T[]) new Object[initialCapacity + 1];
        dequeueIndex = 0;
        enqueueIndex = queue.length - 1;
        size = 0;
    }
    /**
     * Get length of underlying array
     * @return length
     */
    public int getLengthOfUnderlyingArray() {
        return queue.length;
    }
    /**
     * Get size
     * @return size
     */
    public int getSize() {
        return size;
    }
    /**
     * Check if the queue is empty
     * @return true if empty, false if not empty
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Enqueue an object to the queue
     * @param entry to be added
     */
    public void enqueue(T entry) {
        if (entry == null) {
            return;
        }
        ensureCapacity();
        enqueueIndex = (enqueueIndex + 1) % 
            getLengthOfUnderlyingArray();
        queue[enqueueIndex] = entry;
        size++;
        
    }
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if ((enqueueIndex + 2) % getLengthOfUnderlyingArray()
                == dequeueIndex) {
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            int newSize = oldSize * 2 - 1;
            queue = (T[]) new Object[newSize];
            
            int j = dequeueIndex;
            for (int i = 0; i < oldSize - 1; i++) {
                queue[i] = oldQueue[j];
                j = (j + 1) % oldSize;
            }
            dequeueIndex = 0;
            enqueueIndex = oldSize - 2;
        }
    }
    /**
     * Remove the first item in the queue
     * @return removed item
     */
    public T dequeue() {
        T front = getFront();
        queue[dequeueIndex] = null;
        dequeueIndex = (dequeueIndex + 1) % 
            getLengthOfUnderlyingArray();
        size--;
        return front;
        
    }
    /**
     * Method that returns the front method
     * @return the front entry
     */
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return queue[dequeueIndex];
    }
    
    /**
     * Makes the object as newly initialized
     * (with default constructor);
     */
    @SuppressWarnings("unchecked")
    public void clear() {
        queue =  (T[]) new Object[DEFAULT_CAPACITY + 1];
        dequeueIndex = 0;
        enqueueIndex = queue.length - 1;
        size = 0;
    }
    /**
     * Equals method
     * @param o -- object to be compared to
     * @return true when equal, false when not
     */
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
    
        if (this.getClass() != o.getClass()) {
            return false;
        }
        
        
        ArrayQueue<T> other = (ArrayQueue<T>) o;
        if (this.size != other.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            T myElement = queue[(dequeueIndex + i) % queue.length];
            T otherElement = other.queue[(other.dequeueIndex + i) % 
                                         other.queue.length];
            if (!myElement.equals(otherElement)) {
                return false;
            }
        }
        return true;
    }
    /**
     * Convert the queue to array
     * 
     * @return Array object of the queue
     */
    public Object[] toArray() {
        
        Object[] answer = new Object[this.size];
        int j = 0;
        for (int i = 0; i < getLengthOfUnderlyingArray(); i++) {
            if (queue[i] != null) {
                answer[j] = queue[i];
                j = (j + 1) % answer.length;
            }
        }
        return answer;
    }
    /**
     * Convert the class to the string
     * @return string implementation of class
     */
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder str = new StringBuilder();
        str.append("[");
        int indexOfFirstItem = 0;
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] != null) {
                str.append(queue[i].toString());
                indexOfFirstItem = i;
                break;
            }
        }
        for (int i = indexOfFirstItem + 1; i < queue.length; i++) {
            if (queue[i] != null) {
                 
                str.append(", " + queue[i].toString());
            }
        }
        str.append("]");
        return str.toString();
    }
    
    
    
}  