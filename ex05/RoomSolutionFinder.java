package ex05;


import java.util.Scanner;

public class RoomSolutionFinder {
    private Scanner scanner = new Scanner(System.in);

    public int findLength() {
        System.out.println("Введіть довжину приміщення: ");
        int length = scanner.nextInt();
        return length;
    }

    public int findWidth() {
        System.out.println("Введіть ширину приміщення: ");
        int width = scanner.nextInt();
        return width;
    }

    public int findHeight() {
        System.out.println("Введіть висоту приміщення: ");
        int height = scanner.nextInt();
        return height;
    }
}

