package homework7.task2;

public abstract class DebetCard extends Card {

    private double rest;

    @Override
    public String getName() {
        return "Дебетовая карта";
    }

    public double addSum(int sum) {
        rest = this.getAccount() + sum;
        System.out.println("Внесено: " + sum + "\nОстаток: " + rest);
        setAccount(rest);
        return (rest);
    }

    protected abstract double addSum(int sum, double percent);
}
