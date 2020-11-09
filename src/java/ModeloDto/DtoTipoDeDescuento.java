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
public class DtoTipoDeDescuento implements Serializable {

    private int IdTipoDescuento;
    private String Nombre;
    private String Descripcion;
    private Date FechaDeAlta;
    private int IdUsuario;
    private boolean Activo;

    public DtoTipoDeDescuento() {
    }

    public DtoTipoDeDescuento(int IdTipoDescuento, String Nombre, String Descripcion, Date FechaDeAlta, int IdUsuario, boolean Activo) {
        this.IdTipoDescuento = IdTipoDescuento;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.FechaDeAlta = FechaDeAlta;
        this.IdUsuario = IdUsuario;
        this.Activo = Activo;
    }

    /**
     * @return the IdTipoDescuento
     */
    public int getIdTipoDescuento() {
        return IdTipoDescuento;
    }

    /**
     * @param IdTipoDescuento the IdTipoDescuento to set
     */
    public void setIdTipoDescuento(int IdTipoDescuento) {
        this.IdTipoDescuento = IdTipoDescuento;
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
