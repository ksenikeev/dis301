package ru.itis.dis301.lab2_03.component;

public class AbonentImpl implements Abonent {

    private String name;

    private Phone phone;

    public AbonentImpl(String name, Phone phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public Phone getPhone() {
        return null;
    }

    @Override
    public String toString() {
        return "AbonentImpl{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                '}';
    }
}
