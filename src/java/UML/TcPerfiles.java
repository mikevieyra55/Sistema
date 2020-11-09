/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ULISES.VIEYRA
 */
@Entity
@Table(name = "tc_perfiles")
@NamedQueries({
    @NamedQuery(name = "TcPerfiles.findAll", query = "SELECT t FROM TcPerfiles t"),
    @NamedQuery(name = "TcPerfiles.findByIdPerfil", query = "SELECT t FROM TcPerfiles t WHERE t.idPerfil = :idPerfil"),
    @NamedQuery(name = "TcPerfiles.findByNombre", query = "SELECT t FROM TcPerfiles t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TcPerfiles.findByDescripcion", query = "SELECT t FROM TcPerfiles t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TcPerfiles.findByActivo", query = "SELECT t FROM TcPerfiles t WHERE t.activo = :activo"),
    @NamedQuery(name = "TcPerfiles.findByFechaDeAlta", query = "SELECT t FROM TcPerfiles t WHERE t.fechaDeAlta = :fechaDeAlta"),
    @NamedQuery(name = "TcPerfiles.findByIdUsuario", query = "SELECT t FROM TcPerfiles t WHERE t.idUsuario = :idUsuario")})
public class TcPerfiles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdPerfil", nullable = false)
    private Integer idPerfil;
    @Column(name = "Nombre", length = 45)
    private String nombre;
    @Column(name = "Descripcion", length = 45)
    private String descripcion;
    @Column(name = "Activo")
    private Short activo;
    @Column(name = "FechaDeAlta")
    @Temporal(TemporalType.DATE)
    private Date fechaDeAlta;
    @Column(name = "IdUsuario")
    private Integer idUsuario;

    public TcPerfiles() {
    }

    public TcPerfiles(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Short getActivo() {
        return activo;
    }

    public void setActivo(Short activo) {
        this.activo = activo;
    }

    public Date getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(Date fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfil != null ? idPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TcPerfiles)) {
            return false;
        }
        TcPerfiles other = (TcPerfiles) object;
        if ((this.idPerfil == null && other.idPerfil != null) || (this.idPerfil != null && !this.idPerfil.equals(other.idPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UML.TcPerfiles[ idPerfil=" + idPerfil + " ]";
    }
    
}
