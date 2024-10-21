package RohitSir.inheritance;


class A{
    int val;

    A(int def){
        val = def;
    }
}
public class Main  extends A{

    Main(){
        super(30);
    }
    public static void main(String[] args) {
        Main c = new Main();
//        c.val = 20;
        System.out.println(c.val);
    }
}
