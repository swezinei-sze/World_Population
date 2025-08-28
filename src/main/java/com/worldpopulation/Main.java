package com.worldpopulation;

import java.sql.*;
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

    protected ArrayList<Country> read_DB(Connection con) {
        ArrayList<Country> countrylist = new ArrayList<>();
        try{
            PreparedStatement stat = con.prepareStatement("SELECT country_name, capital_name," +
                    " region_name, sub_region_name FROM population");
            ResultSet rs = stat.executeQuery();
            while(rs.next()) {
                countrylist.add(new Country(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            rs.close();
            stat.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countrylist;
    }

    public static void main(String[] args) {

        //Creating ArrayList with Student Object
        Main m = new Main();
        Connection con = m.getConnection("localhost", 3306, "world_population",
                "root", "");
        ArrayList<Country> countrylist = m.read_DB(con);
        System.out.println(countrylist.getLast());

        try {
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}