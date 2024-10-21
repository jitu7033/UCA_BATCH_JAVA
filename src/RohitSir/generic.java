package RohitSir;

public class generic<K,V> {
    K key;
    V value;

    generic(K key, V value){
        this.key = key;
        this.value = value;
    }
    public static void main(String[] args) {
        generic<String , Integer>uca = new generic<>("a",10);
        System.out.println(uca.key + " "+ uca.value);
    }
}
