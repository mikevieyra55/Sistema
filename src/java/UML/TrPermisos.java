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
@Table(name = "tr_permisos")
@NamedQueries({
    @NamedQuery(name = "TrPermisos.findAll", query = "SELECT t FROM TrPermisos t"),
    @NamedQuery(name = "TrPermisos.findByIdPermiso", query = "SELECT t FROM TrPermisos t WHERE t.idPermiso = :idPermiso"),
    @NamedQuery(name = "TrPermisos.findByIdPerfil", query = "SELECT t FROM TrPermisos t WHERE t.idPerfil = :idPerfil"),
    @NamedQuery(name = "TrPermisos.findByIdMenu", query = "SELECT t FROM TrPermisos t WHERE t.idMenu = :idMenu"),
    @NamedQuery(name = "TrPermisos.findByFechaDeAlta", query = "SELECT t FROM TrPermisos t WHERE t.fechaDeAlta = :fechaDeAlta"),
    @NamedQuery(name = "TrPermisos.findByIdUsuario", query = "SELECT t FROM TrPermisos t WHERE t.idUsuario = :idUsuario"),
    @NamedQuery(name = "TrPermisos.findByActivo", query = "SELECT t FROM TrPermisos t WHERE t.activo = :activo")})
public class TrPermisos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdPermiso", nullable = false)
    private Integer idPermiso;
    @Column(name = "IdPerfil")
    private Integer idPerfil;
    @Column(name = "IdMenu")
    private Integer idMenu;
    @Column(name = "FechaDeAlta", length = 45)
    private String fechaDeAlta;
    @Column(name = "IdUsuario", length = 45)
    private String idUsuario;
    @Column(name = "Activo")
    private Short activo;

    public TrPermisos() {
    }

    public TrPermisos(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public Integer getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(String fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Short getActivo() {
        return activo;
    }

    public void setActivo(Short activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermiso != null ? idPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrPermisos)) {
            return false;
        }
        TrPermisos other = (TrPermisos) object;
        if ((this.idPermiso == null && other.idPermiso != null) || (this.idPermiso != null && !this.idPermiso.equals(other.idPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UML.TrPermisos[ idPermiso=" + idPermiso + " ]";
    }
    
}
