package ex02;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Клас для обчислення периметру, площі та об'єму приміщення на основі параметрів.
 */
public class RoomCalculator implements Serializable {
    private static final long serialVersionUID = 1L;

    private transient RoomParams params; // transient поле, не серіалізується

    public RoomCalculator(double length, double width, double height) {
        this.params = new RoomParams(length, width, height);
    }

    public double getPerimeter() {
        return 2 * (params.getLength() + params.getWidth());
    }

    public double getArea() {
        return params.getLength() * params.getWidth();
    }

    public double getVolume() {
        return params.getLength() * params.getWidth() * params.getHeight();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeDouble(params.getLength());
        out.writeDouble(params.getWidth());
        out.writeDouble(params.getHeight());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        double length = in.readDouble();
        double width = in.readDouble();
        double height = in.readDouble();
        this.params = new RoomParams(length, width, height);
    }
}
