/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageBeans;

import ModeloDao.DaoMenu;
import ModeloDto.DtoMenu;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import Recursos.MensajesValidaciones;
import ModeloDto.DtoTransaccionBD;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author ULISES.VIEYRA
 */
@ManagedBean(name = "mbMenus")
@RequestScoped
public class MBMenu implements Serializable {

    private List<SelectItem> listaDeMenusPadres = new ArrayList<SelectItem>();
    private ArrayList<DtoMenu> listaMenus;
    private HtmlDataTable htmlDataTable = new HtmlDataTable();
    private DtoMenu menuSeleccionado = new DtoMenu();
    private DtoMenu menu = new DtoMenu();
    private DtoTransaccionBD objTransacion = null;

    public MBMenu() {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            init();
        }
    }

    @PostConstruct
    public void init() {
        listarObjetos();
    }

    public void listarObjetos() {
        DaoMenu daoMenu = new DaoMenu();
        setListaMenus(daoMenu.listarMenus());
        setListaDeMenusPadres(obtenerMenusPadres());
    }

    public String editar() {
        menuSeleccionado = (DtoMenu) getHtmlDataTable().getRowData();
        if (getMenuSeleccionado().getNombre().equals("")) {
            menuSeleccionado.setNombre(getMenuSeleccionado().getNombreSubMenu());
        }
        setListaDeMenusPadres(obtenerMenusPadres());
        return "Edit";
    }

    public String actualizar() {
        DaoMenu daoMenu = new DaoMenu();
        MensajesValidaciones infoTrans = new MensajesValidaciones();
        if (getMenuSeleccionado().getNombre().equals("")) {
            menuSeleccionado.setNombre(getMenuSeleccionado().getNombreSubMenu());
        }
        if (daoMenu.editarMenu(getMenuSeleccionado())) {
            setObjTransacion(infoTrans.ActualizarCorrecto());
        } else {
            setObjTransacion(infoTrans.ActualizarError());
        }
        listarObjetos();
        return "List";
    }

    public String nuevoSubmenu() {
        menuSeleccionado = (DtoMenu) getHtmlDataTable().getRowData();
        if (menuSeleccionado != null) {
            getMenu().setIdPadre(getMenuSeleccionado().getIdMenu());
        }
        setListaDeMenusPadres(obtenerMenusPadres());
        return "Create";
    }

    public String nuevo() {
        setListaDeMenusPadres(obtenerMenusPadres());
        return "Create";
    }

    public String guardar() {
        DaoMenu daoMenu = new DaoMenu();
        MensajesValidaciones infoTrans = new MensajesValidaciones();
        if (daoMenu.agregarMenu(getMenu())) {
            setObjTransacion(infoTrans.GuardarCorrecto());
        } else {
            setObjTransacion(infoTrans.GuardarError());
        }
        listarObjetos();
        return "List";
    }

    public void activar() {
        DaoMenu daoMenu = new DaoMenu();
        MensajesValidaciones infoTrans = new MensajesValidaciones();
        menuSeleccionado = (DtoMenu) getHtmlDataTable().getRowData();
        if (daoMenu.activarDesactivarMenu(menuSeleccionado.getIdMenu())) {
            setObjTransacion(infoTrans.ActivarCorrecto());
        } else {
            setObjTransacion(infoTrans.ActivarError());
        }
        listarObjetos();
    }

    public List<SelectItem> obtenerMenusPadres() {
        DaoMenu daoMenu = new DaoMenu();
        List<SelectItem> items = new ArrayList<SelectItem>();
        List<DtoMenu> categoryList = daoMenu.listarMenusPadres();
        for (DtoMenu category : categoryList) {
            items.add(new SelectItem(category.getIdMenu(), category.getNombre()));
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
     * @return the listaMenus
     */
    public ArrayList<DtoMenu> getListaMenus() {
        return listaMenus;
    }

    /**
     * @param listaMenus the listaMenus to set
     */
    public void setListaMenus(ArrayList<DtoMenu> listaMenus) {
        this.listaMenus = listaMenus;
    }

    /**
     * @return the menuSeleccionado
     */
    public DtoMenu getMenuSeleccionado() {
        return menuSeleccionado;
    }

    /**
     * @param menuSeleccionado the menuSeleccionado to set
     */
    public void setMenuSeleccionado(DtoMenu menuSeleccionado) {
        this.menuSeleccionado = menuSeleccionado;
    }

    /**
     * @return the menu
     */
    public DtoMenu getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(DtoMenu menu) {
        this.menu = menu;
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
     * @return the listaDeMenusPadres
     */
    public List<SelectItem> getListaDeMenusPadres() {
        return listaDeMenusPadres;
    }

    /**
     * @param listaDeMenusPadres the listaDeMenusPadres to set
     */
    public void setListaDeMenusPadres(List<SelectItem> listaDeMenusPadres) {
        this.listaDeMenusPadres = listaDeMenusPadres;
    }

}
