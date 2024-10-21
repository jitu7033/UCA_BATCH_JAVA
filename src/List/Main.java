package List;

import java.util.*;

class List<T>{
    private Object[] elements;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public List(){
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }
    // Add an element to the list
    public void add(T element){
        ensureCapacity();
        elements[size++] = element;
    }

    // get an element by index
    public T get(int index){
        checkIndex(index);
        return (T) elements[index];
    }

    // remove an element by index
    public T remove(int index){
        checkIndex(index);
        T remove_element = (T) elements[index];
        for(int i = index; i < size-1; i++){
            elements[i] = elements[i+1];
        }
        elements[--size] = null;
        return remove_element;
    }

    // get current size of list
    public int  size(){
        return size;
    }

    // ensure that enough capacity or not
    private void ensureCapacity(){
        if(size >= elements.length){
            elements = Arrays.copyOf(elements,elements.length * 2);
        }
    }

    // check if index is  valid
    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index " + index +", Size " + size);
        }
    }

    // to string method displaying the list
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < size; i++){
            sb.append(elements[i]);
            if(i < size -1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
public class Main {
    public static void main(String[] args) {
        List<String>list = new List<String>();
        list.add("jitejd");
        list.add("jasdha");
        list.add("kumar ");

        System.out.println(list.get(9));

        System.out.println(list);
    }
}
