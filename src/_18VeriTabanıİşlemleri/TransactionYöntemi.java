package _18VeriTabanıİşlemleri;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionYöntemi {

    //Ardışık işlemler gerçekleşirken sürecin bir noktasında bir sorgu hata verebilir.
    //Bu durumlarda süreçteki diğer işlemleri de geri almak isteyebiliriz. İşte bu durumlarda Transaction kullanırız.
    //Veri tabanlarında eğer, bir veri tabanı Transaction’ı başarılı ise “commit” edilir, değilse “rollback” edilir.
    //“commit” edildiğinde değişiklikle kalıcı olarak veri tabanına gönderilir.
    //“rollback” yapılırsa ise o ana kadar yapılmış olan tüm değişiklikler geri alınır.

    public static final String DB_URL = "jdbc:postgresql://Localhost/JavaDb";
    public static final String DB_USER = "postgres";
    public static final String DB_PASSWORD = "root";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //“setAutoCommit” fonksiyonu ile otomatik commit işlemi kapatılabilir. Böylece, Transaction yönetimini yazılımcının üstlenmesi gerekmektedir.
            //Aşağıdaki örnekte false yaparak Transaction yönetimini üzerimize aldık.
            connection.setAutoCommit(false);

            PreparedStatement pr = connection.prepareStatement("INSERT INTO students( name, id) VALUES (?,?)");
            pr.setString(1, "John");
            pr.setInt(2, 1);
            pr.executeUpdate();


            //Sembolik olarak bir if bloğu içine hata fırlatan bir kod ekledik.
            //O hata fırlatan kısmı açtığımızda veri tabanına bir kayıt eklemek komutu işletmiş olsa bile hata alındığından “rollback” fonksiyonu çağırıyoruz.
            //Böylece, o ana kadar yapılmış olan değişikliklerin geri alınmasını sağlıyoruz.
            if (true){
                throw new SQLException();

            }

            pr.setString(1,"Alex");
            pr.setInt(2, 4);
            pr.executeUpdate();

            connection.commit();
            pr.close();
            connection.close();
        } catch (SQLException e) {
            if (connection != null){
                try {
                    connection.rollback();
                }catch (SQLException throwables
                ){
                    throwables.printStackTrace();
                }
            }
            System.out.println(e.getMessage());
        }
    }
}
