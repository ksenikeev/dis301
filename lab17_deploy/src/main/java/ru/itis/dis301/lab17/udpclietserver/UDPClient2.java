package ru.itis.dis301.lab17.udpclietserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient2 {
    public static void main(String[] args) {
        try {
            byte[] data = "Привет #4 UDP сервер!".getBytes();
            InetAddress address = InetAddress.getByName("194.67.84.100");
            DatagramPacket pack = new DatagramPacket(data, data.length, address, 50000);
            DatagramSocket ds = new DatagramSocket();
            ds.send(pack);
            ds.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
