package homework7.task1;

public class SmallAppliances extends LargeAppliances {
    public SmallAppliances(double power, double cosf) {
        super(power, cosf);
    }

    @Override
    public String getname() {
        return "Мелкая бытовая техника";
    }
}
