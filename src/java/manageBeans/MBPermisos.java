/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageBeans;

import BancoDeMensajes.MensajesInformativos;
import ModeloDao.DaoMenu;
import ModeloDao.DaoPerfiles;
import ModeloDao.DaoPermisos;
import ModeloDto.DtoMenu;
import ModeloDto.DtoPerfiles;
import ModeloDto.DtoPermisos;
import ModeloDto.DtoTransaccionBD;
import Recursos.MensajesValidaciones;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author ULISES.VIEYRA
 */
@ManagedBean(name = "mbPermisos")
@RequestScoped
public class MBPermisos implements Serializable {

    private ArrayList<DtoPermisos> listaPermisos;
    private HtmlDataTable htmlDataTable = new HtmlDataTable();
    private List<SelectItem> listaPerfiles = new ArrayList<SelectItem>();
    private HtmlSelectOneMenu uiSelectPerfil = new HtmlSelectOneMenu();
    private DtoTransaccionBD objTransacion = null;
    private DtoPermisos permisoSeleccionado = new DtoPermisos();

    /**
     * Creates a new instance of MBPermisos
     */
    public MBPermisos() {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            init();
        }
    }

    @PostConstruct
    private void init() {
        listarObjetos();
    }

    public void actualizaCB() {
        listarObjetos();
    }

    public void listarObjetos() {
        DaoPermisos daoPermisos = new DaoPermisos();
        DaoMenu daoMenu = new DaoMenu();
        setListaPerfiles(obtenerPerfiles());
        ArrayList<DtoPermisos> listaPermisosBD = new ArrayList<DtoPermisos>();
        ArrayList<DtoMenu> listaMenusBD = new ArrayList<DtoMenu>();
        ArrayList<DtoPermisos> lista = new ArrayList<DtoPermisos>();
        int valorCBPerfil = 1;
        try {
            valorCBPerfil = Integer.parseInt(uiSelectPerfil.getValue().toString());
        } catch (Exception ex) {
            valorCBPerfil = 1;
        }
        listaPermisosBD = daoPermisos.listarPermisos(valorCBPerfil);
        listaMenusBD = daoMenu.listarMenus();
        lista.clear();
        for (DtoMenu menu : listaMenusBD) {
            DtoPermisos permisosVista = new DtoPermisos();
            permisosVista.setNombreMenu(menu.getNombre());
            permisosVista.setNombreSubMenu(menu.getNombreSubMenu());
            permisosVista.setIconActivo(MensajesInformativos.iconInActivo);
            permisosVista.setClassActivo(MensajesInformativos.classInActivo);
            permisosVista.setIdPerfil(valorCBPerfil);
            permisosVista.setIdMenu(menu.getIdMenu());
            for (DtoPermisos permiso : listaPermisosBD) {
                if (permiso.getIdMenu() == menu.getIdMenu()) {
                    permisosVista.setIdPermiso(permiso.getIdPermiso());
                    permisosVista.setFechaDeAlta(permiso.getFechaDeAlta());
                    permisosVista.setNombreUsuario(permiso.getNombreUsuario());
                    permisosVista.setIconActivo(permiso.getIconActivo());
                    permisosVista.setClassActivo(permiso.getClassActivo());
                }
            }
            lista.add(permisosVista);
        }
        setListaPermisos(lista);

    }

    public void activar() {
        DaoPermisos daoPermisos = new DaoPermisos();
        MensajesValidaciones infoTrans = new MensajesValidaciones();
        setPermisoSeleccionado((DtoPermisos) getHtmlDataTable().getRowData());
        try {
            getPermisoSeleccionado().setIdPerfil(Integer.parseInt(uiSelectPerfil.getValue().toString()));
            if (daoPermisos.ActivarDescativarPermiso(getPermisoSeleccionado())) {
                setObjTransacion(infoTrans.ActivarCorrecto());
            } else {
                setObjTransacion(infoTrans.ActivarError());
            }
        } catch (Exception ex) {
            setObjTransacion(infoTrans.ActivarError());
        }
        listarObjetos();
    }

    public List<SelectItem> obtenerPerfiles() {
        DaoPerfiles daoPerfiles = new DaoPerfiles();
        List<SelectItem> items = new ArrayList<SelectItem>();
        List<DtoPerfiles> categoryList = daoPerfiles.listarPerfiles();
        for (DtoPerfiles category : categoryList) {
            items.add(new SelectItem(category.getIdPerfil(), category.getNombre()));
        }
        return items;
    }

    /**
     * @return the htmlDataTable
     */
    public HtmlDataTable getHtmlDataTable() {
        return htmlDataTable;
    }

    /**
     * @param htmlDataTable the htmlDataTable to set
     */
    public void setHtmlDataTable(HtmlDataTable htmlDataTable) {
        this.htmlDataTable = htmlDataTable;
    }

    /**
     * @return the objTransacion
     */
    public DtoTransaccionBD getObjTransacion() {
        return objTransacion;
    }

    /**
     * @param objTransacion the objTransacion to set
     */
    public void setObjTransacion(DtoTransaccionBD objTransacion) {
        this.objTransacion = objTransacion;
    }

    /**
     * @return the listaPerfiles
     */
    public List<SelectItem> getListaPerfiles() {
        return listaPerfiles;
    }

    /**
     * @param listaPerfiles the listaPerfiles to set
     */
    public void setListaPerfiles(List<SelectItem> listaPerfiles) {
        this.listaPerfiles = listaPerfiles;
    }

    /**
     * @return the uiSelectPerfil
     */
    public HtmlSelectOneMenu getUiSelectPerfil() {
        return uiSelectPerfil;
    }

    /**
     * @param uiSelectPerfil the uiSelectPerfil to set
     */
    public void setUiSelectPerfil(HtmlSelectOneMenu uiSelectPerfil) {
        this.uiSelectPerfil = uiSelectPerfil;
    }

    /**
     * @return the listaPermisos
     */
    public ArrayList<DtoPermisos> getListaPermisos() {
        return listaPermisos;
    }

    /**
     * @param listaPermisos the listaPermisos to set
     */
    public void setListaPermisos(ArrayList<DtoPermisos> listaPermisos) {
        this.listaPermisos = listaPermisos;
    }

    /**
     * @return the permisoSeleccionado
     */
    public DtoPermisos getPermisoSeleccionado() {
        return permisoSeleccionado;
    }

    /**
     * @param permisoSeleccionado the permisoSeleccionado to set
     */
    public void setPermisoSeleccionado(DtoPermisos permisoSeleccionado) {
        this.permisoSeleccionado = permisoSeleccionado;
    }

}
