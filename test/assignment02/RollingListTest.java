/**
 * RollingListTest.java
 *
 * @author  John R Perry
 * @version September 9, 2017
 */

package assignment02;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class RollingListTest {

    RollingList list;

    @Before
    public void setUp() throws Exception
    {
        list = new RollingList(2f,0);
    }

    @Test
    public void testPrepend(){
        list.prepend(1);
        assertEquals(1, list.size());
        list.prepend(1);
        assertEquals(2, list.size());
    }

    @Test
    public void testRemove(){
        list.prepend(1);
        list.prepend(1);
        list.removeFirst();
        assertEquals(1, list.size());
        list.removeLast();
        assertEquals(0, list.size());
    }

    @Test
    public void testAppend(){
        list.append(1);
        assertEquals(1, list.size());
        list.append(1);
        assertEquals(2, list.size());
    }

    @Test
    public void testModificationCount(){
        list.append(1);
        list.append(1);
        list.append(1);
        list.append(1);
        assertEquals(list.getModificationCounter(), 4);
        list.removeLast();
        list.removeLast();
        assertEquals(list.getModificationCounter(), 2);
        list.resetArrayModificationCount();
        assertEquals(list.getModificationCounter(), 0);
    }

    @Test
    public void testWastedSpace(){
        assertEquals(list.wastedSpace(),1,0);
        list.append(2);
        assertEquals(list.wastedSpace(),0.8,0);
    }

    @Test
    public void testEnsureCapacity(){
        for(int i = 0; i < 5; i++){
            list.append(i*1.0);
        }
        assertEquals(0.0,list.wastedSpace(),0);
        assertEquals(5,list.size());
        // Known that the initial arrayCapacity is 5.
        // With relativeGrowthRate of 2.0, the next arrayCapacity will be 10.
        list.prepend(2);
        assertEquals(6, list.size());
        assertEquals(4, list.getElement(list.size()-1),0);
        assertEquals(2, list.getElement(0),0);
        assertEquals(list.wastedSpace(),(10-6)/(1.0*10),0);
    }

    @Test
    public void testSetElement(){
        RollingList myList = new RollingList(1.0002f,10);
        for(int i = 0; i < 10_000; i++){
            myList.append(i*1.0);
        }
        myList.setElement(100,1.0*(-100));
        for(int i = 0; i< 10_000; i++){
            if(i==100){
                assertTrue(myList.getElement(i)==1.0*(-100));
            }
            else{
                assertTrue(myList.getElement(i)==1.0*i);
            }
        }
    }


    @Test(expected=NoSuchElementException.class)
    public void testRemoveFirstException() {
        RollingList emptyList = new RollingList(1.2f,1);
        emptyList.removeFirst();
    }

    @Test(expected=NoSuchElementException.class)
    public void testRemoveLastException(){
        RollingList emptyList = new RollingList(3f,1);
        emptyList.removeLast();
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetElementException(){
        RollingList emptyList = new RollingList(2f,0);
        emptyList.getElement(0);
        emptyList.getElement(1);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testSetElementException(){
        RollingList emptyList = new RollingList(1f,2);
        emptyList.setElement(0, 1.0);
        emptyList.setElement(1, 2.0);
    }


}