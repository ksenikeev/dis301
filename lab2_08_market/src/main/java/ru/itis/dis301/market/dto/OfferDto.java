package ru.itis.dis301.market.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Getter@Setter
public class OfferDto {
    private UUID uid;
    private OrganizationDto organization;
    private MerchDto merch;
    private String description;
    private Float count;
    private Float price;
    private String currency;
    private LocalDateTime dateTime;
    private Map<String, String> properties;
}
