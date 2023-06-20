package _18VeriTabanıİşlemleri;

import java.sql.*;

public class StatementKonusu3 {

    //Burada Veritabanında verileri güncelleme işlemi yaptık.

    public static final String DB_URL = "jdbc:postgresql://Localhost/JavaDb";
    public static final String DB_USER = "postgres";
    public static final String DB_PASSWORD = "root";

    public static void main(String[] args) {
        Connection connection = null;
        String stSql = "UPDATE students SET name='Ali' WHERE id=1";
        String prSql = "UPDATE students SET name= ? WHERE id=?";
        try{
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //Statement st = connection.createStatement();
            //Burda executeden sonraki gelecek eklentiye(Burda Update) dikkat etmek lazım. Karışması kolay sonra hata veriyor.
            //st.executeUpdate(stSql);

            //Soru işareti koyduğumuz yerlere değer atayarak değiştirme yapıyoruz.
            //Örnek olarak ilk sorguda muhammet ismini ali olarak değiştirdik.
            //Şimdi ise ikinci sorguda soru işaretli kısımlara değiştirmiş olduğumuz verileri tekrar girerek eski haline getirdik.
            PreparedStatement pr = connection.prepareStatement(prSql);

              //ikinci soru işareti -> id
            pr.setInt(2,1);

                    //birinci soru işareti -> name
            pr.setString(1, "Muhammet");

            //Bunu untuma bu olmadan yukardaki sorgular çalışmaz
            pr.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
