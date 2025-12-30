package com.codegym.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution

*/

public class Solution implements Serializable {
    public static void main(String[] args) throws Exception {
        File yourFile = File.createTempFile("temp", ".txt");
        OutputStream outputStream = new FileOutputStream(yourFile);
        InputStream inputStream = new FileInputStream(yourFile);
        Solution savedObject = new Solution(4);

        savedObject.save(outputStream);
        outputStream.flush();

        Solution loadedObject = new Solution(5);
        loadedObject.load(inputStream);
        inputStream.close();


        System.out.println(savedObject.equals(loadedObject));

    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }

    public void save(OutputStream outputStream) throws Exception {
        // Implement this method
        try (PrintWriter writer = new PrintWriter(outputStream)){
            writer.println(this);
        }
    }
    public void load(InputStream inputStream) throws Exception {
        // Implement this method
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            string = reader.readLine();
        }
    }
}

