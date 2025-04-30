package ru.itis.dis301.market.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter@Setter
public class DeliveryDto {
    private UUID orderUid;
    private LocalDateTime dateSend;
    private LocalDateTime dateReceive;
}
