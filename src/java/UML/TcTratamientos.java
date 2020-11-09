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
@Table(name = "tc_tratamientos")
@NamedQueries({
    @NamedQuery(name = "TcTratamientos.findAll", query = "SELECT t FROM TcTratamientos t"),
    @NamedQuery(name = "TcTratamientos.findByIdTratamiento", query = "SELECT t FROM TcTratamientos t WHERE t.idTratamiento = :idTratamiento"),
    @NamedQuery(name = "TcTratamientos.findByDescripcion", query = "SELECT t FROM TcTratamientos t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TcTratamientos.findByActivo", query = "SELECT t FROM TcTratamientos t WHERE t.activo = :activo"),
    @NamedQuery(name = "TcTratamientos.findByFechaDeAlta", query = "SELECT t FROM TcTratamientos t WHERE t.fechaDeAlta = :fechaDeAlta"),
    @NamedQuery(name = "TcTratamientos.findByPrecio", query = "SELECT t FROM TcTratamientos t WHERE t.precio = :precio"),
    @NamedQuery(name = "TcTratamientos.findByIdUsuario", query = "SELECT t FROM TcTratamientos t WHERE t.idUsuario = :idUsuario")})
public class TcTratamientos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdTratamiento", nullable = false)
    private Integer idTratamiento;
    @Column(name = "Descripcion", length = 45)
    private String descripcion;
    @Column(name = "Activo")
    private Short activo;
    @Column(name = "FechaDeAlta")
    @Temporal(TemporalType.DATE)
    private Date fechaDeAlta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Precio", precision = 12)
    private Float precio;
    @Column(name = "IdUsuario")
    private Integer idUsuario;

    public TcTratamientos() {
    }

    public TcTratamientos(Integer idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public Integer getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(Integer idTratamiento) {
        this.idTratamiento = idTratamiento;
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

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
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
        hash += (idTratamiento != null ? idTratamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TcTratamientos)) {
            return false;
        }
        TcTratamientos other = (TcTratamientos) object;
        if ((this.idTratamiento == null && other.idTratamiento != null) || (this.idTratamiento != null && !this.idTratamiento.equals(other.idTratamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UML.TcTratamientos[ idTratamiento=" + idTratamiento + " ]";
    }
    
}
