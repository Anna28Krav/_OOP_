package ex04;

import java.util.Scanner;

/**
 * Клас `Main` для демонстрації роботи програми.
 */
public class Main {
    /**
     * Головний метод програми.
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        ViewableResult viewableResult = new ViewableResult();
        View view = viewableResult.getView();
        view.viewShow();
    }
}
