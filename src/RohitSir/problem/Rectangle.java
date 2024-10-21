package RohitSir.problem;

public class Rectangle extends Quad {
    double length;
    double breath;
    Rectangle(int l, int b){
        length = l;
        breath = b;
    }

    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public double area() {
        return length * breath;
    }
}
