/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package electricitybillingsystem;

import java.sql.*;

public class conn {
    Connection c;
    Statement s;

    public conn() {
        try {
            // ✅ OLD driver class name (for MySQL 5.1.6)
            Class.forName("com.mysql.jdbc.Driver");

            // ✅ JDBC URL and credentials
           c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Project?characterEncoding=utf8",
                "root",
                "45230"
            );


            // ✅ Create SQL statement object
            s = c.createStatement();

            System.out.println("✅ Connected to MySQL using 5.1.6 driver.");
        } catch (Exception e) {
            System.out.println("❌ Database connection failed: " + e);
        }
    }
}


