
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

    public class AddPeople {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Eklemek istediğiniz kişi sayısını girin: ");
            int numOfPeople = sc.nextInt();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");

                String query = "CREATE TABLE IF NOT EXISTS people (name VARCHAR(15), age INTEGER)";
                PreparedStatement createTableStmt = conn.prepareStatement(query);
                createTableStmt.execute();

                query = "INSERT INTO people (name, age) VALUES (?, ?)";
                PreparedStatement insertPeopleStmt = conn.prepareStatement(query);

                for (int i = 0; i < numOfPeople; i++) {
                    System.out.print("Kişi " + (i + 1) + " ismini girin: ");
                    String name = sc.next();

                    System.out.print("Kişi " + (i + 1) + " yaşını girin: ");
                    int age = sc.nextInt();

                    insertPeopleStmt.setString(1, name);
                    insertPeopleStmt.setInt(2, age);
                    insertPeopleStmt.execute();
                }
                System.out.println("Kişiler başarıyla eklendi.");
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("Hata: " + e.getMessage());
            }
            sc.close();
        }
    }


