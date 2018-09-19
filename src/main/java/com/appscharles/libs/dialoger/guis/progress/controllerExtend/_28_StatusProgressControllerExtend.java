package com.appscharles.libs.dialoger.guis.progress.controllerExtend;

import com.appscharles.libs.ioer.models.StatusProgress;
import com.sun.javafx.application.PlatformImpl;

/**
 * The type 10 table view controller extend.
 */
public class _28_StatusProgressControllerExtend extends _24_LabelsControllerExtend {

    protected StatusProgress statusProgress;

    protected _28_StatusProgressControllerExtend(){
        this.addOnInitializeWithSneakyThrow(()->{
            this.status.setText(this.statusProgress.getStatus());
            this.progressBar.setProgress(this.statusProgress.getProgress());
           this.statusProgress.progressProperty().addListener((args, oldVal, newVal)->{
               PlatformImpl.runLater(()->{
                   this.progressBar.setProgress(newVal.doubleValue());
                   if (newVal.doubleValue() >= 1.0){
                       this.fXStage.close();
                   }
               });
           });
            this.statusProgress.statusProperty().addListener((args, oldVal, newVal)->{
                PlatformImpl.runLater(()->{
                    this.status.setText(newVal);
                });
            });
        });
    }

}
