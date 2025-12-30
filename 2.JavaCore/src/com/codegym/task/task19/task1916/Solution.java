package com.codegym.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Tracking changes

*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String file1name=null;
        String file2name=null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            file1name= reader.readLine();
            file2name= reader.readLine();
        }
        ArrayList<String> file1 = new ArrayList<>();
        ArrayList<String> file2 = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader( new FileReader(file1name))){
            while (reader.ready()) file1.add(reader.readLine());
        }
        try (BufferedReader reader = new BufferedReader( new FileReader(file2name))){
            while (reader.ready()) file2.add(reader.readLine());
        }
        int maxI=file1.size();
        int maxJ=file2.size();
        int i=0;
        int j=0;
        while (i<maxI && j<maxJ){
            String line1 = file1.get(i);
            String line2 = file2.get(j);
            if (line1.equals(line2)){
                lines.add(new LineItem(Type.SAME, line1));
                i++;
                j++;
            } else {
                if (line1.equals(file2.get(j+1))){
                    lines.add(new LineItem(Type.ADDED, line2));
                    j++;
                } else if (line2.equals(file1.get(i+1))){
                    lines.add(new LineItem(Type.REMOVED, line1));
                    i++;
                } else return;
            }

        }
        while (i<maxI){
            lines.add(new LineItem(Type.REMOVED, file1.get(i)));
            i++;
        }
        while (j<maxJ){
            lines.add(new LineItem(Type.ADDED, file2.get(j)));
            j++;
        }
        List<LineItem> line = lines;
    }

    public static enum Type {
        ADDED,        // New line added
        REMOVED,      // Line deleted
        SAME          // No change
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
