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
@Table(name = "tc_estadocompra")
@NamedQueries({
    @NamedQuery(name = "TcEstadocompra.findAll", query = "SELECT t FROM TcEstadocompra t"),
    @NamedQuery(name = "TcEstadocompra.findByIdEstadoCompra", query = "SELECT t FROM TcEstadocompra t WHERE t.idEstadoCompra = :idEstadoCompra"),
    @NamedQuery(name = "TcEstadocompra.findByNombre", query = "SELECT t FROM TcEstadocompra t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TcEstadocompra.findByDescripcion", query = "SELECT t FROM TcEstadocompra t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TcEstadocompra.findByActivo", query = "SELECT t FROM TcEstadocompra t WHERE t.activo = :activo"),
    @NamedQuery(name = "TcEstadocompra.findByFechaDeAlta", query = "SELECT t FROM TcEstadocompra t WHERE t.fechaDeAlta = :fechaDeAlta"),
    @NamedQuery(name = "TcEstadocompra.findByIdUsuario", query = "SELECT t FROM TcEstadocompra t WHERE t.idUsuario = :idUsuario")})
public class TcEstadocompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdEstadoCompra", nullable = false)
    private Integer idEstadoCompra;
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

    public TcEstadocompra() {
    }

    public TcEstadocompra(Integer idEstadoCompra) {
        this.idEstadoCompra = idEstadoCompra;
    }

    public Integer getIdEstadoCompra() {
        return idEstadoCompra;
    }

    public void setIdEstadoCompra(Integer idEstadoCompra) {
        this.idEstadoCompra = idEstadoCompra;
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
        hash += (idEstadoCompra != null ? idEstadoCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TcEstadocompra)) {
            return false;
        }
        TcEstadocompra other = (TcEstadocompra) object;
        if ((this.idEstadoCompra == null && other.idEstadoCompra != null) || (this.idEstadoCompra != null && !this.idEstadoCompra.equals(other.idEstadoCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UML.TcEstadocompra[ idEstadoCompra=" + idEstadoCompra + " ]";
    }
    
}
