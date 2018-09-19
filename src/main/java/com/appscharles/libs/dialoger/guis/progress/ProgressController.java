package com.appscharles.libs.dialoger.guis.progress;


import com.appscharles.libs.dialoger.guis.progress.controllerExtend._42_EventsControllerExtend;
import com.appscharles.libs.ioer.models.StatusProgress;
import javafx.beans.property.BooleanProperty;

/**
 * The type Progress controller.
 */
public class ProgressController extends _42_EventsControllerExtend {

    /**
     * Instantiates a new Progress controller.
     *
     * @param statusProgress the status progress
     */
    public ProgressController(String title, String statusLabel, StatusProgress statusProgress) {
        this.title = title;
        this.statusProgress = statusProgress;
        this.addOnInitializeWithSneakyThrow(()->{
            this.labelStatus.setText(statusLabel);
        });
    }

    /**
     * Set interrupt property progress controller.
     *
     * @param interruptProperty the interrupt property
     * @return the progress controller
     */
    public ProgressController setInterruptProperty(BooleanProperty interruptProperty){
        this.interruptProperty = interruptProperty;
        return this;
    }
}
