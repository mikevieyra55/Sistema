/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDtoUbicacion;

import java.io.Serializable;

/**
 *
 * @author ULISES.VIEYRA
 */
public class DtoEstado implements Serializable {

    private int IdEstado;
    private String Nombre;    
    private boolean Activo;

    public DtoEstado() {
    }

    public DtoEstado(int IdEstado, String Nombre, boolean Activo ) {

        this.setIdEstado(IdEstado);
        this.setNombre(Nombre);        
        this.setActivo(Activo);
        
    }

    /**
     * @return the IdEstado
     */
    public int getIdEstado() {
        return IdEstado;
    }

    /**
     * @param IdEstado the IdEstado to set
     */
    public void setIdEstado(int IdEstado) {
        this.IdEstado = IdEstado;
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
