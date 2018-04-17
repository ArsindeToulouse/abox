package com.abox.clientside;

import com.abox.clientside.Helpers.TreeViewHelper;
import com.abox.clientside.models.SimpleFileInfo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ABoxFxClient extends Application {

    private static final String APP_TITLE = "ABox";
//    private static final String APP_SCREEN_LOCATION = "resources/AppScreen.fxml";
//    private static final String FILE_TREE_INFO_LOCATION = "resources/FileTreeInfo.fxml";

    private ArrayList<SimpleFileInfo> filesList = new ArrayList<>();

    public ABoxFxClient() {
        filesList.add(new SimpleFileInfo("temp.txt", "file", "root"));
        filesList.add(new SimpleFileInfo("images", "dir", "root"));
        filesList.add(new SimpleFileInfo("docs", "dir", "root"));
        filesList.add(new SimpleFileInfo("music", "dir", "root"));
        filesList.add(new SimpleFileInfo("catalog_2459.xdoc", "file", "docs"));
        filesList.add(new SimpleFileInfo("temp_32.txt", "file", "docs"));
        filesList.add(new SimpleFileInfo("NewBook.pdf", "file", "root"));
        filesList.add(new SimpleFileInfo("Welcome.txt", "file", "docs"));
        filesList.add(new SimpleFileInfo("MusicList.lst", "file", "root"));
        filesList.add(new SimpleFileInfo("HappyNewYear.avi", "file", "music"));
        filesList.add(new SimpleFileInfo("HappyNewYear.mp3", "file", "music"));
        filesList.add(new SimpleFileInfo("new_music", "dir", "music"));
        filesList.add(new SimpleFileInfo("new_music2", "dir", "new_music"));
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TreeViewHelper treeViewHelper = new TreeViewHelper(filesList);
        ArrayList<TreeItem<String>> list = treeViewHelper.getFilesList();

        TreeView<String> treeView = new TreeView<>();
        TreeItem<String> rootItem = new TreeItem<>("root");
        rootItem.getChildren().addAll(list);
        treeView.setRoot(rootItem);

        VBox root = new VBox();
        root.getChildren().add(treeView);

        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.setTitle(APP_TITLE);
        stage.show();
    }
}
