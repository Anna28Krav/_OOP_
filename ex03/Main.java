package ex03;

import java.io.*;
import java.util.Scanner;

/**
 * Клас для демонстрації в діалоговому режимі збереження та відновлення стану об'єкта серіалізації/десеріалізації
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть висоту приміщення: ");
        int height = scanner.nextInt();

        System.out.print("Введіть ширину приміщення: ");
        int width = scanner.nextInt();

        System.out.print("Введіть довжину приміщення: ");
        int length = scanner.nextInt();

        // Створюємо об'єкт класу CalculationResult
        CalculationResult result = new CalculationResult(height, width, length);

        // Створюємо об'єкт класу ViewableResult
        ViewableResult viewableResult = new ViewableResult();

        // Отримуємо об'єкт класу View за допомогою методу getView
        View view = viewableResult.getView();

        // Викликаємо метод viewShow для відображення результатів
        view.viewShow();

        try {
            // Зберігаємо результати обчислень
            result.saveToFile("calculation_result.ser");

            // Відновлюємо результати обчислень з файлу
            CalculationResult restoredResult = CalculationResult.restoreFromFile("calculation_result.ser");
            System.out.println("Відновлені результати: " + restoredResult);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
