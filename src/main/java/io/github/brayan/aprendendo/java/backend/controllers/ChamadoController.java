/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.brayan.aprendendo.java.backend.controllers;

import io.github.brayan.aprendendo.java.backend.data.Chamado;
import io.github.brayan.aprendendo.java.backend.data.ChamadoDAO;
import io.github.brayan.aprendendo.java.backend.data.Status;
import io.github.brayan.aprendendo.java.backend.infra.ConexaoPostgresJDBC;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author brayan
 */
@Path("chamados")
public class ChamadoController {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<Chamado> getListChamados(){
        try {
            ChamadoDAO chamadoDAO = new ChamadoDAO();
            return chamadoDAO.listar();
        } catch (SQLException | ClassNotFoundException   e) {
            Logger.getLogger(ChamadoController.class.getName()).log(Level.SEVERE, null, e);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);

        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Chamado getChamado(@PathParam("id") long id){
        try {
            ChamadoDAO chamadoDAO = new ChamadoDAO();
            return chamadoDAO.selecionar(id);
        } catch (SQLException | ClassNotFoundException   e) {
            Logger.getLogger(ChamadoController.class.getName()).log(Level.SEVERE, null, e);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);

        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response createChamados(Chamado chamado){
        try {
            chamado.setStatus(Status.NOVO);
            ChamadoDAO chamadoDAO = new ChamadoDAO();
            chamadoDAO.inserir(chamado);
            return Response.status(Response.Status.OK).build();
        } catch (SQLException | ClassNotFoundException   e) {
            Logger.getLogger(ChamadoController.class.getName()).log(Level.SEVERE, null, e);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);

        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response updateChamados(Chamado chamado){
        try {
            chamado.setStatus(Status.PENDENTE);
            ChamadoDAO chamadoDAO = new ChamadoDAO();
            chamadoDAO.alterar(chamado);
            return Response.status(Response.Status.OK).build();
        } catch (SQLException | ClassNotFoundException   e) {
            Logger.getLogger(ChamadoController.class.getName()).log(Level.SEVERE, null, e);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);

        }
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Response deleteChamado(@PathParam("id") long id){
        try {
            ChamadoDAO chamadoDAO = new ChamadoDAO();
            chamadoDAO.excluir(id);
            return Response.status(Response.Status.OK).build();
        } catch (SQLException | ClassNotFoundException   e) {
            Logger.getLogger(ChamadoController.class.getName()).log(Level.SEVERE, null, e);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);

        }
    }
    
    @PUT
    @Path("{id}/")
    public Response concluirChamado(@PathParam("id") int id){
        try {
            ChamadoDAO chamadoDAO = new ChamadoDAO();
            Chamado chamado = chamadoDAO.selecionar(id);
            chamado.setStatus(Status.FECHADO);
            chamadoDAO.alterar(chamado);
            return Response.status(Response.Status.OK).build();
        } catch (SQLException | ClassNotFoundException   e) {
            Logger.getLogger(ChamadoController.class.getName()).log(Level.SEVERE, null, e);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);

        }
    }
    
}
