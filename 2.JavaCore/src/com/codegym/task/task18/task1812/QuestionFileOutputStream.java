package com.codegym.task.task18.task1812;

import java.io.*;

/* 
Extending AmigoOutputStream

*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream amigoOutputStream;
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public QuestionFileOutputStream(AmigoOutputStream out){
        this.amigoOutputStream=out;
    }
    public void flush() throws IOException{amigoOutputStream.flush();}

    public void write(int b) throws IOException{amigoOutputStream.write(b);}

    public void write(byte[] b) throws IOException{amigoOutputStream.write(b);}

    public void write(byte[] b, int off, int len) throws IOException{amigoOutputStream.write(b, off, len);}

    public void close() throws IOException{
        System.out.println("Do you really want to close the stream? Y/N");
        String in =  bufferedReader.readLine();
        if (in.equals("Y")) amigoOutputStream.close();
    }
}

