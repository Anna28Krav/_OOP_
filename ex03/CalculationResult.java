package ex03;

import java.io.*;

/**
 * Клас, який представляє результати обчислень і є серіалізованим.
 * Зберігає параметри та результати обчислень, а саме висоту, ширину та довжину приміщення,
 * а також обчислює площу, периметр та об'єм приміщення.
 */
public class CalculationResult implements Serializable {
    private static final long serialVersionUID = 1L;
    private int height;
    private int width;
    private int length;
    private int area;
    private int perimeter;
    private int volume;

    public CalculationResult(int height, int width, int length) {
        this.height = height;
        this.width = width;
        this.length = length;
        calculateArea();
        calculatePerimeter();
        calculateVolume();
    }

    private void calculateArea() {
        area = length * width;
    }

    private void calculatePerimeter() {
        perimeter = 2 * (length + width);
    }

    private void calculateVolume() {
        volume = length * width * height;
    }

    public void saveToFile(String fileName) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(this);
            System.out.println("Результати обчислень збережено у файл " + fileName);
        }
    }

    public static CalculationResult restoreFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (CalculationResult) in.readObject();
        }
    }

    @Override
    public String toString() {
        return "Висота: " + height + ", Ширина: " + width + ", Довжина: " + length +
               "\nПлоща: " + area + ", Периметр: " + perimeter + ", Об'єм: " + volume;
    }
}
