/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.brayan.aprendendo.java.backend.data;

/**
 *
 * @author brayan
 */
public class Chamado {
    
    private long id;
    private String assunto;
    private String mensagem;
    private Status status;

    public Chamado(long id, String assunto, String mensagem, Status status) {
        this.id = id;
        this.assunto = assunto;
        this.mensagem = mensagem;
        this.status = status;
    }

    public Chamado() {
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chamado other = (Chamado) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Chamado{" + "id=" + id + ", assunto=" + assunto + ", mensagem=" + mensagem + ", status=" + status + '}';
    }
    
    
    
}
