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
    public void addItem() throws SQLException {
        Scanner scan = new Scanner(System.in);
        String QUERY = "INSERT INTO item (name,description,quantity,price,category) VALUES (?,?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(QUERY);

        System.out.println("Inserisci il nome dell'item da aggiungere");
        stmt.setString(1,scan.next());
        System.out.println("Inserisci la desrizione dell'item da aggiungere");
        stmt.setString(2,scan.next());
        System.out.println("Inserisci la quantita' dell'item da aggiungere");
        stmt.setInt(3,scan.nextInt());
        System.out.println("Inserisci il prezzo dell'item da aggiungere");
        stmt.setDouble(4,scan.nextDouble());
        System.out.println("Inserisci la categoria dell'item da aggiungere");
        stmt.setString(5,scan.next());
        scan.close();
        // Implementazione per aggiungere l'oggetto nel database

        stmt.executeUpdate();
        // Utilizza la connessione per eseguire una query di inserimento
    }

    // Metodo per modificare un oggetto esistente nel database
    public void updateItem(Item item) {
        // Implementazione per modificare l'oggetto nel database
        // Utilizza la connessione per eseguire una query di aggiornamento
    }

    // Metodo per rimuovere un oggetto esistente nel database
    public void removeItem(Item item) {
        // Implementazione per rimuovere l'oggetto nel database
        // Utilizza la connessione per eseguire una query di rimozione
    }

    //METODO DI SELECT CHE ESTRAE TUTTI GLI ITEM PRESENTI NEL DB
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
    //METODO DI SELECT CHE ESTRAE L'ELEMENTO CHE CORRISPONDE ALL'ID INSERITO DALL'UTENTE
    public void selectByIdItem() throws SQLException {
        Scanner scan = new Scanner(System.in);

        //QUERY PARAMETRICA
        String QUERY = "SELECT * FROM item WHERE iditem = ?";

        PreparedStatement stmt = connection.prepareStatement(QUERY);

        //RICHIESTA INSERIMENTO ID DA PARTE UTENTE
        System.out.println("Inserisci l'id dell'item che vuoi selezionare");

        //SET DELL ID INSERITO DALL UTENTE NELLA QUERY
        stmt.setInt(1,scan.nextInt());
        scan.close();

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
