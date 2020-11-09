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
@Table(name = "tr_ordendetrabajo")
@NamedQueries({
    @NamedQuery(name = "TrOrdendetrabajo.findAll", query = "SELECT t FROM TrOrdendetrabajo t"),
    @NamedQuery(name = "TrOrdendetrabajo.findByIdOrdenDeTrabajo", query = "SELECT t FROM TrOrdendetrabajo t WHERE t.idOrdenDeTrabajo = :idOrdenDeTrabajo"),
    @NamedQuery(name = "TrOrdendetrabajo.findByIdPaciente", query = "SELECT t FROM TrOrdendetrabajo t WHERE t.idPaciente = :idPaciente"),
    @NamedQuery(name = "TrOrdendetrabajo.findByIdTratamiento", query = "SELECT t FROM TrOrdendetrabajo t WHERE t.idTratamiento = :idTratamiento"),
    @NamedQuery(name = "TrOrdendetrabajo.findByIdTipoDescuento", query = "SELECT t FROM TrOrdendetrabajo t WHERE t.idTipoDescuento = :idTipoDescuento"),
    @NamedQuery(name = "TrOrdendetrabajo.findByPrecio", query = "SELECT t FROM TrOrdendetrabajo t WHERE t.precio = :precio"),
    @NamedQuery(name = "TrOrdendetrabajo.findByFechaDeAlta", query = "SELECT t FROM TrOrdendetrabajo t WHERE t.fechaDeAlta = :fechaDeAlta"),
    @NamedQuery(name = "TrOrdendetrabajo.findByIdDoctor", query = "SELECT t FROM TrOrdendetrabajo t WHERE t.idDoctor = :idDoctor"),
    @NamedQuery(name = "TrOrdendetrabajo.findByIdUsuario", query = "SELECT t FROM TrOrdendetrabajo t WHERE t.idUsuario = :idUsuario"),
    @NamedQuery(name = "TrOrdendetrabajo.findByIdCompra", query = "SELECT t FROM TrOrdendetrabajo t WHERE t.idCompra = :idCompra")})
public class TrOrdendetrabajo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdOrdenDeTrabajo", nullable = false)
    private Integer idOrdenDeTrabajo;
    @Column(name = "IdPaciente")
    private Integer idPaciente;
    @Column(name = "IdTratamiento")
    private Integer idTratamiento;
    @Column(name = "IdTipoDescuento")
    private Integer idTipoDescuento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Precio", precision = 12)
    private Float precio;
    @Column(name = "FechaDeAlta")
    @Temporal(TemporalType.DATE)
    private Date fechaDeAlta;
    @Column(name = "IdDoctor")
    private Integer idDoctor;
    @Column(name = "IdUsuario")
    private Integer idUsuario;
    @Column(name = "IdCompra")
    private Integer idCompra;

    public TrOrdendetrabajo() {
    }

    public TrOrdendetrabajo(Integer idOrdenDeTrabajo) {
        this.idOrdenDeTrabajo = idOrdenDeTrabajo;
    }

    public Integer getIdOrdenDeTrabajo() {
        return idOrdenDeTrabajo;
    }

    public void setIdOrdenDeTrabajo(Integer idOrdenDeTrabajo) {
        this.idOrdenDeTrabajo = idOrdenDeTrabajo;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(Integer idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public Integer getIdTipoDescuento() {
        return idTipoDescuento;
    }

    public void setIdTipoDescuento(Integer idTipoDescuento) {
        this.idTipoDescuento = idTipoDescuento;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Date getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(Date fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public Integer getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenDeTrabajo != null ? idOrdenDeTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrOrdendetrabajo)) {
            return false;
        }
        TrOrdendetrabajo other = (TrOrdendetrabajo) object;
        if ((this.idOrdenDeTrabajo == null && other.idOrdenDeTrabajo != null) || (this.idOrdenDeTrabajo != null && !this.idOrdenDeTrabajo.equals(other.idOrdenDeTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UML.TrOrdendetrabajo[ idOrdenDeTrabajo=" + idOrdenDeTrabajo + " ]";
    }
    
}
