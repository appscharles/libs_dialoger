package com.appscharles.libs.dialoger.guis.progress.controllerExtend;

import com.appscharles.libs.fxer.abstracts.AbstractStageControllerFxExtend;
import com.sun.javafx.application.PlatformImpl;

/**
 * The type 10 table view controller extend.
 */
public class _10_StageControllerExtend extends AbstractStageControllerFxExtend {

    protected String title;

    protected _10_StageControllerExtend(){
        this.addOnInitializeWithSneakyThrow(()->{
            PlatformImpl.runLater(()->{
                this.fXStage.setTitle(this.title);
                this.fXStage.setResizable(false);
            });
        });
    }
}
