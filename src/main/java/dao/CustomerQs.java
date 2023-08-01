package dao;

import models.Customers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class CustomerQs {

    public static int insert(String name, String address, String postal_Code, int phone, java.sql.Timestamp createDate, String createdBy, java.sql.Timestamp lastUpdate, String lastUpdatedBy, int divisionID) throws SQLException {
        String sql = "INSERT INTO CUSTOMERS (Customer_Name, Address, Postal_Code, Phone, Create_Date, Created_By, Last_Update, Last_Updated_By, Division_ID) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setString(1,name);
        ps.setString(2,address);
        ps.setString(3,postal_Code);
        ps.setInt(4,phone);
        ps.setTimestamp(5,createDate);
        ps.setString(6,createdBy);
        ps.setTimestamp(7,lastUpdate);
        ps.setString(8,lastUpdatedBy);
        ps.setInt(9, divisionID);
        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }


    public static int update(int Customer_ID, String name, String address, String postal_Code, int phone, java.sql.Timestamp createDate, String createdBy, java.sql.Timestamp lastUpdate, String lastUpdatedBy, int divisionID) throws SQLException {
        String sql = "UPDATE CUSTOMERS SET Customer_Name = ?, Address = ?, Postal_Code = ?, Phone = ?, Create_Date = ?, Created_By = ?, Last_Update = ?, Last_Updated_By = ?, Division_ID = ? WHERE Customer_ID = ?";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setInt(10,Customer_ID);
        ps.setString(1,name);
        ps.setString(2,address);
        ps.setString(3,postal_Code);
        ps.setInt(4,phone);
        ps.setTimestamp(5,createDate);
        ps.setString(6,createdBy);
        ps.setTimestamp(7,lastUpdate);
        ps.setString(8,lastUpdatedBy);
        ps.setInt(9, divisionID);
        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }


    public static int delete(int Customer_ID) throws SQLException {
        String sql = "DELETE FROM CUSTOMERS WHERE Customer_ID = ?";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setInt(1,Customer_ID);
        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }


    public static void select() throws SQLException {
        String sql = "SELECT * FROM CUSTOMERS";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Customers.CustomerList.add(new Customers(rs.getInt("Customer_ID"),
                    rs.getString("Customer_Name"),
                    rs.getString("Address"),
                    rs.getString("Postal_Code"),
                    rs.getString("Phone"),
                    rs.getInt("Division_ID")));

        }
    }


    public static void selectByDivision(int divisonID) throws SQLException {
        String sql = "SELECT * FROM CUSTOMERS WHERE Division_ID = ?";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setInt(1, divisonID);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            int custID = rs.getInt("Customer_ID");
            String name = rs.getString("Customer_Name");
            String address = rs.getString("Address");
            String postCode = rs.getString("Postal_Code");
            String phone = rs.getString("Phone");
            java.sql.Timestamp createdDate = rs.getTimestamp("Create_Date");
            String createdBy = rs.getString("Created_By");
            java.sql.Timestamp lastUpdateDate = rs.getTimestamp("Last_Update");
            String lastUpdatedBy = rs.getString("Last_Updated_By");
            int division = rs.getInt("Division_ID");
            System.out.print(custID + " | ");
            System.out.print(address + " | ");
            System.out.print(postCode + " | ");
            System.out.print(phone + " | ");
            System.out.print(createdDate + " | ");
            System.out.print(createdBy + " | ");
            System.out.print(lastUpdateDate + " | ");
            System.out.print(lastUpdatedBy + " | ");
            System.out.print(division + " | ");
            System.out.print(name + "\n");
        }
    }

}
