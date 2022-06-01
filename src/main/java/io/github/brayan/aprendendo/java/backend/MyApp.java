/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.brayan.aprendendo.java.backend;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author brayan
 */
@ApplicationPath("rest")
public class MyApp extends ResourceConfig{
    public MyApp(){
        packages("io.github.brayan.aprendendo.java.backend.controllers");
    }
    
}
