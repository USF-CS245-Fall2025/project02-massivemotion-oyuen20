/*
 * DoublyLinkedList class implements doubly linked list.
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


    /* Adds element at specific index */
    @Override
    public void add(int index, T element){
        if(index < 0 || index > count){
            throw new IndexOutOfBoundsException();
        }

        Node<T> newNode = new Node<>(element);

        if(count == 0){ // first element
            head = newNode;
            tail = newNode;
        } else if(index == 0){ //start of list
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if(index == count){ // end of list
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
    }

    @Override
    public boolean add(T element) {
        add(count, element);
        return true;
    }

    /* Returns element at specific index */
    @Override
    public T get(int index){
        if(index < 0 || index > count){
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }

    /* Removes element at specific index */
    @Override
    public T remove(int index){
        if(index < 0 || index >= count){
            throw new IndexOutOfBoundsException();
        }
        Node<T> removed = null;
        if(index == 0){
            removed = head;
            head = head.next;
            if(head != null){
                head.prev = null;
            } else{
                tail = null;
            }
        }
        return removed.data;
    }

    /* Returns number of elements in the list */
    @Override
    public int size() {
        return count;

    }
}
