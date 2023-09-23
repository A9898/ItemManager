package it.alex;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

       DBConnection.getConnection();


       ItemDAO itemdao = new ItemDAO(DBConnection.getConnection());

       itemdao.selectByIdItem();

       System.out.println();
       DBConnection.closeConnection();
    }
}
