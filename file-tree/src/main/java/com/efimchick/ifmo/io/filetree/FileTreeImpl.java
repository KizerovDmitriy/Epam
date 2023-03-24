package com.efimchick.ifmo.io.filetree;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FileTreeImpl implements FileTree {
    private static final String byt = " bytes";

    @Override
    public Optional<String> tree(Path path) {
        File file = new File(String.valueOf(path));
        if (!file.exists()) return Optional.empty();
        if (file.isFile()) {
            return Optional.of(file.getName() + " " + file.length() + byt);
        }
        if (file.isDirectory()) {
            return Optional.of(file.getName() + " " + getFolderSize(file) + byt + directoryTree(file, new ArrayList<>()));
        }
        return Optional.empty();
    }

    private String directoryTree(File folder, List<Boolean> lastFolders) {
        StringBuilder directory = new StringBuilder();

        if (lastFolders.size() != 0) {
            directory.append(!(lastFolders.get(lastFolders.size() - 1)) ? "├─ " : "└─ ");
            directory.append(folder.getName()).append(" ").append(folderSize(folder));
        }

        File[] files = folder.listFiles();
        assert files != null;
        int count = files.length;
        files = sortFiles(files);
        for (int i = 0; i < count; i++) {
            directory.append("\n").append(head(lastFolders));
            if (files[i].isFile()) {
                directory.append(i + 1 == count ? "└─" : "├─").append(" ").append(files[i].getName()).append(" ").append(files[i].length()).append(byt);
            } else {
                ArrayList<Boolean> list = new ArrayList<>(lastFolders);
                list.add(i + 1 == count);
                directory.append(directoryTree(files[i], list));
            }
        }
        return directory.toString();
    }

    private long getFolderSize(File folder) {
        long size = 0;
        File[] files = folder.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isFile()) {
                size += file.length();
            } else {
                size += getFolderSize(file);
            }
        }
        return size;
    }

    private String folderSize(File folder) {
        return getFolderSize(folder) + byt;
    }

    private File[] sortFiles(File[] folder) {
        Arrays.sort(folder, (f1, f2) -> {
            if (f1.isDirectory() == f2.isDirectory()) {
                return f1.getName().compareToIgnoreCase(f2.getName());
            } else {
                return f1.isDirectory() ? -1 : 1;
            }
        });
        List<File> sorted = new ArrayList<>();
        for (File value : folder) {
            if (value.isDirectory()) {
                sorted.add(value);
            }
        }
        for (File file : folder) {
            if (file.isFile()) {
                sorted.add(file);
            }
        }
        return sorted.toArray(new File[0]);
    }

    private String head(List<Boolean> lastFolders) {
        return String.join("", lastFolders.stream()
                .map(lf -> lf ? "   " : "│  ")
                .toArray(String[]::new));
    }
}