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
public class DtoCuestionarios implements Serializable  {

    private int IdCuestionario;
    private String Nombre;
    private String Descripcion;
    private Date FechaDeAlta;
    private boolean Activo;
   

    public DtoCuestionarios() {
    }

    public DtoCuestionarios(int IdCuestionario, String Nombre, String Descripcion, Date FechaDeAlta, boolean Activo) {
        this.IdCuestionario = IdCuestionario;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.FechaDeAlta = FechaDeAlta;
        this.Activo = Activo;
    }

    /**
     * @return the IdCuestionario
     */
    public int getIdCuestionario() {
        return IdCuestionario;
    }

    /**
     * @param IdCuestionario the IdCuestionario to set
     */
    public void setIdCuestionario(int IdCuestionario) {
        this.IdCuestionario = IdCuestionario;
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
