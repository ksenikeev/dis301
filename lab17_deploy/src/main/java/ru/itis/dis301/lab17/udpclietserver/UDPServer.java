package ru.itis.dis301.lab17.udpclietserver;

import java.io.FileWriter;
import java.io.IOException;
import java.net.BindException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UDPServer {

    final static Logger logger = LogManager.getLogger(UDPServer.class);

    public static void main(String[] args) {

        logger.info("UDPIOServer - start");

        Thread stopServerHook = new Thread(() -> {
            try(FileWriter writer = new FileWriter("stop_marker.log")) {
                writer.write(new Date() + " - stop server");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Runtime.getRuntime().addShutdownHook(stopServerHook);

        try {
            DatagramSocket datagramSocket = new DatagramSocket(50000);
            byte[] buffer = new byte[1400];
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, 1400);
                datagramSocket.receive(packet);

                logger.info(new String(buffer, 0, packet.getLength())
                        + " packet length " + packet.getLength()
                        + " packet address " + packet.getAddress()
                        + " packet port " + packet.getPort()
                );

                //packet.
            }
            // datagramSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
