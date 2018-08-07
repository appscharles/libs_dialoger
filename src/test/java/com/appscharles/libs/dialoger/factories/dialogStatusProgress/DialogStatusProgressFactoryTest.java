package com.appscharles.libs.dialoger.factories.dialogStatusProgress;

import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.stages.FXStage;
import com.appscharles.libs.ioer.models.StatusProgress;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 07.08.2018
 * Time: 15:11
 * Project name: dialoger
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class DialogStatusProgressFactoryTest {

    @Test
    public void shouldOpenDialog() throws FxerException, InterruptedException {
        StatusProgress statusProgress = new StatusProgress();
        DialogStatusProgressFactory factory = DialogStatusProgressFactory.create(statusProgress, "title dialog", "header text");
        FXStage stage = factory.build();
        stage.showFX();
        for (int i = 0; i < 100; i++) {
            if (stage.isShowing() == false){
                throw new FxerException("Not showing dialog");
            }
            statusProgress.setProgress((i+1.0) / 100);
            statusProgress.setStatus("Status " + i);
            Thread.sleep(20);
        }
    }
}