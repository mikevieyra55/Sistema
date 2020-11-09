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
public class DtoPreguntas implements Serializable  {

    private int IdPregunta;
    private String Descripcion;
    private int IdCuestionario;
    private int Orden;
    private boolean Activo;
    private Date FechaDeAlta;
    private int IdUsuario;
    private int IdTipoDePregunta;

    public DtoPreguntas() {
    }

    public DtoPreguntas(int IdPregunta, String Descripcion, int IdCuestionario, int Orden, boolean Activo, 
            Date FechaDeAlta, int IdUsuario, int IdTipoDePregunta) {
        this.IdPregunta = IdPregunta;
        this.Descripcion = Descripcion;
        this.IdCuestionario = IdCuestionario;
        this.Orden = Orden;
        this.Activo = Activo;
        this.FechaDeAlta = FechaDeAlta;
        this.IdUsuario = IdUsuario;
        this.IdTipoDePregunta = IdTipoDePregunta;
    }

    /**
     * @return the IdPregunta
     */
    public int getIdPregunta() {
        return IdPregunta;
    }

    /**
     * @param IdPregunta the IdPregunta to set
     */
    public void setIdPregunta(int IdPregunta) {
        this.IdPregunta = IdPregunta;
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
     * @return the idCuestionario
     */
    public int getIdCuestionario() {
        return IdCuestionario;
    }

    /**
     * @param idCuestionario the idCuestionario to set
     */
    public void setIdCuestionario(int IdCuestionario) {
        this.IdCuestionario = IdCuestionario;
    }

    /**
     * @return the Orden
     */
    public int getOrden() {
        return Orden;
    }

    /**
     * @param Orden the Orden to set
     */
    public void setOrden(int Orden) {
        this.Orden = Orden;
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
}
