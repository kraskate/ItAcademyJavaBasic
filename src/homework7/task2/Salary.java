package homework7.task2;

public class Salary extends DebetCard {

    @Override
    public String getName() {
        return "Зарплатная карта";
    }

    @Override
    public double addSum(int sum) {
        return super.addSum(sum);
    }

    @Override
    public double addSum(int sum, double percent) {
        return super.addSum(sum);
    }

}
