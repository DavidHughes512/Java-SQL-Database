package dao;

import Interfaces.TimeConversions;
import models.Appointments;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**This Class contains the methods required for connecting to the SQL Database and pulling required data*/

public class AppointmentQs{

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /** This is A lambda for Converting the Time of Appointments pulled from the database. This Lambda Provides a clean execute for Appointment data to be manipulated and helps cut down on clutter when refreshing Lists*/
    static TimeConversions convert = timeToConvert -> {
        LocalDateTime sDateTime = LocalDateTime.parse(timeToConvert, dtf);
        ZonedDateTime zSDateTIme = ZonedDateTime.of(sDateTime, ZoneId.of("UTC"));
        ZonedDateTime lzSDateTime = ZonedDateTime.ofInstant(zSDateTIme.toInstant(), ZoneId.systemDefault());
        String zdtStartS = lzSDateTime.format(dtf).toString();
        LocalDateTime startDT = LocalDateTime.parse(zdtStartS, dtf);
        return startDT.format(dtf).toString();
    };

    /*public static String convertEndTime(String timeToConvert){
        LocalDateTime eDateTime = LocalDateTime.parse(timeToConvert, dtf);
        ZonedDateTime zEDateTIme = ZonedDateTime.of(eDateTime, ZoneId.of("UTC"));
        ZonedDateTime lzEDateTime = ZonedDateTime.ofInstant(zEDateTIme.toInstant(), ZoneId.systemDefault());
        String zdtEndS = lzEDateTime.format(dtf).toString();
        LocalDateTime endDT = LocalDateTime.parse(zdtEndS, dtf);
        return endDT.format(dtf).toString();
    }*/
    /** This is the insert method. This method inserts data into the SQL Database*/
    public static void insert(int appointmentID, String title, String description, String location, String type, String start, String end, java.sql.Timestamp createDate, String createdBy, java.sql.Timestamp lastUpdate, String lastUpdatedBy, int custID, int userID, int contactID) throws SQLException {
        String sql = "INSERT INTO APPOINTMENTS (Appointment_ID, Title, Description, Location, Type, Start, End, Create_Date, Created_By, Last_Update, Last_Updated_By, Customer_ID, User_ID, Contact_ID) VALUES(?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setInt(1, appointmentID);
        ps.setString(2,title);
        ps.setString(3, description);
        ps.setString(4,location);
        ps.setString(5,type);
        ps.setString(6,start);
        ps.setString(7, end);
        ps.setTimestamp(8,createDate);
        ps.setString(9,createdBy);
        ps.setTimestamp(10,lastUpdate);
        ps.setString(11,lastUpdatedBy);
        ps.setInt(12, custID);
        ps.setInt(13, userID);
        ps.setInt(14, contactID);
        ps.executeUpdate();
    }

    /** This is the update method. This method updates data in the SQL Database*/
    public static void update(int appointmentID, String title, String description, String location, String type, String start, String end, java.sql.Timestamp createDate, String createdBy, java.sql.Timestamp lastUpdate, String lastUpdatedBy, int custID, int userID, int contactID) throws SQLException {
        String sql = "UPDATE APPOINTMENTS SET Title = ?, Description = ?, Location = ?, Type = ?, Start = ?, End = ?, Create_Date = ?, Created_By = ?, Last_Update = ?, Last_Updated_By = ?, Customer_ID = ?, User_ID = ?, Contact_ID = ? WHERE Appointment_ID = ?";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setString(1,title);
        ps.setString(2, description);
        ps.setString(3,location);
        ps.setString(4,type);
        ps.setString(5,start);
        ps.setString(6, end);
        ps.setTimestamp(7,createDate);
        ps.setString(8,createdBy);
        ps.setTimestamp(9,lastUpdate);
        ps.setString(10,lastUpdatedBy);
        ps.setInt(11, custID);
        ps.setInt(12, userID);
        ps.setInt(13, contactID);
        ps.setInt(14, appointmentID);
        ps.executeUpdate();
    }

    /** This is the delete method. This method deletes data from the SQL Database*/
    public static int delete(int appointmentID) throws SQLException {
        String sql = "DELETE FROM APPOINTMENTS WHERE Appointment_ID = ?";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setInt(1,appointmentID);
        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }

