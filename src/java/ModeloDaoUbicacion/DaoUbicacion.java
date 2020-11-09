/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDaoUbicacion;

import Configuracion.ConexionBD;
import ModeloDtoUbicacion.DtoEstado;
import ModeloDtoUbicacion.DtoMunicipio;
import ModeloDtoUbicacion.DtoPais;
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
public class DaoUbicacion implements Serializable {
    
    static final String sqlObtenerPaises = " SELECT IdPais, Nombre "
            + " FROM tc_paises "
            + " WHERE  Activo = true"
            + " ORDER BY Nombre";
    static final String sqlObtenerEstados = " SELECT IdEstado, Nombre "
            + " FROM tc_estados "            
            + " WHERE Activo = true"
            + " ORDER BY Nombre ";
    static final String sqlObtenerMunicipios = " SELECT IdMunicipio, Nombre "
            + " FROM tc_municipios "
            + " WHERE IdEstado = ? "
            + " AND Activo = true "
            + " ORDER BY Nombre ";
    static final String sqlInsertarPais = "INSERT INTO tc_paises "
            + " (Nombre) "
            + " VALUES (?) ";
    static final String sqlInsertarEstado = " INSERT INTO tc_estados "
            + " ( Nombre)"
            + " VALUES (?)";
    static final String sqlInsertarMunicipio = " INSERT INTO tc_municipios "
            + " ( Nombre, IdEstado)"
            + " VALUES (?, ?)";
    static final String sqlEditarPais = " UPDATE  tc_paises "
            + " SET Nombre = ? "
            + " WHERE IdPais = ? ";
    static final String sqlEditarEstado = " UPDATE  tc_estados"
            + " SET Nombre = ?, "            
            + " WHERE IdEstado = ? ";
    static final String sqlEditarMunicipio = " UPDATE  tc_municipios "
            + " SET Nombre = ?, "
            + " IdEstado = ? "
            + " WHERE IdMunicipio = ? ";
    static final String sqlDesActivarPais = " UPDATE  tc_paises"
            + " SET Activo = false "
            + " WHERE IdPais = ? ";
    static final String sqlDesActivarEstado = " UPDATE  tc_estados"
            + " SET Activo = false "
            + " WHERE IdEstado = ? ";
    static final String sqlDesActivarMunicipio = "  UPDATE  tc_municipios "
            + " SET Activo = false "
            + " WHERE IdMunicipio = ? ";
    
    public ArrayList<DtoPais> listarPaises() {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<DtoPais> lista = new ArrayList<DtoPais>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerPaises);
            rs = ps.executeQuery();
            while (rs.next()) {
                DtoPais objeto = new DtoPais();
                objeto.setIdPais(rs.getInt("IdPais"));
                objeto.setNombre(rs.getString("Nombre"));
                lista.add(objeto);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoUbicacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public boolean agregarPais(DtoPais objeto) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean resp = false;
        try {            
            con = cn.getConnection();
            ps = con.prepareStatement(sqlInsertarPais);
            ps.setString(1, objeto.getNombre());
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
                Logger.getLogger(DaoUbicacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    public boolean editarUsuario(DtoPais objeto) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEditarPais);            
            ps.setString(1, objeto.getNombre());
            ps.setInt(2, objeto.getIdPais());
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
                Logger.getLogger(DaoUbicacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    public boolean desActivarPais(DtoPais objeto) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlDesActivarPais);            
            ps.setInt(1, objeto.getIdPais());
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
                Logger.getLogger(DaoUbicacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    public ArrayList<DtoEstado> listarEstados() {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<DtoEstado> lista = new ArrayList<DtoEstado>();
        try {            
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerEstados);            
            rs = ps.executeQuery();
            while (rs.next()) {
                DtoEstado objeto = new DtoEstado();                
                objeto.setIdEstado(rs.getInt("IdEstado"));
                objeto.setNombre(rs.getString("Nombre"));
                lista.add(objeto);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoUbicacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public boolean agregarEstado(DtoEstado objeto) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean resp = false;
        try {            
            con = cn.getConnection();
            ps = con.prepareStatement(sqlInsertarEstado);
            ps.setString(1, objeto.getNombre());            
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
                Logger.getLogger(DaoUbicacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    public boolean editarEstado(DtoEstado objeto) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEditarEstado);            
            ps.setString(1, objeto.getNombre());            
            ps.setInt(2, objeto.getIdEstado());
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
                Logger.getLogger(DaoUbicacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    public boolean desActivarEstado(DtoEstado objeto) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlDesActivarEstado);            
            ps.setInt(1, objeto.getIdEstado());
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
                Logger.getLogger(DaoUbicacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    public ArrayList<DtoMunicipio> listarMunicipios(int idEstado) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<DtoMunicipio> lista = new ArrayList<DtoMunicipio>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlObtenerMunicipios);
            ps.setInt(1, idEstado);
            rs = ps.executeQuery();
            while (rs.next()) {
                DtoMunicipio objeto = new DtoMunicipio();
                objeto.setIdMunicipio(rs.getInt("IdMunicipio"));
                objeto.setNombre(rs.getString("Nombre"));
                lista.add(objeto);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoUbicacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    public boolean agregarMunicipio(DtoMunicipio objeto) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean resp = false;
        try {            
            con = cn.getConnection();
            ps = con.prepareStatement(sqlInsertarMunicipio);
            ps.setString(1, objeto.getNombre());
            ps.setInt(2, objeto.getIdEstado());
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
                Logger.getLogger(DaoUbicacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    public boolean editarMunicipio(DtoMunicipio objeto) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlEditarMunicipio);            
            ps.setString(1, objeto.getNombre());
            ps.setInt(2, objeto.getIdEstado());
            ps.setInt(3, objeto.getIdMunicipio());
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
                Logger.getLogger(DaoUbicacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    public boolean desActivarMunicipio(DtoMunicipio objeto) {
        ConexionBD cn = new ConexionBD();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean resp = false;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sqlDesActivarMunicipio);            
            ps.setInt(1, objeto.getIdMunicipio());
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
                Logger.getLogger(DaoUbicacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }
}
