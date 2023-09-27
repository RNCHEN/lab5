package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList {
    // Write your implementation below with API documentation
    private SortedIntList sortedIntList; // Private instance for delegation
    private int totalAdded = 0; // To track the total number of elements added

    public DelegationSortedIntList() {
        sortedIntList = new SortedIntList();
    }

    @Override
    public boolean add(int value) {
        totalAdded++; // Increment the count
        return sortedIntList.add(value); // Delegate to the sortedIntList instance
    }

    @Override
    public boolean addAll(IntegerList list) {
        int[] elementsToAdd = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            elementsToAdd[i] = list.get(i);
        }

        totalAdded += elementsToAdd.length; // Increment the count by the number of elements added
        return sortedIntList.addAll(list); // Delegate to the sortedIntList instance
    }

    @Override
    public int get(int index) {
        return sortedIntList.get(index); // Delegate to the sortedIntList instance
    }

    @Override
    public boolean remove(int num) {
        return sortedIntList.remove(num); // Delegate to the sortedIntList instance
    }

    @Override
    public boolean removeAll(IntegerList list) {
        int[] elementsToRemove = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            elementsToRemove[i] = list.get(i);
        }

        return sortedIntList.removeAll(list); // Delegate to the sortedIntList instance
    }

    @Override
    public int size() {
        return sortedIntList.size(); // Delegate to the sortedIntList instance
    }

    // New method to get the total number of elements added
    public int getTotalAdded() {
        return totalAdded;
    }
}