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
@Table(name = "tr_citas")
@NamedQueries({
    @NamedQuery(name = "TrCitas.findAll", query = "SELECT t FROM TrCitas t"),
    @NamedQuery(name = "TrCitas.findByIdCita", query = "SELECT t FROM TrCitas t WHERE t.idCita = :idCita"),
    @NamedQuery(name = "TrCitas.findByFechaDeAlta", query = "SELECT t FROM TrCitas t WHERE t.fechaDeAlta = :fechaDeAlta"),
    @NamedQuery(name = "TrCitas.findByFechaDeCita", query = "SELECT t FROM TrCitas t WHERE t.fechaDeCita = :fechaDeCita"),
    @NamedQuery(name = "TrCitas.findByHoraDeCita", query = "SELECT t FROM TrCitas t WHERE t.horaDeCita = :horaDeCita"),
    @NamedQuery(name = "TrCitas.findByActivo", query = "SELECT t FROM TrCitas t WHERE t.activo = :activo"),
    @NamedQuery(name = "TrCitas.findByIdPaciente", query = "SELECT t FROM TrCitas t WHERE t.idPaciente = :idPaciente"),
    @NamedQuery(name = "TrCitas.findByIdUsuario", query = "SELECT t FROM TrCitas t WHERE t.idUsuario = :idUsuario"),
    @NamedQuery(name = "TrCitas.findByIdEstadoDeCita", query = "SELECT t FROM TrCitas t WHERE t.idEstadoDeCita = :idEstadoDeCita"),
    @NamedQuery(name = "TrCitas.findByIdDoctor", query = "SELECT t FROM TrCitas t WHERE t.idDoctor = :idDoctor")})
public class TrCitas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdCita", nullable = false)
    private Integer idCita;
    @Column(name = "FechaDeAlta")
    @Temporal(TemporalType.DATE)
    private Date fechaDeAlta;
    @Column(name = "FechaDeCita")
    @Temporal(TemporalType.DATE)
    private Date fechaDeCita;
    @Column(name = "HoraDeCita", length = 45)
    private String horaDeCita;
    @Column(name = "Activo")
    private Short activo;
    @Column(name = "IdPaciente")
    private Integer idPaciente;
    @Column(name = "IdUsuario")
    private Integer idUsuario;
    @Column(name = "IdEstadoDeCita")
    private Integer idEstadoDeCita;
    @Column(name = "IdDoctor")
    private Integer idDoctor;

    public TrCitas() {
    }

    public TrCitas(Integer idCita) {
        this.idCita = idCita;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public Date getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(Date fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public Date getFechaDeCita() {
        return fechaDeCita;
    }

    public void setFechaDeCita(Date fechaDeCita) {
        this.fechaDeCita = fechaDeCita;
    }

    public String getHoraDeCita() {
        return horaDeCita;
    }

    public void setHoraDeCita(String horaDeCita) {
        this.horaDeCita = horaDeCita;
    }

    public Short getActivo() {
        return activo;
    }

    public void setActivo(Short activo) {
        this.activo = activo;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdEstadoDeCita() {
        return idEstadoDeCita;
    }

    public void setIdEstadoDeCita(Integer idEstadoDeCita) {
        this.idEstadoDeCita = idEstadoDeCita;
    }

    public Integer getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCita != null ? idCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrCitas)) {
            return false;
        }
        TrCitas other = (TrCitas) object;
        if ((this.idCita == null && other.idCita != null) || (this.idCita != null && !this.idCita.equals(other.idCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UML.TrCitas[ idCita=" + idCita + " ]";
    }
    
}
