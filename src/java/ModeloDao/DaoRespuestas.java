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
import ModeloDto.DtoRespuestas;
import java.util.Date;
/**
 *
 * @author ULISES.VIEYRA
 */
public class DaoRespuestas  implements Serializable {
//     SELECT IdRespuesta, Descripcion,IdPaciente,FechaDeAlta
//     FROM tr_respuestas;
   
     ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    static final String sqlObtenerRespuestas = " SELECT IdRespuesta, Descripcion,IdPaciente,FechaDeAlta "
            + " FROM tr_respuestas  ";
    static final String sqlObtenerRespuesta = " SELECT IdRespuesta, Descripcion,IdPaciente,FechaDeAlta  "
            + " FROM tr_respuestas "
            + " WHERE IdRespuesta = ? ";
    static final String sqlAgregarRespuesta = " INSERT INTO tr_respuestas (  Descripcion,IdPaciente,FechaDeAlta )"
            + " VALUES ( ? , ? ,CURRENT_TIMESTAMP() ) ";
    static final String sqlEditarRespuesta = " update tr_respuestas set Descripcion=? ,IdPaciente= ? "
            + " WHERE IdRespuesta= ? ";
    static final String sqlEliminarRespuesta = " DELETE FROM tr_respuestas  "
            + " WHERE IdRespuesta= ?";


    public ArrayList<DtoRespuestas> listarRespuestas() {
        ArrayList<DtoRespuestas> listaRespuestas = new ArrayList<DtoRespuestas>();

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerRespuestas);
            rs = ps.executeQuery();
            while (rs.next()) {
                DtoRespuestas respuesta = new DtoRespuestas();
//                IdRespuesta, Descripcion,IdPaciente,FechaDeAlta;
                respuesta.setIdRespuesta(rs.getInt("IdRespuesta"));
                respuesta.setDescripcion(rs.getString("Descripcion"));
                respuesta.setIdPaciente(rs.getInt("IdPaciente"));
                respuesta.setFechaDeAlta(rs.getDate("FechaDeAlta"));              
                listaRespuestas.add(respuesta);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
          
        }
        return listaRespuestas;
    }

    
    public DtoRespuestas obtenerRespuesta(int id) {
        DtoRespuestas respuesta = new DtoRespuestas();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerRespuesta);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                respuesta.setIdRespuesta(rs.getInt("IdRespuesta"));
                respuesta.setDescripcion(rs.getString("Descripcion"));
                respuesta.setIdPaciente(rs.getInt("IdPaciente"));
                respuesta.setFechaDeAlta(rs.getDate("FechaDeAlta"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return respuesta;
    }
  
    
    public boolean agregarRespuesta(DtoRespuestas respuesta) {
        boolean resp= false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlAgregarRespuesta);
            ps.setInt(1, respuesta.getIdRespuesta());
            ps.setString(2, respuesta.getDescripcion());
            ps.setInt(3, respuesta.getIdPaciente());
            ps.setDate(4, (java.sql.Date) respuesta.getFechaDeAlta());
            ps.executeUpdate();
            resp =true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }

    
    public boolean editarRespuesta(DtoRespuestas respuesta) {
        boolean resp=false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEditarRespuesta);
            ps.setInt(1, respuesta.getIdRespuesta());
            ps.setString(2, respuesta.getDescripcion());
            ps.setInt(3, respuesta.getIdPaciente());          
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }
    
    public boolean eliminarRespuesta(DtoRespuestas respuesta) {
        boolean resp=false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEliminarRespuesta);
            ps.setInt(1, respuesta.getIdRespuesta());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
              System.out.println("Error" + e.toString());
        } finally {
            
        }
        return resp;
    }
    
}
