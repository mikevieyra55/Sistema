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
@Table(name = "tr_presupuestos")
@NamedQueries({
    @NamedQuery(name = "TrPresupuestos.findAll", query = "SELECT t FROM TrPresupuestos t"),
    @NamedQuery(name = "TrPresupuestos.findByIdPresupuesto", query = "SELECT t FROM TrPresupuestos t WHERE t.idPresupuesto = :idPresupuesto"),
    @NamedQuery(name = "TrPresupuestos.findByIdPaciente", query = "SELECT t FROM TrPresupuestos t WHERE t.idPaciente = :idPaciente"),
    @NamedQuery(name = "TrPresupuestos.findByIdTratamiento", query = "SELECT t FROM TrPresupuestos t WHERE t.idTratamiento = :idTratamiento"),
    @NamedQuery(name = "TrPresupuestos.findByIdTipoDescuento", query = "SELECT t FROM TrPresupuestos t WHERE t.idTipoDescuento = :idTipoDescuento"),
    @NamedQuery(name = "TrPresupuestos.findByPrecio", query = "SELECT t FROM TrPresupuestos t WHERE t.precio = :precio"),
    @NamedQuery(name = "TrPresupuestos.findByFechaDeAlta", query = "SELECT t FROM TrPresupuestos t WHERE t.fechaDeAlta = :fechaDeAlta"),
    @NamedQuery(name = "TrPresupuestos.findByIdDoctor", query = "SELECT t FROM TrPresupuestos t WHERE t.idDoctor = :idDoctor"),
    @NamedQuery(name = "TrPresupuestos.findByIdUsuario", query = "SELECT t FROM TrPresupuestos t WHERE t.idUsuario = :idUsuario")})
public class TrPresupuestos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdPresupuesto", nullable = false)
    private Integer idPresupuesto;
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

    public TrPresupuestos() {
    }

    public TrPresupuestos(Integer idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public Integer getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(Integer idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPresupuesto != null ? idPresupuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrPresupuestos)) {
            return false;
        }
        TrPresupuestos other = (TrPresupuestos) object;
        if ((this.idPresupuesto == null && other.idPresupuesto != null) || (this.idPresupuesto != null && !this.idPresupuesto.equals(other.idPresupuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UML.TrPresupuestos[ idPresupuesto=" + idPresupuesto + " ]";
    }
    
}
