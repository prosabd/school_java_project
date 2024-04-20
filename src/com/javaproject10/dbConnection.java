/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javaproject10;

//import jdk.internal.org.jline.utils.Log;

import java.sql.*;

/**
 *
 * @author prosa
 */
public class dbConnection {

        private String url = "jdbc:mysql://localhost:3306/java_tp";
        private String db_user = "root";
        private String db_password = "";
        private Statement st = null;
        private Connection cn = null;

        protected ResultSet rs = null;

    public static void main(String[] args) {
//        try {
//            login("admin", "123");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }
    public static boolean login(String username, String password) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/java_tp";
        String db_user = "root";
        String db_password = "";
        Statement st = null;
        Connection cn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(url, db_user, db_password);
            st = cn.createStatement();

            try{
                String sql = "SELECT * FROM `user` WHERE `username` = '"+username+"' AND `password` = '"+password+"'";
                st.executeQuery(sql);
                System.out.println("Connected");
                if (st.getResultSet().next()) {
                    System.out.println("Connected");
                    return true;
                } else {
                    return false;
//                    JOptionPane.showMessageDialog(null, "password incorrect", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            String connectionMessage = "connexion incorrect";
            throw new RuntimeException(e);
        }
        finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (cn != null) {
                    cn.close();
                }
                else{
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ResultSet search(String search) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/java_tp";
        String db_user = "root";
        String db_password = "";
        Statement st = null;
        Connection cn = null;
        ResultSet rs = null;
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            cn = DriverManager.getConnection(url, db_user, db_password);

            // Create a statement
            st = cn.createStatement();

            // Create the SQL query
            String sql = "SELECT * FROM `employeeinfo` WHERE `EmployeeID` LIKE ? OR Name LIKE ? OR Gender LIKE ? OR Age LIKE ? OR BloodGroup LIKE ? OR ContactNO LIKE ? OR Qualification LIKE ? OR DOJ LIKE ? OR Address LIKE ? OR EmpImage LIKE ?";

            // Create a PreparedStatement for the SQL query
            PreparedStatement ps = cn.prepareStatement(sql);

            // Set the parameter in the PreparedStatement
            ps.setString(1, "%" + search + "%");
            ps.setString(2, "%" + search + "%");
            ps.setString(3, "%" + search + "%");
            ps.setString(4,"%" + search + "%");
            ps.setString(5, "%" + search + "%");
            ps.setString(6, "%" + search + "%");
            ps.setString(7, "%" + search + "%");
            ps.setString(8, "%" + search + "%");
            ps.setString(9, "%" + search + "%");
            ps.setString(10, "%" + search + "%");

            // Execute the query and store the results in rs
            rs = ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    public ResultSet loadTable() throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/java_tp";
        String db_user = "root";
        String db_password = "";
        Statement st = null;
        Connection cn = null;
        ResultSet rs = null;
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            cn = DriverManager.getConnection(url, db_user, db_password);

            // Create a statement
            st = cn.createStatement();

            // Create the SQL query
            String sql = "SELECT * FROM `employeeinfo`";

            // Create a PreparedStatement for the SQL query
            PreparedStatement ps = cn.prepareStatement(sql);

            rs = ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    public void insert(String name, String gender, Integer age, String bloodgroup, Integer contact, String qualification, String doj, String address, String image ) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/java_tp";
        String db_user = "root";
        String db_password = "";
        Statement st = null;
        Connection cn = null;
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            cn = DriverManager.getConnection(url, db_user, db_password);

            // Create a statement
            st = cn.createStatement();

            // Create the SQL query
            String sql = "INSERT INTO `employeeinfo` (`Name`, `Gender`, `Age`, `BloodGroup`, `ContactNO`, `Qualification`, `DOJ`, `Address`, `EmpImage`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Create a PreparedStatement for the SQL query
            PreparedStatement ps = cn.prepareStatement(sql);

            // Set the parameters in the PreparedStatement
            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setInt(3, age);
            ps.setString(4, bloodgroup);
            ps.setInt(5, contact);
            ps.setString(6, qualification);
            ps.setString(7, doj);
            ps.setString(8, address);
            ps.setString(9, image);

            // Execute the query
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(String name, String gender, Integer age, String bloodgroup, Integer contact, String qualification, String doj, String address, Integer id ) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/java_tp";
        String db_user = "root";
        String db_password = "";
        Statement st = null;
        Connection cn = null;

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            cn = DriverManager.getConnection(url, db_user, db_password);

            // Create a statement
            st = cn.createStatement();

            // Create the SQL query
            String sql = "UPDATE `employeeinfo` SET `Name` = ?, `Gender` = ?, `Age` = ?, `BloodGroup` = ?, `ContactNO` = ?, `Qualification` = ?, `DOJ` = ?, `Address` = ? WHERE `EmployeeID` = ?";

            // Create a PreparedStatement for the SQL query
            PreparedStatement ps = cn.prepareStatement(sql);

            // Set the parameters in the PreparedStatement
            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setInt(3, age);
            ps.setString(4, bloodgroup);
            ps.setInt(5, contact);
            ps.setString(6, qualification);
            ps.setString(7, doj);
            ps.setString(8, address);
            ps.setInt(9, id);

            // Execute the query
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String employeeID) {
        String url = "jdbc:mysql://localhost:3306/java_tp";
        String db_user = "root";
        String db_password = "";
        Statement st = null;
        Connection cn = null;

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            cn = DriverManager.getConnection(url, db_user, db_password);

            // Create a statement
            st = cn.createStatement();

            // Create the SQL query
            String sql = "DELETE FROM `employeeinfo` WHERE `EmployeeID` = ?";

            // Create a PreparedStatement for the SQL query
            PreparedStatement ps = cn.prepareStatement(sql);

            // Set the parameters in the PreparedStatement
            ps.setString(1, employeeID);

            // Execute the query
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
