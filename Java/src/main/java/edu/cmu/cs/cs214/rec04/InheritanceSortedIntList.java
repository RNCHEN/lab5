package edu.cmu.cs.cs214.rec04;

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class InheritanceSortedIntList extends SortedIntList{
    // Write your implementation below with API documentation
      private int totalAdded = 0; // To track the total number of elements added

    // Constructor to call the superclass constructor
    public InheritanceSortedIntList() {
        super();
    }

    // Override the add method to track the number of elements added
    @Override
    public boolean add(int value) {
        totalAdded++; // Increment the count
        return super.add(value); // Call the superclass's add method
    }

    // Override the addAll method to track the number of elements added
    @Override
    public boolean addAll(IntegerList list) {
        return super.addAll(list); // Call the superclass's addAll method
    }

    // New method to get the total number of elements added
    public int getTotalAdded() {
        return totalAdded;
    }




}