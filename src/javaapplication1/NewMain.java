/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class NewMain {

    //THIS CODE WAS MADE ONLY FOR TESTING THE CONNECTION WITH THE MySQL Database , checking the connection & inserting some values was done successfully
    //ALSO SELECTING THE DATA AND GETTING IT FROM THE DATA BASE WAS TESTED and it was done CORRECTLY 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		// TODO code application logic here
		Connection conn = null;
		Statement stmt = null;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (Exception e) {
				System.out.println(e);
			}
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/networks2", "root", "");
			System.out.println("Connection is created successfully:");
			stmt = (Statement) conn.createStatement();
			String query1 = "INSERT INTO table1 " + "VALUES (1,34)";
			stmt.executeUpdate(query1);
			System.out.println("Record is inserted in the table successfully..................");

			String sql = ("SELECT * FROM table1 ");
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				int id = rs.getInt("id");
				String str1 = rs.getString("name");
				System.out.println(id + "      EEEE");
				System.out.println(str1 + "      FFFF");
			}

		} catch (SQLException excep) {
			excep.printStackTrace();
		} catch (Exception excep) {
			excep.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}   
            
    }
    
}
