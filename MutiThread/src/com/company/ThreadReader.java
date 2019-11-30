package com.company;

import javax.swing.plaf.TableHeaderUI;
import java.io.*;
import java.util.logging.FileHandler;

public class ThreadReader {
    private String filename;
    private StringBuilder filecontex = new StringBuilder();
    private complectionListener complectionListener;
    public ThreadReader(String filename) {
        this.filename = filename;
    }

    public void read(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    readFile();
                    if(complectionListener != null){
                        complectionListener.onComplete();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

    }

    public void readFile() throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine())!= null){
            filecontex.append(line);
        }
        bufferedReader.close();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public StringBuilder getFilecontex() {
        return filecontex;
    }

    public void setFilecontex(StringBuilder filecontex) {
        this.filecontex = filecontex;
    }

    public com.company.complectionListener getComplectionListener() {
        return complectionListener;
    }

    public void setComplectionListener(com.company.complectionListener complectionListener) {
        this.complectionListener = complectionListener;
    }
}
