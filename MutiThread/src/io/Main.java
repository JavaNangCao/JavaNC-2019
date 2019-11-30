package io;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
//        String str1 = read("D:\\cadao.txt");
//        System.out.println(str1);
//        String str2 = readUTF8("D:\\cadao.txt");
//        System.out.println(str2);
//        String str3 = deAccent(str2);
//        System.out.println(str3);
        String str1 = readByLine("D:\\cadao.txt");
        String str2 = readByLineUTF8("D:\\cadao.txt");
        String str3 = readUTF8NumberByLine("D:\\cadao.txt");
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

        String strUrl = readOnlineResource("https://raw.githubusercontent.com/nam-long/learning-java/master/resources/cadao.txt");
        System.out.println(strUrl);
        //saveFileByte("D:\\text-1.txt",strUrl.getBytes());
        saveFileByteArray("D:\\text.jpg",readbyte("http://nhandaovadoisong.com.vn/wp-content/uploads/2019/05/hinh-nen-may-tinh-thien-nhien-3d-dep-kich-thuoc-lon-10.jpg"));
    }

    public static String read(String fileName) throws IOException {
        String str = "";
        InputStream is = new FileInputStream(fileName);
        int c;
        while ((c = is.read()) != -1) {
            str += (char) c;
        }
        return str;
    }

    public static String readUTF8(String filename) throws IOException {

        String str = "";

        Reader is = new FileReader(filename);
        int c;
        while ((c = is.read()) != -1) {
            str += (char) c;
        }

        is.close();
        return str;
    }

    public static String deAccent(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

    public static String readByLine(String filename) throws IOException {
        String str = "";
        InputStream is = new FileInputStream(filename);
        DataInput dis = new DataInputStream(is);
        String line;
        while ((line = dis.readLine()) != null) {
            str += line;
        }
        return str;
    }

    public static String readByLineUTF8(String filename) throws IOException {
        String str = "";
        Reader reader = new FileReader(filename);
        BufferedReader br = new BufferedReader(reader);
        String line;
        while ((line = br.readLine()) != null) {
            str += line + "\n";
        }
        return str;
    }

    public static String readUTF8NumberByLine(String filename) throws IOException {
        String str = "";
        Reader reader = new FileReader(filename);
        BufferedReader br = new BufferedReader(reader);
        String line;
        int i = 1;
        while ((line = br.readLine()) != null) {
            str += i + " - " + line + "\n";
            i += 1;
        }
        return str;
    }

    public static String readBuffer(String filename) throws IOException {
        String str = null;
        byte[] buffer = new byte[10]; //[0][1][2]

        InputStream is = new FileInputStream(filename);
        BufferedInputStream bis = new BufferedInputStream(is);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int count;
        while ((count = bis.read(buffer)) != -1) {
            baos.write(buffer, 0, count); // doc tu 0 -> count;
        }
        str = new String(baos.toByteArray());
        baos.close();
        is.close();

        return str;
    }
    public static byte[] readbyte(String strUrl) throws IOException {
        byte[] str = null;
        URL url = new URL(strUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        int responseCode = conn.getResponseCode();
        if (responseCode == HttpsURLConnection.HTTP_OK) {
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[100];
            int count;
            while ((count = bis.read(buffer)) != -1) {
                baos.write(buffer, 0, count); // doc tu 0 -> count;
            }
            str = baos.toByteArray();
            is.close();
        }
        return str;
    }

    public static String readOnlineResource(String strUrl) throws IOException {
        String str = null;
        URL url = new URL(strUrl);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        int responseCode = conn.getResponseCode();
        if (responseCode == HttpsURLConnection.HTTP_OK) {
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[100];
            int count;
            while ((count = bis.read(buffer)) != -1) {
                baos.write(buffer, 0, count); // doc tu 0 -> count;
            }
            str = new String(baos.toByteArray());
            baos.close();
            is.close();
        }
        return str;
    }
    public static void saveFileBuffer(String string, String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("D:/"+ filename));
        writer.write(string);
        writer.close();
    }
    public static void saveFileByteArray(String fileName, byte[] baos) throws IOException {
        OutputStream os = new FileOutputStream(fileName);
        os.write(baos);
        os.close();
    }
}
