package homework7.task1;

public class WashingMachine extends LargeAppliances implements Electricity {

    protected double power;
    protected double cosf;

    public WashingMachine(double power, double cosf) {
        super(power, cosf);
    }

    @Override
    public String getname() {
        return "Стиральная машина ";
    }

}
