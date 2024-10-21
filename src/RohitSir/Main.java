package RohitSir;

public class Main {
    int x;
    int airbags;

    Main(){

    }
    Main(int x, int airbags){
        this.x = x;
        this.airbags = airbags;
    }

    Main(Main copy){
        this.x = copy.x;
        this.x = copy.airbags;
    }
    public static void main(String[] args) {
       Main uca = new Main(10,20);
       Main uca1 = new Main(20,30);
       Main uca3 = new Main(uca);
        System.out.println(uca.x);
    }

}
