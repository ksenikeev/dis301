package ru.itis.dis301.lab15;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;

public class WorkClientSocketChannel {
    public static void main(String[] args) {
        try (SocketChannel sc = SocketChannel.open()) {
            sc.configureBlocking(true);
            sc.connect(new InetSocketAddress("localhost", 5000));

            String requestMessage = "Привет от клиента! " ;
            ByteBuffer buffer = ByteBuffer.wrap(requestMessage.getBytes());
            sc.write(buffer);

            ByteBuffer receivedBuffer = ByteBuffer.allocate(100);
            //Приложение останавливается в ожидании ответа
            sc.read(receivedBuffer);
            String responseMessage = new String(receivedBuffer.array());
            System.out.println(responseMessage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
