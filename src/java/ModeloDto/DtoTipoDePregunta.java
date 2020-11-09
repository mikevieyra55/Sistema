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
public class DtoTipoDePregunta implements Serializable {

    private int IdTipoDePregunta;
    private String Descripcion;
    private boolean Activo;
    private Date FechaDeAlta;
    private int IdUsuario;

    public DtoTipoDePregunta() {
    }

    public DtoTipoDePregunta(int IdTipoDePregunta, String Descripcion, boolean Activo, Date FechaDeAlta, int IdUsuario) {
        this.IdTipoDePregunta = IdTipoDePregunta;
        this.Descripcion = Descripcion;
        this.Activo = Activo;
        this.FechaDeAlta = FechaDeAlta;
        this.IdUsuario = IdUsuario;
    }

    /**
     * @return the IdTipoDePregunta
     */
    public int getIdTipoDePregunta() {
        return IdTipoDePregunta;
    }

    /**
     * @param IdTipoDePregunta the IdTipoDePregunta to set
     */
    public void setIdTipoDePregunta(int IdTipoDePregunta) {
        this.IdTipoDePregunta = IdTipoDePregunta;
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
