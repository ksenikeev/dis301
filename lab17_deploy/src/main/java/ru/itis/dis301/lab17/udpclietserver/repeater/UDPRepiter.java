package ru.itis.dis301.lab17.udpclietserver.repeater;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;
import java.util.HashMap;


/**
 * Протокол:
 * Команда: 3 байта
 *  REG - регистрация (отправляется имя до 12 символов латиница, цифры, - )
 *  LST - список игроков (запрос списка игроков)
 *  SND - сообщение другому игроку (передается 12 символов получателя, затем сообщение)
 *
 */
public class UDPRepiter {

    final static Logger logger = LogManager.getLogger(UDPRepiter.class);


    public static void main(String[] args) {

        final HashMap<String, StoredClientConnection> clients = new HashMap<>();

        logger.info("UDPIOServer - start");

        Thread stopServerHook = new Thread(() -> {

        });

        Runtime.getRuntime().addShutdownHook(stopServerHook);

        try {
            DatagramSocket datagramSocket = new DatagramSocket(51000);

            byte[] buffer = new byte[1400];
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, 1400);
                datagramSocket.receive(packet);

                logger.info(new String(buffer, 0, packet.getLength())
                        + " packet length " + packet.getLength()
                        + " packet address " + packet.getAddress()
                        + " packet port " + packet.getPort()
                );

                try {
                    new PacketHandler(packet, clients, datagramSocket).handle();
                } catch (IOException e) {
                    logger.error(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
