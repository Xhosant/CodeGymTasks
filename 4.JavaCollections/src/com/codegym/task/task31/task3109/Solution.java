package com.codegym.task.task31.task3109;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Reading config files

*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/codegym/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/codegym/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/codegym/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Path path = Paths.get(fileName);
        Properties properties = new Properties();
        if (!Files.exists(path)){
            return properties;
        }
        try (InputStream is = new FileInputStream(path.toFile())){
            if (fileName.endsWith(".xml")){
                    properties.loadFromXML(is);
            } else {
                    properties.load(is);
            }
        } catch (IOException ignored) {
        }
        return properties;
    }
}
