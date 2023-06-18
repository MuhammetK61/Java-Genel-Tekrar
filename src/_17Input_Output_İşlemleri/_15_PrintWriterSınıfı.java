package _17Input_Output_İşlemleri;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class _15_PrintWriterSınıfı {
    public static void main(String[] args) {
        String data = "Java PrintWriter";
        try {
            //PrintWriter sınıfı, çıktı verilerini yaygın olarak okunabilir bir biçimde (metin) yazmak için kullanılabilir.
            //Diğer Writer sınıflarının aksine, PrintWriter ilkel verileri (int, float, char, vb.) Metin formatına dönüştürür.
            //Ayrıca, PrintWriter sınıfı herhangi bir girdi / çıktı istisnası (Exception) atmaz.
            //Bunun yerine, içindeki herhangi bir hatayı bulmak için checkError() metodu kullanmamız gerekir.
            PrintWriter writer = new PrintWriter("output.txt");
            //Burdan istediğin şeyi ekleyebiliyorsun.
            writer.println(data + 123456);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
