package ru.itis.dis301.lab12.list;

import ru.itis.dis301.lab12.model.Month;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Минимум, необходимый для реализации модели списка - получение размера и получение элемента по индексу
 */
public class MonthElementListModel extends AbstractListModel {

    private List<Month> months = new ArrayList<>();

    public MonthElementListModel(List<Month> months) {
        this.months = months;
    }

    @Override
    public int getSize() {
        return months.size();
    }

    @Override
    public Object getElementAt(int index) {
        return months.get(index);
    }
}
