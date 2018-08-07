package com.appscharles.libs.dialoger.factories.dialogStatusProgress;

import com.appscharles.libs.dialoger.factories.dialogStatusProgress.business.configurations.DialogStatusProgressConfiguration;
import com.appscharles.libs.fxer.controllers.AbstractControllerFX;
import com.sun.javafx.application.PlatformImpl;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Client manager controller.
 */
public class DialogStatusProgressController extends AbstractControllerFX {

    /**
     * The Resource bundle.
     */
    public ResourceBundle resourceBundle;

    public DialogStatusProgressConfiguration configuration;

    @FXML
    public Label headerText;

    @FXML
    public Label status;

    @FXML
    public ProgressBar progressBar;

    public DialogStatusProgressController(DialogStatusProgressConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        this.headerText.setText(this.configuration.getHeaderText());
        Platform.runLater(() -> {
            this.fXStage.setTitle(this.configuration.getTitle());
        });
        this.progressBar.progressProperty().bind(this.configuration.getStatusProgress().progressProperty());
        this.configuration.getStatusProgress().statusProperty().addListener((args, oldVal, newVal)->{
            PlatformImpl.runAndWait(()->{
                this.status.setText(newVal);
            });
        });
    }
}
