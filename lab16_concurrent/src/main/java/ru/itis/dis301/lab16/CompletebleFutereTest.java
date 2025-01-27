package ru.itis.dis301.lab16;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletebleFutereTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Supplier<Double> task1 = new PartTask(-10d, -9d);
        Supplier<Double> task2 = new PartTask(-9d, -8d);

        CompletableFuture<Double> integral1 = CompletableFuture.supplyAsync(task1);
        CompletableFuture<Double> integral2 = CompletableFuture.supplyAsync(task2);

        CompletableFuture<Double> integral =
                integral1.thenCombine(integral2, (i1, i2) -> {
                    return i1 + i2;
                });

        //CompletableFuture<Double> greetingFuture = integral.thenApply(d -> d);

        CompletableFuture<Void> greetingFuture =
                integral.thenAccept(d -> System.out.println(d));

        // Block and wait for the future to complete
        System.out.println(Thread.currentThread().getName()+" "+greetingFuture.get());
/*
        System.out.println("integral = " + integral.state());
        Thread.sleep(2000);
        System.out.println("integral = " + integral.state());
        System.out.println("integral = " + integral.resultNow());
*/


    }


    public static class PartTask implements Supplier<Double> {
        double a;
        double b;
        int STEPS = 10000;
        public PartTask(double a, double b) {
            this.a = a;
            this.b = b;
        }

        public Double get() {
            double h = (b - a) / STEPS;
            double sum = 0;
            for (int i = 0; i < STEPS; ++i ) {
                sum += h * func(a + i * h);
            }
            return sum;
        }
    }

    public static Double func(Double x) {
        return x * x * Math.sqrt(3 - 2 * x * x * x);
    }
}
