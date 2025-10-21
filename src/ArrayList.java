/*
 * ArrayList class implements dynamic array.
 */

public class ArrayList<T> implements List<T> {
    private T[] arr;
    private int count;

    public ArrayList(){
        arr = (T[]) new Object[10];
        count = 0;
    }

    /* Adds element at specific index */
    @Override
    public void add(int index, T element){
        if(index < 0 || index > count){
            throw new IndexOutOfBoundsException();
        }

        // Resize array if needed
        if(count == arr.length){
            T[] newArr = (T[]) new Object[arr.length * 2];
            for(int i = 0; i < arr.length; i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
        }

        // Shift elements
        for(int i = count - 1; i >= index; i--){
            arr[i + 1] = arr[i];
        }

        arr[index] = element;
        count ++;
    }

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

    /* Returns element at specific index */
    @Override
    public T get(int index){
        if(index < 0 || index > count){
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    /* Removes element at specific index */
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

    /* Returns number of elements in the list */
    @Override
    public int size() {
        return count;
    }

}
