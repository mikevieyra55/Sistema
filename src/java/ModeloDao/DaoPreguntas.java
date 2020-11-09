/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import java.io.Serializable;
import Configuracion.ConexionBD;
import ModeloDto.DtoPreguntas;
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
public class DaoPreguntas implements Serializable  {

//    SELECT IdPregunta, Descripcion, IdCuestionario, Orden, Activo, FechaDeAlta, IdUsuario, IdTipoDePregunta
//    FROM tr_preguntas;
    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    static final String sqlObtenerPreguntas= " SELECT IdPregunta, Descripcion,IdCuestionario,Orden,Activo,FechaDeAlta, "
            + " IdUsuario, IdTipoDePregunta "
            + " FROM tr_preguntas"
            + " WHERE IdCuestionario = ? AND Activo = true ";
    static final String sqlObtenerPregunta = " SELECT IdPregunta, Descripcion,IdCuestionario,Orden,Activo,FechaDeAlta, "
            + " IdUsuario, IdTipoDePregunta "
            + " FROM tr_preguntas "
            + " WHERE IdCuestionario = ? AND IdPregunta = ? AND Activo = true";
    static final String sqlAgregarPregunta = " INSERT INTO tr_preguntas ( Descripcion,IdCuestionario,Orden,Activo,FechaDeAlta,"
            + " IdUsuario, IdTipoDePregunta)"
            + " values ( ? , ? , ?, true, CURRENT_TIMESTAMP(), ?, ?  ) ";
    static final String sqlEditarPregunta = " update tr_preguntas set Descripcion=? ,IdCuestionario= ?, Orden = ? "
            + " IdUsuario=? ,IdTipoDePregunta= ? "
            + " WHERE  IdCuestionario= ? AND IdPregunta = ? AND Activo = true ";
    static final String sqlEliminarPregunta = " update tr_preguntas set Activo=false "
            + " WHERE IdCuestionario = ? AND IdPregunta = ? AND IdAbono= ?";

  
    public ArrayList<DtoPreguntas> listarPreguntas(int idCuestionario) {
        ArrayList<DtoPreguntas> listaPreguntas = new ArrayList<DtoPreguntas>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerPreguntas);
            ps.setInt(1, idCuestionario);
            rs = ps.executeQuery();
            while (rs.next()) {
                DtoPreguntas pregunta = new DtoPreguntas();
//                IdPregunta, Descripcion,IdCuestionario,Orden,Activo,FechaDeAlta, IdUsuario;
                pregunta.setIdPregunta(rs.getInt("IdPregunta"));
                pregunta.setDescripcion(rs.getString("Descripcion"));
                pregunta.setIdCuestionario(rs.getInt("IdCuestionario"));
                pregunta.setOrden(rs.getInt("Orden"));
                pregunta.setActivo(rs.getBoolean("Activo"));
                pregunta.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                pregunta.setIdUsuario(rs.getInt("IdUsuario"));
                listaPreguntas.add(pregunta);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return listaPreguntas;
    }

   
    public DtoPreguntas obtenerPregunta(int idCuestionario, int idPregunta) {
        DtoPreguntas pregunta = new DtoPreguntas();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerPregunta);
            ps.setInt(1, idCuestionario);
            ps.setInt(2, idPregunta);
            rs = ps.executeQuery();
            while (rs.next()) {
                pregunta.setIdPregunta(rs.getInt("IdPregunta"));
                pregunta.setDescripcion(rs.getString("Descripcion"));
                pregunta.setIdCuestionario(rs.getInt("IdCuestionario"));
                pregunta.setOrden(rs.getInt("Orden"));
                pregunta.setActivo(rs.getBoolean("Activo"));
                pregunta.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                pregunta.setIdUsuario(rs.getInt("IdUsuario"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return pregunta;
    }

   
    public boolean agregarPregunta(DtoPreguntas pregunta) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlAgregarPregunta);
            ps.setString(1, pregunta.getDescripcion());
            ps.setInt(2, pregunta.getIdCuestionario());
            ps.setInt(3, pregunta.getOrden());
            ps.setInt(4, pregunta.getIdUsuario());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }

 
    public boolean editarPregunta(DtoPreguntas pregunta) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEditarPregunta);
             ps.setString(1, pregunta.getDescripcion());
            ps.setInt(2, pregunta.getIdCuestionario());
            ps.setInt(3, pregunta.getOrden());
            ps.setInt(4, pregunta.getIdUsuario());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }

    
    public boolean eliminarPregunta(DtoPreguntas pregunta) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEliminarPregunta);
            ps.setInt(1, pregunta.getIdCuestionario());
             ps.setInt(1, pregunta.getIdPregunta());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }
}
