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
public class DtoAbonos implements Serializable  {

    private int IdAbono;
    private Date FechaDeAlta;
    private float Cantidad;
    private int IdUsuario;
    private int IdCompra;
    private boolean Activo;

    public DtoAbonos() {
    }

    public DtoAbonos(int IdAbono, Date FechaDeAlta, float Cantidad, int IdUsuario, int IdCompra, boolean Activo) {
        this.IdAbono = IdAbono;
        this.FechaDeAlta = FechaDeAlta;
        this.Cantidad = Cantidad;
        this.IdUsuario = IdUsuario;
        this.IdCompra = IdCompra;
        this.Activo = Activo;
    }

    /**
     * @return the IdAbono
     */
    public int getIdAbono() {
        return IdAbono;
    }

    /**
     * @param IdAbono the IdAbono to set
     */
    public void setIdAbono(int IdAbono) {
        this.IdAbono = IdAbono;
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
     * @return the Cantidad
     */
    public float getCantidad() {
        return Cantidad;
    }

    /**
     * @param Cantidad the Cantidad to set
     */
    public void setCantidad(float Cantidad) {
        this.Cantidad = Cantidad;
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
     * @return the IdCompra
     */
    public int getIdCompra() {
        return IdCompra;
    }

    /**
     * @param IdCompra the IdCompra to set
     */
    public void setIdCompra(int IdCompra) {
        this.IdCompra = IdCompra;
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
