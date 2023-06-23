package _19Threadler.Ödev;

import java.util.ArrayList;

public class Threads implements Runnable{
    private ArrayList<Integer> arr;
    static private ArrayList<Integer> oddNum = new ArrayList<>();
    static private ArrayList<Integer> evenNum = new ArrayList<>();
    private int sleepTime; //Burası threadleri sırayla çalıştırabilmek için oluşturuldu.

    public Threads(ArrayList<Integer> arr, int sleepTime) {
        this.arr = arr;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(this.sleepTime);
            //syncronized bildiğimiz gibi threadlerin aynı anda çalışmasını engelleyip sıra sokuyor.
            synchronized (arr){
                for (int i =0; i<this.arr.size();i++){
                    if(i % 2 == 0){
                        evenNum.add(this.arr.get(i));
                    }
                    if(i % 2 == 1){
                        oddNum.add(this.arr.get(i));
                    }
                }
            }
            //Son thread durduğu zaman diziyi yazdırmak için eklendi.
            if (oddNum.size() > 3751 ){
                System.out.println(getOddNum());
                System.out.println(getEvenNum());
            }
        }catch (Exception e){
            System.out.println("Error Message : " + e.getMessage());
        }
    }

    public static ArrayList<Integer> getEvenNum() {
        return evenNum;
    }

    public static ArrayList<Integer> getOddNum() {
        return oddNum;
    }


}
