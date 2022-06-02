/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.brayan.aprendendo.java.backend.data;

import io.github.brayan.aprendendo.java.backend.infra.ConexaoJDBC;
import io.github.brayan.aprendendo.java.backend.infra.ConexaoPostgresJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author brayan
 */
public class ChamadoDAO{
    private final ConexaoJDBC conexaoJDBC;

    public ChamadoDAO() throws SQLException, ClassNotFoundException{
        this.conexaoJDBC = new ConexaoPostgresJDBC();
    }
    
    public long inserir(Chamado chamado) throws SQLException, ClassNotFoundException {
        Long id = null;
        String sqlQuery = "INSERT INTO chamados (assunto,mensagem,status) VALUES (?, ?, ?) RETURNING id";
        try {
            PreparedStatement stmt = this.conexaoJDBC.getConnection().prepareStatement(sqlQuery);
            stmt.setString(1, chamado.getAssunto());
            stmt.setString(2, chamado.getMensagem());
            stmt.setString(3, chamado.getStatus().toString());
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                id = rs.getLong("id");
            }
            this.conexaoJDBC.commit();
        } catch (SQLException e) {
            this.conexaoJDBC.rollback();
            throw e;
        }
        return id;
    }
    
    public int alterar(Chamado chamado) throws SQLException, ClassNotFoundException {
        int linhasAfetadas = 0;
        String sqlQuery = "UPDATE chamados SET assunto = ?, mensagem = ? ,status = ? WHERE id = ?";
        try {
            PreparedStatement stmt = this.conexaoJDBC.getConnection().prepareStatement(sqlQuery);
            stmt.setString(1, chamado.getAssunto());
            stmt.setString(2, chamado.getMensagem());
            stmt.setString(3, chamado.getStatus().toString());
            stmt.setLong(4, chamado.getId());
            
            linhasAfetadas = stmt.executeUpdate();
            this.conexaoJDBC.commit();
        } catch (SQLException e) {
            this.conexaoJDBC.rollback();
            throw e;
        }
        return linhasAfetadas;
    }
    
     public int excluir(long id) throws SQLException, ClassNotFoundException {
         int linhasAfetadas = 0;
         String sqlQuery = "DELETE FROM chamados WHERE id = ?";
         try {
            PreparedStatement stmt = this.conexaoJDBC.getConnection().prepareStatement(sqlQuery);
            stmt.setLong(1,id);
            linhasAfetadas = stmt.executeUpdate();
            this.conexaoJDBC.commit();
         } catch (SQLException e) {
            this.conexaoJDBC.rollback();
            throw e;
         }
         return linhasAfetadas;
     }
     
     public Chamado selecionar(long id) throws SQLException, ClassNotFoundException {
         String sqlQuery = "SELECT * FROM chamados WHERE id = ?";
         try {
            PreparedStatement stmt = this.conexaoJDBC.getConnection().prepareStatement(sqlQuery);
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return parser(rs);
            }
         } catch (SQLException e) {
            throw e;
         }
         return null;
     }
     
        public List<Chamado> listar() throws SQLException, ClassNotFoundException {
         String sqlQuery = "SELECT * FROM chamados ORDER BY id";
         try {
            PreparedStatement stmt = this.conexaoJDBC.getConnection().prepareStatement(sqlQuery);
            ResultSet rs = stmt.executeQuery();
            List<Chamado> chamados = new ArrayList<>();
            while(rs.next()){
                chamados.add(parser(rs));
            }
            
            return chamados;
         } catch (SQLException e) {
            throw e;
         }
     }
    
     private Chamado parser(ResultSet rs) throws SQLException{
         return new Chamado(
                 rs.getLong("id"), 
                 rs.getString("assunto"),
                 rs.getString("mensagem"), 
                 Status.valueOf(rs.getString("status")));
         
     }
    
    
}
