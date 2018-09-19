package com.appscharles.libs.dialoger.guis.progress.controllerExtend;

import javafx.fxml.FXML;

/**
 * The type 30 on actions controller extend.
 */
public class _30_OnActionsControllerExtend extends _28_StatusProgressControllerExtend {


    @FXML
    public void interrupt(){
        this.fXStage.close();
    }
}
