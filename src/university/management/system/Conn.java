package university.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {

    Connection c;
    Statement s;
    Conn(){
        try{
            //Replace the jdbc driver with your driver
            Class.forName("JDBC_DRIVER");
            c = DriverManager.getConnection("MYSQL_DATABASE","MYSQL_USERNAME","MYSQL_PASSWORD");
            s = c.createStatement();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
