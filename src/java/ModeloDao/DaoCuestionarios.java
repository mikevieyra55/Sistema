/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import java.io.Serializable;
import Configuracion.ConexionBD;
import ModeloDto.DtoCuestionarios;
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
public class DaoCuestionarios implements Serializable  {
    
//    IdCuestionario,Nombre,Descripcion,FechaDeAlta,Activo,TipoPregunta;
    
     ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
//    SELECT IdCuestionario,Nombre,Descripcion,FechaDeAlta,Activo,TipoPregunta
// FROM tc_cuestionarios;
    static final String sqlObtenerCuestionarios = " SELECT IdCuestionario,Nombre,Descripcion,FechaDeAlta,Activo "
            + " FROM tc_cuestionarios WHERE Activo = true ";
    static final String sqlObtenerCuestionario = " SELECT IdCuestionario,Nombre,Descripcion,FechaDeAlta,Activo "
            + " FROM tc_cuestionarios "
            + " WHERE IdCuestionario = ? AND Activo = true";
    static final String sqlAgregarCuestionario = " INSERT INTO tc_cuestionarios"
            + " (  Nombre,Descripcion,FechaDeAlta,Activo )"
            + " values (?, ? , CURRENT_TIMESTAMP()  ,  true ) ";
    static final String sqlEditarCuestionario = " update tc_cuestionarios set Nombre=? ,Descripcion= ? "
            + " WHERE  IdCuestionario = ? AND Activo = true ";
    static final String sqlEliminarCuestionario = " update tc_cuestionarios set Activo=false "
            + " WHERE IdCuestionario = ? ";

  
    public ArrayList<DtoCuestionarios> listarCuestionario() {
        ArrayList<DtoCuestionarios> listaCitas = new ArrayList<DtoCuestionarios>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerCuestionarios);
            rs = ps.executeQuery();
            while (rs.next()) {
                DtoCuestionarios cuestionario = new DtoCuestionarios();
                cuestionario.setIdCuestionario(rs.getInt("IdCuestionario"));
                cuestionario.setNombre(rs.getString("Nombre"));
                cuestionario.setDescripcion(rs.getString("Descripcion"));
                cuestionario.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                cuestionario.setActivo(rs.getBoolean("Activo"));
                listaCitas.add(cuestionario);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
          
        }
        return listaCitas;
    }

 
    public DtoCuestionarios obtenerCuestionario(int id) {
        DtoCuestionarios cuestionario = new DtoCuestionarios();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerCuestionario);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                cuestionario.setIdCuestionario(rs.getInt("IdCuestionario"));
                cuestionario.setNombre(rs.getString("Nombre"));
                cuestionario.setDescripcion(rs.getString("Descripcion"));
                cuestionario.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                cuestionario.setActivo(rs.getBoolean("Activo"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return cuestionario;
    }  
   

 
    public boolean agregarCuestionario(DtoCuestionarios cuestionario) {
        boolean resp= false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlAgregarCuestionario);            
            ps.setString(1, cuestionario.getNombre());
            ps.setString(2, cuestionario.getDescripcion());
            ps.executeUpdate();
            resp =true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }

    public boolean editarCuestionario(DtoCuestionarios cuestionario) {
        boolean resp=false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEditarCuestionario);
            ps.setString(1, cuestionario.getNombre());
            ps.setString(2, cuestionario.getDescripcion());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }
 

    public boolean eliminarCuestionario(DtoCuestionarios cuestionario) {
        boolean resp=false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEliminarCuestionario);
            ps.setInt(1, cuestionario.getIdCuestionario());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
              System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }
}
