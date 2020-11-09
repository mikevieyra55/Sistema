/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import java.io.Serializable;
import Configuracion.ConexionBD;
import ModeloDto.DtoPerfiles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ULISES.VIEYRA
 */
public class DaoPerfiles implements Serializable  {

    static final String sqlObtenerPerfiles = " SELECT IdPerfil, Nombre, Descripcion, Activo,FechaDeAlta,IdUsuario "
            + " FROM tc_perfiles WHERE Activo = true ";
    static final String sqlObtenerPerfil = " SELECT IdPerfil, Nombre, Descripcion, Activo,FechaDeAlta,IdUsuario   "
            + " FROM tc_perfiles "
            + " WHERE IdPerfil = ? AND Activo = true";
    static final String sqlAgregarPerfil = " INSERT INTO tc_perfiles (  Nombre, Descripcion, Activo,FechaDeAlta,IdUsuario )"
            + " VALUES ( ? , ? ,  true, CURRENT_TIMESTAMP(), ?  ) ";
    static final String sqlEditarPerfil = " UPDATE tc_perfiles SET Nombre=? ,Descripcion= ?, IdUsuario = ? "
            + " WHERE  IdPerfil= ? AND Activo = true ";
    static final String sqlEliminarPerfil = " UPDATE tc_perfiles SET Activo=false "
            + " WHERE IdPerfil= ?";

   
    public ArrayList<DtoPerfiles> listarPerfiles() {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<DtoPerfiles> listaPerfiles = new ArrayList<DtoPerfiles>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerPerfiles);
            rs = ps.executeQuery();
            while (rs.next()) {
                DtoPerfiles perfil = new DtoPerfiles();
                perfil.setIdPerfil(rs.getInt("IdPerfil"));
                perfil.setNombre(rs.getString("Nombre"));
                perfil.setDescripcion(rs.getString("Descripcion"));
                perfil.setActivo(rs.getBoolean("Activo"));
                perfil.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                perfil.setIdUsuario(rs.getInt("IdUsuario"));
                listaPerfiles.add(perfil);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoPerfiles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaPerfiles;
    }

    
    public DtoPerfiles obtenerPerfil(int id) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DtoPerfiles perfil = new DtoPerfiles();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerPerfil);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                perfil.setIdPerfil(rs.getInt("IdPerfil"));
                perfil.setNombre(rs.getString("Nombre"));
                perfil.setDescripcion(rs.getString("Descripcion"));
                perfil.setActivo(rs.getBoolean("Activo"));
                perfil.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                perfil.setIdUsuario(rs.getInt("IdUsuario"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoPerfiles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return perfil;
    }

    
    public boolean agregarPerfil(DtoPerfiles perfil) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlAgregarPerfil);
            ps.setString(1, perfil.getNombre());
            ps.setString(2, perfil.getDescripcion());
            ps.setInt(3, perfil.getIdUsuario());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoPerfiles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

   
    public boolean editarPerfil(DtoPerfiles perfil) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEditarPerfil);
            ps.setString(1, perfil.getNombre());
            ps.setString(2, perfil.getDescripcion());
            ps.setInt(3, perfil.getIdUsuario());
            ps.setInt(4, perfil.getIdPerfil());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoPerfiles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

  
    public boolean eliminarPerfil(DtoPerfiles perfil) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEliminarPerfil);
            ps.setInt(1, perfil.getIdPerfil());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {

        }
        return resp;
    }

}
