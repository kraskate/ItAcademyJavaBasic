package homework7.task1;

public class LargeAppliances extends Appliances implements Electricity {
    protected double power;
    protected double cosf;

    protected boolean isPlugIn;

    public LargeAppliances(double power, double cosf) {
        this.power = power;
        this.cosf = cosf;
    }

    public void calculateCurrent() {
        System.out.println("I = " + power / (voltage * cosf));
    }

    @Override
    public void plugIn() {
        this.isPlugIn = true;
    }

    @Override
    public void unPlag() {
        this.isPlugIn = false;
    }

    @Override
    public boolean printState() {
        System.out.print(getname() + " включен(а) в розетку: " + isPlugIn);
        System.out.println();
        return isPlugIn;
    }

    @Override
    public String getname() {
        return "Крупная бытовая техника";
    }
}
