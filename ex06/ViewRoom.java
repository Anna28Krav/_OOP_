package ex06;

import java.util.Arrays;
import java.util.Scanner;

public class ViewRoom implements View, Command {
    private int binaryLength;
    private int binaryWidth;
    private int binaryHeight;

    public ViewRoom() {
        getInputAndCalculate();
        CommandHistory.getInstance().add(this);
    }

    private void getInputAndCalculate() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть довжину у двійковому форматі: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Невірне введення. Будь ласка, введіть ціле число.");
            scanner.next();
        }
        this.binaryLength = scanner.nextInt();

        System.out.print("Введіть ширину у двійковому форматі: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Невірне введення. Будь ласка, введіть ціле число.");
            scanner.next();
        }
        this.binaryWidth = scanner.nextInt();

        System.out.print("Введіть висоту у двійковому форматі: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Невірне введення. Будь ласка, введіть ціле число.");
            scanner.next();
        }
        this.binaryHeight = scanner.nextInt();
    }

    @Override
    public void viewHeader() {
        System.out.println();
        System.out.println(" ┌────────────────┬────────────────┬────────────────┬──────────────────┐");
        System.out.println(" │ Довжина(двійк) │ Ширина (двійк) │ Висота (двійк) │Кількість одиниць │");
        System.out.println(" ├────────────────┼────────────────┼────────────────┼──────────────────┤");
    }

    @Override
    public void viewBody() {
        System.out.printf(" │ %17d │ %17d │ %17d │ %18d │%n", binaryLength, binaryWidth, binaryHeight, calculateCountOnes());
    }

    @Override
    public void viewFooter() {
        System.out.println(" └────────────────┴────────────────┴────────────────┴──────────────────┘");
    }

    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }

    public double calculateAverage() {
        Calculation calculation = new Calculation();
        int length = calculation.toDecimal(binaryLength);
        int width = calculation.toDecimal(binaryWidth);
        int height = calculation.toDecimal(binaryHeight);

        int perimeter = calculation.calculatePerimeter(length, width);
        return perimeter / 2.0;
    }

    public int calculateMinimum() {
        return Arrays.stream(new int[]{binaryLength, binaryWidth, binaryHeight}).min().orElse(0);
    }

    public int calculateMaximum() {
        return Arrays.stream(new int[]{binaryLength, binaryWidth, binaryHeight}).max().orElse(0);
    }

    public int calculateSum() {
        Calculation calculation = new Calculation();
        int length = calculation.toDecimal(binaryLength);
        int width = calculation.toDecimal(binaryWidth);
        int height = calculation.toDecimal(binaryHeight);

        return calculation.calculatePerimeter(length, width) + calculation.calculateArea(length, width) + calculation.calculateVolume(length, width, height);
    }

    private int calculateCountOnes() {
        Calculation calculation = new Calculation();
        int length = calculation.toDecimal(binaryLength);
        int width = calculation.toDecimal(binaryWidth);
        int height = calculation.toDecimal(binaryHeight);

        return Calculation.countOnesInBinary(length, width, height);
    }
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть команду (1 - ввести нові дані, інше - показати таблицю):");
        String command = scanner.nextLine();
        if (command.equals("1")) {
            Main.main(null);
            CommandHistory.getInstance().add(this);
        } else {
            CommandHistory.getInstance().add(this);
            viewShow();
        }
    }
    
    @Override
    public void undo() {
        this.binaryLength = 0;
        this.binaryWidth = 0;
        this.binaryHeight = 0;
        Main.main(null);
    }
}