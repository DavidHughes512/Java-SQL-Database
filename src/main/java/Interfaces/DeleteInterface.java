package Interfaces;

import java.sql.SQLException;
/** This is the Delete interface. This Interface establishes the grounds for lambdas to be used for deleting various list entries*/
@FunctionalInterface
public interface DeleteInterface {
    void delete(int ID) throws SQLException;
}
