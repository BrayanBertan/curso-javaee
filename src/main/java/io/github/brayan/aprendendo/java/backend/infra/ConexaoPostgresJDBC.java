/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.brayan.aprendendo.java.backend.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author brayan
 */
public class ConexaoPostgresJDBC implements ConexaoJDBC{
    Connection connection = null;

    public ConexaoPostgresJDBC() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Properties properties = new Properties();
        properties.put("user", "postgres");
        properties.put("password", "123");
        
        this.connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres");
        this.connection.setAutoCommit(false); 
    }
    

    @Override
    public Connection getConnection() {
        return this.connection;
    }

    @Override
    public void close() {
        if(this.connection != null){
            try {
                this.connection.close();
            } catch (SQLException e) {
                Logger.getLogger(ConexaoPostgresJDBC.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    @Override
    public void commit() throws SQLException {
        this.connection.commit();
        this.close();
    }

    @Override
    public void rollback() {
     if(this.connection != null){
         try {
             this.connection.rollback();
         } catch (SQLException e) {
          Logger.getLogger(ConexaoPostgresJDBC.class.getName()).log(Level.SEVERE, null, e);
         }finally{
           this.close();
         }
     }
    }
    
}
