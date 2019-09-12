/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.SWP.Controller;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "usuarioss")
public class SimpleUser implements Serializable {

    public final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", unique = true, nullable = true)
    private Integer idUsuario;
    @Column(name = "nombre", unique = true, updatable = false)
    private String usuario;
    @Column(name = "clave")
    private String claveDelUsuario;
    @Column(name = "ultima_session", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaSession;

    public SimpleUser() {
    }

    public SimpleUser(String usuario, String claveDelUsuario, Date ultimaSession) {
        this.idUsuario = null;
        this.usuario = usuario;
        this.claveDelUsuario = claveDelUsuario;
        this.ultimaSession = new Date();
    }
    
    public SimpleUser(String usuario, String claveDelUsuario) {
        this.idUsuario = null;
        this.usuario = usuario;
        this.claveDelUsuario = claveDelUsuario;
        this.ultimaSession = new Date();
    }


    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClaveDelUsuario() {
        return claveDelUsuario;
    }

    public void setClaveDelUsuario(String claveDelUsuario) {
        this.claveDelUsuario = claveDelUsuario;
    }

    public Date getUltimaSession() {
        return ultimaSession;
    }

    public void setUltimaSession(Date ultimaSession) {
        this.ultimaSession = ultimaSession;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof SimpleUser) {
            SimpleUser that = (SimpleUser) o;
            return that.idUsuario.equals(idUsuario); 
        }
        return false; 
    }

    @Override
    public int hashCode() {
        return idUsuario.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

}
