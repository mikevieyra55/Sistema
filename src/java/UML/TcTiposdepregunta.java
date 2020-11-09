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
@Table(name = "tc_tiposdepregunta")
@NamedQueries({
    @NamedQuery(name = "TcTiposdepregunta.findAll", query = "SELECT t FROM TcTiposdepregunta t"),
    @NamedQuery(name = "TcTiposdepregunta.findByIdTipoDePregunta", query = "SELECT t FROM TcTiposdepregunta t WHERE t.idTipoDePregunta = :idTipoDePregunta"),
    @NamedQuery(name = "TcTiposdepregunta.findByDescripcion", query = "SELECT t FROM TcTiposdepregunta t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TcTiposdepregunta.findByActivo", query = "SELECT t FROM TcTiposdepregunta t WHERE t.activo = :activo"),
    @NamedQuery(name = "TcTiposdepregunta.findByFechaDeAlta", query = "SELECT t FROM TcTiposdepregunta t WHERE t.fechaDeAlta = :fechaDeAlta"),
    @NamedQuery(name = "TcTiposdepregunta.findByIdUsuario", query = "SELECT t FROM TcTiposdepregunta t WHERE t.idUsuario = :idUsuario")})
public class TcTiposdepregunta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdTipoDePregunta", nullable = false)
    private Integer idTipoDePregunta;
    @Column(name = "Descripcion", length = 45)
    private String descripcion;
    @Column(name = "Activo")
    private Short activo;
    @Column(name = "FechaDeAlta")
    @Temporal(TemporalType.DATE)
    private Date fechaDeAlta;
    @Column(name = "IdUsuario")
    private Integer idUsuario;

    public TcTiposdepregunta() {
    }

    public TcTiposdepregunta(Integer idTipoDePregunta) {
        this.idTipoDePregunta = idTipoDePregunta;
    }

    public Integer getIdTipoDePregunta() {
        return idTipoDePregunta;
    }

    public void setIdTipoDePregunta(Integer idTipoDePregunta) {
        this.idTipoDePregunta = idTipoDePregunta;
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
        hash += (idTipoDePregunta != null ? idTipoDePregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TcTiposdepregunta)) {
            return false;
        }
        TcTiposdepregunta other = (TcTiposdepregunta) object;
        if ((this.idTipoDePregunta == null && other.idTipoDePregunta != null) || (this.idTipoDePregunta != null && !this.idTipoDePregunta.equals(other.idTipoDePregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UML.TcTiposdepregunta[ idTipoDePregunta=" + idTipoDePregunta + " ]";
    }
    
}
