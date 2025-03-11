package ru.itis.dis301.lab17.udpclietserver.repeater;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashMap;

/**
 * Протокол:
 * Команда: 3 байта
 *  REG - регистрация (отправляется имя до 12 символов латиница, цифры, - )
 *  LST - список игроков (запрос списка игроков)
 *  SND - сообщение другому игроку (передается 12 символов получателя, затем сообщение)
 *  PNG - запрос сервера на подтверждение регистрации
 *
 */
public class PacketHandler {

    final static Logger logger = LogManager.getLogger(PacketHandler.class);

    private DatagramPacket packet;
    private HashMap<String, StoredClientConnection> clients;
    private DatagramSocket socket;

    public PacketHandler(DatagramPacket packet, HashMap<String, StoredClientConnection> clients, DatagramSocket socket) {
        this.packet = packet;
        this.clients = clients;
        this.socket = socket;
    }

    public void handle() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        String cmd = new String(packet.getData(), 0, 3);

        logger.debug("cmd = " + cmd);

        switch (cmd) {
            case "SND" : repitePacket(); break;
            case "REG" : regClient(); break;
            case "LST" : sendClients(); break;
        }
    }

    private void regClient() {
        int i = 0;
        while (packet.getData()[i + 3] > 0) {
            if (i == 12) break;
            i++;
        }
        String name = new String(packet.getData(), 3, i);

        logger.debug("reg client name: " + name + ", data: " + new String(packet.getData(), packet.getLength()));

        clients.put(name, new StoredClientConnection(name, packet.getAddress(), packet.getPort()));
    }

    private void sendClients() throws IOException {
        String clientNames = "LST";
        if (clients.size() > 0) {
            clientNames += clients.keySet().stream().reduce((a, s) -> a + ";" + s).get();
        }

        logger.debug("clients for send " + clientNames);

        byte[] data = clientNames.getBytes();
        DatagramPacket packetForSend = new DatagramPacket(data, data.length, packet.getAddress(), packet.getPort());
        socket.send(packetForSend);
    }

    private void repitePacket() throws IOException {
        int i = 0;
        while (packet.getData()[i + 3] > 0) {
            if (i == 12) break;
            i++;
        }
        String name = new String(packet.getData(), 3, i);

        StoredClientConnection connection = clients.get(name);

        if (connection != null) {
            byte[] data = new byte[packet.getLength() - 15];
            System.arraycopy(packet.getData(), 15, data, 0, data.length);
            DatagramPacket packetForSend =
                    new DatagramPacket(data, data.length, connection.getAddress(), connection.getPort());
            socket.send(packetForSend);
        }
    }
}
