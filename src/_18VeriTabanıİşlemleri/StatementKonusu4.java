package _18VeriTabanıİşlemleri;

import java.sql.*;

public class StatementKonusu4 {

        //Burada Veritabanından veri silme işlemi yaptık.

        public static final String DB_URL = "jdbc:postgresql://Localhost/JavaDb";
        public static final String DB_USER = "postgres";
        public static final String DB_PASSWORD = "root";

        public static void main(String[] args) {
            Connection connection = null;
            String stSql = "DELETE FROM students WHERE id = 4";
            String prSql = "DELETE FROM students WHERE id=?";

            try{
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                Statement st = connection.createStatement();
                st.executeUpdate(stSql);

                PreparedStatement pr = connection.prepareStatement(prSql);
                pr.setInt(1, 3);
                pr.executeUpdate();

                st.close();
                connection.close();
                pr.close();

            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
}
