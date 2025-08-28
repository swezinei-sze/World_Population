package com.worldpopulation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Class Name: Main
 * Author: aaaa
 * Date: sdf
 * Description: Collection Test
 */

public class Main {

    /*
    main method
     */

    //Connection
    //Statement/PreparedStatement
    //ResultSet

    private Connection getConnection(String ipaddress, int portno, String dbname, String username, String password) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + ipaddress + ":" + portno + "/" + dbname, username, password);
            System.out.println("Successful Connection");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {

        //Creating ArrayList with Student Object
        Main m = new Main();
        Connection con = m.getConnection("localhost", 3306, "world_population", "root", "");

    }
}