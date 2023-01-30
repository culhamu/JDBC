import java.sql.*;

public class JDBC01_Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1 - Ilgili Driver'i yuklemeliyiz. MySQL kullandigimizi bildiriyoruz.
        // Driver'i bulamama ihtimaline karsi forName metodu icin ClassNotFoundException
        // method signature'imiza axception olarak firlatmamizi istiyor.
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2 - Baglantiyi olusturmak icin username ve password girmeliyiz.
        // Burada da bu username ve password'un yanlis olma ihtimaline karsi
        // SQLException firlatmamizi istiyor.

        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");

        // 3 - SQL query'leri icin bir Statement objesi olusturup , javada SQL
        // sorgularimiz icin bir alan acacagiz.

        Statement st=con.createStatement();

        //SQL Query'lerimizi artık çalıştırabilriz,

       ResultSet rs= st.executeQuery("select * from personel");

       //5- sonuçları görmek için iterator ile set içindeki elemanları bir while döngüsü ile yazdırıyoruz.

       while (rs.next()){

           System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
       }

       //6- oluşturulan nesneleri kapatalım
        con.close();
       st.close();
       rs.close();
    }
}
