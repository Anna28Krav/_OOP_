package ex02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Клас для демонстрації взаємодії з користувачем та використання методів тестування.
 */
public class RoomTesterDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double length, width, height;

        // Введення параметрів приміщення
        System.out.println("Введіть довжину:");
        length = Double.parseDouble(reader.readLine());

        System.out.println("Введіть ширину:");
        width = Double.parseDouble(reader.readLine());

        System.out.println("Введіть висоту:");
        height = Double.parseDouble(reader.readLine());

        // Виклик методів тестування
        double perimeter = RoomTester.testPerimeter(length, width);
        double area = RoomTester.testArea(length, width);
        double volume = RoomTester.testVolume(length, width, height);

        System.out.println("Результати тестування:");
        System.out.println("Периметр: " + perimeter);
        System.out.println("Площа: " + area);
        System.out.println("Об'єм: " + volume);
    }
}
