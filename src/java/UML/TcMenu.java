/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ULISES.VIEYRA
 */
@Entity
@Table(name = "tc_menu")
@NamedQueries({
    @NamedQuery(name = "TcMenu.findAll", query = "SELECT t FROM TcMenu t"),
    @NamedQuery(name = "TcMenu.findByIdMenu", query = "SELECT t FROM TcMenu t WHERE t.idMenu = :idMenu"),
    @NamedQuery(name = "TcMenu.findByNombre", query = "SELECT t FROM TcMenu t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TcMenu.findByControlador", query = "SELECT t FROM TcMenu t WHERE t.controlador = :controlador"),
    @NamedQuery(name = "TcMenu.findByActivo", query = "SELECT t FROM TcMenu t WHERE t.activo = :activo"),
    @NamedQuery(name = "TcMenu.findByFechaDeAlta", query = "SELECT t FROM TcMenu t WHERE t.fechaDeAlta = :fechaDeAlta"),
    @NamedQuery(name = "TcMenu.findByIdUsuario", query = "SELECT t FROM TcMenu t WHERE t.idUsuario = :idUsuario"),
    @NamedQuery(name = "TcMenu.findByIdPadre", query = "SELECT t FROM TcMenu t WHERE t.idPadre = :idPadre")})
public class TcMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdMenu", nullable = false)
    private Integer idMenu;
    @Column(name = "Nombre", length = 45)
    private String nombre;
    @Column(name = "Controlador", length = 45)
    private String controlador;
    @Column(name = "Activo")
    private Short activo;
    @Column(name = "FechaDeAlta", length = 45)
    private String fechaDeAlta;
    @Column(name = "IdUsuario")
    private Integer idUsuario;
    @Column(name = "IdPadre")
    private Integer idPadre;

    public TcMenu() {
    }

    public TcMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getControlador() {
        return controlador;
    }

    public void setControlador(String controlador) {
        this.controlador = controlador;
    }

    public Short getActivo() {
        return activo;
    }

    public void setActivo(Short activo) {
        this.activo = activo;
    }

    public String getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(String fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Integer idPadre) {
        this.idPadre = idPadre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenu != null ? idMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TcMenu)) {
            return false;
        }
        TcMenu other = (TcMenu) object;
        if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
            return false;
        }
        return true;
    }
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (idPadre != null ? idPadre.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof TcMenu)) {
//            return false;
//        }
//        TcMenu other = (TcMenu) object;
//        if ((this.idPadre == null && other.idPadre != null) || (this.idPadre != null && !this.idPadre.equals(other.idPadre))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "UML.TcMenu[ idMenu=" + idMenu + " ]";
    }
    
}
