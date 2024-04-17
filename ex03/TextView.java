package ex03;

/**
 * Клас `TextView` реалізує інтерфейс `View` для відображення результатів обчислень у текстовому форматі.
 */
public class TextView implements View {
    @Override
    public void viewHeader() {
        System.out.println("Тут починається відображення результатів:");
    }

    @Override
    public void viewBody() {
        // Логіка для відображення тіла результатів
    }

    @Override
    public void viewFooter() {
        System.out.println("Тут закінчується відображення результатів.");
    }

    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }
}
