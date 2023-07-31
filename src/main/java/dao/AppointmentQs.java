package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentQs {

    public static int insert(String title, String location, String type, java.sql.Timestamp start, java.sql.Timestamp end, java.sql.Timestamp createDate, String createdBy, java.sql.Timestamp lastUpdate, String lastUpdatedBy, int custID, int userID, int contactID) throws SQLException {
        String sql = "INSERT INTO APPOINTMENTS  (Title, Description, Location, Type, Start, End, Create_Date, Created_By, Last_Update, Last_Updated_By, Customer_ID, User_ID, Contact_ID) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setString(1,title);
        ps.setString(2,location);
        ps.setString(3,type);
        ps.setTimestamp(4,start);
        ps.setTimestamp(5, end);
        ps.setTimestamp(6,createDate);
        ps.setString(7,createdBy);
        ps.setTimestamp(8,lastUpdate);
        ps.setString(9,lastUpdatedBy);
        ps.setInt(10, custID);
        ps.setInt(11, userID);
        ps.setInt(12, contactID);
        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }


    public static int update(int appointmentID, String title, String location, String type, java.sql.Timestamp start, java.sql.Timestamp end, java.sql.Timestamp createDate, String createdBy, java.sql.Timestamp lastUpdate, String lastUpdatedBy, int custID, int userID, int contactID) throws SQLException {
        String sql = "UPDATE APPOINTMENTS SET Title = ?, Description = ?, Location = ?, Type = ?, Start = ?, End = ?, Create_Date = ?, Created_By = ?, Last_Update = ?, Last_Updated_By = ?, Customer_ID = ?, User_ID = ?, Contact_ID = ? WHERE Appointment_ID = ?";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setInt(13,appointmentID);
        ps.setString(1,title);
        ps.setString(2,location);
        ps.setString(3,type);
        ps.setTimestamp(4,start);
        ps.setTimestamp(5, end);
        ps.setTimestamp(6,createDate);
        ps.setString(7,createdBy);
        ps.setTimestamp(8,lastUpdate);
        ps.setString(9,lastUpdatedBy);
        ps.setInt(10, custID);
        ps.setInt(11, userID);
        ps.setInt(12, contactID);
        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }


    public static int delete(int appointmentID) throws SQLException {
        String sql = "DELETE FROM APPOINTMENTS WHERE Appointment_ID = ?";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setInt(1,appointmentID);
        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }


    public static void select() throws SQLException {
        String sql = "SELECT * FROM APPOINTMENTS";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            int appointmentID = rs.getInt("Appointment_ID");
            String title = rs.getString("Title");
            String description = rs.getString("Description");
            String location = rs.getString("Location");
            String type = rs.getString("Type");
            java.sql.Timestamp start = rs.getTimestamp("Start");
            java.sql.Timestamp end = rs.getTimestamp("End");
            java.sql.Timestamp createdDate = rs.getTimestamp("Create_Date");
            String createdBy = rs.getString("Created_By");
            java.sql.Timestamp lastUpdateDate = rs.getTimestamp("Last_Update");
            String lastUpdatedBy = rs.getString("Last_Updated_By");
            int custId = rs.getInt("Customer_ID");
            int userID = rs.getInt("User_ID");
            int contactID = rs.getInt("Contact_ID");
            System.out.print(appointmentID + " | ");
            System.out.print(title + " | ");
            System.out.print(description + " | ");
            System.out.print(location + " | ");
            System.out.print(type + " | ");
            System.out.print(start + " | ");
            System.out.print(end + " | ");
            System.out.print(createdDate + " | ");
            System.out.print(createdBy + " | ");
            System.out.print(lastUpdateDate + " | ");
            System.out.print(lastUpdatedBy + " | ");
            System.out.print(custId + " | ");
            System.out.print(userID + " | ");
            System.out.print(contactID + "\n");
        }
    }


    public static void selectByDivision(int divisonID) throws SQLException {
        String sql = "SELECT * FROM CUSTOMERS WHERE Division_ID = ?";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            int appointmentID = rs.getInt("Appointment_ID");
            String title = rs.getString("Title");
            String description = rs.getString("Description");
            String location = rs.getString("Location");
            String type = rs.getString("Type");
            java.sql.Timestamp start = rs.getTimestamp("Start");
            java.sql.Timestamp end = rs.getTimestamp("End");
            java.sql.Timestamp createdDate = rs.getTimestamp("Create_Date");
            String createdBy = rs.getString("Created_By");
            java.sql.Timestamp lastUpdateDate = rs.getTimestamp("Last_Update");
            String lastUpdatedBy = rs.getString("Last_Updated_By");
            int custId = rs.getInt("Customer_ID");
            int userID = rs.getInt("User_ID");
            int contactID = rs.getInt("Contact_ID");
            System.out.print(appointmentID + " | ");
            System.out.print(title + " | ");
            System.out.print(description + " | ");
            System.out.print(location + " | ");
            System.out.print(type + " | ");
            System.out.print(start + " | ");
            System.out.print(end + " | ");
            System.out.print(createdDate + " | ");
            System.out.print(createdBy + " | ");
            System.out.print(lastUpdateDate + " | ");
            System.out.print(lastUpdatedBy + " | ");
            System.out.print(custId + " | ");
            System.out.print(userID + " | ");
            System.out.print(contactID + "\n");
        }
    }


}
