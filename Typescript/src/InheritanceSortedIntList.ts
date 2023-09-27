import { IntegerList } from './IntegerList.js';
import { SortedIntList } from './hidden/SortedIntListLibrary.js'

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

class InheritanceSortedIntList extends SortedIntList {
  // Write your implementation below with API documentation
  private totalAdded: number = 0; // To track the total number of elements added
  /**
     * Constructs an empty InheritanceSortedIntList.
     */
  constructor() {
    super(); // Call the constructor of the superclass (SortedIntList)
    this.totalAdded = 0; // Initialize the totalAdded counter
  }

  /**
   * Overrides the add method to track the total number of elements added.
   *
   * @param num The integer to be added to the list.
   * @returns True if the element was added successfully.
   */
  add(num: number): boolean {
    this.totalAdded++; // Increment the totalAdded counter
    return super.add(num); // Call the add method of the superclass
  }

  /**
   * Overrides the addAll method to track the total number of elements added.
   *
   * @param list The IntegerList containing elements to be added to the list.
   * @returns True if all elements were added successfully.
   */
  addAll(list: IntegerList): boolean {
    let success = true;

    for (let i = 0; i < list.size(); i++) {
      success &&= this.add(list.get(i)); // Call the overridden add method
    }

    return success;
  }

  /**
   * Gets the total number of elements added to the list.
   *
   * @returns The total number of elements added.
   */
  getTotalAdded(): number {
    return this.totalAdded;
  }

}

export { InheritanceSortedIntList }
