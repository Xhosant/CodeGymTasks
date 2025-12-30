package com.codegym.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

/* 
Find all the files

*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> out = new ArrayList<>();
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Files.walkFileTree(Paths.get(root), options, 20, new GetFiles(out));
        return out;

    }

    public static void main(String[] args) {

    }

    private static class GetFiles extends SimpleFileVisitor<Path> {
        private List<String> result;

        public GetFiles(List<String> result) {
            this.result = result;
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            File file = path.toFile();
            if (file.isFile()) {
                result.add(file.getAbsolutePath());
            }
            return super.visitFile(path, basicFileAttributes);
        }
    }
}
