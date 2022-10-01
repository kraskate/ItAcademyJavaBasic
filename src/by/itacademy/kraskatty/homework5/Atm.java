package by.itacademy.kraskatty.homework5;

public class Atm {
    /*2.
    Сделать метод, снимающий деньги.
    На экран – булевское значение (операция удалась или нет).
    При снятии денег метод должен выводить на экран каким количеством купюр и какого номинала выдается сумма.
    */

    private int banknote20;
    private int banknote50;
    private int banknote100;

    public Atm(int banknote100, int banknote50, int banknote20) { //конструктор
        this.banknote20 = banknote20;
        this.banknote50 = banknote50;
        this.banknote100 = banknote100;
    }

    public int getBanknote20() {
        return banknote20;
    }

    public void setBanknote20(int banknote20) {
        this.banknote20 = banknote20;
    }

    public int getBanknote50() {
        return banknote50;
    }

    public void setBanknote50(int banknote50) {
        this.banknote50 = banknote50;
    }

    public int getBanknote100() {
        return banknote100;
    }

    public void setBanknote100(int banknote100) {
        this.banknote100 = banknote100;
    }

    public void addBanknote(int bank100, int bank50, int bank20) { //метод, добавляющий деньги в банкомат
        this.banknote100 += bank100;
        this.banknote50 += bank50;
        this.banknote20 += bank20;
    }

    public boolean isSuccess(int sum) { //подбор банкнот для выдачи денег
        boolean result = false;
        if (sum > (banknote100 * 100 + banknote50 * 50 + banknote20 * 20)) {
            System.out.println("There are not enough funds in the ATM");
        } else {
            int b20 = 0;
            int b50 = 0;
            int b100 = 0;

            if (sum > 0) {
                if (sum % 100 == 10 || sum % 100 == 30) {
                    if (sum % 100 == 10) {
                        b50 = 1;
                        b20 = 3;
                        sum -= (b20 * 20 + b50 * 50);
                    }
                    if (sum % 100 == 30) {
                        b50 = 1;
                        b20 = 4;
                        sum -= (b20 * 20 + b50 * 50);
                    }
                }
                if (sum / 100 <= banknote100) {
                    b100 = sum / 100;
                    sum -= b100 * 100;
                } else {
                    sum -= banknote100 * 100;
                    b100 = banknote100;
                }
            }
            if (sum > 0) {
                if (sum % 50 == 10 || sum % 50 == 30) {
                    if (sum % 50 == 10) {
                        b20 = 3;
                        sum -= b20 * 20;
                    }
                    if (sum % 50 == 30) {
                        b20 = 4;
                        sum -= b20 * 20;
                    }
                }
                if (sum / 50 <= banknote50) {
                    b50 += sum / 50;
                    sum -= (sum / 50) * 50;
                } else {
                    sum -= banknote50 * 50;
                    b50 += banknote50;
                }
            }
            if (sum > 0) {
                if (sum / 20 <= banknote20) {
                    b20 += sum / 20;
                    sum -= (sum / 20) * 20;
                }
            }
            if (sum == 0) {
                result = true;
                printResult(b100, b50, b20);
            }

            setBanknote100(banknote100 - b100); //обновление остатков банкнота
            setBanknote50(banknote50 - b50);
            setBanknote20(banknote20 - b20);

        }
        return result;
    }


    public void printResult(int b100, int b50, int b20) { //вывод выданных банкнот
        if (b100 > 0) {
            System.out.println(b100 + " * banknote 100 ");
        }
        if (b50 > 0) {
            System.out.println(b50 + " * banknote 50 ");
        }
        if (b20 > 0) {
            System.out.println(b20 + " * banknote 20 ");
        }
    }

}
