package ru.itis.dis301.lab16;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletebleFutereComposeTest {
    public static void main(String[] args) throws Exception {
        CompletebleFutereComposeTest  test = new CompletebleFutereComposeTest();
        test.process();

    }

    public void process() throws Exception {
        CompletableFuture<String> result = getUsersDetail("userId")
                .thenCompose(user -> getCreditRating(user));

        CompletableFuture<Void> greetingFuture =
                result.thenAccept(d -> System.out.println(d));

        // Block and wait for the future to complete
        System.out.println(Thread.currentThread().getName()+" "+greetingFuture.get());

    }

    public static String getUserDetails(String userId) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Kamil";
    }

    public static String getCreditRatings(String user) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "1000";
    }

    CompletableFuture<String> getUsersDetail(String userId) {
        return CompletableFuture.supplyAsync(() -> {
            return getUserDetails(userId);
        });
    }

    CompletableFuture<String> getCreditRating(String user) {
        return CompletableFuture.supplyAsync(() -> {
            return getCreditRatings(user);
        });
    }

}
