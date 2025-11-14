/**
 * DoublyLinkedList class implements doubly linked list.
 * @param <T> the type of elements stored in the list
 */

public class DoublyLinkedList<T> implements List<T>{
    private int count;
    private Node<T> head;
    private Node<T> tail;


    private class Node<T>{
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T value){
            data = value;
            next = null;
            prev = null;
        }
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

        Node<T> newNode = new Node<>(element);

        if(count == 0){
            head = newNode;
            tail = newNode;
        } else if(index == 0){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if(index == count){
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            Node<T> current = head;
            for(int i = 0; i < index; i++){
                current = current.next;
            }
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
        }
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

        Node<T> current = head;
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
        Node<T> removed;

        if(index == 0){
            removed = head;
            head = head.next;
            if(head != null){
                head.prev = null;
            } else{
                tail = null;
            }
        } else {
            Node<T> current = head;
            for(int i = 0; i < index -1; i++){
                current = current.next;
            }
            removed = current.next;
            current.next = removed.next;

            if(removed.next != null){
                removed.next.prev = current;
            } else {
                tail = current;
            }
        }

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
