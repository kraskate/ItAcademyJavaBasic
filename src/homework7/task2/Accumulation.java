package homework7.task2;

public class Accumulation extends DebetCard {
    private double accum;

    @Override
    public String getName() {
        return "Накопительная карта";
    }

    @Override
    public double addSum(int sum, double percent) {
        System.out.println("Внесено: " + sum + " под " + percent + "% годовых");
        accum = (this.getAccount() + sum) + ((this.getAccount() + sum) * (percent / 100)) / 12;
        System.out.println("Накопления: " + accum);
        setAccount(accum);
        return accum;
    }
}
