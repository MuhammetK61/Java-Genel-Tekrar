package _19Threadler.Ödev;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> parts = new ArrayList<ArrayList<Integer>>();

        for (int i = 1;i<=10000;i++){
            numbers.add(i);
        }

        for (int i =0; i<4;i++){
            //Alttaki sublist Listenin elemanlarından belirtilen start ve end indeks değerleri aralığını kapsayan yeni bir liste elde etmemizi sağlar.
            //Burdaki start değeri 0 iken end değeri 10000 dir.
            ArrayList<Integer> part = new ArrayList<Integer>(numbers.subList(i*2500,(i+1)*2500));
            parts.add(part);
        }

        //Alttaki get(0) olayı threads sınıfındaki arraylistten gelme yani 4e böldüğümüz ana listenin hangi parçası olduğunu gösteriyor.
        Threads t1 = new Threads(parts.get(0),0);
        Threads t2 = new Threads(parts.get(1),1);
        Threads t3 = new Threads(parts.get(2),2);
        Threads t4 = new Threads(parts.get(3),3);


        Thread s1 = new Thread(t1);
        Thread s2 = new Thread(t2);
        Thread s3 = new Thread(t3);
        Thread s4 = new Thread(t4);

        s1.start();
        s2.start();
        s3.start();
        s4.start();

    }
}