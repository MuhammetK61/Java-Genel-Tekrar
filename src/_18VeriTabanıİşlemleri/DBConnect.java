package _18VeriTabanıİşlemleri;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static void main(String[] args) {
        //Postgresql'i, postgresql websitesine girip son sürümünün maven linkini kopyaladım
        //Daha sonra File -> ProjectStructure -> Libraries -> + işareti -> ve linki yapıştır.
        //Burası bağlanacağımız veritabanı / Server / Database
        String url = "jdbc:postgresql://Localhost/JavaDb";
        String user = "postgres";
        String password = "root";

        //Üst kısım alttaki şekilde de yazılabilir
        // String url = "jdbc:postgresql://Localhost/JavaDb?user=postgres=password=root"

        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Bağlantı başarılı");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
