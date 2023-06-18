package _17Input_Output_İşlemleri;


import java.io.BufferedReader;
import java.io.FileReader;

public class _13_BufferedReaderSınıfı {
    public static void main(String[] args) {
        try {
            FileReader readFile = new FileReader("patika.txt");
            BufferedReader readBuff = new BufferedReader(readFile);
            String line = readBuff.readLine();
            while (line != null){
                System.out.println(line);
                line = readBuff.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
