/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.SimpleWebLogin.Model;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;


import java.rmi.RemoteException;
import java.sql.*;
import java.util.*;
import javax.naming.NamingException;
import mx.com.SimpleWebLogin.Controller.LoginController;
import mx.com.SimpleWebLogin.Model.Mbd;
public class MbdLuser extends Mbd {

    public MbdLuser() {
        super();
    }

//    public boolean insertaUsuario(LoginController usuario) throws SQLException,
//            NamingException {
//        getConexion();
//
//        stmt = conn.createStatement();
//        
//
//        boolean exito = false;
//        try {
//            ps = conn.prepareStatement("INSERT INTO usuario (nombre,login,password,email) VALUES(?,?,?,?);");
//            ps.setString(1, usuario.getNombre());
//            ps.setString(2, usuario.getLogin());
//            ps.setString(3, usuario.getPassword());
//            ps.setString(4, usuario.getEmail());
//            ps.executeUpdate();
////            stmt.executeUpdate("INSERT INTO usuario (nombre,login,password,email) VALUES("
////                    + "'" + usuario.getNombre() + "',"
////                    + "'" + usuario.getLogin() + "',"
////                    + "'" + usuario.getPassword() + "',"
////                    + "'" + usuario.getEmail() + "')");
//            exito = true;
//        } catch (SQLException e) {
//            System.out.println("Error en sql: ");
//            throw e;
//        } finally {
//            returnConexion(conn, ps, rst, stmt);
//        }
//        return exito;
//    }

    public LoginController buscaUsuario(int idUsuario) throws SQLException,
            NamingException {
        getConexion();

        stmt = conn.createStatement();

        LoginController usuario = null;
        try {
            //rst = stmt.executeQuery("SELECT * FROM usuario WHERE idUsuario=" + idUsuario);
            ps = conn.prepareStatement("SELECT * FROM login WHERE idUsuario=?");
            ps.setInt(1, idUsuario);
            rst = ps.executeQuery();
            if (rst.next()) {
                usuario = new LoginController();
                usuario.setIdUsuario(rst.getInt(1));
                usuario.setCorreo(rst.getString(2));
                usuario.setClaveM(rst.getString(3));
          
            }
        } catch (SQLException e) {
            System.out.println("Error en sql: ");
            throw e;
        } finally {
            returnConexion(conn, ps, rst, stmt);
        }
        return usuario;
    }

    public LoginController buscaUsuario(String login, String password) throws SQLException, NamingException {
        getConexion();

        stmt = conn.createStatement();

        LoginController usuario = null;
        try {
            //st = stmt.executeQuery("SELECT * FROM usuario WHERE login='" + login + "' AND password='" + password + "'");
            ps = conn.prepareStatement("SELECT * FROM usuario WHERE login=? AND password=?");
            ps.setString(1, login);
            ps.setString(2, password);
            rst = ps.executeQuery();
            if (rst.next()) {
                usuario = new LoginController();
                usuario.setIdUsuario(rst.getInt(1));
                usuario.setCorreo(rst.getString(2));
                usuario.setClaveM(rst.getString(3));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en sql: ");
            throw e;
        } finally {
            returnConexion(conn, ps, rst, stmt);
        }
        return usuario;
    }

//    public ArrayList<LoginController> traerTodosLosUsuarios() throws SQLException,
//            NamingException {
//        getConexion();
//
//        stmt = conn.createStatement();
//
//        ArrayList<LoginController> usuarios = new ArrayList<Usuario>();
//
//        try {
//
//            //rst = stmt.executeQuery("SELECT * FROM usuario ORDER BY nombre");
//            ps = conn.prepareStatement("SELECT * FROM usuario ORDER BY nombre");
//            rst = ps.executeQuery();
//            while (rst.next()) {
//                LoginController usuario = new LoginController();
//                usuario.setIdUsuario(rst.getInt(1));
//                usuario.setNombre(rst.getString(2));
//                usuario.setLogin(rst.getString(3));
//                usuario.setPassword(rst.getString(4));
//                usuario.setEmail(rst.getString(5));
//                usuarios.add(usuario);
//            }
//        } catch (SQLException e) {
//            System.out.println("Error en sql: ");
//            throw e;
//        } finally {
//            returnConexion(conn, ps, rst, stmt);
//        }
//        return usuarios;
//    }

    public void eliminaUsuario(int idUsuario) throws SQLException,
            NamingException {
        getConexion();
        stmt = conn.createStatement();

        try {
            //stmt.executeUpdate("DELETE FROM usuario WHERE idUsuario=" + idUsuario);
            ps = conn.prepareStatement("DELETE FROM usuario WHERE idUsuario=?");
            ps.setInt(1, idUsuario);
            rst = ps.executeQuery();
            

        } catch (Exception e) {
            System.out.println("Error en sql: ");

        } finally {
            returnConexion(conn, ps, rst, stmt);
        }
    }

//    public boolean actualizaUsuario(LoginController usuario) throws SQLException,
//            NamingException {
//        getConexion();
//
//        stmt = conn.createStatement();
//
//        boolean exito = false;
//        try {
//             ps = conn.prepareStatement("update usuario set nombre=?,login=?,password=?,email=? where idUsuario=?");
//             ps.setString(1, usuario.getNombre());
//             ps.setString(2, usuario.getLogin());
//             ps.setString(3, usuario.getPassword());
//             ps.setString(4, usuario.getEmail());
//             ps.setInt(5, usuario.getIdUsuario());
//             rst = ps.executeQuery();
////            stmt.executeUpdate("update usuario set "
////                    + "nombre='" + usuario.getNombre() + "',"
////                    + "login='" + usuario.getLogin() + "',"
////                    + "password='" + usuario.getPassword() + "',"
////                    + "email='" + usuario.getEmail() + "' where idUsuario="+usuario.getIdUsuario());
//            exito = true;
//        } catch (SQLException e) {
//            System.out.println("Error en sql: ");
//            throw e;
//        } finally {
//            returnConexion(conn, ps, rst, stmt);
//        }
//        return exito;
//    }

}

