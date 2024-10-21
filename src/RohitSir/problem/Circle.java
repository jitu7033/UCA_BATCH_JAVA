package RohitSir.problem;

public class Circle implements Shapes {
    int radius;

    Circle(int a){
        radius = a;
    }
    public double area(){
        return (Math.PI * (radius * radius));
    }
    public int numberOfSize(){
        return 0;
    }
    @Override
    public String getName() {
        return "Circle";
    }
}
