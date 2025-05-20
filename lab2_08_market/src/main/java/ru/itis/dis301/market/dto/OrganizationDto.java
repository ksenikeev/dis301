package ru.itis.dis301.market.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter@Setter
public class OrganizationDto {
    private UUID uid;
    private String name;
    private String nameLat;
    private String country;
}
