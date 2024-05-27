package de.softknk;

import javafx.application.Platform;
import java.util.concurrent.CountDownLatch;

public class JavaFXInitializer {
    private static final CountDownLatch latch = new CountDownLatch(1);

    static {
        new Thread(() -> {
            try {
                Platform.startup(() -> {
                    /* No-op */
                });
            } finally {
                latch.countDown();
            }
        }).start();
    }

    public static void initialize() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Failed to initialize JavaFX", e);
        }
    }
}
