package _19Threadler.ThreadOluşturma;

public class Main {
    public static void main(String[] args) {
        Counter c1 = new Counter("Counter-1");

        Counter c2 = new Counter("Counter-2");

        //start komutu adından da anlaşılacağı üzere thread nesnelerini başlatmak için kullanılır.
        c1.start();
        c2.start();

        //NOT:
        //Normal şartlarda yukardaki kodda önce c1 çalışır biter sonra c2 çalışırdı.
        //Ancak threadler eş zamanlı çalışabildikleri için normal bir sıralama olmayacaktır.
        //Mesela c2 ye geçtiğimizde c1 threadinden veri almaya devam edebiriz.
    }
}
