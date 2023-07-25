package dao;

import java.sql.PreparedStatement;
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




}
