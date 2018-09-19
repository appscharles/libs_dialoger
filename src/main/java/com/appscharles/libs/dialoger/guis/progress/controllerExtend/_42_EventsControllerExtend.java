package com.appscharles.libs.dialoger.guis.progress.controllerExtend;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The type 30 on actions controller extend.
 */
public class _42_EventsControllerExtend extends _30_OnActionsControllerExtend {



    protected _42_EventsControllerExtend() {
        addOnCloseWithSneakyThrow(() -> {
            if (this.statusProgress.getProgress() < 1){
                if (this.interruptProperty != null){
                    this.interruptProperty.setValue(true);
                }
            }
        });
        addOnShownWithSneakyThrow((event)->{
            if (this.statusProgress.getProgress()>= 1.0){
                ExecutorService service = Executors.newSingleThreadExecutor();
                service.submit(()->{
                    sneakyThrow(()->{
                        this.fXStage.closeFX();
                    });
                });
                service.shutdown();

            }
        });
    }

}
