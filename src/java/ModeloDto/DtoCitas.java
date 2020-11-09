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
public class DtoCitas implements Serializable  {

    private int IdCita;
    private Date FechaDeAlta;
    private Date FechaDeCita;
    private String HoraDeCita;
    private boolean Activo;
    private int IdPaciente;
    private int IdUsuario;
    private int IdEstadoDeCita;
    private int IdDoctor;

    public DtoCitas() {
    }

    public DtoCitas(int IdCita, Date FechaDeAlta, Date FechaDeCita, String HoraDeCita, boolean Activo, int IdPaciente, int IdUsuario, int IdEstadoDeCita,
            int IdDoctor) {
        this.IdCita = IdCita;
        this.FechaDeAlta = FechaDeAlta;
        this.FechaDeCita = FechaDeCita;
        this.HoraDeCita = HoraDeCita;
        this.Activo = Activo;
        this.IdPaciente = IdPaciente;
        this.IdUsuario = IdUsuario;
        this.IdEstadoDeCita = IdEstadoDeCita;
        this.IdDoctor = IdDoctor;
    }

    /**
     * @return the IdCita
     */
    public int getIdCita() {
        return IdCita;
    }

    /**
     * @param IdCita the IdCita to set
     */
    public void setIdCita(int IdCita) {
        this.IdCita = IdCita;
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
     * @return the FechaDeCita
     */
    public Date getFechaDeCita() {
        return FechaDeCita;
    }

    /**
     * @param FechaDeCita the FechaDeCita to set
     */
    public void setFechaDeCita(Date FechaDeCita) {
        this.FechaDeCita = FechaDeCita;
    }

    /**
     * @return the HoraDeCita
     */
    public String getHoraDeCita() {
        return HoraDeCita;
    }

    /**
     * @param HoraDeCita the HoraDeCita to set
     */
    public void setHoraDeCita(String HoraDeCita) {
        this.HoraDeCita = HoraDeCita;
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
}
