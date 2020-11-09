/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import BancoDeMensajes.MensajesInformativos;
import java.io.Serializable;
import Configuracion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ModeloDto.DtoUsuarios;
import java.util.Date;
import UML.util.Fecha;

/**
 *
 * @author ULISES.VIEYRA
 */
public class DaoUsuarios implements Serializable {

    static final String sqlObtenerUsuariosActivosInActivos = " SELECT tus.IdUsuario, tus.Nombres, tus.Apellidos, tus.Celular, tus.Correo, "
            + " tus.FechaDeNacimiento, tus.FechaDeAlta, tus.Activo, tus.Usuario, tus.IdPerfil,  tpe.Nombre DescPerfil, "
            + " tus.Domicilio, tus.IdEstado, tus.IdMunicipio, tus.Password, "
            + " tes.Nombre DescEstado, tmu.Nombre DescMunicipio, tus.CodigoPostal "
            + " FROM tc_usuarios tus"
            + " INNER JOIN tc_estados tes ON tus.IdEstado = tes.IdEstado "
            + " INNER JOIN tc_municipios tmu ON tus.IdMunicipio = tmu.IdMunicipio"
            + " INNER JOIN  tc_perfiles tpe ON tus.IdPerfil = tpe.IdPerfil "
            + " ORDER BY tus.Activo";
    
    static final String sqlObtenerUsuarios = " SELECT tus.IdUsuario, tus.Nombres, tus.Apellidos, tus.Celular, tus.Correo, "
            + " tus.FechaDeNacimiento, tus.FechaDeAlta, tus.Activo, tus.Usuario, tus.IdPerfil, "
            + " tus.Domicilio, tus.IdEstado, tus.IdMunicipio, tus.Password, "
            + " tes.Nombre DescEstado, tmu.Nombre DescMunicipio, tus.CodigoPostal "
            + " FROM tc_usuarios tus"
            + " INNER JOIN tc_estados tes ON tus.IdEstado = tes.IdEstado "
            + " INNER JOIN tc_municipios tmu ON tus.IdMunicipio = tmu.IdMunicipio "
            + " WHERE "
            + " tus.Activo = true ";
    static final String sqlObtenerUsuario = " SELECT tus.IdUsuario, tus.Nombres, tus.Apellidos, tus.Celular, tus.Correo, "
            + " tus.FechaDeNacimiento, tus.FechaDeAlta, tus.Activo, tus.Usuario, tus.IdPerfil, "
            + " tus.Domicilio, tus.IdEstado, tus.IdMunicipio, tus.Password, "
            + " tes.Nombre DescEstado, tmu.Nombre DescMunicipio, tus.CodigoPostal "
            + " FROM tc_usuarios tus "
            + " INNER JOIN tc_estados tes ON tus.IdEstado = tes.IdEstado "
            + " INNER JOIN tc_municipios tmu ON tus.IdMunicipio = tmu.IdMunicipio "
            + " WHERE tus.IdUsuario = ? "
            + " AND tus.Activo = true";
    static final String sqlAgregarUsuario = " INSERT INTO tc_usuarios (  Nombres,Apellidos, Celular, Correo,"
            + " FechaDeNacimiento,FechaDeAlta, Activo, Usuario, IdPerfil,"
            + " Domicilio, IdEstado, IdMunicipio, Password, CodigoPostal )"
            + " VALUES ( ? , ? , ? , ? , "
            + " ? , CURRENT_TIMESTAMP(),  true, ? , ?, "
            + " ?, ? , ? ,  ?, ? ) ";
    static final String sqlEditarUsuario = " UPDATE tc_usuarios SET Nombres=? ,Apellidos= ?, Celular = ?, "
            + " Correo=? ,FechaDeNacimiento= ?, Usuario = ?, IdPerfil=? ,Domicilio= ?, IdEstado = ?, "
            + " IdMunicipio=? , Password = ? , CodigoPostal = ? "
            + " WHERE  IdUsuario= ? AND Activo = true ";
    static final String sqlEliminarUsuario = " UPDATE tc_usuarios SET Activo=false "
            + " WHERE IdUsuario= ?";
    static final String sqlObtenerUsuariosxPerfil
            = " SELECT tus.IdUsuario, tus.Nombres, tus.Apellidos, tus.Celular, tus.Correo, "
            + " tus.FechaDeNacimiento, tus.FechaDeAlta, tus.Activo, tus.Usuario, tus.IdPerfil, "
            + " tus.Domicilio, tus.IdEstado, tus.IdMunicipio, tus.Password, "
            + " tes.Nombre DescEstado, tmu.Nombre DescMunicipio, tus.CodigoPostal"
            + " FROM tc_usuarios tus"
            + " INNER JOIN tc_estados tes ON tus.IdEstado = tes.IdEstado "
            + " INNER JOIN tc_municipios tmu ON tus.IdMunicipio = tmu.IdMunicipio "
            + " WHERE "
            + " tus.Activo = true "
            + " AND tus.IdPerfil = ? ";

