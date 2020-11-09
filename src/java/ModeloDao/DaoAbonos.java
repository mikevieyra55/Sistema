/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import java.io.Serializable;
import Configuracion.ConexionBD;
import ModeloDto.DtoAbonos;
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
public class DaoAbonos implements Serializable {

    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    static final String sqlObtenerAbonos = " SELECT IdAbono, FechaDeAlta, Cantidad, IdUsuario, IdCompra "
            + " FROM tr_abonos WHERE IdCompra = ? AND Activo = true ";
    static final String sqlObtenerAbono = " SELECT IdAbono, FechaDeAlta, Cantidad, IdUsuario, IdCompra  "
            + " FROM tr_abonos "
            + " WHERE IdAbono = ? AND Activo = true";
    static final String sqlAgregarAbono = " INSERT INTO tr_abonos (  FechaDeAlta, Cantidad, IdUsuario, IdCompra, Activo )"
            + " values (CURRENT_TIMESTAMP() , ? , ? , ?, true  ) ";
    static final String sqlEditarAbono = " update tr_abonos set Cantidad=? ,IdUsuario= ?, IdCompra = ? "
            + " WHERE  IdAbono= ? AND Activo = true ";
    static final String sqlEliminarAbono = " update tr_abonos set Activo=false "
            + " WHERE IdAbono= ?";


    public ArrayList<DtoAbonos> listarAbonos(int idCompra) {
        ArrayList<DtoAbonos> listaAbonos = new ArrayList<DtoAbonos>();

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerAbonos);
            ps.setInt(1, idCompra);
            rs = ps.executeQuery();
            while (rs.next()) {
                DtoAbonos abono = new DtoAbonos();
                abono.setIdAbono(rs.getInt("IdAbono"));
                abono.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                abono.setCantidad(rs.getFloat("Cantidad"));
                abono.setIdUsuario(rs.getInt("IdUsuario"));
                abono.setIdCompra(rs.getInt("IdCompra"));
                listaAbonos.add(abono);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return listaAbonos;
    }


    public DtoAbonos obtenerAbono(int id) {
        DtoAbonos abono = new DtoAbonos();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerAbono);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                abono.setIdAbono(rs.getInt("IdAbono"));
                abono.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                abono.setCantidad(rs.getFloat("Cantidad"));
                abono.setIdUsuario(rs.getInt("IdUsuario"));
                abono.setIdCompra(rs.getInt("IdCompra"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return abono;
    }


    public boolean agregarAbono(DtoAbonos abono) {
        boolean resp= false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlAgregarAbono);
            ps.setDouble(1, abono.getCantidad());
            ps.setInt(2, abono.getIdUsuario());
            ps.setInt(3, abono.getIdCompra());
            ps.executeUpdate();
            resp =true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            
        }
        return resp;
    }
    
    public boolean editarAbono(DtoAbonos abono) {
        boolean resp=false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEditarAbono);
            ps.setDouble(1, abono.getCantidad());
            ps.setInt(2, abono.getIdUsuario());
            ps.setInt(3, abono.getIdCompra());
            ps.setInt(4, abono.getIdAbono());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }

    public boolean eliminarAbono(DtoAbonos abono) {
        boolean resp=false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEliminarAbono);
            ps.setInt(1, abono.getIdAbono());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
              System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }
}