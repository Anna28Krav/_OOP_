package ex02;


import java.io.Serializable;

/**
 * Клас для зберігання параметрів приміщення.
 */
public class RoomParams implements Serializable {
    private static final long serialVersionUID = 1L;

    private double length;
    private double width;
    private double height;

    public RoomParams(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Length: " + length + ", Width: " + width + ", Height: " + height;
    }
}
