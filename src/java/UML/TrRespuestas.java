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
@Table(name = "tr_respuestas")
@NamedQueries({
    @NamedQuery(name = "TrRespuestas.findAll", query = "SELECT t FROM TrRespuestas t"),
    @NamedQuery(name = "TrRespuestas.findByIdRespuesta", query = "SELECT t FROM TrRespuestas t WHERE t.idRespuesta = :idRespuesta"),
    @NamedQuery(name = "TrRespuestas.findByDescripcion", query = "SELECT t FROM TrRespuestas t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TrRespuestas.findByIdPaciente", query = "SELECT t FROM TrRespuestas t WHERE t.idPaciente = :idPaciente"),
    @NamedQuery(name = "TrRespuestas.findByFechaDeAlta", query = "SELECT t FROM TrRespuestas t WHERE t.fechaDeAlta = :fechaDeAlta")})
public class TrRespuestas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRespuesta", nullable = false)
    private Integer idRespuesta;
    @Column(name = "Descripcion", length = 45)
    private String descripcion;
    @Column(name = "IdPaciente")
    private Integer idPaciente;
    @Column(name = "FechaDeAlta")
    @Temporal(TemporalType.DATE)
    private Date fechaDeAlta;

    public TrRespuestas() {
    }

    public TrRespuestas(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public Integer getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
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
        hash += (idRespuesta != null ? idRespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrRespuestas)) {
            return false;
        }
        TrRespuestas other = (TrRespuestas) object;
        if ((this.idRespuesta == null && other.idRespuesta != null) || (this.idRespuesta != null && !this.idRespuesta.equals(other.idRespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UML.TrRespuestas[ idRespuesta=" + idRespuesta + " ]";
    }
    
}
