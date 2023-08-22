package dao;

import models.Countries;
import models.Customers;
import models.FirstLvlDivisions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**This Class contains the methods required for connecting to the SQL Database and pulling required data*/
public class LvLDivisionQs {
    /** This is the select method. This method selects data from the SQL Database*/
    public static void select() throws SQLException {
        String sql = "SELECT * FROM FIRST_LEVEL_DIVISIONS";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            FirstLvlDivisions.States.add(new FirstLvlDivisions(rs.getInt("Division_ID"),
                    rs.getString("Division"),
                    rs.getTimestamp("Create_Date"),
                    rs.getString("Created_By"),
                    rs.getTimestamp("Last_Update"),
                    rs.getString("Last_Updated_By"),
                    rs.getInt("Country_ID")));
        }
    }
    /** This is the selectByCountry method. This method selects data from the SQL Database by country ID*/
    public static void selectByCountry(int countryID) throws SQLException {
        String sql = "SELECT * FROM FIRST_LEVEL_DIVISIONS WHERE Country_ID = ?";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setInt(1, countryID);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            FirstLvlDivisions.Divisions.add(new FirstLvlDivisions(rs.getInt("Division_ID"),
                    rs.getString("Division"),
                    rs.getTimestamp("Create_Date"),
                    rs.getString("Created_By"),
                    rs.getTimestamp("Last_Update"),
                    rs.getString("Last_Updated_By"),
                    rs.getInt("Country_ID")));

        }
    }
}
