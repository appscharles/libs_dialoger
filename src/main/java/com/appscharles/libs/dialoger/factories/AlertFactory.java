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
public class AlertFactory {

    private Alert alert;

    private String iconStageResource;

    private ResourceBundle resourceBundle;

    /**
     * Create alert factory.
     *
     * @param alertType   the alert type
     * @param title       the title
     * @param contentText the content text
     * @return the alert factory
     */
    public static AlertFactory create(Alert.AlertType alertType, String title, String contentText) {
        AlertFactory instance = new AlertFactory();
        instance.alert = new Alert(alertType);
        instance.alert.setTitle(title);
        instance.alert.setHeaderText(null);
        instance.alert.setContentText(contentText);
        instance.resourceBundle = ResourceBundle.getBundle("com/appscharles/libs/dialoger/translations/Alert", new UTF8Control());
        return instance;
    }

    /**
     * Sets header text.
     *
     * @param headerText the header text
     * @return the header text
     */
    public AlertFactory setHeaderText(String headerText) {
        this.alert.setHeaderText(headerText);
        return this;
    }

    /**
     * Sets icon stage resource.
     *
     * @param iconStageResource the icon stage resource
     * @return the icon stage resource
     */
    public AlertFactory setIconStageResource(String iconStageResource) {
        this.iconStageResource = iconStageResource;
        return this;
    }

    public AlertFactory setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        return this;
    }

    /**
     * Build alert.
     *
     * @return the alert
     */
    public Alert build() {
        this.alert.getDialogPane().getButtonTypes().clear();
        this.alert.getDialogPane().getButtonTypes().add(new ButtonType(this.resourceBundle.getString("view.button.ok"), ButtonBar.ButtonData.OK_DONE));
        Stage stage = (Stage) this.alert.getDialogPane().getScene().getWindow();
        if (this.iconStageResource != null) {
            stage.getIcons().add(new Image(this.getClass().getResource(this.iconStageResource).toString()));
        }
        return alert;
    }
}
