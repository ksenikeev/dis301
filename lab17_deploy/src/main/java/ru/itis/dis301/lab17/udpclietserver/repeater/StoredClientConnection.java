package ru.itis.dis301.lab17.udpclietserver.repeater;

import lombok.Getter;

import java.net.InetAddress;

@Getter
public class StoredClientConnection {
    private String clientId;
    private InetAddress address;
    private int port;

    public StoredClientConnection(String clientId, InetAddress address, int port) {
        this.clientId = clientId;
        this.address = address;
        this.port = port;
    }
}
