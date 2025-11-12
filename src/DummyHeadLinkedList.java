/*
 * DummyHeadLinkedList class implements linked list with dummyhead node.
 */
public class DummyHeadLinkedList<T> implements List<T>{
    public DummyHeadLinkedList(){
        head = new Node();
        head.next = null;
        head.prev = null;
        count = 0;
    }

    private class Node{
        T data;
        Node prev;
        Node next;

    }

    private int count;
    private Node head;

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
        newNode.prev = current;

        if(current.next != null){
            current.next.prev = newNode;
        }
        current.next = newNode;
        count++;
    }

    @Override
    public boolean add(T element) {
        add(count, element);
        return true;

    }

    /* Returns element at specific index */
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

    /* Removes element at specific index */
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

    /* Returns number of elements in the list */
    @Override
    public int size() {
        return count;

    }
}
