package RohitSir.problem;

public class Parallelogram extends Quad{
    int base;
    int height;
    Parallelogram(int base, int height){
        this.base = base;
        this.height = height;
    }
    @Override
    public double area() {
        return (base* height);
    }
    @Override
    public String getName() {
        return "Parallelogram";
    }
}
