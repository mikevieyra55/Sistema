/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad;

import Configuracion.ConexionBD;
import ModeloDao.MenusUsuarios.DtoMenuUsuario;
import ModeloDao.MenusUsuarios.DtoSubMenuUsuario;
import java.io.Serializable;
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
public class DaoPermisosUsuarios implements Serializable {

    static final String sqlObtenerMenusUsuario = " SELECT "
            + " m.IdMenu, m.Nombre, m.Controlador, m.IdPadre, "
            + " case m.IdPadre when 0 then m.IdMenu else m.IdPadre end as MenuPadre "
            + " FROM tr_permisos p "
            + " INNER JOIN tc_menu m on p.IdMenu = m.IdMenu "
            + " WHERE "
            + " p.Activo= true AND p.IdPerfil = ? "
            + " AND m.IdPadre = 0 "
            + " ORDER BY MenuPadre desc, m.IdMenu desc ";
    static final String sqlObtenerSubMenuUsuario = " SELECT "
            + " m.IdMenu, m.Nombre, m.Controlador, m.IdPadre, "
            + " case m.IdPadre when 0 then m.IdMenu else m.IdPadre end as MenuPadre "
            + " FROM tr_permisos p "
            + " INNER JOIN tc_menu m on p.IdMenu = m.IdMenu "
            + " WHERE "
            + " p.Activo= true AND p.IdPerfil = ? "
            + " AND m.IdPadre =  ? "
            + " ORDER BY MenuPadre desc, m.IdMenu desc ";

    public ArrayList<DtoMenuUsuario> obtenerMenusUsuario(int IdPerfil) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<DtoMenuUsuario> listaMenus = new ArrayList<DtoMenuUsuario>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerMenusUsuario);
            ps.setInt(1, IdPerfil);
            rs = ps.executeQuery();
            while (rs.next()) {
                DtoMenuUsuario menu = new DtoMenuUsuario();
                menu.setNombre(rs.getString("Nombre"));
                menu.setIdMenu(rs.getInt("IdMenu"));
                listaMenus.add(menu);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoPermisosUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaMenus;
    }

    public ArrayList<DtoSubMenuUsuario> obtenerSubMenusUsuario(int IdPerfil, int IdMenu) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<DtoSubMenuUsuario> listaSubmenus = new ArrayList<DtoSubMenuUsuario>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerSubMenuUsuario);
            ps.setInt(1, IdPerfil);
            ps.setInt(2, IdMenu);
            rs = ps.executeQuery();
            while (rs.next()) {
                DtoSubMenuUsuario submenu = new DtoSubMenuUsuario();
                submenu.setNombre(rs.getString("Nombre"));
                submenu.setControlador(rs.getString("Controlador"));
                listaSubmenus.add(submenu);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoPermisosUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaSubmenus;
    }

}
