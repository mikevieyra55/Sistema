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
@Table(name = "tc_estadosdecita")
@NamedQueries({
    @NamedQuery(name = "TcEstadosdecita.findAll", query = "SELECT t FROM TcEstadosdecita t"),
    @NamedQuery(name = "TcEstadosdecita.findByIdEstadoDeCita", query = "SELECT t FROM TcEstadosdecita t WHERE t.idEstadoDeCita = :idEstadoDeCita"),
    @NamedQuery(name = "TcEstadosdecita.findByNombre", query = "SELECT t FROM TcEstadosdecita t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TcEstadosdecita.findByDescripcion", query = "SELECT t FROM TcEstadosdecita t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TcEstadosdecita.findByActivo", query = "SELECT t FROM TcEstadosdecita t WHERE t.activo = :activo"),
    @NamedQuery(name = "TcEstadosdecita.findByIdUsuario", query = "SELECT t FROM TcEstadosdecita t WHERE t.idUsuario = :idUsuario"),
    @NamedQuery(name = "TcEstadosdecita.findByFechaDeAlta", query = "SELECT t FROM TcEstadosdecita t WHERE t.fechaDeAlta = :fechaDeAlta")})
public class TcEstadosdecita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdEstadoDeCita", nullable = false)
    private Integer idEstadoDeCita;
    @Column(name = "Nombre", length = 45)
    private String nombre;
    @Column(name = "Descripcion", length = 45)
    private String descripcion;
    @Column(name = "Activo")
    private Short activo;
    @Column(name = "IdUsuario")
    private Integer idUsuario;
    @Column(name = "FechaDeAlta")
    @Temporal(TemporalType.DATE)
    private Date fechaDeAlta;

    public TcEstadosdecita() {
    }

    public TcEstadosdecita(Integer idEstadoDeCita) {
        this.idEstadoDeCita = idEstadoDeCita;
    }

    public Integer getIdEstadoDeCita() {
        return idEstadoDeCita;
    }

    public void setIdEstadoDeCita(Integer idEstadoDeCita) {
        this.idEstadoDeCita = idEstadoDeCita;
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

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(Date fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoDeCita != null ? idEstadoDeCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TcEstadosdecita)) {
            return false;
        }
        TcEstadosdecita other = (TcEstadosdecita) object;
        if ((this.idEstadoDeCita == null && other.idEstadoDeCita != null) || (this.idEstadoDeCita != null && !this.idEstadoDeCita.equals(other.idEstadoDeCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UML.TcEstadosdecita[ idEstadoDeCita=" + idEstadoDeCita + " ]";
    }
    
}
