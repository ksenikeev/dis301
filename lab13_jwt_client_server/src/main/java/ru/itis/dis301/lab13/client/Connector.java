package ru.itis.dis301.lab13.client;

public class Connector {

    private boolean isConnected = false;

    private ClientContext context;

    public Connector(ClientContext context) {
        this.context = context;
    }
}
