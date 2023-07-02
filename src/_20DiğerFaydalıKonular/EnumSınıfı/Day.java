package _20DiğerFaydalıKonular.EnumSınıfı;

public enum Day {
    PAZARTESI(1),
    SALI(2),
    CARSAMBA(3),
    PERSEMBE(4),
    CUMA(5),
    CUMARTESI(6),
    PAZAR(7);

    private int day;

    Day(int day){
        this.day= day;
    }

    public int getDay() {
        return this.day;
    }

    public void getDayName(){
        String day = null;
        switch (this){
            case PAZARTESI:
                day = "Pazartesi";
                break;
            case SALI:
                day= "Salı";
                break;
        }
        System.out.println(day);
    }
}
