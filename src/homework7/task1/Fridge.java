package homework7.task1;

public class Fridge extends LargeAppliances {

    protected double power;
    protected double cosf;

    public Fridge(double power, double cosf) {
        super(power, cosf);
    }

    @Override
    public String getname() {
        return "Холодильник";
    }
}
