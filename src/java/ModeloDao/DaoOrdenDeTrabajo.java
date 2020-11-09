/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import java.io.Serializable;
import Configuracion.ConexionBD;
import ModeloDto.DtoOrdenDeTrabajo;
import java.sql.Connection;
import java.sql.Date;
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
public class DaoOrdenDeTrabajo implements Serializable  {
//    SELECT IdOrdenDeTrabajo,IdPaciente,IdTratamiento,IdTipoDescuento,Precio,FechaDeAlta,IdDoctor,
//    IdUsuario,IdCompra
// FROM tr_ordendetrabajo;

    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    static final String sqlObtenerOrdenesDeTrabajo = " SELECT IdOrdenDeTrabajo,IdPaciente,IdTratamiento,IdTipoDescuento, "
            + " Precio,FechaDeAlta,IdDoctor,IdUsuario,IdCompra "
            + " FROM tr_ordendetrabajo ";
    static final String sqlObtenerOrdenDeTrabajo = " SELECT IdOrdenDeTrabajo,IdPaciente,IdTratamiento,IdTipoDescuento, "
            + " Precio,FechaDeAlta,IdDoctor,IdUsuario,IdCompra "
            + " FROM tr_ordendetrabajo "
            + " WHERE IdOrdenDeTrabajo = ? ";
    static final String sqlAgregarOrdenDeTrabajo = " INSERT INTO tr_ordendetrabajo ( IdPaciente,IdTratamiento,IdTipoDescuento,"
            + " Precio,FechaDeAlta,IdDoctor,IdUsuario,IdCompra )"
            + " values (? , ? , ? , ?,CURRENT_TIMESTAMP(),?,?,?  ) ";
    static final String sqlEditarOrdenDeTrabajo = " update tr_ordendetrabajo set IdPaciente=? ,IdTratamiento= ?, IdTipoDescuento = ? "
            + " , Precio = ?, IdDoctor = ?, IdUsuario = ?, IdCompra = ?"
            + " WHERE IdOrdenDeTrabajo = ? ";
    static final String sqlEliminarOrdenDeTrabajo = " delete from  tr_ordendetrabajo  "
            + " WHERE IdOrdenDeTrabajo = ? ";


    public ArrayList<DtoOrdenDeTrabajo> listarOrdenesTrabajo() {
        ArrayList<DtoOrdenDeTrabajo> listaAbonos = new ArrayList<DtoOrdenDeTrabajo>();

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerOrdenesDeTrabajo);
            rs = ps.executeQuery();
            while (rs.next()) {
                DtoOrdenDeTrabajo ordenTrabajo = new DtoOrdenDeTrabajo();
//                IdOrdenDeTrabajo,IdPaciente,IdTratamiento,IdTipoDescuento,Precio,
//                FechaDeAlta,IdDoctor, IdUsuario,IdCompra
                ordenTrabajo.setIdOrdenDeTrabajo(rs.getInt("IdOrdenDeTrabajo"));
                ordenTrabajo.setIdPaciente(rs.getInt("IdPaciente"));
                ordenTrabajo.setIdTratamiento(rs.getInt("IdTratamiento"));
                ordenTrabajo.setIdTipoDescuento(rs.getInt("IdTipoDescuento"));
                ordenTrabajo.setPrecio(rs.getFloat("Precio"));
                ordenTrabajo.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                ordenTrabajo.setIdDoctor(rs.getInt("IdDoctor"));
                ordenTrabajo.setIdUsuario(rs.getInt("IdUsuario"));
                ordenTrabajo.setIdCompra(rs.getInt("IdCompra"));
                listaAbonos.add(ordenTrabajo);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
          
        }
        return listaAbonos;
    }

  
    public DtoOrdenDeTrabajo obtenerOrdenTrabajo(int id) {
        DtoOrdenDeTrabajo ordenTrabajo = new DtoOrdenDeTrabajo();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerOrdenDeTrabajo);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                ordenTrabajo.setIdOrdenDeTrabajo(rs.getInt("IdOrdenDeTrabajo"));
                ordenTrabajo.setIdPaciente(rs.getInt("IdPaciente"));
                ordenTrabajo.setIdTratamiento(rs.getInt("IdTratamiento"));
                ordenTrabajo.setIdTipoDescuento(rs.getInt("IdTipoDescuento"));
                ordenTrabajo.setPrecio(rs.getFloat("Precio"));
                ordenTrabajo.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                ordenTrabajo.setIdDoctor(rs.getInt("IdDoctor"));
                ordenTrabajo.setIdUsuario(rs.getInt("IdUsuario"));
                ordenTrabajo.setIdCompra(rs.getInt("IdCompra"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
          
        }
        return ordenTrabajo;
    }


    public boolean agregarOrdenTrabajo(DtoOrdenDeTrabajo ordenTrabajo) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlAgregarOrdenDeTrabajo);
            ps.setDouble(1, ordenTrabajo.getIdPaciente());
            ps.setInt(2, ordenTrabajo.getIdTratamiento());
            ps.setInt(3, ordenTrabajo.getIdTipoDescuento());
            ps.setDouble(4, ordenTrabajo.getPrecio());
            ps.setDate(5, (Date) ordenTrabajo.getFechaDeAlta());
            ps.setInt(6, ordenTrabajo.getIdDoctor());
            ps.setInt(7, ordenTrabajo.getIdUsuario());
            ps.setInt(8, ordenTrabajo.getIdCompra());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }

    
    public boolean editarOrdenTrabajo(DtoOrdenDeTrabajo ordenTrabajo) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEditarOrdenDeTrabajo);
            ps.setDouble(1, ordenTrabajo.getIdPaciente());
            ps.setInt(2, ordenTrabajo.getIdTratamiento());
            ps.setInt(3, ordenTrabajo.getIdTipoDescuento());
            ps.setDouble(4, ordenTrabajo.getPrecio());
            ps.setInt(5, ordenTrabajo.getIdDoctor());
            ps.setInt(6, ordenTrabajo.getIdUsuario());
            ps.setInt(7, ordenTrabajo.getIdCompra());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }

 
    public boolean eliminarOrdenTrabajo(DtoOrdenDeTrabajo ordenTrabajo) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEliminarOrdenDeTrabajo);
            ps.setInt(1, ordenTrabajo.getIdOrdenDeTrabajo());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            
        }
        return resp;
    }

}
