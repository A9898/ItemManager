package it.alex;

import it.alex.Model.Item;

import java.sql.*;
import java.util.List;
import java.util.Scanner;


public class ItemDAO {
    private Connection connection;

    public ItemDAO(Connection connection){
        this.connection = connection;
    }

    // Metodo per aggiungere un nuovo oggetto nel database
    public void addItem(Item item) {
        // Implementazione per aggiungere l'oggetto nel database

        // Utilizza la connessione per eseguire una query di inserimento

    }

    // Metodo per modificare un oggetto esistente nel database
    public void updateItem(Item item) {
        // Implementazione per modificare l'oggetto nel database
        // Utilizza la connessione per eseguire una query di aggiornamento
    }

    // Metodo per modificare un oggetto esistente nel database
    public void removeItem(Item item) {
        // Implementazione per modificare l'oggetto nel database
        // Utilizza la connessione per eseguire una query di aggiornamento
    }


    public void selectAll() throws SQLException {
        Statement stmt = connection.createStatement();

        String QUERY = "SELECT * FROM item";

        ResultSet rs = stmt.executeQuery(QUERY);

        while(rs.next()){
            System.out.println("IDItem: " + rs.getInt("iditem"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Description: " + rs.getString("description"));
            System.out.println("Quantity: " + rs.getInt("quantity"));
            System.out.println("Price: " + rs.getDouble("price"));
            System.out.println("Category: " + rs.getString("category"));
        }

    }

    public void selectByIdItem() throws SQLException {
        Scanner scan = new Scanner(System.in);

        //QUERY PARAMETRICA
        String QUERY = "SELECT * FROM item WHERE iditem = ?";

        PreparedStatement stmt = connection.prepareStatement(QUERY);

        //RICHIESTA INSERIMENTO ID DA PARTE UTENTE
        System.out.println("Inserisci l'id dell'item che vuoi selezionare");

        //SET DELL ID INSERITO DALL UTENTE NELLA QUERY
        stmt.setInt(1,scan.nextInt());

        try{
            ResultSet rs = stmt.executeQuery();
            rs.next();
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Description: " + rs.getString("description"));
            System.out.println("Quantity: " + rs.getInt("quantity"));
            System.out.println("Price: " + rs.getDouble("price"));
            System.out.println("Category: " + rs.getString("category"));
        }
        catch (SQLException e){
            System.out.println("L'ID item inserito non corrisponde a nessun ID presente nel nostro DB");
        }
    }
}
