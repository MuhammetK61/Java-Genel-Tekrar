package _17Input_Output_İşlemleri;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class _14_BufferedWriterSınıfı {
    public static void main(String[] args) {
        String data = "Java BufferedWriter sınıfı öğreniyorum.";
        File dosya = new File("output.txt");
        try {
            //Burdaki Charset.forName("Big5") kısmı UTF8 gibi bir olay.
            //Alttaki gibi yaptığımızda türkçedeki ÜŞĞ gibi harfler sembol yapılıyor yani normal görünmüyor.
            FileWriter writeFile = new FileWriter(dosya, Charset.forName("Big5"));
            BufferedWriter writeBuff = new BufferedWriter(writeFile);

            writeBuff.write(data);

            writeBuff.close();
            writeBuff.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
