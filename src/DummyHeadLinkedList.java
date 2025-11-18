/**
 * DummyHeadLinkedList class implements linked list with dummyhead node.
 * @param <T> the type of elements stored in the list
 */
public class DummyHeadLinkedList<T> implements List<T>{

    /**
     * Constructs an empty list with a dummy head node.
     */
    public DummyHeadLinkedList(){
        head = new Node();
        head.next = null;
        count = 0;
    }

    private class Node{
        T data;
        Node next;

    }

    private int count;
    private Node head;


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
        Node current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }

        Node newNode = new Node();
        newNode.data = element;
        newNode.next = current.next;


        current.next = newNode;
        count++;
    }

    /**
     * Adds the specified element to end of the list.
     *
     * @param element the element to append
     * @return {@code true} if added successfully, {@code false} otherwise
     */
    @Override
    public boolean add(T element) {
        try{
            add(count, element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /** Returns element at specific index
     *
     * @param index the index to get
     * @return the element at that index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public T get(int index){
        if(index < 0 || index >= count){
            throw new IndexOutOfBoundsException();
        }

        Node current = head.next;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
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
        Node current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        Node removed = current.next;
        current.next = removed.next;

        count--;
        return removed.data;
    }

    /** Returns number of elements in the list
    * @return the size of the list
    * */
    @Override
    public int size() {
        return count;

    }
}
