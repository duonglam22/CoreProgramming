package com.lamdn.asynchornousExam;

import java.util.concurrent.CompletableFuture;

public class AsynSingleThreadExam {

    public static void main(String[] args) {
        System.out.println("started Asynchonourse on single thread");
        CompletableFuture.supplyAsync(() -> 10)
                .thenApply(i -> i*5)
                .thenAccept(i -> System.out.println("the result is: " + i))
                .thenRun(() -> System.out.println("Finished stt " ));
    }
}
