package it.alex;

import java.sql.*;

public class DBConnection {
    private static Connection connection;
    static final String DB_URL = "jdbc:mysql://localhost:3306/inventory";
    static final String USER = "root";
    static final String PASS = "Bokunohero98";
    static final String QUERY = "SELECT iditem, name, description, quantity, price, category FROM item";
    static final String ADDQUERY = "INSERT INTO item VALUES (?,?,?,?,?,?)";


    public static Connection getConnection(){
        if(connection == null){
            try{
                //CARICAMENTO DEL DRIVER JDBC
                Class.forName("com.mysql.cj.jdbc.Driver");

                //CREAZIONE DEL DATABASE
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Connessione al DB riuscita");
            }
            catch (ClassNotFoundException e){
                e.printStackTrace();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }

        return connection;
    }
    // Metodo per chiudere la connessione al database
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connessione al DB chiusa");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
