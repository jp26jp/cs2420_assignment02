/**
 * RollingList.java
 *
 * @author John R Perry
 * @version September 9, 2017
 */

package assignment02;

import java.util.NoSuchElementException;

public class RollingList
{
    // Fields
    float    relativeGrowthRate;
    int      absoluteGrowthRate;
    int      firstIndex;
    int      modificationCounter;
    int      indexCounter;
    double[] backingArray;

    // Constructor

    /**
     * Creates a new rolling array with no elements, a backing array of size 5,
     * and the specified growth rate. The growth rate parameters must ensure
     * that the backing array always grows when needed.
     *
     * @param relativeGrowthRate the growth rate multiplier
     * @param absoluteGrowthRate the growth rate constant
     * @throws IllegalArgumentException iff the growth rate does not ensure growth of the backing array
     */
    public RollingList(float relativeGrowthRate, int absoluteGrowthRate)
    {

        // Ensures array growth
        if (relativeGrowthRate <= 1 && absoluteGrowthRate <= 0)
            throw new IllegalArgumentException();

        this.relativeGrowthRate = relativeGrowthRate;
        this.absoluteGrowthRate = absoluteGrowthRate;

        this.backingArray = new double[5];
        this.modificationCounter = 0;
        this.indexCounter = 0;
        this.firstIndex = 0;
    }

    /**
     * This method ensures that the backing array has enough space to store some
     * number of elements (a desired capacity). Iff the backing array is too
     * small, this method creates a larger backing array and copies the list
     * elements into it. The larger backing array reference is then copied into the
     * backing array reference, and the capacity and first element locations are updated
     * to be correct.
     *
     * @param desiredCapacity the needed capacity of the backing array
     */
    private void ensureCapacity(int desiredCapacity)
    {

        int newArraySize = (int) Math.ceil((backingArray.length * relativeGrowthRate + absoluteGrowthRate));

        double[] newArray = new double[newArraySize];

        // Check to see if there is enough space
        if (backingArray.length < desiredCapacity)
        {
            // If new array is bigger than old array throw IllegalArgumentException.
            if (newArray.length <= backingArray.length)
                throw new IllegalArgumentException();

            // Pass items from old to new array
            for (int index = 0; index < backingArray.length; index++)
            {
                newArray[index] = getElement(index);
                modificationCounter++;
            }

            // Reset firstIndex
            firstIndex = 0;

            // Update backingArray
            backingArray = newArray;
        }
    }

    /**
     * Retrieves a value from the list.
     *
     * @param index the element to retrieve
     * @return the value of the specified element
     */
    public double getElement(int index)
    {
        // Throw error if element doesn't exist
        if (index < 0 || index >= indexCounter)
            throw new IndexOutOfBoundsException("Item does not exist");

        return backingArray[(index + firstIndex + backingArray.length) % backingArray.length];
    }

    /**
     * Changes an element's value in this list.
     *
     * @param index     the element to change
     * @param value the new value (any double) for this element
     */
    public void setElement(int index, double value)
    {
        if (index < 0 || index >= indexCounter)
            throw new IndexOutOfBoundsException("Item does not exist");

        backingArray[(index + firstIndex + backingArray.length) % backingArray.length] = value;
        modificationCounter++;
    }

    /**
     * Adds a value to the end of the list (increasing the element
     * count). The last entry is the entry with an element index of (length of
     * list) - 1.
     *
     * @param value any double
     */
    public void append(double value)
    {
        // Ensure there is enough space
        ensureCapacity(indexCounter + 1);

        // Increment the indexCounter
        indexCounter++;

        setElement(indexCounter - 1, value);
    }

    /**
     * Adds (inserts) a value before the first element in the list (increasing
     * the element count). The value becomes the first entry. The first entry is
     * the entry with an element index of 0.
     *
     * @param value any double
     */
    public void prepend(double value)
    {
        // Ensure there is enough space
        ensureCapacity(indexCounter + 1);

        // Decrement the firstIndex
        firstIndex--;

        // Increment the indexCounter
        indexCounter++;

        setElement(0, value);
    }

    /**
     * Removes the last entry in the list (decreasing the element count). The
     * last entry is the entry with an element index of (length of list) - 1.
     *
     * @throws NoSuchElementException if the list is empty prior to this call
     */
    public void removeLast()
    {
        if (indexCounter == 0)
            throw new NoSuchElementException("Item does not exist");

        // Decrement the indexCounter
        indexCounter--;

        // Increment modification counter
        modificationCounter++;
    }

    /**
     * Removes the first entry in the list (decreasing the element count). The
     * first entry is the entry with an element index of 0.
     *
     * @throws NoSuchElementException if the list is empty prior to this call
     */
    public void removeFirst()
    {
        if (indexCounter == 0)
            throw new NoSuchElementException("Item does not exist");

        // Reposition items in array
        for (int index = 0; index < indexCounter - 1; index++)
        {
            backingArray[index] = getElement(index + 1);
        }

        // Decrement the indexCounter
        indexCounter--;

        // Increment modification counter
        modificationCounter++;
    }

    /**
     * Returns the number of elements in this rolling list.
     *
     * @return the number of elements in this list
     */
    public int size()
    {
        return indexCounter;
    }

    /**
     * Clears (sets to 0) the array modification count.
     */
    public void resetArrayModificationCount()
    {
        modificationCounter = 0;
    }

    /**
     * Returns the array modification count.
     *
     * @return a count of the number of times the backing array has changed
     */
    public int getModificationCounter()
    {
        return modificationCounter;
    }

    /**
     * Returns the percentage of the backing array that is unused. Return values
     * will be between [0.0 and 1.0].
     *
     * @return the percentage of the backing array that is wasted space
     */
    public double wastedSpace()
    {
        double wastedSpace = 1 - ((double) indexCounter / (double) backingArray.length);
        return wastedSpace;
    }
}