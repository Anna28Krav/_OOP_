package ex03;

import java.io.IOException;

/**
 * Інтерфейс для фабрикуючого методу, що визначає метод для отримання об'єкта для відображення результатів обчислень.
 */
public interface Viewable {
    ViewResult getView();
}
