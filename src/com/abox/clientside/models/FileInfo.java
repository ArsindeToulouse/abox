package com.abox.clientside.models;

import javafx.beans.InvalidationListener;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FileInfo {

    private static final String UNKNOWN = "unknown";
    private static final int NULL_SIZE = 0;

    private StringProperty fileTitle;
    private StringProperty fileType;
    private IntegerProperty fileSize;
    private ObjectProperty<LocalDateTime> fileDate;

    public FileInfo() {
        this(null);
    }

    public FileInfo(final String fileTitle) {
        if (fileTitle != null) {
            this.fileTitle = new SimpleStringProperty(UNKNOWN);
        } else {
            this.fileTitle = new SimpleStringProperty(fileTitle);
        }
        this.fileType = new SimpleStringProperty(UNKNOWN);
        this.fileSize = new SimpleIntegerProperty(NULL_SIZE);
        this.fileDate = new SimpleObjectProperty<>(LocalDateTime.now());
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

    public String getFileType() {
        return fileType.get();
    }

    public StringProperty fileTypeProperty() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType.set(fileType);
    }

    public int getFileSize() {
        return fileSize.get();
    }

    public IntegerProperty fileSizeProperty() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize.set(fileSize);
    }

    public LocalDateTime getFileDate() {
        return fileDate.get();
    }

    public ObjectProperty<LocalDateTime> fileDateProperty() {
        return fileDate;
    }

    public void setFileDate(LocalDateTime fileDate) {
        this.fileDate.set(fileDate);
    }
}
