package RohitSir.problem;

public class Triangle implements Shapes{
    int base;int height;

    Triangle(int a, int b){
        base = a;
        height = b;
    }
    public double area(){
        return (0.5 * (base * height));
    }

    @Override
    public int numberOfSize() {
        return 3;
    }

    @Override
    public String getName() {
        return "Triangle";
    }
}
