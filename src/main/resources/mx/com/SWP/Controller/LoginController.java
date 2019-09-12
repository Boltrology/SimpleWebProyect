/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.SWP.Controller;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author USER
 */
public class LoginController {

    private String Correo;
    private int idUsuario;
    private String claveUsuario;
    private SimpleUser su;
    
    
    
    @Resource
    private UserTransaction ut;

    @PersistenceContext(name = "LoginPU")
    private EntityManager em;

    public String validate() {
        generateUser();
        this.Correo = Correo;
        this.claveUsuario = claveUsuario;
        TypedQuery<SimpleUser> query = em.createQuery("SELECT su FROM SimpleUser su WHERE su.correo=:correo AND su.clave=:clave", SimpleUser.class);

        query.setParameter("correo", Correo);
        query.setParameter("clave", claveUsuario);

        try {
            su = query.getSingleResult();//execute query SELECT
            //NoResultExeptio 
            // NoUniqueExeption
            //NoResultException 
        } catch (NoResultException e) {
            //su = null;
            return "fail";
        }
        System.out.println("Aqui!! " + su);

        return "success";
    }

    private void generateUser() {
        TypedQuery<SimpleUser> query = em.createQuery("SELECT su FROM SimpleUser su", SimpleUser.class);
        if (query.getResultList().isEmpty()) {
            try {
                ut.begin();
                em.persist(new SimpleUser("saw", "saw"));
                ut.commit();
            } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException notSupportedException) {

            }
        }
    }

//<editor-fold defaultstate="collapsed" desc="Getter $Setter">
    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    public SimpleUser getSu() {
        return su;
    }

    public void setSu(SimpleUser su) {
        this.su = su;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
//</editor-fold>

}
