package electricitybillingsystem;
import java.sql.*;


public class DBTest {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Project?characterEncoding=utf8",
                "root",
                "45230"
);
            System.out.println("✅ Connected to MySQL!");
            con.close();
        } catch (Exception e) {
            System.out.println("❌ Failed to connect: " + e);
        }
    }
}
