/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import java.io.Serializable;

import Configuracion.ConexionBD;
import ModeloDto.DtoCitas;
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
public class DaoCitas implements Serializable  {

    ConexionBD cn = new ConexionBD();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
//    SELECT IdCita,FechaDeAlta,FechaDeCita,HoraDeCita,Activo,IdPaciente,IdUsuario,IdEstadoDeCita,IdDoctor
// FROM tr_citas;
//    IdCita,FechaDeAlta,FechaDeCita,HoraDeCita,Activo,IdPaciente,IdUsuario,IdEstadoDeCita,IdDoctor
    static final String sqlObtenerCitas = "  SELECT IdCita,FechaDeAlta,FechaDeCita,HoraDeCita,Activo,IdPaciente,"
            + " IdUsuario,IdEstadoDeCita,IdDoctor "
            + " FROM tr_citas WHERE Activo = true";
    static final String sqlObtenerCita = "  SELECT IdCita,FechaDeAlta,FechaDeCita,HoraDeCita,Activo,IdPaciente,"
            + " IdUsuario,IdEstadoDeCita,IdDoctor "
            + " FROM tr_citas where IdCita = ? AND Activo = true";
    static final String sqlAgregarCita = " INSERT INTO tr_citas ( FechaDeAlta,FechaDeCita,HoraDeCita,Activo,IdPaciente,"
            + " IdUsuario,IdEstadoDeCita,IdDoctor )"
            + " values (CURRENT_TIMESTAMP() , ? , ? , true, ?, ?, ?, ?  ) ";
    static final String sqlEditarCita = " update tr_citas set FechaDeCita = ? ,HoraDeCita = ?, IdPaciente = ?, "
            + " IdUsuario = ?, IdEstadoDeCita = ?, IdDoctor = ? "
            + " WHERE  IdCita= ? AND Activo = true ";
    static final String sqlEliminarCita = " update tr_citas set Activo=false "
            + " WHERE IdCita= ? AND Activo = true ";

   
    public ArrayList<DtoCitas> listarCitas() {
        ArrayList<DtoCitas> listaCitas = new ArrayList<DtoCitas>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerCitas);
            rs = ps.executeQuery();
            while (rs.next()) {
                DtoCitas cita = new DtoCitas();
                cita.setIdCita(rs.getInt("IdCita"));
                cita.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                cita.setFechaDeCita(rs.getDate("FechaDeCita"));
                cita.setHoraDeCita(rs.getString("HoraDeCita"));
                cita.setActivo(rs.getBoolean("Activo"));
                cita.setIdPaciente(rs.getInt("IdPaciente"));
                cita.setIdUsuario(rs.getInt("IdUsuario"));
                cita.setIdEstadoDeCita(rs.getInt("IdEstadoDeCita"));
                cita.setIdDoctor(rs.getInt("IdDoctor"));
                listaCitas.add(cita);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
          
        }
        return listaCitas;
    }


    public DtoCitas obtenerCita(int id) {
        DtoCitas cita = new DtoCitas();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerCita);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                cita.setIdCita(rs.getInt("IdCita"));
                cita.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                cita.setFechaDeCita(rs.getDate("FechaDeCita"));
                cita.setHoraDeCita(rs.getString("HoraDeCita"));
                cita.setActivo(rs.getBoolean("Activo"));
                cita.setIdPaciente(rs.getInt("IdPaciente"));
                cita.setIdUsuario(rs.getInt("IdUsuario"));
                cita.setIdEstadoDeCita(rs.getInt("IdEstadoDeCita"));
                cita.setIdDoctor(rs.getInt("IdDoctor"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return cita;
    }

 
    public boolean agregarCita(DtoCitas cita) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlAgregarCita);
//            ps.setInt(1, cita.getIdCita());
//            ps.setDate(2, (java.sql.Date) cita.getFechaDeAlta());
            ps.setDate(1, (java.sql.Date) cita.getFechaDeCita());
            ps.setString(2, cita.getHoraDeCita());
//            ps.setBoolean(5, cita.isActivo());
            ps.setInt(3, cita.getIdPaciente());
            ps.setInt(4, cita.getIdUsuario());
            ps.setInt(5, cita.getIdEstadoDeCita());
            ps.setInt(6, cita.getIdDoctor());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }


    public boolean editarCita(DtoCitas cita) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEditarCita);
            ps.setDate(1, (java.sql.Date) cita.getFechaDeCita());
            ps.setString(2, cita.getHoraDeCita());
            ps.setInt(3, cita.getIdPaciente());
            ps.setInt(4, cita.getIdUsuario());
            ps.setInt(5, cita.getIdEstadoDeCita());
            ps.setInt(6, cita.getIdDoctor());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }


    public boolean eliminarCita(DtoCitas cita) {
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEliminarCita);
            ps.setInt(1, cita.getIdCita());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
           
        }
        return resp;
    }
}
