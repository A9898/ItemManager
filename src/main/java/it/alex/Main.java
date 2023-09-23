package it.alex;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

       //DBConnection.getConnection();


       ItemDAO itemdao = new ItemDAO(DBConnection.getConnection());

       itemdao.selectAll();
        // itemdao.addItem();
        //itemdao.selectByIdItem();
        //itemdao.removeItemById();
        //itemdao.updateItemById();

       System.out.println();

       DBConnection.closeConnection();
    }
}
