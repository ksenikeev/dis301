package ru.itis.dis301.market.dto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class DictCurrencyDto {
    private Long id;
    private String name;
    private String code;
    private String country; // код страны RUS
    private Float price;
}
