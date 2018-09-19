package com.appscharles.libs.dialoger.guis.progress;

import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.factories.FXStageFactory;
import com.appscharles.libs.fxer.factories.IFXStageFactory;
import com.appscharles.libs.fxer.stages.FXStage;
import com.appscharles.libs.ioer.models.StatusProgress;
import javafx.beans.property.BooleanProperty;
import javafx.stage.Modality;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Progress stage.
 */
public class ProgressStage {

    private String title;

    private String statusLabel;

    private StatusProgress statusProgress;

    private BooleanProperty interruptProperty;

    private Boolean withWait;

    private String resourceIcon;

    private List<String> stylesheets;

    /**
     * Instantiates a new Progress stage.
     *
     * @param title             the title
     * @param statusLabel       the status label
     * @param statusProgress    the status progress
     * @param interruptProperty the interrupt property
     */
    public ProgressStage(String title, String statusLabel, StatusProgress statusProgress, BooleanProperty interruptProperty) {
        this.title = title;
        this.statusLabel = statusLabel;
        this.statusProgress = statusProgress;
        this.interruptProperty = interruptProperty;
        this.withWait = true;
        this.stylesheets = new ArrayList<>();
    }

    /**
     * Show fx.
     *
     * @throws FxerException the fxer exception
     */
    public void showFx() throws FxerException {
        IFXStageFactory stageFactory = new FXStageFactory("/com/appscharles/libs/dialoger/guis/progress/ProgressView.fxml",
                "com/appscharles/libs/dialoger/guis/progress/translations/Progress");
        ProgressController progressController = new ProgressController(title, statusLabel, statusProgress);
        progressController.setInterruptProperty(interruptProperty);
        if (this.resourceIcon != null){
            stageFactory.setIcon(this.resourceIcon);
        }
        for (String stylesheet : this.stylesheets) {
            stageFactory.addStylesheet(stylesheet);
        }
       stageFactory.setController(progressController);
        FXStage stage = stageFactory.create();
        stage.initModality(Modality.APPLICATION_MODAL);
        if (this.withWait){
            stage.showAndWaitFX();
        } else {
            stage.showFX();
        }
    }
}
