/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDto;

import java.io.Serializable;
import java.util.Date;
//import javax.persistence.Entity;
//import javax.persistence.Table;

/**
 *
 * @author ULISES.VIEYRA
 */
//@Entity
//@Table(name = "DtoMenu")
public class DtoMenu implements Serializable {

    private int IdMenu;
    private String Nombre;
    private String Controlador;
    private boolean Activo;
    private Date FechaDeAlta;
    private int IdUsuario;
    private int IdPadre;
    private String NombreUsuario;
    private String NombreSubMenu;
    private boolean BtnSubMenu;
    private String classActivo;
    private String iconActivo;    

    public DtoMenu() {
    }

    public DtoMenu(int IdMenu, String Nombre, String Controlador, boolean Activo, Date FechaDeAlta, int IdUsuario, int IdPadre) {
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

    /**
     * @return the NombreSubMenu
     */
    public String getNombreSubMenu() {
        return NombreSubMenu;
    }

    /**
     * @param NombreSubMenu the NombreSubMenu to set
     */
    public void setNombreSubMenu(String NombreSubMenu) {
        this.NombreSubMenu = NombreSubMenu;
    }

    /**
     * @return the BtnSubMenu
     */
    public boolean isBtnSubMenu() {
        return BtnSubMenu;
    }

    /**
     * @param BtnSubMenu the BtnSubMenu to set
     */
    public void setBtnSubMenu(boolean BtnSubMenu) {
        this.BtnSubMenu = BtnSubMenu;
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

//    /**
//     * @return the iconActivo
//     */
//    public String getIconActivo() {
//        return iconActivo;
//    }

    /**
     * @param iconActivo the iconActivo to set
     */
//   @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (IdMenu != null ? IdMenu.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        if (!(object instanceof DtoMenu)) {
//            return false;
//        }
//        DtoMenu other = (DtoMenu) object;
//        if ((this.IdMenu == null && other.IdMenu != null) || (this.IdMenu != null && !this.IdMenu.equals(other.IdMenu))) {
//            return false;
//        }
//        return true;
//    }
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (IdMenu != null ? IdMenu.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        if (!(object instanceof DtoMenu)) {
//            return false;
//        }
//        DtoMenu other = (DtoMenu) object;
//        if ((this.IdMenu == null && other.IdMenu != null) || (this.IdMenu != null && !this.IdMenu.equals(other.IdMenu))) {
//            return false;
//        }
//        return true;
//    }
    
//     @Override
//    public Object getAsObject(FacesContext context, UIComponent component, String value) {
//        long id = -1;
//        try{
//            id = Long.parseLong(value);
//        }
//        catch(Exception e){
//            return null;
//        }
//        Transaction t = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//        try{
//            DtoMenu e = new ProductoServiceImpl().find(id);
//            t.commit();
//            return e;
//        }
//        catch(Exception e){
//            t.rollback();
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public String getAsString(FacesContext context, UIComponent component, Object value) {
//        if (value instanceof DtoMenu){
//            return ((DtoMenu)value).getIdMenu().toString();
//        }
//        return null;
//    }

//   @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (IdMenu != null ? IdMenu.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof DtoMenu)) {
//            return false;
//        }
//        DtoMenu other = (DtoMenu) object;
//        if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
//            return false;
//        }
//        return true;
//    }
    
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (IdPadre != null ? IdPadre.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        if (!(object instanceof DtoMenu)) {
//            return false;
//        }
//        DtoMenu other = (DtoMenu) object;
//        if ((this.IdPadre == null && other.IdPadre != null) || (this.IdPadre != null && !this.IdPadre.equals(other.IdPadre))) {
//            return false;
//        }
//        return true;
//    }
}
