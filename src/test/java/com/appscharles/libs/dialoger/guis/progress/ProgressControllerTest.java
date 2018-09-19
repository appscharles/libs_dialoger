package com.appscharles.libs.dialoger.guis.progress;

import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.ioer.models.StatusProgress;
import extensions.AppInitializeTest;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.concurrent.Executors;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 19.09.2018
 * Time: 11:08
 * Project name: dialoger
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
@AppInitializeTest
public class ProgressControllerTest {

    /**
     * Should open view.
     *
     * @throws FxerException the fxer exception
     */
    @Test
    public void shouldOpenView() throws FxerException {
        StatusProgress statusProgress = new StatusProgress();
        BooleanProperty interruptProperty = new SimpleBooleanProperty(false);
        Executors.newSingleThreadExecutor().submit(()->{
            for (Double d = 0.0 ; d <= 1.2 ; d += 0.05){
                try {
                    Thread.sleep(200);
                    statusProgress.setProgress(d);
                    statusProgress.setStatus(UUID.randomUUID().toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        new ProgressStage("Czekaj","Dane:", statusProgress, interruptProperty).showFx();
    }
}