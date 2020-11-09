/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import java.io.Serializable;
import Configuracion.ConexionBD;
import ModeloDto.DtoUsuarios;
import UML.util.Fecha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ULISES.VIEYRA
 */
public class DaoLogin implements Serializable {
    
 static final String sqlObtenerUsuario = " SELECT IdUsuario, Nombres,Apellidos, Celular, Correo, "
            + " FechaDeNacimiento,FechaDeAlta, Activo, Usuario, IdPerfil, "
            + " Domicilio, IdEstado, IdMunicipio, IdPais, Password"
            + " FROM tc_usuarios "
            + " WHERE Usuario = ? AND Password=?  AND Activo = true";

    public DtoUsuarios ValidarUsuario(String usuario, String contrasenia) {
        DtoUsuarios objetoUsuario =  null;
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerUsuario);
            ps.setString(1, usuario);
            ps.setString(2, contrasenia);
            rs = ps.executeQuery();
            while (rs.next()) {
                objetoUsuario = new DtoUsuarios();
                objetoUsuario.setIdUsuario(rs.getInt("IdUsuario"));
                objetoUsuario.setNombres(rs.getString("Nombres"));
                objetoUsuario.setApellidos(rs.getString("Apellidos"));
                objetoUsuario.setCelular(rs.getString("Celular"));
                objetoUsuario.setCorreo(rs.getString("Correo"));
                objetoUsuario.setFechaDeNacimiento(rs.getString("FechaDeNacimiento"));
                objetoUsuario.setFechaDeAlta(rs.getString("FechaDeAlta"));
                objetoUsuario.setActivo(rs.getBoolean("Activo"));
                objetoUsuario.setUsuario(rs.getString("Usuario"));
                objetoUsuario.setIdPerfil(rs.getInt("IdPerfil"));
                objetoUsuario.setDomicilio(rs.getString("Domicilio"));
                objetoUsuario.setIdEstado(rs.getInt("IdEstado"));
                objetoUsuario.setIdMunicipio(rs.getInt("IdMunicipio"));                
                objetoUsuario.setPassword(rs.getString("Password"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }      
        return objetoUsuario;
        
    }
    
    
}
