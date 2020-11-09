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
public class DtoTratamientos implements Serializable {

    private int IdTratamiento;
    private String Descripcion;
    private boolean Activo;
    private Date FechaDeAlta;
    private Float Precio;
    private int IdUsuario;

    public DtoTratamientos() {
    }

    public DtoTratamientos(int IdTratamiento, String Descripcion, boolean Activo, Date FechaDeAlta, Float Precio, int IdUsuario) {
        this.IdTratamiento = IdTratamiento;
        this.Descripcion = Descripcion;
        this.Activo = Activo;
        this.FechaDeAlta = FechaDeAlta;
        this.Precio = Precio;
        this.IdUsuario = IdUsuario;
    }

    /**
     * @return the IdTratamiento
     */
    public int getIdTratamiento() {
        return IdTratamiento;
    }

    /**
     * @param IdTratamiento the IdTratamiento to set
     */
    public void setIdTratamiento(int IdTratamiento) {
        this.IdTratamiento = IdTratamiento;
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
     * @return the Precio
     */
    public Float getPrecio() {
        return Precio;
    }

    /**
     * @param Precio the Precio to set
     */
    public void setPrecio(Float Precio) {
        this.Precio = Precio;
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

}
