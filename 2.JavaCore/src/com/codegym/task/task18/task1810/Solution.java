package com.codegym.task.task18.task1810;

/* 
DownloadException

*/


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException{
        String file1;

        byte[] buffer;
        int count;
        while (true) {


            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                file1 = reader.readLine();

            } catch (Exception ignored) {
                return;
            }
            try (FileInputStream input = new FileInputStream(file1)) {
                buffer = new byte[input.available()];
                count = input.read(buffer);
                if (count < 1000) throw new DownloadException();
            } catch (DownloadException e) {
                throw e;
            }catch (Exception ignored) {
                return;
            }


        }

    }
    public static class DownloadException extends Exception {

    }
}
