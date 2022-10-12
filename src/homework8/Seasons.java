package homework8;

/*1. Создать enum, который описывает сезоны года. Добавить поле description в этот enum.
Добавить поле countOfDays в этот enum. Вывести на экран все константы сезоны года.
*/
public enum Seasons {
    WINTER("cold, snow, New Year", 90), SPRING("warm, flowers, Easter", 92),
    SUMMER("hot, green, holidays", 92), AUTUMN("cool, rain, Halloween", 91);

    private final int countOfDays;
    private final String description;

    Seasons(String description, int countOfDays) {
        this.countOfDays = countOfDays;
        this.description = description;
    }

    public int getCountOfDays() {
        return countOfDays;
    }

    public String getDescription() {
        return description;
    }

}
