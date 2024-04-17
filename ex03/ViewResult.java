package ex03;


public class ViewResult implements View {
    
    private int perimeter;
    private int area;
    private int volume;
    
    // Конструктор та інші методи класу
    
    @Override
    public void viewHeader() {
        System.out.println("=== Результати обчислень ===");
    }
    
    @Override
    public void viewBody() {
        System.out.printf("Периметр: %d%n", perimeter);
        System.out.printf("Площа: %d%n", area);
        System.out.printf("Об'єм: %d%n", volume);
    }
    
    @Override
    public void viewFooter() {
        System.out.println("=== Кінець результатів ===");
    }
    
    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }
}
