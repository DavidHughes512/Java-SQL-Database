package dao;

import models.Contacts;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**This Class contains the methods required for connecting to the SQL Database and pulling required data*/
public class ContactQs {
    /** This is the select method. This method selects data from the SQL Database*/
    public static void select() throws SQLException {
        String sql = "SELECT * FROM CONTACTS";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Contacts.Contacts.add(new Contacts(rs.getInt("Contact_ID"),
                    rs.getString("Contact_Name"),
                    rs.getString("Email")));
        }
    }

}
