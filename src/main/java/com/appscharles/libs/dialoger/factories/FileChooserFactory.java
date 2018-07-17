package com.appscharles.libs.dialoger.factories;

import com.appscharles.libs.fxer.controls.UTF8Control;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;
import java.util.ResourceBundle;

/**
 * The type File chooser factory.
 */
public class FileChooserFactory {

    private FileChooser chooser;

    private ResourceBundle resourceBundle;

    /**
     * Create file chooser factory.
     *
     * @param title the title
     * @return the file chooser factory
     */
    public static FileChooserFactory create(String title) {
        FileChooserFactory instance = new FileChooserFactory();
        instance.chooser = new FileChooser();
        instance.chooser.setTitle(title);
        instance.chooser.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        instance.resourceBundle = ResourceBundle.getBundle("com/appscharles/libs/dialoger/translations/FileChooser", new UTF8Control());
        return instance;
    }

    public FileChooserFactory setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        return this;
    }

    /**
     * Add extension filter file chooser factory.
     *
     * @param description the description
     * @param extensions  the extensions
     * @return the file chooser factory
     */
    public FileChooserFactory addExtensionFilter(String description, String... extensions){
        this.chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(description, extensions));
        return this;
    }

    /**
     * Add extension filter file chooser factory.
     *
     * @param description the description
     * @param extensions  the extensions
     * @return the file chooser factory
     */
    public FileChooserFactory addExtensionFilter(String description, List<String> extensions){
        this.chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(description, extensions));
        return this;
    }

    /**
     * Build file chooser.
     *
     * @return the file chooser
     */
    public FileChooser build() {
        this.addExtensionFilter(this.resourceBundle.getString("view.extension_filter.all_files")+" (*.*)", "*.*");
        return this.chooser;
    }
}
