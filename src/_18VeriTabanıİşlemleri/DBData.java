package _18VeriTabanıİşlemleri;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBData {

    //İki şekilde de kullanılabilir. Alternatif olarak bunu da yazmak istedim buraya.
    public static final String DB_URL = "jdbc:postgresql://Localhost/JavaDb";
    public static final String DB_USER = "postgresql";
    public static final String DB_PASSWORD = "root";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
