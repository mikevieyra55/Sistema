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
public class DtoCompras implements Serializable  {

    private int IdCompra;
    private Date FechaDeAlta;
    private float Total;
    private int IdUsuario;
    private int IdDoctor;
    private int IdEstadoCompra;

    public DtoCompras() {
    }

    public DtoCompras(int IdCompra, Date FechaDeAlta, float Total, int IdUsuario, int IdDoctor, int IdEstadoCompra) {
        this.IdCompra = IdCompra;
        this.FechaDeAlta = FechaDeAlta;
        this.Total = Total;
        this.IdUsuario = IdUsuario;
        this.IdDoctor = IdDoctor;
        this.IdEstadoCompra = IdEstadoCompra;
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
     * @return the Total
     */
    public float getTotal() {
        return Total;
    }

    /**
     * @param Total the Total to set
     */
    public void setTotal(float Total) {
        this.Total = Total;
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
     * @return the IdDoctor
     */
    public int getIdDoctor() {
        return IdDoctor;
    }

    /**
     * @param IdDoctor the IdDoctor to set
     */
    public void setIdDoctor(int IdDoctor) {
        this.IdDoctor = IdDoctor;
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
}
