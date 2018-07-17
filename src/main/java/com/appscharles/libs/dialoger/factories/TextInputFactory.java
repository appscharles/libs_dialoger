package com.appscharles.libs.dialoger.factories;

import com.appscharles.libs.fxer.controls.UTF8Control;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ResourceBundle;

/**
 * The type Text input factory.
 */
public class TextInputFactory {

    private TextInputDialog dialog;

    private String iconStageResource;

    private ResourceBundle resourceBundle;

    /**
     * Create text input factory.
     *
     * @param defaultValue the default value
     * @param title        the title
     * @param contentText  the content text
     * @return the text input factory
     */
    public static TextInputFactory create(String defaultValue, String title, String contentText) {
        TextInputFactory instance = new TextInputFactory();
        instance.dialog = new TextInputDialog(defaultValue);
        instance.dialog.setTitle(title);
        instance.dialog.setHeaderText(null);
        instance.dialog.setContentText(contentText);
        instance.resourceBundle = ResourceBundle.getBundle("com/appscharles/libs/dialoger/translations/TextInput", new UTF8Control());
        return instance;
    }

    /**
     * Sets header text.
     *
     * @param headerText the header text
     * @return the header text
     */
    public TextInputFactory setHeaderText(String headerText) {
        this.dialog.setHeaderText(headerText);
        return this;
    }

    /**
     * Sets icon stage resource.
     *
     * @param iconStageResource the icon stage resource
     * @return the icon stage resource
     */
    public TextInputFactory setIconStageResource(String iconStageResource) {
        this.iconStageResource = iconStageResource;
        return this;
    }

    /**
     * Sets resource bundle.
     *
     * @param resourceBundle the resource bundle
     * @return the resource bundle
     */
    public TextInputFactory setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        return this;
    }

    /**
     * Build text input dialog.
     *
     * @return the text input dialog
     */
    public TextInputDialog build() {
        this.dialog.getDialogPane().getButtonTypes().clear();
        this.dialog.getDialogPane().getButtonTypes().add(new ButtonType(this.resourceBundle.getString("view.button.ok"), ButtonBar.ButtonData.OK_DONE));
        this.dialog.getDialogPane().getButtonTypes().add(new ButtonType(this.resourceBundle.getString("view.button.cancel"), ButtonBar.ButtonData.CANCEL_CLOSE));

        Stage stage = (Stage) this.dialog.getDialogPane().getScene().getWindow();
        if (this.iconStageResource != null) {
            stage.getIcons().add(new Image(this.getClass().getResource(this.iconStageResource).toString()));
        }
        return this.dialog;
    }
}
