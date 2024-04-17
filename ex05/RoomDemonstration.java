package ex05;


import java.util.Scanner;

public class RoomDemonstration {

    public static void main(String[] args) {
        RoomSolutionFinder solutionFinder = new RoomSolutionFinder();
        RoomCalculation calculation = new RoomCalculation();
        Scanner scanner = new Scanner(System.in);

        int length = solutionFinder.findLength();
        int width = solutionFinder.findWidth();
        int height = solutionFinder.findHeight();

        int perimeter = calculation.calculatePerimeter(length, width);
        int area = calculation.calculateArea(length, width);
        int volume = calculation.calculateVolume(length, width, height);

        System.out.println("Розміри приміщення:");
        System.out.println("Довжина: " + length + ", Ширина: " + width + ", Висота: " + height);
        System.out.println("Периметр: " + perimeter);
        System.out.println("Площа: " + area);
        System.out.println("Об'єм: " + volume);
    }
}

