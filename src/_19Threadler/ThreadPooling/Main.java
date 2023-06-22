package _19Threadler.ThreadPooling;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        OrderMatic oMatic = new OrderMatic();

        //Bu nedenle Thread havuzu oluşturup bu havuzu önceden oluşturulmuş ve kullanıma hazır Thread nesneleri ile doldururuz.
        //Böylece, performans kazanımı ve sistem kaynaklarının verimli kullanımını sağlayabiliriz.
        //Eğer havuzda uygun boş bir Thread yoksa beklemede kalacaktır. Havuzdan ilk boşa çıkan Thread nesnesini alıp çalışacaktır.
        //Alttaki değerde havuzda kaç thread olduğunu belirtiriz.
        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 0; i< 20;i++){
            pool.execute(oMatic);
        }

        System.out.println(oMatic.getOrderNo());
    }
}
