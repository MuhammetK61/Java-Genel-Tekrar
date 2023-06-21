package _19Threadler.ThreadOluşturma;

public class Counter extends Thread{
    public String name;

    public Counter(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name + " Çalıştı !");

        for (int i =0; i<5; i++){
            System.out.print(i + " - ");
        }
    }
}
