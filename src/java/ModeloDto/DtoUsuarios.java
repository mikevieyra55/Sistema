/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDto;

import UML.util.Fecha;
import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author ULISES.VIEYRA
 */
public class DtoUsuarios implements Serializable {

    private int IdUsuario;
    private String Nombres;
    private String Apellidos;
    private String Celular;
    private String Correo;
    private String FechaDeNacimiento;
    private String FechaDeAlta;
    private boolean Activo;
    private String Usuario;
    private int IdPerfil;
    private String Domicilio;
    private int IdEstado;
    private int IdMunicipio;    
    private String Password;
    private String NombreEstado;
    private String NombreMunicipio;  
    private String NombrePerfil;
    private String classActivo;
    private String iconActivo;
    private String CodigoPostal;

    public DtoUsuarios() {
    }

    public DtoUsuarios(int IdUsuario, String Nombres, String Apellidos, String Celular, String Correo,
            String FechaDeNacimiento, String FechaDeAlta, boolean Activo, String Usuario, int IdPerfil, String Domicilio,
            int IdEstado, int IdMunicipio, String Password, String CodigoPostal) {
        this.IdUsuario = IdUsuario;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Celular = Celular;
        this.Correo = Correo;
        this.FechaDeNacimiento = FechaDeNacimiento;
        this.FechaDeAlta = FechaDeAlta;
        this.Activo = Activo;
        this.Usuario = Usuario;
        this.IdPerfil = IdPerfil;
        this.Domicilio = Domicilio;
        this.IdEstado = IdEstado;
        this.IdMunicipio = IdMunicipio;
        this.Password = Password;
        this.CodigoPostal = CodigoPostal;
    }

    /**
     * @return the IdUsuario
     */
    public int getIdUsuario() {
        return IdUsuario;
    }

    /**
     * @param IdUsuario the IdUsuario to set
     */
    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    /**
     * @return the Nombres
     */
    public String getNombres() {
        return Nombres;
    }

    /**
     * @param Nombres the Nombres to set
     */
    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    /**
     * @return the Apellidos
     */
    public String getApellidos() {
        return Apellidos;
    }

    /**
     * @param Apellidos the Apellidos to set
     */
    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    /**
     * @return the Celular
     */
    public String getCelular() {
        return Celular;
    }

    /**
     * @param Celular the Celular to set
     */
    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    /**
     * @return the Correo
     */
    public String getCorreo() {
        return Correo;
    }

    /**
     * @param Correo the Correo to set
     */
    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    /**
     * @return the FechaDeNacimiento
     */
    public String getFechaDeNacimiento() {
        return FechaDeNacimiento;
    }

    /**
     * @param FechaDeNacimiento the FechaDeNacimiento to set
     */
    public void setFechaDeNacimiento(String FechaDeNacimiento) {
        this.FechaDeNacimiento = FechaDeNacimiento;
    }

    /**
     * @return the FechaDeAlta
     */
    public String getFechaDeAlta() {
        return FechaDeAlta;
    }

    /**
     * @param FechaDeAlta the FechaDeAlta to set
     */
    public void setFechaDeAlta(String FechaDeAlta) {
        this.FechaDeAlta = FechaDeAlta ;
    }

    /**
     * @return the Activo
     */
    public boolean isActivo() {
        return Activo;
    }

    /**
     * @param Activo the Activo to set
     */
    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }

    /**
     * @return the Usuario
     */
    public String getUsuario() {
        return Usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    /**
     * @return the IdPerfil
     */
    public int getIdPerfil() {
        return IdPerfil;
    }

    /**
     * @param IdPerfil the IdPerfil to set
     */
    public void setIdPerfil(int IdPerfil) {
        this.IdPerfil = IdPerfil;
    }

    /**
     * @return the Domicilio
     */
    public String getDomicilio() {
        return Domicilio;
    }

    /**
     * @param Domicilio the Domicilio to set
     */
    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
    }

    /**
     * @return the Estado
     */
    public int getIdEstado() {
        return IdEstado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setIdEstado(int IdEstado) {
        this.IdEstado = IdEstado;
    }

    /**
     * @return the Municipio
     */
    public int getIdMunicipio() {
        return IdMunicipio;
    }

    /**
     * @param Municipio the Municipio to set
     */
    public void setIdMunicipio(int IdMunicipio) {
        this.IdMunicipio = IdMunicipio;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the NombreEstado
     */
    public String getNombreEstado() {
        return NombreEstado;
    }

    /**
     * @param NombreEstado the NombreEstado to set
     */
    public void setNombreEstado(String NombreEstado) {
        this.NombreEstado = NombreEstado;
    }

    /**
     * @return the NombreMunicipio
     */
    public String getNombreMunicipio() {
        return NombreMunicipio;
    }

    /**
     * @param NombreMunicipio the NombreMunicipio to set
     */
    public void setNombreMunicipio(String NombreMunicipio) {
        this.NombreMunicipio = NombreMunicipio;
    }

    /**
     * @return the classActivo
     */
    public String getClassActivo() {
        return classActivo;
    }

    /**
     * @param classActivo the classActivo to set
     */
    public void setClassActivo(String classActivo) {
        this.classActivo = classActivo;
    }

    /**
     * @return the iconActivo
     */
    public String getIconActivo() {
        return iconActivo;
    }

    /**
     * @param iconActivo the iconActivo to set
     */
    public void setIconActivo(String iconActivo) {
        this.iconActivo = iconActivo;
    }

    /**
     * @return the CodigoPostal
     */
    public String getCodigoPostal() {
        return CodigoPostal;
    }

    /**
     * @param CodigoPostal the CodigoPostal to set
     */
    public void setCodigoPostal(String CodigoPostal) {
        this.CodigoPostal = CodigoPostal;
    }

    /**
     * @return the NombrePerfil
     */
    public String getNombrePerfil() {
        return NombrePerfil;
    }

    /**
     * @param NombrePerfil the NombrePerfil to set
     */
    public void setNombrePerfil(String NombrePerfil) {
        this.NombrePerfil = NombrePerfil;
    }
}
