package ex04;

/**
 * Конкретний створювач (Concrete Creator) у шаблоні проектування Factory Method.
 * Реалізує інтерфейс Viewable, надаючи метод getView(), який повертає новий об'єкт ViewCalculator.
 */
public class ViewableResult implements Viewable {
    /**
     * Метод, який повертає новий об'єкт класу ViewCalculator.
     *
     * @return новий об'єкт класу ViewCalculator
     */
    @Override
    public View getView() {
        return new ViewCalculator();
    }
}