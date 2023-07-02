package _20DiğerFaydalıKonular.EnumSınıfı;

public class Main {
    public static void main(String[] args) {
        //Kaçıncı gün olduğunu yazar(Gun Sınıfı)
        System.out.println(Gun.PAZARTESI.getDay());

        //Kaçıncı gün olduğunu yazar(Day Sınıfı)
        System.out.println(Day.CARSAMBA.getDay());

        Day.PAZARTESI.getDayName();
    }
}
