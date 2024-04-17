package ex05;


import java.io.*;
import java.util.Scanner;

public class RoomCalculatorTest {

    public static void main(String[] args) {
        RoomSolutionFinder solutionFinder = new RoomSolutionFinder();
        RoomCalculation calculation = new RoomCalculation();
        Scanner scanner = new Scanner(System.in);
        int choice;
        int currentLength = 0;
        int currentWidth = 0;
        int currentHeight = 0;
        int previousLength = 0;
        int previousWidth = 0;
        int previousHeight = 0;
        int perimeter = 0;
        int area = 0;
        int volume = 0;

        do {
            System.out.println("___________________________________________________________");
            System.out.println("Меню:");
            System.out.println("1. Ввести нові розміри приміщення.");
            System.out.println("2. Відобразити результати (периметр, площа, об'єм).");
            System.out.println("3. Зберегти результати.");
            System.out.println("4. Відновити результати.");
            System.out.println("5. Нове введення розмірів приміщення.");
            System.out.println("6. Скасувати останнє введення розмірів.");
            System.out.println("7. Вийти.");
            System.out.println("___________________________________________________________");
            System.out.println("Виберіть опцію: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    previousLength = currentLength;
                    previousWidth = currentWidth;
                    previousHeight = currentHeight;
                    currentLength = solutionFinder.findLength();
                    currentWidth = solutionFinder.findWidth();
                    currentHeight = solutionFinder.findHeight();
                    break;
                case 2:
                    if (currentLength != 0 && currentWidth != 0 && currentHeight != 0) {
                        perimeter = calculation.calculatePerimeter(currentLength, currentWidth);
                        area = calculation.calculateArea(currentLength, currentWidth);
                        volume = calculation.calculateVolume(currentLength, currentWidth, currentHeight);
                        System.out.println("Результати для приміщення з розмірами:");
                        System.out.println("Довжина: " + currentLength + ", Ширина: " + currentWidth + ", Висота: " + currentHeight);
                        System.out.println("Периметр: " + perimeter);
                        System.out.println("Площа: " + area);
                        System.out.println("Об'єм: " + volume);
                    } else {
                        System.out.println("Спочатку введіть розміри приміщення.");
                    }
                    break;
                case 3:
                    saveResults(currentLength, currentWidth, currentHeight, perimeter, area, volume);
                    System.out.println("Результати збережено.");
                    break;
                case 4:
                    int[] restoredData = restoreResults();
                    if (restoredData != null) {
                        currentLength = restoredData[0];
                        currentWidth = restoredData[1];
                        currentHeight = restoredData[2];
                        perimeter = calculation.calculatePerimeter(currentLength, currentWidth);
                        area = calculation.calculateArea(currentLength, currentWidth);
                        volume = calculation.calculateVolume(currentLength, currentWidth, currentHeight);
                        System.out.println("Результати відновлено.");
                        System.out.println("Розміри приміщення:");
                        System.out.println("Довжина: " + currentLength + ", Ширина: " + currentWidth + ", Висота: " + currentHeight);
                        System.out.println("Периметр: " + perimeter);
                        System.out.println("Площа: " + area);
                        System.out.println("Об'єм: " + volume);
                    } else {
                        System.out.println("Немає збережених результатів.");
                    }
                    break;
                case 5:
                    previousLength = currentLength;
                    previousWidth = currentWidth;
                    previousHeight = currentHeight;
                    currentLength = solutionFinder.findLength();
                    currentWidth = solutionFinder.findWidth();
                    currentHeight = solutionFinder.findHeight();
                    break;
                case 6:
                    currentLength = previousLength;
                    currentWidth = previousWidth;
                    currentHeight = previousHeight;
                    previousLength = 0;
                    previousWidth = 0;
                    previousHeight = 0;
                    System.out.println("Останнє введення скасовано.");
                    break;
                case 7:
                    System.out.println("Програма завершує роботу.");
                    break;
                default:
                    System.out.println("Некоректний вибір. Спробуйте ще раз.");
            }
        } while (choice != 7);
    }

    private static void saveResults(int length, int width, int height, int perimeter, int area, int volume) {
        try (PrintWriter writer = new PrintWriter("room_results.txt")) {
            writer.println(length);
            writer.println(width);
            writer.println(height);
            writer.println(perimeter);
            writer.println(area);
            writer.println(volume);
        } catch (IOException e) {
            System.err.println("Помилка при збереженні результатів: " + e.getMessage());
        }
    }

    private static int[] restoreResults() {
        try (BufferedReader reader = new BufferedReader(new FileReader("room_results.txt"))) {
            int length = Integer.parseInt(reader.readLine());
            int width = Integer.parseInt(reader.readLine());
            int height = Integer.parseInt(reader.readLine());
            int perimeter = Integer.parseInt(reader.readLine());
            int area = Integer.parseInt(reader.readLine());
            int volume = Integer.parseInt(reader.readLine());
            return new int[]{length, width, height, perimeter, area, volume};
        } catch (IOException | NumberFormatException e) {
            System.err.println("Помилка при відновленні результатів: " + e.getMessage());
            return null;
        }
    }
}
