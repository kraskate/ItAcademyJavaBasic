package homework8;

public class Garage<T extends Vehicle> {
    T transport;

    public Garage(T transport) {
        this.transport = transport;
    }
}

