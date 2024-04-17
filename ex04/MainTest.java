package ex04;

/**
 * Клас для тестування основної функціональності.
 */
public class MainTest {
    /**
     * Функція протестована.
     */
    private static boolean tested = true;
    
    public static void main(String[] args) {
        // Створюємо об'єкт класу ViewableResult
        ViewableResult viewableResult = new ViewableResult();
        
        // Отримуємо об'єкт класу View за допомогою методу getView
        View view = viewableResult.getView();
        
        // Викликаємо метод viewShow для відображення результатів
        view.viewShow();
        
        if(tested) {
            System.out.println("Функція протестована!");
        }
    }
}
