package com.appscharles.libs.dialoger.factories;

import com.sun.javafx.application.PlatformImpl;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import org.junit.Test;

import java.io.IOException;

/**
 * The type Exception dialog factory test.
 */
public class ExceptionDialogFactoryTest {

    /**
     * Should show alert with exception.
     *
     * @throws InterruptedException the interrupted exception
     */
    @Test
    public void shouldShowAlertWithException() throws InterruptedException {
        PlatformImpl.startup(()->{});
        Platform.runLater(()->{
            Alert alert = ExceptionDialogFactory.create("Title", "Content text", new IOException("IO Exception"))
                    .build();
            alert.show();
        });
        Thread.sleep(2000);
    }
}