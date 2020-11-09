/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import java.io.Serializable;
import Configuracion.ConexionBD;
import ModeloDto.DtoEstadosCompra;
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
public class DaoEstadoCompra implements Serializable  {

// SELECT  IdEstadoCompra,Nombre,Descripcion, Activo,FechaDeAlta,IdUsuario
// FROM tc_estadocompra;
    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    static final String sqlObtenerEstadosCompras = " SELECT  IdEstadoCompra,Nombre,Descripcion, Activo,FechaDeAlta,IdUsuario "
            + " FROM tc_estadocompra WHERE Activo = true ";
    static final String sqlObtenerEstadoCompra = " SELECT  IdEstadoCompra,Nombre,Descripcion, Activo,FechaDeAlta,IdUsuario "
            + " FROM tc_estadocompra "
            + " where IdEstadoCompra = ? AND Activo = true";
    static final String sqlAgregarEstadoCompra = " INSERT INTO tc_estadocompra (Nombre,Descripcion,Activo,FechaDeAlta,IdUsuario)"
            + " values ( ? , ? , true, CURRENT_TIMESTAMP() , ?  ) ";
    static final String sqlEditarEstadoCompra = " update tc_estadocompra set Nombre=? ,Descripcion= ?, IdUsuario = ? "
            + " WHERE  IdEstadoCompra= ? AND Activo = true ";
    static final String sqlEliminarEstadoCompra = " update tc_estadocompra set Activo=false "
            + " WHERE IdEstadoCompra = ?";


    public ArrayList<DtoEstadosCompra> listarEstadosCompra() {
        ArrayList<DtoEstadosCompra> listaEstadosCompras = new ArrayList<DtoEstadosCompra>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerEstadosCompras);
            rs = ps.executeQuery();
            while (rs.next()) {
                DtoEstadosCompra estadoCompra = new DtoEstadosCompra();
//                IdEstadoCompra,Nombre,Descripcion, Activo,FechaDeAlta,IdUsuario
                estadoCompra.setIdEstadoCompra(rs.getInt("IdEstadoCompra"));
                estadoCompra.setNombre(rs.getString("Nombre"));
                estadoCompra.setDescripcion(rs.getString("Descripcion"));
                estadoCompra.setActivo(rs.getBoolean("Activo"));
                estadoCompra.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                estadoCompra.setIdUsuario(rs.getInt("IdUsuario"));
                listaEstadosCompras.add(estadoCompra);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return listaEstadosCompras;
    }


    public DtoEstadosCompra obtenerEstadosCompra(int id) {
        DtoEstadosCompra estadoCompra = new DtoEstadosCompra();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerEstadoCompra);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                estadoCompra.setIdEstadoCompra(rs.getInt("IdEstadoCompra"));
                estadoCompra.setNombre(rs.getString("Nombre"));
                estadoCompra.setDescripcion(rs.getString("Descripcion"));
                estadoCompra.setActivo(rs.getBoolean("Activo"));
                estadoCompra.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                estadoCompra.setIdUsuario(rs.getInt("IdUsuario"));

            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return estadoCompra;
    }

    public boolean agregarEstadoCompra(DtoEstadosCompra estadoCompra) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlAgregarEstadoCompra);
            ps.setString(1, estadoCompra.getNombre());
            ps.setString(2, estadoCompra.getDescripcion());
            ps.setInt(3, estadoCompra.getIdUsuario());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
          
        }
        return resp;
    }

 
    public boolean editarEstadoCompra(DtoEstadosCompra estadoCompra) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEditarEstadoCompra);
            ps.setString(1, estadoCompra.getNombre());
            ps.setString(2, estadoCompra.getDescripcion());
            ps.setInt(3, estadoCompra.getIdUsuario());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }

   
    public boolean eliminarEstadoCompra(DtoEstadosCompra estadoCompra) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEliminarEstadoCompra);
            ps.setInt(1, estadoCompra.getIdEstadoCompra());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }

}
