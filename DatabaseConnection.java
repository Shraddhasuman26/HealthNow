package employees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

//    String loginUrl = "jdbc:mysql://localhost:330/ManagementSystemDB";
    String databaseUrl = "jdbc:mysql://localhost:3306/EmployeesDB";
    String username = "root";
    String password = "sanusubh";

//    Connection loginConnection;
    Connection databaseConnection;

    {
        try {
//              loginConnection = DriverManager.getConnection(loginUrl,username,password);
            databaseConnection = DriverManager.getConnection(databaseUrl,username,password);

        } catch (SQLException e){
           e.printStackTrace();
        }
    }
}