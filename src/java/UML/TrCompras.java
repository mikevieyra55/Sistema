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
@Table(name = "tr_compras")
@NamedQueries({
    @NamedQuery(name = "TrCompras.findAll", query = "SELECT t FROM TrCompras t"),
    @NamedQuery(name = "TrCompras.findByIdCompra", query = "SELECT t FROM TrCompras t WHERE t.idCompra = :idCompra"),
    @NamedQuery(name = "TrCompras.findByFechaDeAlta", query = "SELECT t FROM TrCompras t WHERE t.fechaDeAlta = :fechaDeAlta"),
    @NamedQuery(name = "TrCompras.findByTotal", query = "SELECT t FROM TrCompras t WHERE t.total = :total"),
    @NamedQuery(name = "TrCompras.findByIdUsuario", query = "SELECT t FROM TrCompras t WHERE t.idUsuario = :idUsuario"),
    @NamedQuery(name = "TrCompras.findByIdDoctor", query = "SELECT t FROM TrCompras t WHERE t.idDoctor = :idDoctor"),
    @NamedQuery(name = "TrCompras.findByIdEstadoCompra", query = "SELECT t FROM TrCompras t WHERE t.idEstadoCompra = :idEstadoCompra")})
public class TrCompras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdCompra", nullable = false)
    private Integer idCompra;
    @Column(name = "FechaDeAlta")
    @Temporal(TemporalType.DATE)
    private Date fechaDeAlta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Total", precision = 12)
    private Float total;
    @Column(name = "IdUsuario")
    private Integer idUsuario;
    @Column(name = "IdDoctor")
    private Integer idDoctor;
    @Column(name = "IdEstadoCompra")
    private Integer idEstadoCompra;

    public TrCompras() {
    }

    public TrCompras(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Date getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(Date fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public Integer getIdEstadoCompra() {
        return idEstadoCompra;
    }

    public void setIdEstadoCompra(Integer idEstadoCompra) {
        this.idEstadoCompra = idEstadoCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompra != null ? idCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrCompras)) {
            return false;
        }
        TrCompras other = (TrCompras) object;
        if ((this.idCompra == null && other.idCompra != null) || (this.idCompra != null && !this.idCompra.equals(other.idCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UML.TrCompras[ idCompra=" + idCompra + " ]";
    }
    
}
