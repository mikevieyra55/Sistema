/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import java.io.Serializable;
import Configuracion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ModeloDto.DtoTratamientos;

/**
 *
 * @author ULISES.VIEYRA
 */
public class DaoTratamientos implements Serializable  {
//    SELECT    IdTratamiento, Descripcion,Activo,FechaDeAlta,Precio,IdUsuario
// FROM tc_tratamientos;

    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    static final String sqlObtenerTratamientos = " SELECT IdTratamiento, Descripcion,Activo,FechaDeAlta,Precio,IdUsuario "
            + " FROM tc_tratamientos WHERE Activo = true ";
    static final String sqlObtenerTratamiento = " SELECT IdTratamiento, Descripcion,Activo,FechaDeAlta,Precio,IdUsuario  "
            + " FROM tc_tratamientos "
            + " WHERE IdTratamiento = ? AND Activo = true";
    static final String sqlAgregarTratamiento = " INSERT INTO tc_tratamientos ( Descripcion,Activo,FechaDeAlta,Precio,IdUsuario )"
            + " VALUES ( ? , true ,CURRENT_TIMESTAMP(), ?, ? ) ";
    static final String sqlEditarTratamiento = " UPDATE tc_tratamientos set Descripcion=? ,Precio= ?, IdUsuario = ? "
            + " WHERE  IdTratamiento= ? AND Activo = true ";
    static final String sqlEliminarTratamiento = " UPDATE tc_tratamientos set Activo=false "
            + " WHERE IdTratamiento= ?";

    
    public ArrayList<DtoTratamientos> listarTratamientos() {
        ArrayList<DtoTratamientos> listaTratamientos = new ArrayList<DtoTratamientos>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerTratamientos);
            rs = ps.executeQuery();
            while (rs.next()) {
                DtoTratamientos tratamiento = new DtoTratamientos();
//                 IdTratamiento, Descripcion,Activo,FechaDeAlta,Precio,IdUsuario;
                tratamiento.setIdTratamiento(rs.getInt("IdTratamiento"));
                tratamiento.setDescripcion(rs.getString("Descripcion"));
                tratamiento.setActivo(rs.getBoolean("Activo"));
                tratamiento.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                tratamiento.setPrecio(rs.getFloat("Precio"));
                tratamiento.setIdUsuario(rs.getInt("IdUsuario"));
                listaTratamientos.add(tratamiento);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return listaTratamientos;
    }

    
    public DtoTratamientos obtenerTratamiento(int id) {
        DtoTratamientos tratamiento = new DtoTratamientos();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerTratamiento);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                tratamiento.setIdTratamiento(rs.getInt("IdTratamiento"));
                tratamiento.setDescripcion(rs.getString("Descripcion"));
                tratamiento.setActivo(rs.getBoolean("Activo"));
                tratamiento.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                tratamiento.setPrecio(rs.getFloat("Precio"));
                tratamiento.setIdUsuario(rs.getInt("IdUsuario"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return tratamiento;
    }

    
    public boolean agregarTratamiento(DtoTratamientos tratamiento) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlAgregarTratamiento);
            ps.setString(1, tratamiento.getDescripcion());
            ps.setFloat(2, tratamiento.getPrecio());
            ps.setInt(3, tratamiento.getIdUsuario());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }

    
    public boolean editarTratamiento(DtoTratamientos tratamiento) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEditarTratamiento);
            ps.setString(1, tratamiento.getDescripcion());
            ps.setFloat(2, tratamiento.getPrecio());
            ps.setInt(3, tratamiento.getIdUsuario());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            
        }
        return resp;
    }

    
    public boolean eliminarTratamiento(DtoTratamientos tratamiento) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEliminarTratamiento);
            ps.setInt(1, tratamiento.getIdTratamiento());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }

}
