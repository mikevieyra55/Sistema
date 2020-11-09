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
public class DtoMenu_1 implements Serializable  {

    private int IdMenu;
    private String Nombre;
    private String Controlador;
    private boolean Activo;
    private Date FechaDeAlta;
    private int IdUsuario;
    private int IdPadre;
    private String NombreUsuario;

    public DtoMenu_1() {
    }

    public DtoMenu_1(int IdMenu, String Nombre, String Controlador, boolean Activo, Date FechaDeAlta, int IdUsuario, int IdPadre) {
        this.IdMenu = IdMenu;
        this.Nombre = Nombre;
        this.Controlador = Controlador;
        this.Activo = Activo;
        this.FechaDeAlta = FechaDeAlta;
        this.IdUsuario = IdUsuario;
        this.IdPadre = IdPadre;
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
     * @return the IdPadre
     */
    public int getIdPadre() {
        return IdPadre;
    }

    /**
     * @param IdPadre the IdPadre to set
     */
    public void setIdPadre(int IdPadre) {
        this.IdPadre = IdPadre;
    }

    /**
     * @return the NombreUsuario
     */
    public String getNombreUsuario() {
        return NombreUsuario;
    }

    /**
     * @param NombreUsuario the NombreUsuario to set
     */
    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }
}
