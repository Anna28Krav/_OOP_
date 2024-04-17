package ex04;

import java.util.Scanner;

/**
 * Клас, який представляє результати обчислень та забезпечує їх відображення.
 * Реалізує інтерфейс View для обчислення та відображення периметру, площі та об'єму приміщення за заданими параметрами.
 */
public class ViewCalculator implements View {
    private int length;
    private int width;
    private int height;
    private int perimeter;
    private int area;
    private int volume;
    
    /**
     * Конструктор класу, який отримує від користувача вхідні дані та обчислює периметр, площу та об'єм.
     */
    public ViewCalculator() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть довжину приміщення: ");
        this.length = scanner.nextInt();

        System.out.print("Введіть ширину приміщення: ");
        this.width = scanner.nextInt();

        System.out.print("Введіть висоту приміщення: ");
        this.height = scanner.nextInt();

        scanner.close();

        calculate();
    }
    
    /**
     * Метод для обчислення периметру, площі та об'єму приміщення.
     */
    private void calculate() {
        this.perimeter = 2 * (length + width);
        this.area = length * width;
        this.volume = length * width * height;
    }
    
    @Override
    public void viewHeader() {
        System.out.println();
        System.out.println(" ┌────────────┬──────────────┬───────────────┐");
        System.out.println(" │ Периметр   │ Площа        │ Об'єм         │");
        System.out.println(" ├────────────┼──────────────┼───────────────┤");
    }

    @Override
    public void viewBody() {
        System.out.printf(" │ %10d │ %12d │ %13d │%n", perimeter, area, volume);
    }

    @Override
    public void viewFooter() {
        System.out.println(" └────────────┴──────────────┴───────────────┘");
    }

    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }
}