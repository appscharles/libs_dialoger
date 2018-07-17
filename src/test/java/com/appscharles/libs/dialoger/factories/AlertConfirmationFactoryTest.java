package com.appscharles.libs.dialoger.factories;

import com.sun.javafx.application.PlatformImpl;
import javafx.scene.control.Alert;
import org.junit.Test;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 17.07.2018
 * Time: 12:02
 * Project name: dialoger
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class AlertConfirmationFactoryTest {

    @Test
    public void shouldGetButtonFromAlertConfirmation(){
        PlatformImpl.startup(()->{});
        PlatformImpl.runAndWait(()->{
            AlertConfirmationFactory factory = AlertConfirmationFactory.create(Alert.AlertType.INFORMATION, "title", "content");
//            Alert alert = factory.build();
//            Optional<ButtonType> result = alert.showAndWait();
//            if (result.get() == factory.getButtonTypeYes()){
//                System.out.println("YES");
//            }
        });

    }
}