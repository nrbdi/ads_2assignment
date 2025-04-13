public interface MyList<T> extends Iterable<T> {
    void add(T item);  // Adds an item to the end of the list
    void set(int index, T item); // Sets the item at the given index
    void add(int index, T item); // Adds an item at a specific index
    void addFirst(T item);  // Adds an item to the beginning of the list
    void addLast(T item);  // Adds an item to the end of the list
    T get(int index);  // Returns the item at the specified index
    T getFirst();
    T getLast();
    void remove(int index);  // Removes the item at the given index
    void removeFirst();
    void removeLast();
    void sort();
    int indexOf(Object object);  // Returns the index of the first occurrence of the object
    int lastIndexOf(Object object); // Returns the index of the last occurrence of the object
    boolean exists(Object object);// Checks whether the list contains the given object
    Object[] toArray();// Converts the list to an array
    void clear();   // Removes all elements from the list
    int size();// Returns the number of elements in the list
}
