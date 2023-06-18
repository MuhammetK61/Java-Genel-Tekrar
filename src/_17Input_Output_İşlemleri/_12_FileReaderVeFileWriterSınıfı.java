package _17Input_Output_İşlemleri;



import java.io.FileReader;
import java.io.FileWriter;

public class _12_FileReaderVeFileWriterSınıfı {
    public static void main(String[] args) {

        //------- FileReader Kısmı -------
        //FileReader sınıfı, dosyalardan verileri (karakter olarak) okumak için kullanılabilir. InputStreamReader sınıfını genişletir.

        try {
            FileReader readFile = new FileReader("patika.text");
            int i = readFile.read();
            while (i != -1){
                System.out.print((char) i);
                i = readFile.read();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //------- FileWriter Kısmı -------
        //FileWriter sınıfı, dosyalara (karakter olarak) veri yazmak için kullanılabilir. OutputStreamWriter sınıfını genişletir.

        String data = "Java öğrenmeye devam ediyorum";
        try {
            FileWriter  writerFile = new FileWriter("output.txt");
            writerFile.write(data);
            writerFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
