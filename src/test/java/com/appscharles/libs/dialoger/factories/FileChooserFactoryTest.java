package com.appscharles.libs.dialoger.factories;

import com.sun.javafx.application.PlatformImpl;
import javafx.stage.FileChooser;
import org.junit.Test;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 17.07.2018
 * Time: 11:13
 * Project name: dialoger
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class FileChooserFactoryTest {

    @Test
    public void shouldOpenFileChooser(){
        PlatformImpl.startup(()->{});
        PlatformImpl.runAndWait(()->{
            FileChooser chooser = FileChooserFactory.create("Zapisz").build();
            //chooser.showSaveDialog(null);
        });
    }
}