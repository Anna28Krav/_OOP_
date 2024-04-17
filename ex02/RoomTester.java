package ex02;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class RoomTester implements Serializable {
    private static final long serialVersionUID = 1L;

    public static double testPerimeter(double length, double width) {
        RoomCalculator calculator = new RoomCalculator(length, width, 0.0);
        return calculator.getPerimeter();
    }

    public static double testArea(double length, double width) {
        RoomCalculator calculator = new RoomCalculator(length, width, 0.0);
        return calculator.getArea();
    }

    public static double testVolume(double length, double width, double height) {
        RoomCalculator calculator = new RoomCalculator(length, width, height);
        return calculator.getVolume();
    }

    public static RoomCalculator testSerialization(double length, double width, double height) {
        RoomCalculator calculator = new RoomCalculator(length, width, height);
        RoomCalculator deserializedCalculator = null;

        try {
            // Serialization
            ObjectOutputStream out = new ObjectOutputStream(System.out);
            out.writeObject(calculator);
            out.close();

            // Deserialization
            ObjectInputStream in = new ObjectInputStream(System.in);
            deserializedCalculator = (RoomCalculator) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return deserializedCalculator;
    }
}
