package ru.itis.dis301.market.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter@Setter
public class MerchDto {
    private UUID uid;
    private Long categoty;
    private String name;
    private Long unit;
}
