package _19Threadler.ThreadPooling;

public class OrderMatic implements Runnable{
    private int orderNo;
    private final Object LOCK = new Object();

    public OrderMatic() {
        this.orderNo = 0;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Bu fonksiyon herşeyi düzenleyen adamın dibidir.
        //Bir sınıftaki herhangi bir metod synchronized ifadesini aldığı zaman o metoda bir thread girdiğinde metodun
        //bulunduğu obje otomatikman olarak lock mekanizması ile erişime kapatılır.
        //Bu durumda başka bir thread o sınıf içindeki hiçbir synchronized metoda erişemez.
        //synchronized metod üzerinde işlem yapan thread metoddan çıktığı zaman ise lock kaldırılır ve tüm obje yeniden erişilebilir hale gelir.
        //Bu birinci yoldur.
        //synchronized (LOCK){
        //this.orderNo++;
        //System.out.println("Thread : " + Thread.currentThread().getName() + " - OrderNo : " + this.orderNo);

        //}
        increaseOrder();
    }

    //Bu da ikinci kullanım
    public synchronized void  increaseOrder(){
        this.orderNo++;
        System.out.println("Thread : " + Thread.currentThread().getName() + " - OrderNo : " + this.orderNo);

    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }
}
