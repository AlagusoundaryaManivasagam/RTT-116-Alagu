package org.example;

import java.sql.*;

public class JDBCExample {
    public static void main(String[] args) throws ClassNotFoundException {
        String dburl = "jdbc:mysql://127.0.0.1:3306/classic_models";
        String user = "root";
        String password = "Root@SQL1,";
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dburl, user, password);

            // using a regular statement
            //String SelectSQL = "Select * FROM employees where id= 1056";
            //Statement stmt = connection.createStatement();
            //ResultSet result =  stmt.executeQuery(SelectSQL);

            // when we have variables to substitute we have  to use a prepared statement
            // using prep statement is a standard best practice
            // primarily for security from sql injection attacks
            String SelectSQL = "Select * FROM employees where id= ?";
            PreparedStatement stmt = connection.prepareStatement(SelectSQL);
            stmt.setInt(1, 1056);
            ResultSet result = stmt.executeQuery();

            // using the sample from the slide
            //String SelectSQL1 = "Select * FROM employees where salary> ? and id = ?";
            //PreparedStatement stmt1 = connection.prepareStatement(SelectSQL);
            //stmt1.setInt(1,5000);
            //stmt1.setInt(2,1056);
            while(result.next())
            {
                String EmployeeID  = result.getString("id");
                String fname = result.getString("firstname");
                String lname  = result.getString("lastname");
                System.out.println(EmployeeID +" | " + fname + "|"+ lname );
            }
            result.close();
            stmt.close();
            connection.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
