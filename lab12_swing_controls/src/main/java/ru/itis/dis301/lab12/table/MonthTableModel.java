package ru.itis.dis301.lab12.table;

import ru.itis.dis301.lab12.model.Month;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;
import java.util.List;

public class MonthTableModel extends AbstractTableModel {

    private List<Month> monthList = Arrays.asList(new Month[]{
            new Month("Январь", "Зима"),
            new Month("Февраль","Зима"),
            new Month("Март","Весна"),
            new Month("Апрель","Весна"),
            new Month("Май","Весна"),
            new Month("Июнь","Лето"),
            new Month("Июль","Лето"),
            new Month("Август","Лето"),
            new Month("Сентябрь","Осень"),
            new Month("Октябрь","Осень"),
            new Month("Ноябрь","Осень"),
            new Month("Декабрь","Зима")
    });


    @Override
    public int getRowCount() {
        return monthList.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    public Class getColumnClass(int column) {
        return String.class;
    }

    public String getColumnName(int column) {
        return switch (column) {
            case 0: yield "Месяц";
            case 1: yield "Сезон";
            default: yield "-";
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0: yield monthList.get(rowIndex).getName();
            case 1: yield monthList.get(rowIndex).getSeason();
            default: yield "-";
        };
    }
}
