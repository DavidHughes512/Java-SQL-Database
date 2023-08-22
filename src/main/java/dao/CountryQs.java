package dao;

import models.Contacts;
import models.Countries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**This Class contains the methods required for connecting to the SQL Database and pulling required data*/
public class CountryQs {
    /** This is the select method. This method selects data from the SQL Database*/
    public static void select() throws SQLException {
        String sql = "SELECT * FROM COUNTRIES";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Countries.Countries.add(new Countries(rs.getInt("Country_ID"),
                    rs.getString("Country"),
                    rs.getTimestamp("Create_Date"),
                    rs.getString("Created_By"),
                    rs.getTimestamp("Last_Update"),
                    rs.getString("Last_Updated_By")));
        }
    }
}
