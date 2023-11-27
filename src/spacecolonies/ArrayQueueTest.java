// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at 
// all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- danila
package spacecolonies;

import queue.EmptyQueueException;
import student.TestCase;
/**
 * Test ArrayQueue()
 * @author danila
 * @version 10.11.2022
 *
 */
public class ArrayQueueTest extends TestCase {
    
    private ArrayQueue<String> array;
    /**
     * Run before each test case
     */
    public void setUp() {
        array = new ArrayQueue<String>();
    }
    /**
     * Test simple methods, such as
     * getSize(), isEmpty, and 
     */
    public void testGettersAndOtherSimpleMethods() {
        assertEquals(21, array.getLengthOfUnderlyingArray());
        assertTrue(array.isEmpty());
        assertEquals(0, array.getSize());
        
    }
    /**
     * Test enqueue and toArray methods
     */
    public void testEnqueueAndToArray() {
        array.enqueue(null);
        assertEquals(0, array.getSize());
        array.enqueue("amogus");
        assertEquals("amogus", array.toArray()[0]);
        array.enqueue("sunshine");
        assertEquals("sunshine", array.toArray()[1]);
    }
    /**
     * Test dequeue and GetFront
     */
    public void testDequeueAndGetFront() {
        Exception e = null;
        try {
            array.dequeue();
        }
        catch (Exception ex) {
            e = ex;
        }
        assertTrue(e instanceof EmptyQueueException);
        array.enqueue("amogus");
        array.enqueue("sunshine");
        array.dequeue();
        assertEquals("sunshine", array.toArray()[0]);
        
        
    }
    /**
     * Test equals method
     */
    public void testEquals() {
        array.enqueue("amogus");
        array.enqueue("sunshine");
        ArrayQueue<String> ar2 = new ArrayQueue<String>();
        ar2.enqueue("amogus");
        ar2.enqueue("sunshine");
        assertTrue(ar2.equals(array));
        ar2.enqueue("dawn");
        assertFalse(ar2.equals(array));
        ar2.dequeue();
        ar2.dequeue();
        ar2.enqueue("bob");
        assertFalse(ar2.equals(array));
        assertFalse(ar2.equals(null));
        assertFalse(ar2.equals(""));
    }
    /**
     * Test that ensure capacity works correctly
     */
    public void testEnsureCapcity() {
        
        for (int i = 0; i < 23; i++) {
            array.enqueue("Que?");
        }
        assertEquals(41, 
            array.getLengthOfUnderlyingArray());
        
    }
    /**
     * Test that toString outputs what expected
     */
    public void testToString() {
        assertEquals("[]", array.toString());
        array.enqueue("amogus");
        array.enqueue("sunshine");
        array.enqueue("kiba");
        assertEquals("[amogus, sunshine, kiba]", array.toString());
        
        array.dequeue();
        assertEquals("[sunshine, kiba]", array.toString());
    }
    /**
     * Test that clear cleared everything to 0
     */
    public void testClear() {
        array.enqueue("lala");
        array.enqueue("lala");
        array.enqueue("lala");
        array.enqueue("lala");
        assertEquals(4, array.getSize());
        array.clear();
        assertTrue(array.isEmpty());
    }
    
    

}
