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
@Table(name = "tc_usuarios")
@NamedQueries({
    @NamedQuery(name = "TcUsuarios.findAll", query = "SELECT t FROM TcUsuarios t"),
    @NamedQuery(name = "TcUsuarios.findByIdUsuario", query = "SELECT t FROM TcUsuarios t WHERE t.idUsuario = :idUsuario"),
    @NamedQuery(name = "TcUsuarios.findByNombres", query = "SELECT t FROM TcUsuarios t WHERE t.nombres = :nombres"),
    @NamedQuery(name = "TcUsuarios.findByApellidos", query = "SELECT t FROM TcUsuarios t WHERE t.apellidos = :apellidos"),
    @NamedQuery(name = "TcUsuarios.findByCelular", query = "SELECT t FROM TcUsuarios t WHERE t.celular = :celular"),
    @NamedQuery(name = "TcUsuarios.findByCorreo", query = "SELECT t FROM TcUsuarios t WHERE t.correo = :correo"),
    @NamedQuery(name = "TcUsuarios.findByFechaDeNacimiento", query = "SELECT t FROM TcUsuarios t WHERE t.fechaDeNacimiento = :fechaDeNacimiento"),
    @NamedQuery(name = "TcUsuarios.findByFechaDeAlta", query = "SELECT t FROM TcUsuarios t WHERE t.fechaDeAlta = :fechaDeAlta"),
    @NamedQuery(name = "TcUsuarios.findByActivo", query = "SELECT t FROM TcUsuarios t WHERE t.activo = :activo"),
    @NamedQuery(name = "TcUsuarios.findByUsuario", query = "SELECT t FROM TcUsuarios t WHERE t.usuario = :usuario"),
    @NamedQuery(name = "TcUsuarios.findByIdPerfil", query = "SELECT t FROM TcUsuarios t WHERE t.idPerfil = :idPerfil"),
    @NamedQuery(name = "TcUsuarios.findByDomicilio", query = "SELECT t FROM TcUsuarios t WHERE t.domicilio = :domicilio"),
    @NamedQuery(name = "TcUsuarios.findByEstado", query = "SELECT t FROM TcUsuarios t WHERE t.estado = :estado"),
    @NamedQuery(name = "TcUsuarios.findByMunicipio", query = "SELECT t FROM TcUsuarios t WHERE t.municipio = :municipio"),
    @NamedQuery(name = "TcUsuarios.findByPais", query = "SELECT t FROM TcUsuarios t WHERE t.pais = :pais"),
    @NamedQuery(name = "TcUsuarios.findByPassword", query = "SELECT t FROM TcUsuarios t WHERE t.password = :password")})
public class TcUsuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdUsuario", nullable = false)
    private Integer idUsuario;
    @Column(name = "Nombres", length = 45)
    private String nombres;
    @Column(name = "Apellidos", length = 45)
    private String apellidos;
    @Column(name = "Celular", length = 45)
    private String celular;
    @Column(name = "Correo", length = 45)
    private String correo;
    @Column(name = "FechaDeNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaDeNacimiento;
    @Column(name = "FechaDeAlta")
    @Temporal(TemporalType.DATE)
    private Date fechaDeAlta;
    @Column(name = "Activo")
    private Short activo;
    @Column(name = "Usuario", length = 45)
    private String usuario;
    @Column(name = "IdPerfil")
    private Integer idPerfil;
    @Column(name = "Domicilio", length = 45)
    private String domicilio;
    @Column(name = "Estado", length = 45)
    private String estado;
    @Column(name = "Municipio", length = 45)
    private String municipio;
    @Column(name = "Pais", length = 45)
    private String pais;
    @Column(name = "Password", length = 45)
    private String password;

    public TcUsuarios() {
    }

    public TcUsuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TcUsuarios)) {
            return false;
        }
        TcUsuarios other = (TcUsuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UML.TcUsuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}
