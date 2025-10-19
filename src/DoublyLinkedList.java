public class DoublyLinkedList<T> implements List<T>{
    private int count;

    @Override
    public void add(int index, T element){
        if(index < 0 || index > count){
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean add(T element) {

    }

    @Override
    public T get(int index){
        if(index < 0 || index > count){
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public T remove(int index){
        if(index < 0 || index > count){
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int size() {
        return count;

    }
}
