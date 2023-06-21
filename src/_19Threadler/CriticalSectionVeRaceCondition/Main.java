package _19Threadler.CriticalSectionVeRaceCondition;

import java.util.ArrayList;
import java.util.List;

public class Main {
    //Bir iş parçacığı kaynağı kullanıyorken diğerleri onu beklemelidirler.
    //İşte birden fazla iş parçacığının kullandığı bu paylaşımlı ortak alanlara “Critical Sections” adı verilmektedir
    //Critical Section'a aynı anda birden fazla thread erişmeye çalışırsa bu olaya 'Race Condition' denir.
    public static void main(String[] args) throws InterruptedException {
        OrderMatic oMatic = new OrderMatic();
        List<Thread> islemler = new ArrayList<>();
        for (int i =0; i<10;i++){
            Thread t1 = new Thread(oMatic);
            islemler.add(t1);
            t1.start();
        }

        for (Thread t : islemler){
            //Thread de join methodu, bir thread işlemini bitirmeden diğer bir thread çalışması engellenir.
            t.join();
        }

        System.out.println(oMatic.getOrderNo());






        /*
        Thread t1 = new Thread(oMatic);
        t1.start();
        t1.join();

        Thread t2 = new Thread();
        t2.start();
        t2.join();

         */

    }
}
