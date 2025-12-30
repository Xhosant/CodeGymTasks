package com.codegym.task.task19.task1918;

/* 
Introducing tags

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        String name = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            name=reader.readLine();
        }
        StringBuilder HTML = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(name))){
            while (reader.ready()) {
                HTML.append(reader.readLine());
            }
        }
        String html = HTML.toString();
        html=html.replaceAll("\\n", "").replaceAll("\\r", "").replaceAll("  ", " ");

        String tag = args[0];
        //String tag = "span";
        String op = "<"+tag;
        String cl = "</"+tag+">";
        ArrayList<Pair> list = new ArrayList<>();
        int clL = cl.length()-1;
        int i=0;
        while ((i = html.indexOf(op, i))!=-1){
            list.add(new Pair(i, true));
            i++;
        }
        i=0;
        while ((i = html.indexOf(cl, i))!=-1){
            list.add(new Pair(i+clL, false));
            i++;
        }

        Collections.sort(list);
        ArrayList<IndexPair> indices = new ArrayList<>();

        for (i=0;i<list.size(); i++){
            if (!list.get(i).open) continue;
            int openTags=1;
            for (int j=i+1; j< list.size(); j++){
                if (!list.get(j).open) openTags--;
                else openTags++;
                if (openTags==0){
                    indices.add(new IndexPair(list.get(i).index, list.get(j).index));
                    break;
                }
            }
        }

        for (IndexPair pair: indices) {
            System.out.println(html.substring(pair.opIndex, pair.clIndex+1));
        }

    }
    static class Pair implements Comparable<Pair>{
        public int index;
        public boolean open;
        public Pair(int index, boolean open){
            this.index=index;
            this.open=open;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(index, o.index);
        }
    }

    static class IndexPair{
        public int opIndex;
        public int clIndex;

        public IndexPair(int opIndex, int clIndex) {
            this.opIndex = opIndex;
            this.clIndex = clIndex;
        }
    }
}
