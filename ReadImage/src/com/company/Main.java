package com.company;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        byte[] data = readImage("https://i.ytimg.com/vi/cYKt61n4gZY/maxresdefault.jpg");
        saveFile("D:\\hinh.png",data);
    }
    public static byte[] readImage(String strUrl) throws IOException {
        byte[] str = null;
        URL url = new URL(strUrl);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        int responseCode = conn.getResponseCode();
        if(responseCode == HttpsURLConnection.HTTP_OK){
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1000];
            int count;
            while ((count = bis.read(buffer))!= -1){
                baos.write(buffer,0,count);
            }
            str = baos.toByteArray();
            is.close();
        }
        return str;
    }
    public static void saveFile(String fileName, byte[] data) throws IOException {
        OutputStream os = new FileOutputStream(fileName);
        os.write(data);
        os.close();
    }

}
