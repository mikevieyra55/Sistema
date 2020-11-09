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
public class DtoEstadosCompra implements Serializable {

    private int IdEstadoCompra;
    private String Nombre;
    private String Descripcion;
    private boolean Activo;
    private Date FechaDeAlta;
    private int IdUsuario;

    public DtoEstadosCompra() {
    }

    public DtoEstadosCompra(int IdEstadoCompra, String Nombre, String Descripcion, boolean Activo, Date FechaDeAlta, int IdUsuario) {
        this.IdEstadoCompra = IdEstadoCompra;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Activo = Activo;
        this.FechaDeAlta = FechaDeAlta;
        this.IdUsuario = IdUsuario;
    }

    /**
     * @return the IdEstadoCompra
     */
    public int getIdEstadoCompra() {
        return IdEstadoCompra;
    }

    /**
     * @param IdEstadoCompra the IdEstadoCompra to set
     */
    public void setIdEstadoCompra(int IdEstadoCompra) {
        this.IdEstadoCompra = IdEstadoCompra;
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
