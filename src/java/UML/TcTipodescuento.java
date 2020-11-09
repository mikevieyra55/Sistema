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
@Table(name = "tc_tipodescuento")
@NamedQueries({
    @NamedQuery(name = "TcTipodescuento.findAll", query = "SELECT t FROM TcTipodescuento t"),
    @NamedQuery(name = "TcTipodescuento.findByIdTipoDescuento", query = "SELECT t FROM TcTipodescuento t WHERE t.idTipoDescuento = :idTipoDescuento"),
    @NamedQuery(name = "TcTipodescuento.findByNombre", query = "SELECT t FROM TcTipodescuento t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TcTipodescuento.findByDescripcion", query = "SELECT t FROM TcTipodescuento t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TcTipodescuento.findByFechaDeAlta", query = "SELECT t FROM TcTipodescuento t WHERE t.fechaDeAlta = :fechaDeAlta"),
    @NamedQuery(name = "TcTipodescuento.findByIdUsuario", query = "SELECT t FROM TcTipodescuento t WHERE t.idUsuario = :idUsuario"),
    @NamedQuery(name = "TcTipodescuento.findByActivo", query = "SELECT t FROM TcTipodescuento t WHERE t.activo = :activo")})
public class TcTipodescuento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdTipoDescuento", nullable = false)
    private Integer idTipoDescuento;
    @Column(name = "Nombre", length = 45)
    private String nombre;
    @Column(name = "Descripcion", length = 45)
    private String descripcion;
    @Column(name = "FechaDeAlta")
    @Temporal(TemporalType.DATE)
    private Date fechaDeAlta;
    @Column(name = "IdUsuario", length = 45)
    private String idUsuario;
    @Column(name = "Activo")
    private Short activo;

    public TcTipodescuento() {
    }

    public TcTipodescuento(Integer idTipoDescuento) {
        this.idTipoDescuento = idTipoDescuento;
    }

    public Integer getIdTipoDescuento() {
        return idTipoDescuento;
    }

    public void setIdTipoDescuento(Integer idTipoDescuento) {
        this.idTipoDescuento = idTipoDescuento;
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

    public Date getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(Date fechaDeAlta) {
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
        hash += (idTipoDescuento != null ? idTipoDescuento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TcTipodescuento)) {
            return false;
        }
        TcTipodescuento other = (TcTipodescuento) object;
        if ((this.idTipoDescuento == null && other.idTipoDescuento != null) || (this.idTipoDescuento != null && !this.idTipoDescuento.equals(other.idTipoDescuento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UML.TcTipodescuento[ idTipoDescuento=" + idTipoDescuento + " ]";
    }
    
}
