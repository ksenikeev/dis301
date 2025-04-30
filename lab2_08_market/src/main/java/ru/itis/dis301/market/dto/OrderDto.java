package ru.itis.dis301.market.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Getter@Setter
public class OrderDto {
    private UUID uid;
    private UUID offerUid;
    private OrganizationDto organization;
    private LocalDateTime dateTime;
    private Float count;
    private Long status;
}
