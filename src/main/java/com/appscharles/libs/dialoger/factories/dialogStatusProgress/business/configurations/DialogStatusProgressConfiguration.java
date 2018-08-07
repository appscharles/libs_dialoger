package com.appscharles.libs.dialoger.factories.dialogStatusProgress.business.configurations;

import com.appscharles.libs.ioer.models.StatusProgress;

/**
 * The type Client manager configuration.
 */
public class DialogStatusProgressConfiguration {

    private String title;

    private String headerText;

    private StatusProgress statusProgress;

    public DialogStatusProgressConfiguration(String title, String headerText, StatusProgress statusProgress) {
        this.title = title;
        this.headerText = headerText;
        this.statusProgress = statusProgress;
    }

    /**
     * Getter for property 'title'.
     *
     * @return Value for property 'title'.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for property 'title'.
     *
     * @param title Value to set for property 'title'.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for property 'headerText'.
     *
     * @return Value for property 'headerText'.
     */
    public String getHeaderText() {
        return headerText;
    }

    /**
     * Setter for property 'headerText'.
     *
     * @param headerText Value to set for property 'headerText'.
     */
    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    /**
     * Getter for property 'statusProgress'.
     *
     * @return Value for property 'statusProgress'.
     */
    public StatusProgress getStatusProgress() {
        return statusProgress;
    }

    /**
     * Setter for property 'statusProgress'.
     *
     * @param statusProgress Value to set for property 'statusProgress'.
     */
    public void setStatusProgress(StatusProgress statusProgress) {
        this.statusProgress = statusProgress;
    }
}
