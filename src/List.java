/**
 * The {@code List} interface defines ordered elements
 * that can be accessed, inserted, and removed by index.
 * It also supports retrieval and removal of elements.
 *
 *
 * @param <T> the type of elements stored in the list
 */
public interface List<T> {

    /**
     * Inserts the element at the specified position
     *
     * @param index the position to insert the element at
     * @param element the element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void add (int index, T element);

    /**
     * Adds the specified element to the end of this list.
     *
     * @param element the element to be added
     * @return {@code true} if the element was successfully added
     */
    public boolean add (T element);

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index the index of the element to return
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T get (int index);

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     * @return the element that was removed
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T remove (int index);
    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in the list
     */
    public int size ();
}
