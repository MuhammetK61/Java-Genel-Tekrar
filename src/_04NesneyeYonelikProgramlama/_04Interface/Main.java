package _04NesneyeYonelikProgramlama._04Interface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       // final String terminalId = "123123";
       // final String password = "616161";

        System.out.println("Tutar giriniz : ");
        double price = input.nextDouble();

        System.out.println("Kart no giriniz: ");
        String cardNumber = input.next();

        System.out.println("Son kullanim tarihi giriniz: ");
        String date = input.next();

        System.out.println("Guvenlik kodu giriniz : ");
        String cvc = input.next();

        System.out.println("1. A Bankasi" );
        System.out.println("2. B Bankasi" );
        System.out.println("3. C Bankasi" );
        System.out.println("Banka Seciniz : ");

        int selectBank = input.nextInt();

        switch (selectBank){
            case 1:
                ABankasi aPos = new ABankasi("A Bankasi","123123", "616161");
                aPos.connect("127.0.0.1");
                aPos.payment(price,cardNumber,date,cvc);
                break;
            case  2:
                BBankasi bPos = new BBankasi("B Bankasi", "123123", "616161");
                bPos.connect("127.0.0.1");
                bPos.payment(price,cardNumber,date,cvc);
                break;

            default:
                System.out.println("Gecerli banka giriniz:");
        }
    }
}
