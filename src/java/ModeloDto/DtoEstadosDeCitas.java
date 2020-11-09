/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ULISES.VIEYRA
 */
public class DtoEstadosDeCitas implements Serializable  {

    private int IdEstadoDeCita;
    private String Nombre;
    private String Descripcion;
    private boolean Activo;
    private int IdUsuario;
    private Date FechaDeAlta;

    public DtoEstadosDeCitas() {
    }

    public DtoEstadosDeCitas(int IdEstadoDeCita, String Nombre, String Descripcion, boolean Activo, int IdUsuario,
            Date FechaDeAlta) {
        this.IdEstadoDeCita = IdEstadoDeCita;
        this.Nombre = Nombre;
        this.Descripcion = Nombre;
        this.Activo = Activo;
        this.IdUsuario = IdUsuario;
        this.FechaDeAlta = FechaDeAlta;
    }

    /**
     * @return the IdEstadoDeCita
     */
    public int getIdEstadoDeCita() {
        return IdEstadoDeCita;
    }

    /**
     * @param IdEstadoDeCita the IdEstadoDeCita to set
     */
    public void setIdEstadoDeCita(int IdEstadoDeCita) {
        this.IdEstadoDeCita = IdEstadoDeCita;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
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
     * @return the FechaDeAlta
     */
    public Date getFechaDeAlta() {
        return FechaDeAlta;
    }

    /**
     * @param FechaDeAlta the FechaDeAlta to set
     */
    public void setFechaDeAlta(Date FechaDeAlta) {
        this.FechaDeAlta = FechaDeAlta;
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
}
