/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package io.github.brayan.aprendendo.java.backend.infra;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author brayan
 */
public interface ConexaoJDBC {
    
    public Connection getConnection();
    
    public void close();
    
    public void commit() throws SQLException;
    
    public void rollback();
}
