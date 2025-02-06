import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final String connectionString = "jdbc:postgresql://localhost/db";

    private static final String allContactsQuery = "SELECT Name, Handynummer, Gesucht FROM Kontakte ORDER BY Name",
                                oneContactQuery = "SELECT Name, Handynummer, Gesucht FROM Kontakte WHERE Name = ?",
                                updateCountQuery = "UPDATE Kontakte SET Gesucht = Gesucht + 1 WHERE Name = ANY (?);";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(connectionString);
            String contactName;
            Scanner scanner = new Scanner(System.in);

            Statement allContactsStatement = connection.createStatement();
            PreparedStatement oneContactStatement = connection.prepareStatement(oneContactQuery);
            PreparedStatement updateCountStatement = connection.prepareStatement(updateCountQuery);
            ResultSet result;

            while (true) {
                System.out.println("Name angeben: ");

                contactName = scanner.nextLine();

                if (contactName.equals("_exit"))
                    break;

                if (contactName.isBlank())
                    result = allContactsStatement.executeQuery(allContactsQuery);
                else {
                    oneContactStatement.setString(1, contactName);
                    result = oneContactStatement.executeQuery();
                }


                int rows;
                ArrayList<String> hitContacts = new ArrayList<>();

                for (rows = 0; result.next(); rows++) {
                    System.out.println("Name: " + result.getString(1) + " | Handynummer: "
                            + result.getString(2) + " (" + result.getInt(3) + ")");

                    hitContacts.add(result.getString(1));
                }

                if (rows < 1)
                    System.out.println("\nKein Kontakt gefunden");
                else {
                    Array sqlArray = connection.createArrayOf("VARCHAR", hitContacts.toArray());
                    updateCountStatement.setArray(1, sqlArray);
                    updateCountStatement.executeUpdate();
                }

                System.out.println();

                result.close();
            }

            updateCountStatement.close();
            oneContactStatement.close();
            allContactsStatement.close();
            scanner.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Verbindung ist abgebrochen");
            e.printStackTrace();
        }

        System.out.println("Verlassen...");
    }
}