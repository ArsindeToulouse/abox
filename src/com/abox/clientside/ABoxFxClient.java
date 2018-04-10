package com.abox.clientside;

import com.abox.clientside.controllers.FilesTreeInfo;
import com.abox.clientside.models.FileInfo;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ABoxFxClient extends Application {

    private static final String APP_TITLE = "ABox";
    private static final String APP_SCREEN_LOCATION = "resources/AppScreen.fxml";
    private static final String FILE_TREE_INFO_LOCATION = "resources/FileTreeInfo.fxml";

    private Stage primaryStage;
    private BorderPane appScreen;

    private ObservableList<FileInfo> personData = FXCollections.observableArrayList();

    public ABoxFxClient() {
        personData.add(new FileInfo("temp.txt"));
        personData.add(new FileInfo("LuckyCat.png"));
        personData.add(new FileInfo("MyNotes.xdoc"));
        personData.add(new FileInfo("catalog_2459.xdoc"));
        personData.add(new FileInfo("temp_32.txt"));
        personData.add(new FileInfo("NewBook.pdf"));
        personData.add(new FileInfo("Welcome.txt"));
        personData.add(new FileInfo("MusicList.lst"));
        personData.add(new FileInfo("HappyNewYear.avi"));
        personData.add(new FileInfo("HappyNewYear.mp3"));
    }

    public ObservableList<FileInfo> getPersonData() {
        return personData;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle(APP_TITLE);

        initAppScreen();
        showFileTreeInfo();
    }

    private void initAppScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ABoxFxClient.class.getResource(APP_SCREEN_LOCATION));
            appScreen = loader.load();

            Scene scene = new Scene(appScreen);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFileTreeInfo() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ABoxFxClient.class.getResource(FILE_TREE_INFO_LOCATION));
            AnchorPane pane = loader.load();

            appScreen.setCenter(pane);

            FilesTreeInfo treeInfo = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
