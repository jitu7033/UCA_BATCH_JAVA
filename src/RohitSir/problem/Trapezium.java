package RohitSir.problem;

import java.awt.*;

public class Trapezium extends Quad{
    int b1;int b2;int h;
    Trapezium(int b1, int b2, int h) {
        this.b1 = b1;
        this.b2 = b2;
        this.h = h;
    }
    @Override
    public double area() {
        return (0.5 * ((b1 * b2 ) * h));
    }
    @Override
    public String getName() {
        return "Trapezium";
    }
}

