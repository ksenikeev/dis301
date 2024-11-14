package ru.itis.dis301.lab03;

import java.util.Map;

public interface IResourceHandler {
    ResponceContent handle(Map<String, String> params);
}
