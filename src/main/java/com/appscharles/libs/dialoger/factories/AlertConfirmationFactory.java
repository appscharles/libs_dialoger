package com.appscharles.libs.dialoger.factories;

import com.appscharles.libs.fxer.controls.UTF8Control;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ResourceBundle;

/**
 * The type Alert factory.
 */
public class AlertConfirmationFactory {

    private Alert alert;

    private String iconStageResource;

    private ResourceBundle resourceBundle;

    private ButtonType buttonTypeYes;

    private ButtonType buttonTypeNo;

    /**
     * Create alert factory.
     *
     * @param alertType   the alert type
     * @param title       the title
     * @param contentText the content text
     * @return the alert factory
     */
    public static AlertConfirmationFactory create(Alert.AlertType alertType, String title, String contentText) {
        AlertConfirmationFactory instance = new AlertConfirmationFactory();
        instance.alert = new Alert(alertType);
        instance.alert.setTitle(title);
        instance.alert.setHeaderText(null);
        instance.alert.setContentText(contentText);
        instance.resourceBundle = ResourceBundle.getBundle("com/appscharles/libs/dialoger/translations/AlertConfirmation", new UTF8Control());
        return instance;
    }

    /**
     * Sets header text.
     *
     * @param headerText the header text
     * @return the header text
     */
    public AlertConfirmationFactory setHeaderText(String headerText) {
        this.alert.setHeaderText(headerText);
        return this;
    }

    /**
     * Sets icon stage resource.
     *
     * @param iconStageResource the icon stage resource
     * @return the icon stage resource
     */
    public AlertConfirmationFactory setIconStageResource(String iconStageResource) {
        this.iconStageResource = iconStageResource;
        return this;
    }

    public AlertConfirmationFactory setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        return this;
    }

    /**
     * Build alert.
     *
     * @return the alert
     */
    public Alert build() {
        this.buttonTypeYes = new ButtonType(this.resourceBundle.getString("view.button.yes"), ButtonBar.ButtonData.YES);
        this.buttonTypeNo = new ButtonType(this.resourceBundle.getString("view.button.no"), ButtonBar.ButtonData.NO);
        this.alert.getDialogPane().getButtonTypes().clear();
        this.alert.getDialogPane().getButtonTypes().addAll(this.buttonTypeYes,this.buttonTypeNo);
        Stage stage = (Stage) this.alert.getDialogPane().getScene().getWindow();
        if (this.iconStageResource != null) {
            stage.getIcons().add(new Image(this.getClass().getResource(this.iconStageResource).toString()));
        }
        return alert;
    }

    /**
     * Getter for property 'buttonTypeYes'.
     *
     * @return Value for property 'buttonTypeYes'.
     */
    public ButtonType getButtonTypeYes() {
        return buttonTypeYes;
    }

    /**
     * Getter for property 'buttonTypeNo'.
     *
     * @return Value for property 'buttonTypeNo'.
     */
    public ButtonType getButtonTypeNo() {
        return buttonTypeNo;
    }

}
