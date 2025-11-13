/**
 * ArrayList class implements dynamic array.
 * @param <T> the type of elements stored in the list
 */

public class ArrayList<T> implements List<T> {
    private T[] arr;
    private int count;

    public ArrayList(){
        arr = (T[]) new Object[10];
        count = 0;
    }

    /**
     * Inserts the element at the specified position.
     *
     * @param index  the position at which to insert
     * @param element the element to insert
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void add(int index, T element){
        if(index < 0 || index > count){
            throw new IndexOutOfBoundsException();
        }

        if(count == arr.length){
            T[] newArr = (T[]) new Object[arr.length * 2];
            for(int i = 0; i < arr.length; i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
        }

        for(int i = count - 1; i >= index; i--){
            arr[i + 1] = arr[i];
        }

        arr[index] = element;
        count ++;
    }

    /**
     * Adds the specified element to end of the list.
     *
     * @param element the element to append
     * @return {@code true} if added successfully
     */
    @Override
    public boolean add(T element) {
        if(count == arr.length){
            T[] newArr = (T[]) new Object[arr.length * 2];
            for(int i = 0; i < arr.length; i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[count] = element;
        count ++;
        return true;
    }

    /** Returns element at specific index
     *
     * @param index the index to get
     * @return the element at that index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public T get(int index){
        if(index < 0 || index > count){
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    /**
     * Removes element at the specified index.
     *
     * @param index the index to remove
     * @return the removed element
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public T remove(int index){
        if(index < 0 || index >= count){
            throw new IndexOutOfBoundsException();
        }

        T removed = arr[index];

        for(int i = index; i < count - 1; i++){
            arr[i] = arr[i + 1];
        }

        arr[count - 1] = null;
        count--;

        return removed;
    }

    /** Returns number of elements in the list
     * @return the size of the list
     * */
    @Override
    public int size() {
        return count;
    }

}
