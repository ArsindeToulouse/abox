package com.abox.clientside.Helpers;

import com.abox.clientside.models.FileTree;
import com.abox.clientside.models.SimpleFileInfo;
import javafx.scene.control.TreeItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TreeViewHelper {

    private static final String TAG = TreeViewHelper.class.getSimpleName();
    private static final String ROOT_FOLDER = "root";
    private static final String DESCRIPTOR_FILE = "file";
    private static final String DESCRIPTOR_FOLDER = "dir";

    private ArrayList<SimpleFileInfo> fileInfoList;

    public TreeViewHelper(final ArrayList<SimpleFileInfo> list) {
        this.fileInfoList = list;
    }

    public ArrayList<TreeItem<String>> getFilesList() {
        ArrayList<TreeItem<String>> items = new ArrayList<>();

        for (SimpleFileInfo node : fileInfoList) {
            if (node.getFileParent().equalsIgnoreCase(ROOT_FOLDER)
                    && node.getFileDescription().equalsIgnoreCase(DESCRIPTOR_FILE)) {
                items.add(new TreeItem<>(node.getFileTitle()));
            } else if (node.getFileParent().equalsIgnoreCase(ROOT_FOLDER)
                    && node.getFileDescription().equalsIgnoreCase(DESCRIPTOR_FOLDER)){
                TreeItem<String> dir = new TreeItem<>(node.getFileTitle());
                dir.getChildren().addAll(getChildrenList(node.getFileTitle()));
                items.add(dir);
            }
        }
        return items;
    }

    private ArrayList<TreeItem<String>> getChildrenList(final String parent) {
        ArrayList<TreeItem<String>> items = new ArrayList<>();
        List<SimpleFileInfo> stream = fileInfoList.stream()
                .filter(simpleFileInfo -> simpleFileInfo.getFileParent().equalsIgnoreCase(parent))
                .collect(Collectors.toList());
        for (SimpleFileInfo node : stream) {
            if (node.getFileDescription().equalsIgnoreCase(DESCRIPTOR_FOLDER)) {
//                items.addAll(getChildrenList(node.getFileParent()));
                TreeItem<String> dir = new TreeItem<>(node.getFileTitle());
                dir.getChildren().addAll(getChildrenList(node.getFileTitle()));
                items.add(dir);
            } else {
                TreeItem<String> leaf = new TreeItem<>(node.getFileTitle());
                items.add(leaf);
            }
        }

        if (items.isEmpty()) {
            TreeItem<String> leaf = new TreeItem<>("(empty)");
            items.add(leaf);
        }
        return items;
    }
}
