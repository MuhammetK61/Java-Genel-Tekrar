package _20DiğerFaydalıKonular.StreamApi;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(25);
        list.add(12);
        list.add(3);
        list.add(89);
        list.add(25);
        list.add(44);
        list.add(100);
        list.add(7);
        list.add(63);
        list.add(63);
        list.add(63);

        //------------------------------------------------------
        for (Integer i : list){
            System.out.println(i);
        }
        //Üstteki ile aynı işi yapar
        list.stream().forEach(i -> System.out.println(i));
        //------------------------------------------------------

        //60dan büyük sayıları yazdırdım.
        list.stream().filter(num -> num >60).forEach(num -> System.out.println(num));
        //------------------------------------------------------

        //Listelerken tekrarlı sayıları tek sefer yazıyor. Mesela 3 tane 63 sayısını yazmayıp tek 63 yazıyor.
        //SQl den hatırla
        list.stream().distinct().forEach(i -> System.out.println(i));
        //------------------------------------------------------

        //Küçükten büyüğe doğru sıraladım
        list.stream().sorted().forEach(i -> System.out.println(i));
        //------------------------------------------------------

        //Büyükten küçüğe doğru sıraladım
        list.stream().sorted(Comparator.reverseOrder()).forEach(i -> System.out.println(i));
        //------------------------------------------------------

        //5 Adet veri yazar
        list.stream().limit(5L).forEach(i -> System.out.println(i));
        //------------------------------------------------------

        //Burada önce 3 eleman atladım(skip ile) daha sonra  eleman yazdırdım
        list.stream().skip(3).limit(5).forEach(i -> System.out.println(i));
        //------------------------------------------------------



    }
}
