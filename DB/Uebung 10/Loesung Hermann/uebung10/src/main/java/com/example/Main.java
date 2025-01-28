package com.example;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final String  URL = "jdbc:postgresql://hera.hs-regensburg.de:5432/loh33595?currentSchema=Übung10";
        final String  USER = "loh33595";
        final String PASSWORD= "loh33595";

        try {
            Scanner sc = new Scanner(System.in);
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement st = con.prepareStatement("INSERT INTO kontakte (name, handynummer) VALUES (?, ?)");
           
            System.out.print("Kundenname: ");
            st.setString(1, sc.nextLine());

            System.out.print("Handynummer: ");
            st.setString(2, sc.nextLine());
            
            ResultSet rs = st.executeUpdate();

            if()


            sc.close();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}