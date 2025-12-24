package shukshin.streamPeople;

public class Person {
    private final String name;
    private final String number;

    public Person(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return name + ":" + number;
    }
}
