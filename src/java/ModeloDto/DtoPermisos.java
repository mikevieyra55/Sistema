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
public class DtoPermisos implements Serializable {

    private int IdPermiso;
    private int IdPerfil;
    private int IdMenu;
    private Date FechaDeAlta;
    private int IdUsuario;
    private boolean Activo;
    private String nombreMenu;
    private String nombreSubMenu;
    private int IdPadreMenu;
    private String nombreUsuario;
    private String classActivo;
    private String iconActivo;

    public DtoPermisos() {
    }

    public DtoPermisos(int IdPermiso, int IdPerfil, int IdMenu, Date FechaDeAlta, int IdUsuario, boolean Activo) {
        this.IdPermiso = IdPermiso;
        this.IdPerfil = IdPerfil;
        this.IdMenu = IdMenu;
        this.FechaDeAlta = FechaDeAlta;
        this.IdUsuario = IdUsuario;
        this.Activo = Activo;
    }

    /**
     * @return the IdPermiso
     */
    public int getIdPermiso() {
        return IdPermiso;
    }

    /**
     * @param IdPermiso the IdPermiso to set
     */
    public void setIdPermiso(int IdPermiso) {
        this.IdPermiso = IdPermiso;
    }

    /**
     * @return the IdPerfil
     */
    public int getIdPerfil() {
        return IdPerfil;
    }

    /**
     * @param IdPerfil the IdPerfil to set
     */
    public void setIdPerfil(int IdPerfil) {
        this.IdPerfil = IdPerfil;
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
     * @return the nombreMenu
     */
    public String getNombreMenu() {
        return nombreMenu;
    }

    /**
     * @param nombreMenu the nombreMenu to set
     */
    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    /**
     * @return the IdPadreMenu
     */
    public int getIdPadreMenu() {
        return IdPadreMenu;
    }

    /**
     * @param IdPadreMenu the IdPadreMenu to set
     */
    public void setIdPadreMenu(int IdPadreMenu) {
        this.IdPadreMenu = IdPadreMenu;
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the classActivo
     */
    public String getClassActivo() {
        return classActivo;
    }

    /**
     * @param classActivo the classActivo to set
     */
    public void setClassActivo(String classActivo) {
        this.classActivo = classActivo;
    }

    /**
     * @return the iconActivo
     */
    public String getIconActivo() {
        return iconActivo;
    }

    /**
     * @param iconActivo the iconActivo to set
     */
    public void setIconActivo(String iconActivo) {
        this.iconActivo = iconActivo;
    }

    /**
     * @return the nombreSubMenu
     */
    public String getNombreSubMenu() {
        return nombreSubMenu;
    }

    /**
     * @param nombreSubMenu the nombreSubMenu to set
     */
    public void setNombreSubMenu(String nombreSubMenu) {
        this.nombreSubMenu = nombreSubMenu;
    }
}
