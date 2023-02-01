import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CommitRollback {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scan=new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
        con.setAutoCommit(false);
        String sorgu1="delete from pide_kuyrugu where ad='ali'";
        String sorgu2="update pide_kuyrugu set soyad='guleryuz'";

        Statement statement=con.createStatement();
        statement.executeUpdate(sorgu1);
        statement.executeUpdate(sorgu2);

        System.out.println("İşlemleriniz kaydedilsin mi? : (yes/no)");
        String cevap=scan.nextLine();

        if (cevap.equalsIgnoreCase("yes")){
            con.commit();
            System.out.println("Veri tabanı güncellendi..");
        }else{
            con.rollback();
            System.out.println("Veri tabanı güncellemesi iptal edildi...");
        }
    }
}
