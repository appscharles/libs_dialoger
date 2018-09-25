package com.appscharles.libs.dialoger.builders;

import com.appscharles.libs.dialoger.guis.progress.ProgressStage;
import com.appscharles.libs.fxer.abstracts.IStatusProgressAsynchable;
import com.appscharles.libs.fxer.exceptions.ThrowingConsumer;
import com.appscharles.libs.fxer.sneakers.ExceptionDialogThrowSneaker;
import com.sun.javafx.application.PlatformImpl;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/**
 * The type Async progress builder.
 */
public class AsyncProgressBuilder {

    private IStatusProgressAsynchable statusProgressAsynchable;

    private String title;

    private String statusLabel;

    private ThrowingConsumer<Exception> async;

    private ThrowingConsumer<Exception> inFxThreadAsyncCompleted;

    private ProgressStage progressStage;

    private AsyncProgressBuilder(){

    }

    /**
     * Create async progress builder.
     *
     * @param statusProgressAsynchable the status progress asynchable
     * @param title                    the title
     * @param statusLabel              the status label
     * @param async                    the async
     * @param inFxThreadAsyncCompleted the in fx thread async completed
     * @return the async progress builder
     */
    public static AsyncProgressBuilder create(IStatusProgressAsynchable statusProgressAsynchable, String title, String statusLabel, ThrowingConsumer<Exception> async, ThrowingConsumer<Exception> inFxThreadAsyncCompleted){
        AsyncProgressBuilder instance = new AsyncProgressBuilder();
        instance.statusProgressAsynchable = statusProgressAsynchable;
        instance.title = title;
        instance.statusLabel = statusLabel;
        instance.async = async;
        instance.inFxThreadAsyncCompleted = inFxThreadAsyncCompleted;
       instance.progressStage = new ProgressStage(instance.title, instance.statusLabel, instance.statusProgressAsynchable.getStatusProgress(), instance.statusProgressAsynchable.getInterruptProperty());
        return instance;
    }

    /**
     * Build.
     */
    public ProgressStage build() {
        ObjectProperty<ProgressStage> progressStage = new SimpleObjectProperty<>();
        ExceptionDialogThrowSneaker.sneaky(() -> {
            ExecutorService service = Executors.newSingleThreadExecutor();
            service.submit(() -> {
                ExceptionDialogThrowSneaker.sneaky(() -> {
                    async.accept();
                });
                PlatformImpl.runLater(() -> {
                    ExceptionDialogThrowSneaker.sneaky(() -> {
                        inFxThreadAsyncCompleted.accept();
                    });
                });
                statusProgressAsynchable.getStatusProgress().setProgress(1.0);
            });
            service.shutdown();
            progressStage.setValue(this.progressStage);
        });
        return progressStage.getValue();
    }

    /**
     * Progress stage.
     *
     * @param progressStage the progress stage
     */
    public void progressStage(Consumer<ProgressStage> progressStage){
        progressStage.accept(this.progressStage);
    }
}
