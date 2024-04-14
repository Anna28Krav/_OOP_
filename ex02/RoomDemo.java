package ex02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Клас для демонстрації взаємодії з користувачем та використання серіалізації для збереження та відновлення стану об'єкта.
 */
public class RoomDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double length, width, height;

        // Введення параметрів приміщення
        System.out.println("Введіть довжину:");
        length = Double.parseDouble(reader.readLine());

        System.out.println("Введіть ширину:");
        width = Double.parseDouble(reader.readLine());

        System.out.println("Введіть висоту:");
        height = Double.parseDouble(reader.readLine());

        // Створення об'єкта RoomCalculator з введеними параметрами
        RoomCalculator calculator = new RoomCalculator(length, width, height);

        // Виведення результатів
        System.out.println("Периметр: " + calculator.getPerimeter());
        System.out.println("Площа: " + calculator.getArea());
        System.out.println("Об'єм: " + calculator.getVolume());
    }
}
