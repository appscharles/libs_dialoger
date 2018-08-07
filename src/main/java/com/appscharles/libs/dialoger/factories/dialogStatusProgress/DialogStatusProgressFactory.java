package com.appscharles.libs.dialoger.factories.dialogStatusProgress;

import com.appscharles.libs.dialoger.factories.dialogStatusProgress.business.configurations.DialogStatusProgressConfiguration;
import com.appscharles.libs.fxer.exceptions.FxerException;
import com.appscharles.libs.fxer.factories.FXStageFactory;
import com.appscharles.libs.fxer.factories.IFXStageFactory;
import com.appscharles.libs.fxer.stages.FXStage;
import com.appscharles.libs.ioer.models.StatusProgress;

/**
 * The type Dialog status progress factory.
 */
public class DialogStatusProgressFactory {

    private StatusProgress statusProgress;

    private String title;

    private String headerText;

    private String resourceStageIcon;

    private String resourceStageStylesheet;

    /**
     * Create dialog status progress factory.
     *
     * @param statusProgress the status progress
     * @param title          the title
     * @param headerText     the header text
     * @return the dialog status progress factory
     */
    public static DialogStatusProgressFactory create(StatusProgress statusProgress, String title, String headerText){
        DialogStatusProgressFactory instance = new DialogStatusProgressFactory();
        instance.statusProgress = statusProgress;
        instance.title = title;
        instance.headerText = headerText;
        return instance;
    }

    /**
     * Build.
     *
     * @throws FxerException the fxer exception
     */
    public FXStage build() throws FxerException {
        IFXStageFactory stageFactory = new FXStageFactory("/com/appscharles/libs/dialoger/factories/dialogStatusProgress/DialogStatusProgressView.fxml");
        if (this.resourceStageIcon != null){
            stageFactory.setIcon(this.resourceStageIcon);
        }
        if (this.resourceStageStylesheet != null){
            stageFactory.addStylesheet(this.resourceStageStylesheet);
        }
        DialogStatusProgressConfiguration configuration = new DialogStatusProgressConfiguration(this.title, this.headerText, this.statusProgress);
        stageFactory.setController(new DialogStatusProgressController(configuration));
        FXStage stage = stageFactory.create();
        stage.setResizable(false);
        return stage;
    }

    /**
     * Sets resource stage icon.
     *
     * @param resourceStageIcon the resource stage icon
     * @return the resource stage icon
     */
    public DialogStatusProgressFactory setResourceStageIcon(String resourceStageIcon) {
        this.resourceStageIcon = resourceStageIcon;
        return this;
    }

    /**
     * Sets resource stage stylesheet.
     *
     * @param resourceStageStylesheet the resource stage stylesheet
     * @return the resource stage stylesheet
     */
    public DialogStatusProgressFactory setResourceStageStylesheet(String resourceStageStylesheet) {
        this.resourceStageStylesheet = resourceStageStylesheet;
        return this;
    }
}
