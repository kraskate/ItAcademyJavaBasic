package homework7.task1;

public class Kettle extends SmallAppliances {
    public Kettle(double power, double cosf) {
        super(power, cosf);
    }

    @Override
    public String getname() {
        return "Чайник";
    }
}
