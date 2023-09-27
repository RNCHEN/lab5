package edu.cmu.cs.cs214.rec04;
import java.util.ArrayList;
import java.util.List;
public class SortedIntList extends AbstractIntList{
    private List<Integer> elements;

    public SortedIntList() {
        elements = new ArrayList<>();
    }

    @Override
    public boolean add(int value) {
        int index = 0;
        while (index < elements.size() && elements.get(index) < value) {
            index++;
        }
        elements.add(index, value);
        return true; // always returns true because the list is never full
    }
    @Override
    public boolean addAll(IntegerList list) {

        boolean success = false;

        for (int i = 0; i < list.size(); i++)
        {
            success |= this.add(list.get(i));
        }

        return success;
    }
    @Override
    public int get(int index) {
        if (index < 0 || index >= elements.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return elements.get(index);
    }

    @Override
    public boolean remove(int num) {
        boolean removed = elements.remove((Integer) num); // remove the first occurrence of num
        return removed;
    }

    @Override
    public boolean removeAll(IntegerList list) {
        List<Integer> toRemove = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            toRemove.add(list.get(i));
        }
        boolean success = elements.removeAll(toRemove);
        return success; // returns true if any elements were removed
    }

    @Override
    public int size() {
        return elements.size();
    }
}