    /** This is the select method. This method selects data from the SQL Database*/
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
                    /** This is A lambda for Converting the Time of Appointments pulled from the database. This Lambda Provides a clean execute for Appointment data to be manipulated and helps cut down on clutter when refreshing Lists*/
            convert.convertTime(rs.getString("Start")),
                    /** This is A lambda for Converting the Time of Appointments pulled from the database. This Lambda Provides a clean execute for Appointment data to be manipulated and helps cut down on clutter when refreshing Lists*/
            convert.convertTime(rs.getString("End")),
            rs.getDate("Create_Date"),
            rs.getString("Created_By"),
            rs.getTimestamp("Last_Update"),
            rs.getString("Last_Updated_By"),
            rs.getInt("Customer_ID"),
            rs.getInt("User_ID"),
            rs.getInt("Contact_ID")));
        }
    }

    /** This is the selectByWeek method. This method selects data from the SQL Database By Week*/
    public static void selectByWeek() throws SQLException {
        String sql = "select * from appointments where Start between current_date() and current_date() + interval 1 week";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Appointments.weekApts.add(new Appointments(
                    rs.getInt("Appointment_ID"),
                    rs.getString("Title"),
                    rs.getString("Description"),
                    rs.getString("Location"),
                    rs.getString("Type"),
                    //convertStartTime
                    //convertEndTime
                    /** This is A lambda for Converting the Time of Appointments pulled from the database. This Lambda Provides a clean execute for Appointment data to be manipulated and helps cut down on clutter when refreshing Lists*/
                    convert.convertTime(rs.getString("Start")),
                    /** This is A lambda for Converting the Time of Appointments pulled from the database. This Lambda Provides a clean execute for Appointment data to be manipulated and helps cut down on clutter when refreshing Lists*/
                    convert.convertTime(rs.getString("End")),
                    rs.getDate("Create_Date"),
                    rs.getString("Created_By"),
                    rs.getTimestamp("Last_Update"),
                    rs.getString("Last_Updated_By"),
                    rs.getInt("Customer_ID"),
                    rs.getInt("User_ID"),
                    rs.getInt("Contact_ID")));
        }
    }

    /** This is the selectByMonth method. This method selects data from the SQL Database By Month*/
    public static void selectByMonth() throws SQLException {
        String sql = "select * from appointments where Start between current_date() and current_date() + interval 1 month";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Appointments.monthApts.add(new Appointments(
                    rs.getInt("Appointment_ID"),
                    rs.getString("Title"),
                    rs.getString("Description"),
                    rs.getString("Location"),
                    rs.getString("Type"),
                    /** This is A lambda for Converting the Time of Appointments pulled from the database. This Lambda Provides a clean execute for Appointment data to be manipulated and helps cut down on clutter when refreshing Lists*/
                    convert.convertTime(rs.getString("Start")),
                    /** This is A lambda for Converting the Time of Appointments pulled from the database. This Lambda Provides a clean execute for Appointment data to be manipulated and helps cut down on clutter when refreshing Lists*/
                    convert.convertTime(rs.getString("End")),
                    rs.getDate("Create_Date"),
                    rs.getString("Created_By"),
                    rs.getTimestamp("Last_Update"),
                    rs.getString("Last_Updated_By"),
                    rs.getInt("Customer_ID"),
                    rs.getInt("User_ID"),
                    rs.getInt("Contact_ID")));
        }
    }

    public static void selectForAnika() throws SQLException {
        String sql = "select * from appointments where Contact_ID = 1 ";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Appointments.anikaApts.add(new Appointments(
                    rs.getInt("Appointment_ID"),
                    rs.getString("Title"),
                    rs.getString("Description"),
                    rs.getString("Location"),
                    rs.getString("Type"),
                    convert.convertTime(rs.getString("Start")),
                    convert.convertTime(rs.getString("End")),
                    rs.getDate("Create_Date"),
                    rs.getString("Created_By"),
                    rs.getTimestamp("Last_Update"),
                    rs.getString("Last_Updated_By"),
                    rs.getInt("Customer_ID"),
                    rs.getInt("User_ID"),
                    rs.getInt("Contact_ID")));
        }
    }

    public static void selectForDaniel() throws SQLException {
        String sql = "select * from appointments where Contact_ID = 2 ";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Appointments.danielApts.add(new Appointments(
                    rs.getInt("Appointment_ID"),
                    rs.getString("Title"),
                    rs.getString("Description"),
                    rs.getString("Location"),
                    rs.getString("Type"),
                    convert.convertTime(rs.getString("Start")),
                    convert.convertTime(rs.getString("End")),
                    rs.getDate("Create_Date"),
                    rs.getString("Created_By"),
                    rs.getTimestamp("Last_Update"),
                    rs.getString("Last_Updated_By"),
                    rs.getInt("Customer_ID"),
                    rs.getInt("User_ID"),
                    rs.getInt("Contact_ID")));
        }
    }

    public static void selectForLi() throws SQLException {
        String sql = "select * from appointments where Contact_ID = 3 ";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Appointments.liApts.add(new Appointments(
                    rs.getInt("Appointment_ID"),
                    rs.getString("Title"),
                    rs.getString("Description"),
                    rs.getString("Location"),
                    rs.getString("Type"),
                    convert.convertTime(rs.getString("Start")),
                    convert.convertTime(rs.getString("End")),
                    rs.getDate("Create_Date"),
                    rs.getString("Created_By"),
                    rs.getTimestamp("Last_Update"),
                    rs.getString("Last_Updated_By"),
                    rs.getInt("Customer_ID"),
                    rs.getInt("User_ID"),
                    rs.getInt("Contact_ID")));
        }
    }


}
