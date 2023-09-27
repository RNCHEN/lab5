/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

import { IntegerList } from "./IntegerList";
import { SortedIntLinkedList } from "./hidden/SortedIntListLibrary";

class DelegationSortedIntList implements IntegerList{
  // Write your implementation below with API documentatioin
  private sortedList: IntegerList; 
  private totalAdded: number = 0; // To track the total number of elements added
  constructor() {
    this.sortedList = new SortedIntLinkedList(); // Initialize the sortedList
  }

  /**
   * Adds the specified integer to the list.
   *
   * @param num An integer to be added to the list.
   * @returns True if the element was added successfully.
   */
  add(num: number): boolean {
    this.totalAdded++; // Increment the totalAdded counter
    return this.sortedList.add(num); // 委托给 sortedList 的 add 方法
  }

  /**
   * Adds all elements from another IntegerList to the list.
   *
   * @param list IntegerList containing elements to be added to the list.
   * @returns True if all elements were added successfully.
   */
  addAll(list: IntegerList): boolean {
    this.totalAdded = this.totalAdded + list.size(); // Increment the totalAdded counter
    return this.sortedList.addAll(list); // 委托给 sortedList 的 addAll 方法
  }

  /**
   * Gets the integer at the specified position in the list.
   *
   * @param index Index of the element to return.
   * @returns The element at the specified position.
   */
  get(index: number): number {
    return this.sortedList.get(index); // 委托给 sortedList 的 get 方法
  }

  /**
   * Removes the first occurrence of the specified integer from the list, if it is present.
   *
   * @param num An integer to be removed from the list, if present.
   * @returns True if an element was removed as a result of this call.
   */
  remove(num: number): boolean {
    return this.sortedList.remove(num); // 委托给 sortedList 的 remove 方法
  }

  /**
   * Removes from the list all elements that are contained in another IntegerList.
   *
   * @param list IntegerList containing elements to be removed from the list.
   * @returns True if the list changed as a result of the call.
   */
  removeAll(list: IntegerList): boolean {
    return this.sortedList.removeAll(list); // 委托给 sortedList 的 removeAll 方法
  }

  /**
   * Returns the number of elements in the list.
   *
   * @returns Number of elements in the list.
   */
  size(): number {
    return this.sortedList.size(); // 委托给 sortedList 的 size 方法
  }

  getTotalAdded(): number {
    return this.totalAdded;
  }
}

export { DelegationSortedIntList }
