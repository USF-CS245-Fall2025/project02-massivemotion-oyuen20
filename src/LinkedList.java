public class LinkedList<T> implements List<T> {
    private class Node{
        T data;
        Node next;
        Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int count;


    @Override
    public void add(int index, T element){
        if(index < 0 || index > count){
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(element);
        if(index == 0){
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        count++;
    }

    @Override
    public boolean add(T element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        count++;
        return true;
    }

    @Override
    public T get(int index){
        if(index < 0 || index > count){
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }

    @Override
    public T remove(int index){
        if(index < 0 || index > count){
            throw new IndexOutOfBoundsException();
        }
        Node removed = null;
        if(index == 0){
            removed = head;
            head = head.next;
        } else {
            Node prev = head;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
                removed = prev.next;
                prev.next = removed.next;
            }
        }
        count--;
        return removed.data;
    }

    @Override
    public int size() {
        return count;
    }
}
