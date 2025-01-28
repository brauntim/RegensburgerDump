package com.example;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        final String  URL = "jdbc:postgresql://hera.hs-regensburg.de:5432/loh33595?currentSchema=Übung10";
        final String  USER = "loh33595";
        final String PASSWORD= "loh33595";

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT name, handynummer FROM kontakte ORDER BY name");

            while (rs.next()) {
                System.out.printf("%s %s\n", rs.getString(1), rs.getString(2));
            }
            con.close();
            st.close();
            rs.close();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}