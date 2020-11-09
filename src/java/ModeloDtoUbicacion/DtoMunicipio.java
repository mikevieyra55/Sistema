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
public class DtoMunicipio implements Serializable  {

    private int IdMunicipio;
    private String Nombre;
    private int IdEstado;
    private boolean Activo;

    public DtoMunicipio() {
    }

    public DtoMunicipio(int IdMunicipio, String Nombre, int IdEstado, boolean Activo) {
        this.setIdMunicipio(IdMunicipio);
        this.setNombre(Nombre);
        this.setIdEstado(IdEstado);
        this.setActivo(Activo);
        
    }

    /**
     * @return the IdMunicipio
     */
    public int getIdMunicipio() {
        return IdMunicipio;
    }

    /**
     * @param IdMunicipio the IdMunicipio to set
     */
    public void setIdMunicipio(int IdMunicipio) {
        this.IdMunicipio = IdMunicipio;
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
