package ru.itis.dis301.lab03;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponceContent {
    private String mimeType;
    private byte[] content;
}