    private static final String classActivo = MensajesInformativos.classActivo;
    private static final String classInActivo = MensajesInformativos.classInActivo;
    private static final String iconActivo = MensajesInformativos.iconActivo;
    private static final String iconInActivo = MensajesInformativos.iconInActivo;

    public ArrayList<DtoUsuarios> listarUsuariosXPerfil(int idPerfil) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<DtoUsuarios> listaUsuarios = new ArrayList<DtoUsuarios>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerUsuarios);
            ps.setInt(1, idPerfil);
            rs = ps.executeQuery();
            while (rs.next()) {
                DtoUsuarios usuario = new DtoUsuarios();
                usuario.setIdUsuario(rs.getInt("IdUsuario"));
                usuario.setNombres(rs.getString("Nombres"));
                usuario.setApellidos(rs.getString("Apellidos"));
                usuario.setCelular(rs.getString("Celular"));
                usuario.setCorreo(rs.getString("Correo"));
                usuario.setFechaDeNacimiento(rs.getString("FechaDeNacimiento"));
                usuario.setFechaDeAlta(rs.getString("FechaDeAlta"));  
                usuario.setActivo(rs.getBoolean("Activo"));
                usuario.setUsuario(rs.getString("Usuario"));
                usuario.setIdPerfil(rs.getInt("IdPerfil"));
                usuario.setDomicilio(rs.getString("Domicilio"));
                usuario.setIdEstado(rs.getInt("IdEstado"));
                usuario.setIdMunicipio(rs.getInt("IdMunicipio"));
                usuario.setPassword(rs.getString("Password"));
                usuario.setNombreEstado(rs.getString("DescEstado"));
                usuario.setNombreMunicipio(rs.getString("DescMunicipio"));
                usuario.setCodigoPostal(rs.getString("CodigoPostal"));
                if (usuario.isActivo()) {
                    usuario.setClassActivo(classActivo);
                    usuario.setIconActivo(iconActivo);
                } else {
                    usuario.setClassActivo(classInActivo);
                    usuario.setIconActivo(iconInActivo);
                }

                listaUsuarios.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaUsuarios;
    }

    public ArrayList<DtoUsuarios> listarUsuarios() {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<DtoUsuarios> listaUsuarios = new ArrayList<DtoUsuarios>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerUsuarios);
            rs = ps.executeQuery();
            while (rs.next()) {
                DtoUsuarios usuario = new DtoUsuarios();
                usuario.setIdUsuario(rs.getInt("IdUsuario"));
                usuario.setNombres(rs.getString("Nombres"));
                usuario.setApellidos(rs.getString("Apellidos"));
                usuario.setCelular(rs.getString("Celular"));
                usuario.setCorreo(rs.getString("Correo"));
                usuario.setFechaDeNacimiento(rs.getString("FechaDeNacimiento"));
                usuario.setFechaDeAlta(rs.getString("FechaDeAlta"));                
                usuario.setActivo(rs.getBoolean("Activo"));
                usuario.setUsuario(rs.getString("Usuario"));
                usuario.setIdPerfil(rs.getInt("IdPerfil"));
                usuario.setDomicilio(rs.getString("Domicilio"));
                usuario.setIdEstado(rs.getInt("IdEstado"));
                usuario.setIdMunicipio(rs.getInt("IdMunicipio"));
                usuario.setPassword(rs.getString("Password"));
                usuario.setNombreEstado(rs.getString("DescEstado"));
                usuario.setNombreMunicipio(rs.getString("DescMunicipio"));
                usuario.setCodigoPostal(rs.getString("CodigoPostal"));
                if (usuario.isActivo()) {
                    usuario.setClassActivo(classActivo);
                    usuario.setIconActivo(iconActivo);
                } else {
                    usuario.setClassActivo(classInActivo);
                    usuario.setIconActivo(iconInActivo);
                }
                listaUsuarios.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaUsuarios;
    }
    
    public ArrayList<DtoUsuarios> listarUsuariosActivoInActivo() {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<DtoUsuarios> listaUsuarios = new ArrayList<DtoUsuarios>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerUsuariosActivosInActivos);
            rs = ps.executeQuery();
            while (rs.next()) {
                DtoUsuarios usuario = new DtoUsuarios();
                usuario.setIdUsuario(rs.getInt("IdUsuario"));
                usuario.setNombres(rs.getString("Nombres"));
                usuario.setApellidos(rs.getString("Apellidos"));
                usuario.setCelular(rs.getString("Celular"));
                usuario.setCorreo(rs.getString("Correo"));
                usuario.setFechaDeNacimiento(rs.getString("FechaDeNacimiento"));
                usuario.setFechaDeAlta(rs.getString("FechaDeAlta"));                
                usuario.setActivo(rs.getBoolean("Activo"));
                usuario.setUsuario(rs.getString("Usuario"));
                usuario.setIdPerfil(rs.getInt("IdPerfil"));
                usuario.setDomicilio(rs.getString("Domicilio"));
                usuario.setIdEstado(rs.getInt("IdEstado"));
                usuario.setIdMunicipio(rs.getInt("IdMunicipio"));
                usuario.setPassword(rs.getString("Password"));
                usuario.setNombreEstado(rs.getString("DescEstado"));
                usuario.setNombreMunicipio(rs.getString("DescMunicipio"));
                usuario.setCodigoPostal(rs.getString("CodigoPostal"));
                usuario.setNombrePerfil(rs.getString("DescPerfil"));
                if (usuario.isActivo()) {
                    usuario.setClassActivo(classActivo);
                    usuario.setIconActivo(iconActivo);
                } else {
                    usuario.setClassActivo(classInActivo);
                    usuario.setIconActivo(iconInActivo);
                }
                listaUsuarios.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaUsuarios;
    }

    public DtoUsuarios obtenerUsuario(int id) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DtoUsuarios usuario = new DtoUsuarios();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerUsuario);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                usuario.setIdUsuario(rs.getInt("IdUsuario"));
                usuario.setNombres(rs.getString("Nombres"));
                usuario.setApellidos(rs.getString("Apellidos"));
                usuario.setCelular(rs.getString("Celular"));
                usuario.setCorreo(rs.getString("Correo"));                
                usuario.setFechaDeNacimiento(rs.getString("FechaDeNacimiento"));
                usuario.setFechaDeAlta(rs.getString("FechaDeNacimiento"));
                usuario.setActivo(rs.getBoolean("Activo"));
                usuario.setUsuario(rs.getString("Usuario"));
                usuario.setIdPerfil(rs.getInt("IdPerfil"));
                usuario.setDomicilio(rs.getString("Domicilio"));
                usuario.setIdEstado(rs.getInt("IdEstado"));
                usuario.setIdMunicipio(rs.getInt("IdMunicipio"));
                usuario.setPassword(rs.getString("Password"));
                usuario.setCodigoPostal(rs.getString("CodigoPostal"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuario;
    }

    public boolean agregarUsuario(DtoUsuarios usuario) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlAgregarUsuario);
            ps.setString(1, usuario.getNombres());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getCelular());
            ps.setString(4, usuario.getCorreo());
            ps.setString(5, new Fecha(new Date(usuario.getFechaDeNacimiento()), true).fechaFormateada());//usuario.getFechaDeNacimiento().toString());//(java.sql.Date) usuario.getFechaDeNacimiento());
            ps.setString(6, usuario.getUsuario());
            ps.setInt(7, usuario.getIdPerfil());
            ps.setString(8, usuario.getDomicilio());
            ps.setInt(9, usuario.getIdEstado());
            ps.setInt(10, usuario.getIdMunicipio());
            ps.setString(11, usuario.getPassword());
            ps.setString(12, usuario.getCodigoPostal());
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
                Logger.getLogger(DaoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    public boolean editarUsuario(DtoUsuarios usuario) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEditarUsuario);
            ps.setString(1, usuario.getNombres());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getCelular());
            ps.setString(4, usuario.getCorreo());
            ps.setString(5,  new Fecha(new Date(usuario.getFechaDeNacimiento()), true).fechaFormateada());// (java.sql.Date) usuario.getFechaDeNacimiento());
            ps.setString(6, usuario.getUsuario());
            ps.setInt(7, usuario.getIdPerfil());
            ps.setString(8, usuario.getDomicilio());
            ps.setInt(9, usuario.getIdEstado());
            ps.setInt(10, usuario.getIdMunicipio());
            ps.setString(11, usuario.getPassword());
            ps.setString(12, usuario.getCodigoPostal());
            ps.setInt(13, usuario.getIdUsuario());
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
                Logger.getLogger(DaoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    public boolean eliminarUsuario(DtoUsuarios usuario) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEliminarUsuario);
            ps.setInt(1, usuario.getIdUsuario());
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
                Logger.getLogger(DaoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

}
