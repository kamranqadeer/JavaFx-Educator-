/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package educator.DataBase;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author KAMRAN QADEER
 */
public class Connection {

    Statement pst;
    ResultSet rs;
    private static java.sql.Connection con = null;
    private static final Connection handler = null;

    public static java.sql.Connection ConnectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Educator?useSSL=false", "root", "");
            if (con != null) {
                System.out.println("Server is Running");
            }
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                /* ignored */ }
        }
    }
}
