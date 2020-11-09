/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import BancoDeMensajes.MensajesInformativos;
import java.io.Serializable;
import Configuracion.ConexionBD;
import ModeloDto.DtoPermisos;
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
public class DaoPermisos implements Serializable {

    static final String sqlObtnerPermisosPerfil = " SELECT "
            + " p.IdPermiso, p.IdPerfil, p.IdMenu, p.FechaDeAlta, p.IdUsuario, p.Activo, u.Usuario "
            + " FROM tr_permisos p "
            + " INNER JOIN tc_usuarios u ON p.IdUsuario = u.IdUsuario "
            + " WHERE p.IdPerfil  = ?";
    static final String sqlObtenerPermisoXMenuPerfil = " SELECT IdPermiso, Activo  "
            + " FROM tr_permisos "
            + " WHERE IdPerfil = ? "
            + " AND IdMenu = ? ";
    static final String sqlActivarPermiso = " UPDATE tr_permisos set Activo=? "
            + " WHERE IdPermiso = ? ";
    static final String sqlInsertarPermiso = " INSERT INTO tr_permisos (IdPerfil, IdMenu, FechaDeAlta, Idusuario, Activo)"
            + " VALUES (? , ?, CURRENT_TIMESTAMP(), ? , true)";
    private static final String classActivo = MensajesInformativos.classActivo;
    private static final String classInActivo = MensajesInformativos.classInActivo;
    private static final String iconActivo = MensajesInformativos.iconActivo;
    private static final String iconInActivo = MensajesInformativos.iconInActivo;

    public boolean ActivarDescativarPermiso(DtoPermisos permiso) {
        boolean resp = false;
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean Activo = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerPermisoXMenuPerfil);
            ps.setInt(1, permiso.getIdPerfil());
            ps.setInt(2, permiso.getIdMenu());
            rs = ps.executeQuery();
            if (rs.next()) {
                permiso.setIdPermiso(rs.getInt("IdPermiso"));
                Activo = rs.getBoolean("Activo");
            } else {
                permiso.setIdPermiso(0);
            }
            if (permiso.getIdPermiso() == 0) {
                con = cn.getConnection();
                ps = con.prepareStatement(sqlInsertarPermiso);
                ps.setInt(1, permiso.getIdPerfil());
                ps.setInt(2, permiso.getIdMenu());
                ps.setInt(3, 1);
                ps.executeUpdate();
                resp = true;
            } else {
                if (Activo) {
                    con = cn.getConnection();
                    ps = con.prepareStatement(sqlActivarPermiso);
                    ps.setBoolean(1, false);
                    ps.setInt(2, permiso.getIdPermiso());
                    ps.executeUpdate();
                    resp = true;
                } else {
                    con = cn.getConnection();
                    ps = con.prepareStatement(sqlActivarPermiso);
                    ps.setBoolean(1, true);
                    ps.setInt(2, permiso.getIdPermiso());
                    ps.executeUpdate();
                    resp = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    public ArrayList<DtoPermisos> listarPermisos(int idPerfil) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<DtoPermisos> listaPermisos = new ArrayList<DtoPermisos>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtnerPermisosPerfil);
            ps.setInt(1, idPerfil);
            rs = ps.executeQuery();
            while (rs.next()) {
                DtoPermisos permiso = new DtoPermisos();
                permiso.setIdPermiso(rs.getInt("IdPermiso"));
                permiso.setIdPerfil(rs.getInt("IdPerfil"));
                permiso.setIdMenu(rs.getInt("IdMenu"));
                permiso.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                permiso.setNombreUsuario(rs.getString("Usuario"));
                permiso.setActivo(rs.getBoolean("Activo"));
                if (permiso.isActivo()) {
                    permiso.setClassActivo(classActivo);
                    permiso.setIconActivo(iconActivo);
                } else {
                    permiso.setClassActivo(classInActivo);
                    permiso.setIconActivo(iconInActivo);
                }
                listaPermisos.add(permiso);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaPermisos;
    }

}
