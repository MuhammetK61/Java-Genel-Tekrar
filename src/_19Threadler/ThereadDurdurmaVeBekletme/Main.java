package _19Threadler.ThereadDurdurmaVeBekletme;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter c1 = new Counter("c1", 1);
        Thread t1 = new Thread(c1);

        t1.start();

        //Alttaki stop nedeniyle sleep() içine girilen saniye kadar çalışır sonra çalışmayı durdurur.
        Thread.sleep(2000);
        c1.stop();

    }
}
