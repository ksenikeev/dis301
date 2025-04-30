package ru.itis.dis301.market.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter@Setter
public class PaymentDto {
    private UUID orderUid;
    private LocalDateTime dateTime;
    private Float cost;
    private String currency;
}
