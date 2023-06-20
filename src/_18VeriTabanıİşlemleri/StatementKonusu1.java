package _18VeriTabanıİşlemleri;

import java.sql.*;

public class StatementKonusu1 {

    //Burda Veritabanından veri çekme işlemleri yaptık

    public static final String DB_URL = "jdbc:postgresql://Localhost/JavaDb";
    public static final String DB_USER = "postgres";
    public static final String DB_PASSWORD = "root";

    public static void main(String[] args) {
        Connection connection = null;
        Statement st = null;
        String sql = "SELECT * FROM students*";
        try {
            //Burda DriverManager ile Veritabanına bağlantı sağlıyoruz.
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            st = connection.createStatement();
            ResultSet data = st.executeQuery(sql);
            //bununla sadece istediğimiz kısımı çekebiliriz.
            data.absolute(2);
            while (data.next()){
                System.out.println("ID : " + data.getInt("id"));
                System.out.println("Ad : " + data.getString("name"));
                System.out.println("Soyad : "+ data.getString("surname"));
                System.out.println("--------------------");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
