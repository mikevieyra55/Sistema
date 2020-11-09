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
public class DtoRespuestas implements Serializable {

    private int IdRespuesta;
    private String Descripcion;
    private int IdPaciente;
    private Date FechaDeAlta;

    public DtoRespuestas() {
    }

    public DtoRespuestas(int IdRespuesta, String Descripcion, int IdPaciente, Date FechaDeAlta) {
        this.IdRespuesta = IdRespuesta;
        this.Descripcion = Descripcion;
        this.IdPaciente = IdPaciente;
        this.FechaDeAlta = FechaDeAlta;
    }

    /**
     * @return the IdRespuesta
     */
    public int getIdRespuesta() {
        return IdRespuesta;
    }

    /**
     * @param IdRespuesta the IdRespuesta to set
     */
    public void setIdRespuesta(int IdRespuesta) {
        this.IdRespuesta = IdRespuesta;
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
     * @return the IdPaciente
     */
    public int getIdPaciente() {
        return IdPaciente;
    }

    /**
     * @param IdPaciente the IdPaciente to set
     */
    public void setIdPaciente(int IdPaciente) {
        this.IdPaciente = IdPaciente;
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

}
