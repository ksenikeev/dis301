package ru.itis.dis301.lab15;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileWorkByChannel2 {
    public static void main(String[] args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("NIO_channels.md", "rw");
                         FileChannel channel = randomAccessFile.getChannel()) {
            System.out.println(channel.size());
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());

            StringBuilder builder = new StringBuilder();

            channel.read(byteBuffer);

            byteBuffer.flip();

            while (byteBuffer.hasRemaining()) {
                builder.append((char) byteBuffer.get());
            }

            System.out.println(builder);

            String someText = "Hello, Amigo!!!!!";

            ByteBuffer byteBuffer2 = ByteBuffer.allocate(someText.getBytes().length);

            byteBuffer2.put(someText.getBytes());


            byteBuffer2.flip();

            channel.write(byteBuffer2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
