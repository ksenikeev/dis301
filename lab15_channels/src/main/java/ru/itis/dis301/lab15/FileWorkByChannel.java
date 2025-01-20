package ru.itis.dis301.lab15;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWorkByChannel {
    public static void main(String[] args) {

        Path path = Paths.get("NIO_channels.md");
        try (FileChannel fileChannel = FileChannel.open(path)) {

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            // Сбрасываем из канала данные в буфер
            fileChannel.read(buffer);

            buffer.flip();

            StringBuilder builder = new StringBuilder();

            while (buffer.hasRemaining()) {
                //System.out.println(buffer.limit());
                builder.append((char) buffer.get());
            }

            System.out.println(builder);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
