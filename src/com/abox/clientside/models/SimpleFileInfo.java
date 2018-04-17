package com.abox.clientside.models;

public class SimpleFileInfo {

    private String fileTitle;
    private String fileDescription;
    private String fileParent;

    public SimpleFileInfo(String fileTitle, String fileDescription, String fileParent) {
        this.fileTitle = fileTitle;
        this.fileDescription = fileDescription;
        this.fileParent = fileParent;
    }

    public String getFileTitle() {
        return fileTitle;
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public String getFileParent() {
        return fileParent;
    }

    public void setFileParent(String fileParent) {
        this.fileParent = fileParent;
    }

    @Override
    public String toString() {
        return "SimpleFileInfo{" +
                "fileTitle='" + fileTitle + '\'' +
                ", fileDescription='" + fileDescription + '\'' +
                ", fileParent='" + fileParent + '\'' +
                '}';
    }
}
