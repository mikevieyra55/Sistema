/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import java.io.Serializable;
import Configuracion.ConexionBD;
import ModeloDto.DtoPresupuestos;
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
public class DaoPresupuestos implements Serializable {
//     SELECT IdPresupuesto,IdPaciente, IdTratamiento, IdTipoDescuento,Precio,
//   FechaDeAlta,IdDoctor,IdUsuario
// FROM tr_presupuestos;

    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    static final String sqlObtenerPresupuestos = " SELECT IdPresupuesto,IdPaciente, IdTratamiento, IdTipoDescuento,Precio,"
            + " FechaDeAlta,IdDoctor,IdUsuario "
            + " FROM tr_presupuestos ";
    static final String sqlObtenerPresupuesto = " SELECT IdPresupuesto,IdPaciente, IdTratamiento, IdTipoDescuento,Precio,"
            + " FechaDeAlta,IdDoctor,IdUsuario "
            + " FROM tr_presupuestos "
            + " WHERE IdPresupuesto = ? ";
    static final String sqlAgregarPresupuesto = " INSERT INTO tr_presupuestos ( IdPaciente, IdTratamiento, IdTipoDescuento,Precio,"
            + " FechaDeAlta,IdDoctor,IdUsuario )"
            + " VALUES ( ? , ? , ?, ?, CURRENT_TIMESTAMP(), ? , ?  ) ";
    static final String sqlEditarPresupuesto = " update tr_presupuestos set IdPaciente=? ,IdTratamiento= ?, IdTipoDescuento = ? "
            + " Precio=? ,IdDoctor= ?, IdUsuario = ? "
            + " WHERE  IdPresupuesto = ? ";
    static final String sqlEliminarPresupuesto = " DELETE FROM tr_presupuestos  "
            + " WHERE IdPresupuesto= ?";

    
    public ArrayList<DtoPresupuestos> listarPresupuestos() {
        ArrayList<DtoPresupuestos> listaPresupuestos = new ArrayList<DtoPresupuestos>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerPresupuestos);
            rs = ps.executeQuery();
            while (rs.next()) {
                DtoPresupuestos presupuesto = new DtoPresupuestos();
//                IdPresupuesto,IdPaciente, IdTratamiento, IdTipoDescuento,Precio,
//   FechaDeAlta,IdDoctor,IdUsuario;
                presupuesto.setIdPresupuesto(rs.getInt("IdPresupuesto"));
                presupuesto.setIdPaciente(rs.getInt("IdPaciente"));
                presupuesto.setIdTratamiento(rs.getInt("IdTratamiento"));
                presupuesto.setIdTipoDescuento(rs.getInt("IdTipoDescuento"));
                presupuesto.setPrecio(rs.getFloat("Precio"));
                presupuesto.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                presupuesto.setIdDoctor(rs.getInt("IdDoctor"));
                presupuesto.setIdUsuario(rs.getInt("IdUsuario"));
                listaPresupuestos.add(presupuesto);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return listaPresupuestos;
    }

    
    public DtoPresupuestos obtenerPresupuesto(int id) {
        DtoPresupuestos presupuesto = new DtoPresupuestos();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerPresupuesto);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                presupuesto.setIdPresupuesto(rs.getInt("IdPresupuesto"));
                presupuesto.setIdPaciente(rs.getInt("IdPaciente"));
                presupuesto.setIdTratamiento(rs.getInt("IdTratamiento"));
                presupuesto.setIdTipoDescuento(rs.getInt("IdTipoDescuento"));
                presupuesto.setPrecio(rs.getFloat("Precio"));
                presupuesto.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                presupuesto.setIdDoctor(rs.getInt("IdDoctor"));
                presupuesto.setIdUsuario(rs.getInt("IdUsuario"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return presupuesto;
    }

    
    public boolean agregarPresupuesto(DtoPresupuestos presupuesto) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlAgregarPresupuesto);
            ps.setInt(1, presupuesto.getIdPaciente());
            ps.setInt(2, presupuesto.getIdTratamiento());
            ps.setInt(3, presupuesto.getIdTipoDescuento());
            ps.setDouble(4, presupuesto.getPrecio());
            ps.setInt(5, presupuesto.getIdDoctor());
            ps.setInt(6, presupuesto.getIdUsuario());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }

    
    public boolean editarPresupuesto(DtoPresupuestos presupuesto) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEditarPresupuesto);
            ps.setInt(1, presupuesto.getIdPaciente());
            ps.setInt(2, presupuesto.getIdTratamiento());
            ps.setInt(3, presupuesto.getIdTipoDescuento());
            ps.setDouble(4, presupuesto.getPrecio());
            ps.setInt(5, presupuesto.getIdDoctor());
            ps.setInt(6, presupuesto.getIdUsuario());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }

    
    public boolean eliminarPresupuesto(DtoPresupuestos presupuesto) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEliminarPresupuesto);
            ps.setInt(1, presupuesto.getIdPresupuesto());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }
}
