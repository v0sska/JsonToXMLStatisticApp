package threads;

import interfaces.IJsonParser;
import json.JsonParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadPoolTimeTask {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        List<String> fileNames = Arrays.asList("statistic1", "statistic2", "statistic3", "statistic4", "statistic5", "statistic6", "statistic7", "statistic8");
        List<Thread> threads = new ArrayList<>();

        JsonParser parser = new JsonParser();

        for (String fileName : fileNames) {
            long threadStartTime = System.currentTimeMillis();
            Thread thread = new ThreadTask(parser, fileName);
            threads.add(thread);
            thread.start();
            long threadEndTime = System.currentTimeMillis();
            System.out.println("Thread started for file " + fileName + ". Execution time: " + (threadEndTime - threadStartTime) + " ms");
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("All threads completed. Total execution time: " + (endTime - startTime) + " ms");

    }
}
