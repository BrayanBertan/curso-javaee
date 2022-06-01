/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.brayan.aprendendo.java.backend.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author brayan
 */

@Path("hello")
public class HelloController {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMensagem(@QueryParam("usuario") String usuario){
        return "Bem vindo:" + usuario;
    }
    
     @GET
     @Produces(MediaType.TEXT_PLAIN)
     @Path("usuarios/{id}")
     public String getUsuario(@PathParam("id") long id){
         return "Bem vindo:" + id;
    }
    
}
