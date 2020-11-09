/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao.MenusUsuarios;

import java.io.Serializable;

/**
 *
 * @author ULISES.VIEYRA
 */
public class DtoSubMenuUsuario implements Serializable  {
    
    private String Nombre;
    private String Controlador;

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
     * @return the Controlador
     */
    public String getControlador() {
        return Controlador;
    }

    /**
     * @param Controlador the Controlador to set
     */
    public void setControlador(String Controlador) {
        this.Controlador = Controlador;
    }
    
}
