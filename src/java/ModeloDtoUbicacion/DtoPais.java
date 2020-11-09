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
public class DtoPais implements Serializable {

    private int IdPais;
    private String Nombre;
    private boolean Activo;

    public DtoPais() {
    }

    public DtoPais(int IdPais, String Nombre, boolean Activo) {
        this.setIdPais(IdPais);
        this.setNombre(Nombre);
        this.setActivo(Activo);
        
    }

    /**
     * @return the IdPais
     */
    public int getIdPais() {
        return IdPais;
    }

    /**
     * @param IdPais the IdPais to set
     */
    public void setIdPais(int IdPais) {
        this.IdPais = IdPais;
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
