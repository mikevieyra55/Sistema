/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad;

import ModeloDao.MenusUsuarios.DtoMenuUsuario;
import ModeloDao.MenusUsuarios.DtoSubMenuUsuario;
import ModeloDto.DtoUsuarios;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
/**
 *
 * @author ULISES.VIEYRA
 */
@ManagedBean(name = "mbUsuariosPermisos")
@RequestScoped
public class MBPermisosUsuarios {

    private ArrayList<DtoMenuUsuario> listaMenus = new ArrayList<DtoMenuUsuario>();
    private ArrayList<DtoSubMenuUsuario> listaSubMenus = new ArrayList<DtoSubMenuUsuario>();

    /**
     * Creates a new instance of MBPermisosUsuarios
     */
    public MBPermisosUsuarios() {
        DtoUsuarios usuarioLog = new DtoUsuarios();
        usuarioLog = SessionUtils.getUser();
        DaoPermisosUsuarios daoPermisos = new DaoPermisosUsuarios();
        setListaMenus(daoPermisos.obtenerMenusUsuario(usuarioLog.getIdPerfil()));
        for (DtoMenuUsuario menu : getListaMenus()) {
            menu.setListaSubMenu(daoPermisos.obtenerSubMenusUsuario(usuarioLog.getIdPerfil(), menu.getIdMenu()));
        }
    }

    /**
     * @return the listaMenus
     */
    public ArrayList<DtoMenuUsuario> getListaMenus() {
        return listaMenus;
    }

    /**
     * @param listaMenus the listaMenus to set
     */
    public void setListaMenus(ArrayList<DtoMenuUsuario> listaMenus) {
        this.listaMenus = listaMenus;
    }

    /**
     * @return the listaSubMenus
     */
    public ArrayList<DtoSubMenuUsuario> getListaSubMenus() {
        return listaSubMenus;
    }

    /**
     * @param listaSubMenus the listaSubMenus to set
     */
    public void setListaSubMenus(ArrayList<DtoSubMenuUsuario> listaSubMenus) {
        this.listaSubMenus = listaSubMenus;
    }

}
