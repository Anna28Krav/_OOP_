package ex06;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ViewRoom viewRoom1 = new ViewRoom();
    

        // Створення потоків для паралельної обробки
        Thread thread1 = new Thread(() -> {
            System.out.println("---------------");
            System.out.println("Середнє значення периметрів: " + viewRoom1.calculateAverage());
            System.out.println("Мінімальне число: " + viewRoom1.calculateMinimum());
            System.out.println("Максимум число: " + viewRoom1.calculateMaximum());
            System.out.println("Сума периметрів: " + viewRoom1.calculateSum());

            System.out.println("---------------");
        });

        // Запуск потоків
        thread1.start();

        try {
            // Очікування завершення потоків
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean running = true;
        while (running) {
            System.out.println("\nМеню:");
            System.out.println("1. Відобразити таблицю");
            System.out.println("2. Повторити введення");
            System.out.println("3. Скасувати останнє введення");
            System.out.println("4. Вийти");

            System.out.print("Виберіть опцію: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    viewRoom1.viewShow();
                
                    break;
                case 2:
                    viewRoom1.execute();
                    break;
                case 3:
                    viewRoom1.undo();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Невідома опція. Спробуйте ще раз.");
            }
        }

        scanner.close();
    }
}
