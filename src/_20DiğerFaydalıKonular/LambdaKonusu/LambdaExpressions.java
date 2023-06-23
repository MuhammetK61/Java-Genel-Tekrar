package _20DiğerFaydalıKonular.LambdaKonusu;

public class LambdaExpressions {
    //Ana amacı dilin ifade gücünü artırmaktır.

    public static void main(String[] args) {
        /*
          Runnable r1 = new Runnable() {
           @Override
           public void run() {
               System.out.println("Runnable sınıfı");
           }
       };
       r1.run();

       Runnable r2 = () -> {
           System.out.println("r2 sınıfı");
       };
       r2.run();
         */

        Matematik t1 = new Matematik() {
            @Override
            public int transaction(int a, int b) {
                return a +b;
            }
        };

        //üstteki gibi yapmaktansa bu şekilde yapılabilir.
        //Dilin ifade gücü arttı.

        Matematik toplama = (a,b) -> a + b;
        Matematik cıkarma = (a,b) -> a - b;
        Matematik carpma = (a,b) -> a * b;
        Matematik bolme = (a,b) -> {
            if (b == 0){
                b =1;
            }
            return a/b;
        };
        System.out.println(toplama.transaction(5,10));
        System.out.println(cıkarma.transaction(5,10));
        System.out.println(carpma.transaction(5,10));
        System.out.println(bolme.transaction(5,10));
    }
}
