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
@Table(name = "tr_preguntas")
@NamedQueries({
    @NamedQuery(name = "TrPreguntas.findAll", query = "SELECT t FROM TrPreguntas t"),
    @NamedQuery(name = "TrPreguntas.findByIdPregunta", query = "SELECT t FROM TrPreguntas t WHERE t.idPregunta = :idPregunta"),
    @NamedQuery(name = "TrPreguntas.findByDescripcion", query = "SELECT t FROM TrPreguntas t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TrPreguntas.findByIdCuestionario", query = "SELECT t FROM TrPreguntas t WHERE t.idCuestionario = :idCuestionario"),
    @NamedQuery(name = "TrPreguntas.findByOrden", query = "SELECT t FROM TrPreguntas t WHERE t.orden = :orden"),
    @NamedQuery(name = "TrPreguntas.findByActivo", query = "SELECT t FROM TrPreguntas t WHERE t.activo = :activo"),
    @NamedQuery(name = "TrPreguntas.findByFechaDeAlta", query = "SELECT t FROM TrPreguntas t WHERE t.fechaDeAlta = :fechaDeAlta"),
    @NamedQuery(name = "TrPreguntas.findByIdUsuario", query = "SELECT t FROM TrPreguntas t WHERE t.idUsuario = :idUsuario"),
    @NamedQuery(name = "TrPreguntas.findByIdTipoDePregunta", query = "SELECT t FROM TrPreguntas t WHERE t.idTipoDePregunta = :idTipoDePregunta")})
public class TrPreguntas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdPregunta", nullable = false)
    private Integer idPregunta;
    @Column(name = "Descripcion", length = 45)
    private String descripcion;
    @Column(name = "IdCuestionario")
    private Integer idCuestionario;
    @Column(name = "Orden")
    private Integer orden;
    @Column(name = "Activo")
    private Short activo;
    @Column(name = "FechaDeAlta")
    @Temporal(TemporalType.DATE)
    private Date fechaDeAlta;
    @Column(name = "IdUsuario")
    private Integer idUsuario;
    @Column(name = "IdTipoDePregunta")
    private Integer idTipoDePregunta;

    public TrPreguntas() {
    }

    public TrPreguntas(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Integer getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdCuestionario() {
        return idCuestionario;
    }

    public void setIdCuestionario(Integer idCuestionario) {
        this.idCuestionario = idCuestionario;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
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

    public Integer getIdTipoDePregunta() {
        return idTipoDePregunta;
    }

    public void setIdTipoDePregunta(Integer idTipoDePregunta) {
        this.idTipoDePregunta = idTipoDePregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPregunta != null ? idPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrPreguntas)) {
            return false;
        }
        TrPreguntas other = (TrPreguntas) object;
        if ((this.idPregunta == null && other.idPregunta != null) || (this.idPregunta != null && !this.idPregunta.equals(other.idPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UML.TrPreguntas[ idPregunta=" + idPregunta + " ]";
    }
    
}
