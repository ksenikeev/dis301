package ru.itis.dis301.lab15;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class WorkServerSocketChannel {
    public static void main(String[] args) {
        try {

            ServerSocketChannel ssc = ServerSocketChannel.open();
            //Привязываем канал к сокету
            ssc.socket().bind(new InetSocketAddress(5000));

            //ssc.configureBlocking(false);
            String responseMessage = "Привет от сервера! : " + ssc.socket().getLocalSocketAddress();
            ByteBuffer sendBuffer = ByteBuffer.wrap(responseMessage.getBytes());

            while (true) {
                //Слушаем и соединяемся ssc.accept()

                try (SocketChannel sc = ssc.accept()) {
                    System.out.println("Принято соединение от  " +
                            sc.socket().getRemoteSocketAddress());
                    ByteBuffer receivedBuffer = ByteBuffer.allocate(100);
                    sc.read(receivedBuffer);

                    receivedBuffer.flip();

                    System.out.println(receivedBuffer.limit());

                    String requestMessage =
                            new String(receivedBuffer.array(), 0, receivedBuffer.limit());
                    System.out.println(requestMessage);

                    sendBuffer.rewind();
                    sc.write(sendBuffer);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
