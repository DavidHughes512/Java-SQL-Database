package dao;

import models.Appointments;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class AppointmentQs {

    public static void insert(int appointmentID, String title, String description, String location, String type, java.sql.Timestamp start, java.sql.Timestamp end, java.sql.Timestamp createDate, String createdBy, java.sql.Timestamp lastUpdate, String lastUpdatedBy, int custID, int userID, int contactID) throws SQLException {
        String sql = "INSERT INTO APPOINTMENTS (Appointment_ID, Title, Description, Location, Type, Start, End, Create_Date, Created_By, Last_Update, Last_Updated_By, Customer_ID, User_ID, Contact_ID) VALUES(?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setInt(1, appointmentID);
        ps.setString(2,title);
        ps.setString(3, description);
        ps.setString(4,location);
        ps.setString(5,type);
        ps.setTimestamp(6,start);
        ps.setTimestamp(7, end);
        ps.setTimestamp(8,createDate);
        ps.setString(9,createdBy);
        ps.setTimestamp(10,lastUpdate);
        ps.setString(11,lastUpdatedBy);
        ps.setInt(12, custID);
        ps.setInt(13, userID);
        ps.setInt(14, contactID);
        ps.executeUpdate();
    }


    public static void update(int appointmentID, String title, String location, String type, java.sql.Timestamp start, java.sql.Timestamp end, java.sql.Timestamp createDate, String createdBy, java.sql.Timestamp lastUpdate, String lastUpdatedBy, int custID, int userID, int contactID) throws SQLException {
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
        ps.executeUpdate();
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
        while(rs.next()) {
            Appointments.allApts.add(new Appointments(
            rs.getInt("Appointment_ID"),
            rs.getString("Title"),
            rs.getString("Description"),
            rs.getString("Location"),
            rs.getString("Type"),
            rs.getTimestamp("Start"),
            rs.getTimestamp("End"),
            rs.getDate("Create_Date"),
            rs.getString("Created_By"),
            rs.getTimestamp("Last_Update"),
            rs.getString("Last_Updated_By"),
            rs.getInt("Customer_ID"),
            rs.getInt("User_ID"),
            rs.getInt("Contact_ID")));
        }
    }


    public static void selectByWeek() throws SQLException {
        String sql = "SELECT * FROM APPOINTMENTS WHERE Start BETWEEN NOW() AND NOW() +7";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Appointments.weekApts.add(new Appointments(
                    rs.getInt("Appointment_ID"),
                    rs.getString("Title"),
                    rs.getString("Description"),
                    rs.getString("Location"),
                    rs.getString("Type"),
                    rs.getTimestamp("Start"),
                    rs.getTimestamp("End"),
                    rs.getDate("Create_Date"),
                    rs.getString("Created_By"),
                    rs.getTimestamp("Last_Update"),
                    rs.getString("Last_Updated_By"),
                    rs.getInt("Customer_ID"),
                    rs.getInt("User_ID"),
                    rs.getInt("Contact_ID")));
        }
    }


    public static void selectByMonth() throws SQLException {
        String sql = "SELECT * FROM APPOINTMENTS WHERE Start BETWEEN NOW() AND NOW() +31";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Appointments.monthApts.add(new Appointments(
                    rs.getInt("Appointment_ID"),
                    rs.getString("Title"),
                    rs.getString("Description"),
                    rs.getString("Location"),
                    rs.getString("Type"),
                    rs.getTimestamp("Start"),
                    rs.getTimestamp("End"),
                    rs.getDate("Create_Date"),
                    rs.getString("Created_By"),
                    rs.getTimestamp("Last_Update"),
                    rs.getString("Last_Updated_By"),
                    rs.getInt("Customer_ID"),
                    rs.getInt("User_ID"),
                    rs.getInt("Contact_ID")));
        }
    }
    public static java.sql.Timestamp getTime(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp;
    }


}