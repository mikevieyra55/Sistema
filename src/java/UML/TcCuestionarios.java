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
@Table(name = "tc_cuestionarios")
@NamedQueries({
    @NamedQuery(name = "TcCuestionarios.findAll", query = "SELECT t FROM TcCuestionarios t"),
    @NamedQuery(name = "TcCuestionarios.findByIdCuestionario", query = "SELECT t FROM TcCuestionarios t WHERE t.idCuestionario = :idCuestionario"),
    @NamedQuery(name = "TcCuestionarios.findByNombre", query = "SELECT t FROM TcCuestionarios t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TcCuestionarios.findByDescripcion", query = "SELECT t FROM TcCuestionarios t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TcCuestionarios.findByFechaDeAlta", query = "SELECT t FROM TcCuestionarios t WHERE t.fechaDeAlta = :fechaDeAlta"),
    @NamedQuery(name = "TcCuestionarios.findByActivo", query = "SELECT t FROM TcCuestionarios t WHERE t.activo = :activo")})
public class TcCuestionarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdCuestionario", nullable = false)
    private Integer idCuestionario;
    @Column(name = "Nombre", length = 45)
    private String nombre;
    @Column(name = "Descripcion", length = 45)
    private String descripcion;
    @Column(name = "FechaDeAlta")
    @Temporal(TemporalType.DATE)
    private Date fechaDeAlta;
    @Column(name = "Activo")
    private Short activo;

    public TcCuestionarios() {
    }

    public TcCuestionarios(Integer idCuestionario) {
        this.idCuestionario = idCuestionario;
    }

    public Integer getIdCuestionario() {
        return idCuestionario;
    }

    public void setIdCuestionario(Integer idCuestionario) {
        this.idCuestionario = idCuestionario;
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

    public Short getActivo() {
        return activo;
    }

    public void setActivo(Short activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuestionario != null ? idCuestionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TcCuestionarios)) {
            return false;
        }
        TcCuestionarios other = (TcCuestionarios) object;
        if ((this.idCuestionario == null && other.idCuestionario != null) || (this.idCuestionario != null && !this.idCuestionario.equals(other.idCuestionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UML.TcCuestionarios[ idCuestionario=" + idCuestionario + " ]";
    }
    
}
