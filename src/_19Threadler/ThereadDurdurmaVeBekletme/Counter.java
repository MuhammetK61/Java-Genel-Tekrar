package _19Threadler.ThereadDurdurmaVeBekletme;

public class Counter implements Runnable{
    private String name;
    private int id;
    private boolean isRun = true;


    public Counter(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println(this.name + "Çalıştı !");
        while (isRun){
            for (int i =1; i<=10; i++){
                if (this.id == 1) {
                    try {
                        //Burdaki 1000L = 1 saniye
                        //1 saniye beklete beklete yazıyor.
                        Thread.sleep(1000L * this.id);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(i);
            }
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void stop(){
        this.isRun = false;
    }
}
