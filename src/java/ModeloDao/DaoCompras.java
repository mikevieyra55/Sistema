/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import java.io.Serializable;
import Configuracion.ConexionBD;
import ModeloDto.DtoCompras;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ULISES.VIEYRA
 */
public class DaoCompras implements Serializable  {

    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    static final String sqlObtenerCompras = "  SELECT IdCompra, FechaDeAlta,Total,IdUsuario,IdDoctor, IdEstadoCompra "
            + " FROM tr_compras ";
    static final String sqlObtenerCompra = "  SELECT IdCompra, FechaDeAlta,Total,IdUsuario,IdDoctor, IdEstadoCompra "
            + " FROM tr_compras WHERE IdCompra = ? ";
    static final String sqlAgregarCompra = " INSERT INTO tr_compras ( FechaDeAlta,Total,IdUsuario,IdDoctor, IdEstadoCompra)"
            + " values (CURRENT_TIMESTAMP() , ? , ? , ?, ?  ) ";
    static final String sqlEditarCompra = " update tr_compras set Total = ? ,IdUsuario = ?, IdDoctor = ?, "
            + " IdEstadoCompra = ? "
            + " WHERE  IdCompra = ? ";
    static final String sqlEliminarCompra = " delete from tr_compras "
            + " WHERE IdCompra = ? ";

   
    public ArrayList<DtoCompras> listarCompras() {
        ArrayList<DtoCompras> listaCompras = new ArrayList<DtoCompras>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerCompras);
            rs = ps.executeQuery();
            while (rs.next()) {
                DtoCompras compra = new DtoCompras();
                compra.setIdCompra(rs.getInt("IdCompra"));
                compra.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                compra.setTotal(rs.getFloat("Total"));
                compra.setIdUsuario(rs.getInt("IdUsuario"));
                compra.setIdDoctor(rs.getInt("IdDoctor"));
                compra.setIdEstadoCompra(rs.getInt("IdEstadoCompra"));
                listaCompras.add(compra);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
        }
        return listaCompras;
    }

   
    public DtoCompras obtenerCompra(int id) {
        DtoCompras compra = new DtoCompras();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerCompra);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                compra.setIdCompra(rs.getInt("IdCompra"));
                compra.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                compra.setTotal(rs.getFloat("Total"));
                compra.setIdUsuario(rs.getInt("IdUsuario"));
                compra.setIdDoctor(rs.getInt("IdDoctor"));
                compra.setIdEstadoCompra(rs.getInt("IdEstadoCompra"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
        }
        return compra;
    }

  
    public boolean agregarCompra(DtoCompras compra) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlAgregarCompra);
            ps.setFloat(1, compra.getTotal());
            ps.setInt(2, compra.getIdUsuario());
            ps.setInt(3, compra.getIdDoctor());
            ps.setInt(4, compra.getIdEstadoCompra());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
        }
        return resp;
    }


    public boolean editarCompra(DtoCompras compra) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEditarCompra);
            ps.setFloat(1, compra.getTotal());
            ps.setInt(2, compra.getIdUsuario());
            ps.setInt(3, compra.getIdDoctor());
            ps.setInt(4, compra.getIdEstadoCompra());
            ps.setInt(5, compra.getIdCompra());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {

        }
        return resp;
    }

 
    public boolean eliminarCompra(DtoCompras compra) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEliminarCompra);
            ps.setInt(1, compra.getIdCompra());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {

        }
        return resp;
    }

}
