package com.appscharles.libs.dialoger.factories;

import com.appscharles.libs.fxer.controls.UTF8Control;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ResourceBundle;

/**
 * The type Exception dialog factory.
 */
public class ExceptionDialogFactory {

    private Alert alert;

    private Exception exception;

    private ResourceBundle resourceBundle;

    private String iconStageResource;

    private ExceptionDialogFactory() {
        this.alert = new Alert(Alert.AlertType.ERROR);
    }

    /**
     * Create exception dialog factory.
     *
     * @param title       the title
     * @param contentText the content text
     * @param exception   the exception
     * @return the exception dialog factory
     */
    public static ExceptionDialogFactory create(String title, String contentText, Exception exception) {
        ExceptionDialogFactory instance = new ExceptionDialogFactory();
        instance.alert.setTitle(title);
        instance.alert.setHeaderText(null);
        instance.alert.setContentText(contentText);
        instance.exception = exception;
        instance.resourceBundle = ResourceBundle.getBundle("com/appscharles/libs/dialoger/translations/ExceptionDialog", new UTF8Control());
        return instance;
    }

    /**
     * Set header text exception dialog factory.
     *
     * @param headerText the header text
     * @return the exception dialog factory
     */
    public ExceptionDialogFactory setHeaderText(String headerText) {
        this.alert.setHeaderText(headerText);
        return this;
    }

    /**
     * Set resource bundle exception dialog factory.
     *
     * @param resourceBundle the resource bundle
     * @return the exception dialog factory
     */
    public ExceptionDialogFactory setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        return this;
    }

    /**
     * Set icon stage resource exception dialog factory.
     *
     * @param iconStageResource the icon stage resource
     * @return the exception dialog factory
     */
    public ExceptionDialogFactory setIconStageResource(String iconStageResource) {
        this.iconStageResource = iconStageResource;
        return this;
    }

    /**
     * Build alert.
     *
     * @return the alert
     */
    public Alert build() {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        this.exception.printStackTrace(pw);
        String exceptionText = sw.toString();
        Label label = new Label(this.resourceBundle.getString("view.label.details_error"));
        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);
        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);
        this.alert.getDialogPane().setExpandableContent(expContent);
        Stage stage = (Stage) this.alert.getDialogPane().getScene().getWindow();
        if (this.iconStageResource != null) {
            stage.getIcons().add(new Image(this.getClass().getResource(this.iconStageResource).toString()));
        }

        Platform.runLater(() -> {
            Hyperlink detailsButton = (Hyperlink) alert.getDialogPane().lookup(".details-button");
            detailsButton.setText(this.alert.getDialogPane().isExpanded() ?
                    this.resourceBundle.getString("view.button.hide_details") :
                    this.resourceBundle.getString("view.button.show_details"));
            alert.getDialogPane().expandedProperty().addListener(
                    (ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                        detailsButton.setText(newValue == false ?
                                this.resourceBundle.getString("view.button.show_details") :
                                this.resourceBundle.getString("view.button.hide_details"));
                    });
        });
        return this.alert;
    }
}
