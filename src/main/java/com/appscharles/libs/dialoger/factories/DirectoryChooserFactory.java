package com.appscharles.libs.dialoger.factories;

import com.appscharles.libs.fxer.controls.UTF8Control;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.util.ResourceBundle;

/**
 * The type File chooser factory.
 */
public class DirectoryChooserFactory {

    private DirectoryChooser chooser;

    private ResourceBundle resourceBundle;

    /**
     * Create file chooser factory.
     *
     * @param title the title
     * @return the file chooser factory
     */
    public static DirectoryChooserFactory create(String title) {
        DirectoryChooserFactory instance = new DirectoryChooserFactory();
        instance.chooser = new DirectoryChooser();
        instance.chooser.setTitle(title);
        instance.chooser.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        instance.resourceBundle = ResourceBundle.getBundle("com/appscharles/libs/dialoger/translations/FileChooser", new UTF8Control());
        return instance;
    }

    public DirectoryChooserFactory setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        return this;
    }

    /**
     * Build file chooser.
     *
     * @return the file chooser
     */
    public DirectoryChooser build() {
        return this.chooser;
    }
}
