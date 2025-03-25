package ru.itis.dis301.lab2_03.component;

public class PhoneImpl implements Phone {

    private String number;

    private String countryCode;

    public PhoneImpl(String number, String countryCode) {
        this.number = number;
        this.countryCode = countryCode;
    }

    @Override
    public String getNumber() {
        return "";
    }

    @Override
    public String getCountryCode() {
        return "";
    }

    @Override
    public String toString() {
        return "PhoneImpl{" +
                "number='" + number + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
