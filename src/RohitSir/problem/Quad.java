package RohitSir.problem;

public abstract class Quad implements Shapes{
    @Override
    public int numberOfSize() {
        return 4;
    }

    @Override
    public String getName() {
        return "Quad";
    }

    public abstract double area();
}
