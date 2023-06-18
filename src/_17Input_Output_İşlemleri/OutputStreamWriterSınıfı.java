package _17Input_Output_İşlemleri;


import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class OutputStreamWriterSınıfı {
    public static void main(String[] args) {
        String data = "ĞÜİŞ";

        try {
            FileOutputStream fileOutput = new FileOutputStream("output.txt");

            OutputStreamWriter fileWriter = new OutputStreamWriter(fileOutput);

            fileWriter.write(data);

            fileWriter.close();
            fileOutput.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
