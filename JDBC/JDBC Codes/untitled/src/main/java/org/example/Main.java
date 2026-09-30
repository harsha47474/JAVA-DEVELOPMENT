package org.example;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        *  import package
        *  load and register
        *  create connection
        *  create statement
        *  execute statement
        *  process statement
        *  close the connection
        */
        try {
            String url = "jdbc:postgresql://localhost:5432/Demo";
            String username = "postgres";
            String password = "Qwertyuiop@27";

//            String query = "CREATE TABLE users (id INT PRIMARY KEY, name VARCHAR(50), age INT)";

            Class.forName("org.postgresql.Driver"); // load the class file / the driver

            Connection con = DriverManager.getConnection(url, username, password); // this is same as Connection con = new PostgreSQLConnection(...);
            System.out.println("Connected to database successfully");

            Statement st = con.createStatement();
//            st.executeUpdate(query); // this doesn't need result set because it is updating the database with new table

//            String query = "INSERT INTO users VALUES (1, 'Harsha', 19)";
//            st.executeUpdate(query);
//            System.out.println("Inserted users successfully");

//            ResultSet rs = st.executeQuery("SELECT name FROM users WHERE id = 1");
//            System.out.println(rs.next()); // we have to do this anyway cuz pointer will be before the data and we have to go to that data to print it (if not understood see the leceture again)
//            System.out.println(rs.getString("name")); // or we can store in String variable and print it


            // NOW HOW TO FETCH ALL THE ROWS ?
            ResultSet rs2 = st.executeQuery("SELECT * FROM users");
            while(rs2.next()){
                System.out.print(rs2.getInt(1) + "-");
                System.out.print(rs2.getString(2) + "-");
                System.out.println(rs2.getInt(3));
            }

//            st.executeUpdate("DELETE FROM users WHERE id = 1");

            // ---------PREPARED STATEMENT----------
            int id = 101;
            String name = "Harsha";
            int age = 19;
            String sql = "INSERT INTO users VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);

            ps.executeUpdate();

            con.close();
            System.out.println("Connection closed");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}