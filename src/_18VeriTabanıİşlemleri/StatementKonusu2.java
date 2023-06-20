package _18VeriTabanıİşlemleri;

import java.sql.*;

public class StatementKonusu2 {

    //Burada Veritabanına veri ekleme işlemleri yaptık

    public static final String DB_URL = "jdbc:postgresql://Localhost/JavaDb";
    public static final String DB_USER = "postgres";
    public static final String DB_PASSWORD = "root";

    public static void main(String[] args) {
        Connection connection = null;
        String insertSql = "INSERT INTO students (name, surname) VALUES ('Mukaddes', 'Karaguzel')";
        String prSql = "INSERT INTO students (name, surname) VALUES (?,?)";
        try{
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            //Statement st = connection.createStatement();
            //System.out.println(st.executeUpdate(insertSql));

            PreparedStatement prSt = connection.prepareStatement(prSql);
            //İlk soru işaretine yazılacak değer : bkz -> 1
            prSt.setString(1,"Ahmet");
            //İkinci soru işaretine yazılacak değer : bkz -> 2
            prSt.setString(2, "Mehmet");
            prSt.executeUpdate();
            prSt.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
