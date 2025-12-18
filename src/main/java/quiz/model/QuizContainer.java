package quiz.model;

import java.util.ArrayList;
import java.util.List;

public class QuizContainer<T> {

    private List<T> items = new ArrayList<>();

    public QuizContainer() {
    }

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}
