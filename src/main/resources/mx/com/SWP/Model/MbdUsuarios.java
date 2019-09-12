package mx.com.SWP.Model;

import java.rmi.RemoteException;
import java.sql.*;
import java.util.*;
import javax.naming.NamingException;
import mx.com.SWP.Controller.LoginController;
import mx.com.SWP.Model.Mbd;

public class MbdUsuarios extends Mbd {

    public MbdUsuarios() {
        super();
    }

//    public boolean insertaUsuario(LoginController usuario) throws SQLException,
//            NamingException {
//        getConexion();
//
//        stmt = conn.createStatement();
//
//        boolean exito = false;
//        try {
//
//            ps = conn.prepareStatement("INSERT INTO usuario (nombre,login,password,email) VALUES(?,?,?,?)");
//            ps.setString(1, usuario.getNombre());
//            ps.setString(2, usuario.getLogin());
//            ps.setString(3, usuario.getPassword());
//            ps.setString(4, usuario.getEmail());
//            ps.executeUpdate();
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

        LoginController LogIn = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM login WHERE idUsuario=?");
            ps.setInt(1, idUsuario);
            rst = ps.executeQuery();
            if (rst.next()) {
                LogIn = new LoginController();
                LogIn.setIdUsuario(rst.getInt(1));
                LogIn.setCorreo(rst.getString(2));
                LogIn.setClaveUsuario(rst.getString(3));
               
            }
        } catch (SQLException e) {
            System.out.println("Error en sql: ");
            throw e;
        } finally {
            returnConexion(conn, ps, rst, stmt);
        }
        return LogIn;
    }

    public LoginController buscaUsuario(String login, String password) throws SQLException, NamingException {
        getConexion();

        stmt = conn.createStatement();

        LoginController Login2 = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM login WHERE correo=? AND clave=?");
            ps.setString(1, login);
            ps.setString(2, password);
            rst = ps.executeQuery();
            if (rst.next()) {
                Login2 = new LoginController();
                Login2.setIdUsuario(rst.getInt(1));
                Login2.setCorreo(rst.getString(2));
                Login2.setClaveUsuario(rst.getString(3));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en sql: ");
            throw e;
        } finally {
            returnConexion(conn, ps, rst, stmt);
        }
        return Login2;
    }

//    public ArrayList<Usuario> traerTodosLosUsuarios() throws SQLException,
//            NamingException {
//        getConexion();
//
//        stmt = conn.createStatement();
//
//        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
//
//        try {
//
//            ps = conn.prepareStatement("SELECT * FROM usuario ORDER BY nombre");
//            rst = ps.executeQuery();
//            while (rst.next()) {
//                Usuario usuario = new Usuario();
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
//
//    public void eliminaUsuario(int idUsuario) throws SQLException,
//            NamingException {
//        getConexion();
//        stmt = conn.createStatement();
//
//        try {
//            ps = conn.prepareStatement("DELETE FROM usuario WHERE idUsuario=?");
//            ps.setInt(1, idUsuario);
//            ps.executeUpdate();
//
//        } catch (Exception e) {
//            System.out.println("Error en sql: ");
//
//        } finally {
//            returnConexion(conn, ps, rst, stmt);
//        }
//    }
//
//    public boolean actualizaUsuario(Usuario usuario) throws SQLException,
//            NamingException {
//        getConexion();
//
//        stmt = conn.createStatement();
//
//        boolean exito = false;
//        try {
//
//            ps = conn.prepareStatement("update usuario set  nombre=?, login=?,"
//                    + "password=?,email=? where idUsuario=?");
//            ps.setString(1, usuario.getNombre());
//            ps.setString(2, usuario.getLogin());
//            ps.setString(3, usuario.getPassword());
//            ps.setString(4, usuario.getEmail());
//            ps.setInt(5, usuario.getIdUsuario());
//            ps.executeUpdate();
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
