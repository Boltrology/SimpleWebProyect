/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.SimpleWebLogin.Controller;

/**
 *
 * @author USER
 */
public class LoginController {
    private int idUsuario;
    private String Correo;
    private String ClaveM;
    private boolean checkin;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getClaveM() {
        return ClaveM;
    }

    public void setClaveM(String ClaveM) {
        this.ClaveM = ClaveM;
    }

    public boolean isCheckin() {
        return checkin;
    }

    public void setCheckin(boolean checkin) {
        this.checkin = checkin;
    }
    
    
}
