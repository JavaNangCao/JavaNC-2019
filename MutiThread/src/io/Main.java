package io;

import java.io.*;
import java.nio.charset.StandardCharsets;
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
}
