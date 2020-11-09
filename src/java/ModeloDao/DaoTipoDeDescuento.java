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
import ModeloDto.DtoTipoDeDescuento;

/**
 *
 * @author ULISES.VIEYRA
 */
public class DaoTipoDeDescuento implements Serializable  {
// SELECT IdTipoDescuento,Nombre, Descripcion, FechaDeAlta,IdUsuario,Activo
// FROM tc_tipodescuento;

    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    static final String sqlObtenerTiposDeDescuentos = "  SELECT IdTipoDescuento,Nombre, Descripcion, "
            + " FechaDeAlta,IdUsuario,Activo "
            + " FROM tc_tipodescuento WHERE  Activo = true ";
    static final String sqlObtenerTipoDeDescuento = "  SELECT IdTipoDescuento,Nombre, Descripcion, "
            + " FechaDeAlta,IdUsuario,Activo "
            + " FROM tc_tipodescuento "
            + " WHERE IdTipoDescuento = ? AND Activo = true";
    static final String sqlAgregarTipoDeDescuento = " INSERT INTO tc_tipodescuento ( Nombre, Descripcion,FechaDeAlta,IdUsuario,Activo)"
            + " values ( ? , ? , CURRENT_TIMESTAMP() ,?, true  ) ";
    static final String sqlEditarTipoDeDescuento = " update tc_tipodescuento set Nombre=? ,Descripcion= ?, IdUsuario = ? "
            + " WHERE  IdTipoDescuento= ? AND Activo = true ";
    static final String sqlEliminarTipoDeDescuento = " update tc_tipodescuento set Activo=false "
            + " WHERE IdTipoDescuento = ?";

    
    public ArrayList<DtoTipoDeDescuento> listarTipoDeDescuentos() {
        ArrayList<DtoTipoDeDescuento> listaTiposDeDescuento = new ArrayList<DtoTipoDeDescuento>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerTiposDeDescuentos);
            rs = ps.executeQuery();
            while (rs.next()) {
                DtoTipoDeDescuento tipoDescuento = new DtoTipoDeDescuento();
//                IdTipoDescuento,Nombre, Descripcion, FechaDeAlta,IdUsuario,Activo;
                tipoDescuento.setIdTipoDescuento(rs.getInt("IdTipoDescuento"));
                tipoDescuento.setNombre(rs.getString("Nombre"));
                tipoDescuento.setDescripcion(rs.getString("Descripcion"));
                tipoDescuento.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                tipoDescuento.setIdUsuario(rs.getInt("IdUsuario"));
                tipoDescuento.setActivo(rs.getBoolean("Activo"));
                listaTiposDeDescuento.add(tipoDescuento);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            
        }
        return listaTiposDeDescuento;
    }

    
    public DtoTipoDeDescuento obtenerTipoDeDescuento(int id) {
        DtoTipoDeDescuento tipoDescuento = new DtoTipoDeDescuento();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerTipoDeDescuento);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                tipoDescuento.setIdTipoDescuento(rs.getInt("IdTipoDescuento"));
                tipoDescuento.setNombre(rs.getString("Nombre"));
                tipoDescuento.setDescripcion(rs.getString("Descripcion"));
                tipoDescuento.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                tipoDescuento.setIdUsuario(rs.getInt("IdUsuario"));
                tipoDescuento.setActivo(rs.getBoolean("Activo"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return tipoDescuento;
    }

    
    public boolean agregarTipoDeDescuento(DtoTipoDeDescuento tipoDescuento) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlAgregarTipoDeDescuento);
            ps.setString(1, tipoDescuento.getNombre());
            ps.setString(2, tipoDescuento.getDescripcion());
            ps.setInt(3, tipoDescuento.getIdUsuario());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
          
        }
        return resp;
    }

    
    public boolean editarTipoDeDescuento(DtoTipoDeDescuento tipoDescuento) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEditarTipoDeDescuento);
            ps.setString(1, tipoDescuento.getNombre());
            ps.setString(2, tipoDescuento.getDescripcion());
            ps.setInt(3, tipoDescuento.getIdUsuario());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }

    
    public boolean eliminarTipoDeDescuento(DtoTipoDeDescuento tipoDescuento) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEliminarTipoDeDescuento);
            ps.setInt(1, tipoDescuento.getIdTipoDescuento());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }

}
