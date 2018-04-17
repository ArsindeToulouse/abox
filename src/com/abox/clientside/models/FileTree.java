package com.abox.clientside.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FileTree {

    private StringProperty fileTitle;
    private StringProperty fileDescription;
    private StringProperty fileParent;

    public FileTree(final String title, final String description, final String parent) {
        this.fileTitle = new SimpleStringProperty(title);
        this.fileDescription = new SimpleStringProperty(description);
        this.fileParent = new SimpleStringProperty(parent);
    }

    public String getFileTitle() {
        return fileTitle.get();
    }

    public StringProperty fileTitleProperty() {
        return fileTitle;
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle.set(fileTitle);
    }

    public String getFileDescription() {
        return fileDescription.get();
    }

    public StringProperty fileDescriptionProperty() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription.set(fileDescription);
    }

    @Override
    public String toString() {
        return "FileTree{" +
                "fileTitle=" + fileTitle +
                ", fileDescription=" + fileDescription +
                '}';
    }
}
