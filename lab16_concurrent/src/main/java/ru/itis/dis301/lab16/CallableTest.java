package ru.itis.dis301.lab16;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws Exception {
        Callable<String> task = () -> {
            Thread.sleep(3000);
          return "Task result as String";
        };

        FutureTask<String> future = new FutureTask<>(task);
        new Thread(future).start();
        System.out.println(future.get());
        System.out.println(future.state());
    }
}
