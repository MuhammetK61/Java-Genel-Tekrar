package _20DiğerFaydalıKonular;

public class TipDönüşümleri {
    public static void main(String[] args) {

        //İnt veri tipini double a dönüştürüyoruz.
        //Bunu küçük veri tipini büyük tipe dönüştürürken yaparız.
        int a = 10;
        double b = a;

        //Double diti int tipine dönüştürüyoruz.
        //Bunu da büyük veri tipini daha küçük veri tiplerine çevirirken yaparız
        double pi =3.14;
        int x = (int) pi;

        //Integer => String dönüşümü
        int sayi = 10;
        String str = String.valueOf(sayi);

        //String => Integer Dönüşümü
        String data = "15";
        int num = Integer.parseInt(data);

    }
}
