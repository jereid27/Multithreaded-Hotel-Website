package edu.wgu.d387_sample_code;

import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newFixedThreadPool;


public class DisplayMessage {
    private static ExecutorService messageExecutor = newFixedThreadPool(5);

    public static String[] retrieveMessages() {
        Properties properties = new Properties();
        List<String> messages = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(2);

        messageExecutor.execute(() -> {
            try {
                InputStream stream = new ClassPathResource("welcome_en_US.properties").getInputStream();
                properties.load(stream);
                messages.add(properties.getProperty("welcome"));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });

        messageExecutor.execute(() -> {
            try {
                InputStream stream = new ClassPathResource("welcome_fr_CA.properties").getInputStream();
                properties.load(stream);
                messages.add(properties.getProperty("welcome"));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });

        try {
            latch.await(10, TimeUnit.SECONDS); // Wait for both tasks to complete or timeout after 10 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return messages.toArray(new String[2]);
    }
}

