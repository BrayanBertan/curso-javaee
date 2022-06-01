/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.brayan.aprendendo.java.backend.controllers;

import io.github.brayan.aprendendo.java.backend.data.Chamado;
import io.github.brayan.aprendendo.java.backend.data.Status;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
        List<Chamado> chamados = new ArrayList<>();
        chamados.add(new Chamado(1,"Teste","mensagem teste",Status.NOVO));
        chamados.add(new Chamado(2,"Teste2","mensagem teste2",Status.FECHADO));
        chamados.add(new Chamado(3,"Teste3","mensagem teste3",Status.PENDENTE));
        chamados.add(new Chamado(1,"Teste","mensagem teste",Status.NOVO));
        chamados.add(new Chamado(2,"Teste2","mensagem teste2",Status.FECHADO));
        chamados.add(new Chamado(3,"Teste3","mensagem teste3",Status.PENDENTE));
        chamados.add(new Chamado(1,"Teste","mensagem teste",Status.NOVO));
        chamados.add(new Chamado(2,"Teste2","mensagem teste2",Status.FECHADO));
        chamados.add(new Chamado(3,"Teste3","mensagem teste3",Status.PENDENTE));
        chamados.add(new Chamado(1,"Teste","mensagem teste",Status.NOVO));
        chamados.add(new Chamado(2,"Teste2","mensagem teste2",Status.FECHADO));
        chamados.add(new Chamado(3,"Teste3","mensagem teste3",Status.PENDENTE));
        chamados.add(new Chamado(1,"Teste","mensagem teste",Status.NOVO));
        chamados.add(new Chamado(2,"Teste2","mensagem teste2",Status.FECHADO));
        chamados.add(new Chamado(3,"Teste3","mensagem teste3",Status.PENDENTE));
        return chamados;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Chamado getChamado(@PathParam("id") long id){
        return new Chamado(id,"Teste " + id,"mensagem teste",Status.NOVO);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response createChamados(Chamado chamado){
        System.out.println("Criado " + chamado.toString());
        return Response.status(Response.Status.OK).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response updateChamados(Chamado chamado){
        System.out.println("Atualizado " + chamado.toString());
        return Response.status(Response.Status.OK).build();
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Response deleteChamado(@PathParam("id") long id){
        System.out.println( id +"Deletado");
        return Response.status(Response.Status.OK).build();
    }
    
}
