/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import BancoDeMensajes.MensajesInformativos;
import Configuracion.ConexionBD;
import ModeloDto.DtoMenu;
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
public class DaoMenu implements Serializable {

    static final String sqlObtenerMenus = " SELECT tm.IdMenu, tm.Nombre, tm.Controlador, tm.Activo, "
            + " tm.FechaDeAlta, usuario.usuario,"
            + " case tm.IdPadre when 0 then tm.IdMenu else tm.IdPadre end as MenuPadre, "
            + " tm.IdPadre, "
            + " (SELECT tbs.Nombre FROM tc_menu tbs where tm.IdPadre = tbs.IdMenu ) Padre"
            + " FROM tc_menu  tm "
            + " INNER JOIN tc_usuarios usuario on tm.IdUsuario = usuario.IdUsuario"
            + " WHERE tm.Activo = true  "
            + " ORDER BY MenuPadre, tm.IdMenu";
    static final String sqlObtenerMenu = "  SELECT IdMenu, Nombre,Controlador,Activo,FechaDeAlta, IdUsuario,  IdPadre  "
            + " FROM tc_menu "
            + " WHERE IdMenu = ? AND Activo = true";
    static final String sqlAgregarMenu = " INSERT INTO tc_menu (  Nombre,Controlador,Activo,FechaDeAlta, IdUsuario, IdPadre )"
            + " values ( ? , ? , true, CURRENT_TIMESTAMP(), ? ,? ) ";
    static final String sqlEditarMenu = " UPDATE tc_menu set Nombre=? ,Controlador= ?, IdPadre= ? "
            + " WHERE  IdMenu= ? AND Activo = true ";
    static final String sqlEliminarMenu = " UPDATE tc_menu set Activo=false "
            + " WHERE IdMenu= ?";
    static final String sqlObtenerMenuPadres = "  SELECT IdMenu, Nombre,Controlador,Activo,FechaDeAlta, IdUsuario,  IdPadre  "
            + " FROM tc_menu "
            + " WHERE IdPadre = 0 AND Activo = true"
            + " ORDER BY IdMenu ";
    static final String sqlObtenerMenuActivarDesActivar = "  SELECT Activo "
            + " FROM tc_menu "
            + " WHERE IdMenu = ? ";
    static final String sqlActivarDesActivarMenu = " UPDATE tc_menu set Activo= ? "
            + " WHERE  IdMenu= ? ";
    private static final String classActivo = MensajesInformativos.classActivo;
    private static final String classInActivo = MensajesInformativos.classInActivo;
    private static final String iconActivo = MensajesInformativos.iconActivo;
    private static final String iconInActivo = MensajesInformativos.iconInActivo;

    public ArrayList<DtoMenu> listarMenusPadres() {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<DtoMenu> listaMenus = new ArrayList<DtoMenu>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerMenuPadres);
            rs = ps.executeQuery();
            while (rs.next()) {
                DtoMenu menu = new DtoMenu();
                menu.setIdMenu(rs.getInt("IdMenu"));
                menu.setNombre(rs.getString("Nombre"));
                menu.setControlador(rs.getString("Controlador"));
                menu.setActivo(rs.getBoolean("Activo"));
                menu.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                menu.setIdUsuario(rs.getInt("IdUsuario"));
                menu.setIdPadre(rs.getInt("IdPadre"));
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
                Logger.getLogger(DaoMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaMenus;
    }

    public ArrayList<DtoMenu> listarMenus() {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<DtoMenu> listaMenus = new ArrayList<DtoMenu>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerMenus);
            rs = ps.executeQuery();
            while (rs.next()) {
                DtoMenu menu = new DtoMenu();
                menu.setIdMenu(rs.getInt("IdMenu"));
                menu.setNombre(rs.getString("Nombre"));
                menu.setControlador(rs.getString("Controlador"));
                menu.setActivo(rs.getBoolean("Activo"));
                menu.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                menu.setNombreUsuario(rs.getString("usuario"));
                menu.setIdPadre(rs.getInt("IdPadre"));
                if (rs.getInt("IdPadre") != 0) {
                    menu.setNombreSubMenu(rs.getString("Nombre"));
                    menu.setNombre("");
                    menu.setBtnSubMenu(false);
                } else {
                    menu.setNombreSubMenu("");
                    menu.setBtnSubMenu(true);
                }
                if (menu.isActivo()) {
                    menu.setClassActivo(classActivo);
                    menu.setIconActivo(iconActivo);
                } else {
                    menu.setClassActivo(classInActivo);
                    menu.setIconActivo(iconInActivo);
                }

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
                Logger.getLogger(DaoMenu.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return listaMenus;
    }

    public DtoMenu obtenerMenu(int id) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DtoMenu menu = new DtoMenu();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerMenu);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                menu.setIdMenu(rs.getInt("IdMenu"));
                menu.setNombre(rs.getString("Nombre"));
                menu.setControlador(rs.getString("Controlador"));
                menu.setActivo(rs.getBoolean("Activo"));
                menu.setFechaDeAlta(rs.getDate("FechaDeAlta"));
                menu.setIdUsuario(rs.getInt("IdUsuario"));
                menu.setIdPadre(rs.getInt("IdPadre"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return menu;
    }

    public boolean agregarMenu(DtoMenu menu) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlAgregarMenu);
            ps.setString(1, menu.getNombre());
            ps.setString(2, menu.getControlador());
            ps.setInt(3, 1);
            ps.setInt(4, menu.getIdPadre());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    public boolean editarMenu(DtoMenu menu) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEditarMenu);
            ps.setString(1, menu.getNombre());
            ps.setString(2, menu.getControlador());
            ps.setInt(3, menu.getIdPadre());
            ps.setInt(4, menu.getIdMenu());
            ps.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    public boolean activarDesactivarMenu(int id) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerMenuActivarDesActivar);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getBoolean("Activo")) {
                    con = cn.getConnection();
                    ps = con.prepareStatement(sqlActivarDesActivarMenu);
                    ps.setBoolean(1, false);
                    ps.setInt(2, id);
                    ps.executeUpdate();
                    resp = true;
                } else {
                    con = cn.getConnection();
                    ps = con.prepareStatement(sqlActivarDesActivarMenu);
                    ps.setBoolean(1, true);
                    ps.setInt(2, id);
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
                Logger.getLogger(DaoMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }
}
