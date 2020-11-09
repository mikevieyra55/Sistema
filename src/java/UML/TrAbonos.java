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
@Table(name = "tr_abonos")
@NamedQueries({
    @NamedQuery(name = "TrAbonos.findAll", query = "SELECT t FROM TrAbonos t"),
    @NamedQuery(name = "TrAbonos.findByIdAbono", query = "SELECT t FROM TrAbonos t WHERE t.idAbono = :idAbono"),
    @NamedQuery(name = "TrAbonos.findByFechaDeAlta", query = "SELECT t FROM TrAbonos t WHERE t.fechaDeAlta = :fechaDeAlta"),
    @NamedQuery(name = "TrAbonos.findByCantidad", query = "SELECT t FROM TrAbonos t WHERE t.cantidad = :cantidad"),
    @NamedQuery(name = "TrAbonos.findByIdUsuario", query = "SELECT t FROM TrAbonos t WHERE t.idUsuario = :idUsuario"),
    @NamedQuery(name = "TrAbonos.findByIdCompra", query = "SELECT t FROM TrAbonos t WHERE t.idCompra = :idCompra"),
    @NamedQuery(name = "TrAbonos.findByActivo", query = "SELECT t FROM TrAbonos t WHERE t.activo = :activo")})
public class TrAbonos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdAbono", nullable = false)
    private Integer idAbono;
    @Column(name = "FechaDeAlta")
    @Temporal(TemporalType.DATE)
    private Date fechaDeAlta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Cantidad", precision = 12)
    private Float cantidad;
    @Column(name = "IdUsuario")
    private Integer idUsuario;
    @Column(name = "IdCompra")
    private Integer idCompra;
    @Column(name = "Activo")
    private Short activo;

    public TrAbonos() {
    }

    public TrAbonos(Integer idAbono) {
        this.idAbono = idAbono;
    }

    public Integer getIdAbono() {
        return idAbono;
    }

    public void setIdAbono(Integer idAbono) {
        this.idAbono = idAbono;
    }

    public Date getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(Date fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
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

    public Short getActivo() {
        return activo;
    }

    public void setActivo(Short activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAbono != null ? idAbono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrAbonos)) {
            return false;
        }
        TrAbonos other = (TrAbonos) object;
        if ((this.idAbono == null && other.idAbono != null) || (this.idAbono != null && !this.idAbono.equals(other.idAbono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UML.TrAbonos[ idAbono=" + idAbono + " ]";
    }
    
}
