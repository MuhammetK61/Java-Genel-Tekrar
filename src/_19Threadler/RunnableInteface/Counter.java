package _19Threadler.RunnableInteface;

public class Counter implements Runnable{
    private String name;

    public Counter(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + "Sayaci basladı !");
        for (int i = 0; i<=10;i++){
            System.out.println(this.getName() + " : " + i);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
