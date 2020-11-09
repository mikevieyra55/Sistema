/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao.MenusUsuarios;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ULISES.VIEYRA
 */
public class DtoMenuUsuario implements Serializable {

    private String Nombre;
    private ArrayList<DtoSubMenuUsuario> listaSubMenu;
    private int IdMenu;

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
     * @return the listaSubMenu
     */
    public ArrayList<DtoSubMenuUsuario> getListaSubMenu() {
        return listaSubMenu;
    }

    /**
     * @param listaSubMenu the listaSubMenu to set
     */
    public void setListaSubMenu(ArrayList<DtoSubMenuUsuario> listaSubMenu) {
        this.listaSubMenu = listaSubMenu;
    }

    /**
     * @return the IdMenu
     */
    public int getIdMenu() {
        return IdMenu;
    }

    /**
     * @param IdMenu the IdMenu to set
     */
    public void setIdMenu(int IdMenu) {
        this.IdMenu = IdMenu;
    }

}
