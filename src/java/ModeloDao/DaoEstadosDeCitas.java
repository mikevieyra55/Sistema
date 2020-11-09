/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import java.io.Serializable;
import Configuracion.ConexionBD;
import ModeloDto.DtoEstadosDeCitas;
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
public class DaoEstadosDeCitas implements Serializable  {
//   SELECT  IdEstadoDeCita,Nombre,Descripcion,Activo,IdUsuario, FechaDeAlta
// FROM tc_estadosdecita;

    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    static final String sqlObtenerEstadosDeCitas = " SELECT IdEstadoDeCita,Nombre,Descripcion,Activo,IdUsuario, FechaDeAlta "
            + " FROM tc_estadosdecita "
            + " WHERE Activo = true ";
    static final String sqlObtenerEstadoDeCita = " SELECT IdEstadoDeCita,Nombre,Descripcion,Activo,IdUsuario, FechaDeAlta  "
            + " FROM tc_estadosdecita "
            + " WHERE IdEstadoDeCita = ? AND Activo = true";
    static final String sqlAgregarEstadoDeCita = " INSERT INTO tc_estadosdecita (Nombre,Descripcion,Activo,IdUsuario, FechaDeAlta )"
            + " values ( ? , ? , true, ? , CURRENT_TIMESTAMP()  ) ";
    static final String sqlEditarEstadoDeCita = " update tc_estadosdecita set Nombre=? ,Descripcion= ?, IdUsuario = ? "
            + " WHERE  IdEstadoDeCita= ? AND Activo = true ";
    static final String sqlEliminarEstadoDeCita = " update tc_estadosdecita set Activo=false "
            + " WHERE IdEstadoDeCita= ? ";

 
    
    public ArrayList<DtoEstadosDeCitas> listarEstadosDeCitas() {
        ArrayList<DtoEstadosDeCitas> listaEstadosCitas = new ArrayList<DtoEstadosDeCitas>();

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerEstadosDeCitas);
            rs = ps.executeQuery();
            while (rs.next()) {
                DtoEstadosDeCitas estadoCita = new DtoEstadosDeCitas();
//                IdEstadoDeCita,Nombre,Descripcion,Activo,IdUsuario, FechaDeAlta
                estadoCita.setIdEstadoDeCita(rs.getInt("IdEstadoDeCita"));
                estadoCita.setNombre(rs.getString("Nombre"));
                estadoCita.setDescripcion(rs.getString("Descripcion"));
                estadoCita.setActivo(rs.getBoolean("Activo"));
                estadoCita.setIdUsuario(rs.getInt("IdUsuario"));
                estadoCita.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                listaEstadosCitas.add(estadoCita);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
          
        }
        return listaEstadosCitas;
    }

 
    
    public DtoEstadosDeCitas obtenerEstadosDeCita(int id) {
        DtoEstadosDeCitas estadoCita = new DtoEstadosDeCitas();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerEstadoDeCita);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                 estadoCita.setIdEstadoDeCita(rs.getInt("IdEstadoDeCita"));
                estadoCita.setNombre(rs.getString("Nombre"));
                estadoCita.setDescripcion(rs.getString("Descripcion"));
                estadoCita.setActivo(rs.getBoolean("Activo"));
                estadoCita.setIdUsuario(rs.getInt("IdUsuario"));
                estadoCita.setFechaDeAlta(rs.getDate("FechaDeAlta"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
          
        }
        return estadoCita;
    }


    
    public boolean agregarEstadoDeCita(DtoEstadosDeCitas estadoCita) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlAgregarEstadoDeCita);
            ps.setString(1, estadoCita.getNombre());
            ps.setString(2, estadoCita.getDescripcion());
            ps.setInt(3, estadoCita.getIdUsuario());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }

   
    public boolean editarEstadoDeCita(DtoEstadosDeCitas estadoCita) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEditarEstadoDeCita); 
            ps.setString(1, estadoCita.getNombre());
            ps.setString(2, estadoCita.getDescripcion());
            ps.setInt(3, estadoCita.getIdUsuario());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }

  
    public boolean eliminarEstadoDeCita(DtoEstadosDeCitas estadoCita) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEliminarEstadoDeCita);
            ps.setInt(1, estadoCita.getIdEstadoDeCita());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            
        }
        return resp;
    }

}
