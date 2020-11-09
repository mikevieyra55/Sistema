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
import ModeloDto.DtoTipoDePregunta;

/**
 *
 * @author ULISES.VIEYRA
 */
public class DaoTipoDePreguntas implements Serializable  {
//     SELECT     IdTipoDePregunta,Descripcion, Activo,FechaDeAlta,IdUsuario
// FROM tc_tiposdepregunta;

    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    static final String sqlObtenerTiposDePreguntas = " SELECT  IdTipoDePregunta,Descripcion, Activo,FechaDeAlta,IdUsuario "
            + " FROM tc_tiposdepregunta WHERE Activo = true ";
    static final String sqlObtenerTipoDePregunta = " SELECT  IdTipoDePregunta,Descripcion, Activo,FechaDeAlta,IdUsuario  "
            + " FROM tc_tiposdepregunta "
            + " WHERE IdTipoDePregunta = ? AND Activo = true";
    static final String sqlAgregarTipoDePregunta = " INSERT INTO tc_tiposdepregunta ( Descripcion, Activo,FechaDeAlta,IdUsuario )"
            + " values ( ? , true, CURRENT_TIMESTAMP(), ?  ) ";
    static final String sqlEditarTipoDePregunta = " UPDATE tc_tiposdepregunta set Descripcion=? ,IdUsuario= ? "
            + " WHERE IdTipoDePregunta= ? AND Activo = true ";
    static final String sqlEliminarTipoDePregunta = " update tc_tiposdepregunta set Activo=false "
            + " WHERE IdTipoDePregunta= ?";

    
    public ArrayList<DtoTipoDePregunta> listarTipoDePreguntas() {
        ArrayList<DtoTipoDePregunta> listaTipoPreguntas = new ArrayList<DtoTipoDePregunta>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerTiposDePreguntas);
            rs = ps.executeQuery();
            while (rs.next()) {
                DtoTipoDePregunta tipoPregunta = new DtoTipoDePregunta();
//                IdTipoDePregunta,Descripcion, Activo,FechaDeAlta,IdUsuario 
                tipoPregunta.setIdTipoDePregunta(rs.getInt("IdTipoDePregunta"));
                tipoPregunta.setDescripcion(rs.getString("Descripcion"));
                tipoPregunta.setActivo(rs.getBoolean("Activo"));
                tipoPregunta.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                tipoPregunta.setIdUsuario(rs.getInt("IdUsuario"));
                listaTipoPreguntas.add(tipoPregunta);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return listaTipoPreguntas;
    }

    
    public DtoTipoDePregunta obtenerTipoDePregunta(int id) {
        DtoTipoDePregunta tipoPregunta = new DtoTipoDePregunta();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerTipoDePregunta);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                tipoPregunta.setIdTipoDePregunta(rs.getInt("IdTipoDePregunta"));
                tipoPregunta.setDescripcion(rs.getString("Descripcion"));
                tipoPregunta.setActivo(rs.getBoolean("Activo"));
                tipoPregunta.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                tipoPregunta.setIdUsuario(rs.getInt("IdUsuario"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return tipoPregunta;
    }

    
    public boolean agregarTipoDePregunta(DtoTipoDePregunta tipoPregunta) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlAgregarTipoDePregunta);
            ps.setString(1, tipoPregunta.getDescripcion());
            ps.setInt(2, tipoPregunta.getIdUsuario());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }

    
    public boolean editarTipoDePregunta(DtoTipoDePregunta tipoPregunta) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEditarTipoDePregunta);
            ps.setString(1, tipoPregunta.getDescripcion());
            ps.setInt(2, tipoPregunta.getIdUsuario());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }

    
    public boolean eliminarTipoDePregunta(DtoTipoDePregunta tipoPregunta) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEliminarTipoDePregunta);
            ps.setInt(1, tipoPregunta.getIdTipoDePregunta());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }

}
