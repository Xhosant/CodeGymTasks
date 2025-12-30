package com.codegym.task.task20.task2027;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Word search

*/

public class Solution {
    public static void main(String[] args) {
        int[][] wordSearch = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> words = detectAllWords(wordSearch, "home", "same");
        for (Word word: words
             ) {
            System.out.println(word.toString());
        }
        /*
Expected result
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] wordSearch, String... words) {
        List<Word> output = new ArrayList<>();


        for (String word : words) {
            char[] ch = word.toCharArray();
            output.add(detectWord(ch, wordSearch));
        }

        return output;
    }

    public static Word detectWord(char[] ch, int[][] wordSearch){
        for (int i = 0; i< wordSearch.length; i++)
            for (int j=0; j<wordSearch[0].length; j++){
                if (ch[0]==wordSearch[i][j]){
                    if (ch.length==1) return new Word(ch, i, j);
                    Word word = detectFollowup(ch, wordSearch, i, j);
                    if (word!=null) return word;
                }
            }

        return null;
    }

    public static Word detectFollowup(char[] ch, int[][] wordSearch, int i, int j){
        int length = ch.length-1;
        boolean up = i-length >=0;
        boolean down = i+length < wordSearch.length;
        boolean left = j-length >=0;
        boolean right = j+length < wordSearch[0].length;

        if (up){
            if (ch[1]==wordSearch[i-1][j]){
                if (ch.length==2) return new Word(ch, i, j, i-1, j);
                Word word = followup(ch, wordSearch, i, j, -1, 0);
                if (word!=null) return word;
            }
        }
        if (down){
            if (ch[1]==wordSearch[i+1][j]){
                if (ch.length==2) return new Word(ch, i, j, i+1, j);
                Word word = followup(ch, wordSearch, i, j, +1, 0);
                if (word!=null) return word;
            }
        }
        if (left){
            if (ch[1]==wordSearch[i][j-1]){
                if (ch.length==2) return new Word(ch, i, j, i, j-1);
                Word word = followup(ch, wordSearch, i, j, 0, -1);
                if (word!=null) return word;
            }
        }
        if (right){
            if (ch[1]==wordSearch[i][j+1]){
                if (ch.length==2) return new Word(ch, i, j, i, j+1);
                Word word = followup(ch, wordSearch, i, j, 0, +1);
                if (word!=null) return word;
            }
        }
        if (left&&up){
            if (ch[1]==wordSearch[i-1][j-1]){
                if (ch.length==2) return new Word(ch, i, j, i-1, j-1);
                Word word = followup(ch, wordSearch, i, j, -1, -1);
                if (word!=null) return word;
            }
        }
        if (left&&down){
            if (ch[1]==wordSearch[i+1][j-1]){
                if (ch.length==2) return new Word(ch, i, j, i+1, j-1);
                Word word = followup(ch, wordSearch, i, j, +1, -1);
                if (word!=null) return word;
            }
        }
        if (right&&up){
            if (ch[1]==wordSearch[i-1][j+1]){
                if (ch.length==2) return new Word(ch, i, j, i-1, j+1);
                Word word = followup(ch, wordSearch, i, j, -1, +1);
                if (word!=null) return word;
            }
        }
        if (right&&down){
            if (ch[1]==wordSearch[i+1][j+1]){
                if (ch.length==2) return new Word(ch, i, j, i+1, j+1);
                Word word = followup(ch, wordSearch, i, j, +1, +1);
                if (word!=null) return word;
            }
        }


        return null;
    }

    public static Word followup(char[] ch, int[][] wordSearch, int i, int j, int iDir, int jDir){

        for (int p=2;p< ch.length;p++){
            if (ch[p]!=wordSearch[i+(p*iDir)][j+(p*jDir)]) return null;
        }

        int iOffset = iDir * (ch.length-1);
        int jOffset = jDir * (ch.length-1);
        return new Word(ch, i, j, i+iOffset, j+jOffset);
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }
        public Word(char[] text, int i, int j, int k, int l){
            this.text = new String(text);
            startX = j;
            startY = i;
            endX = l;
            endY = k;
        }
        public Word(char[] text, int i, int j){
            this.text = new String(text);
            startX = j;
            startY = i;
            endX = j;
            endY = i;
        }
        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
