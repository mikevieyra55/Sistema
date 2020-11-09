/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageBeans;

import ModeloDao.DaoPerfiles;
import ModeloDao.DaoUsuarios;
import ModeloDaoUbicacion.DaoUbicacion;
import ModeloDto.DtoPerfiles;

import ModeloDto.DtoUsuarios;
import Recursos.MensajesValidaciones;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import ModeloDto.DtoTransaccionBD;
import ModeloDtoUbicacion.DtoEstado;
import ModeloDtoUbicacion.DtoMunicipio;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author ULISES.VIEYRA
 */
@ManagedBean(name = "mbUsuarios")
@RequestScoped
public class MBUsuarios implements Serializable {

    private ArrayList<SelectItem> listaPerfiles = new ArrayList<SelectItem>();
    private ArrayList<DtoUsuarios> listaUsuarios;
    private HtmlDataTable htmlDataTable = new HtmlDataTable();
    private DtoUsuarios usuarioSeleccionado = new DtoUsuarios();
    private DtoUsuarios usuario = new DtoUsuarios();
    private DtoTransaccionBD objTransacion = null;
    private HtmlSelectOneMenu uiSelectEstado = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu uiSelectMunicipio = new HtmlSelectOneMenu();
    private ArrayList<SelectItem> listaEstados;
    private ArrayList<SelectItem> listaMunicipios; 
  
    /**
     * Creates a new instance of MBUsuarios
     */
    public MBUsuarios() {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            init();
        }
    }

    @PostConstruct
    public void init() {
        listarObjetos();
    }

    public void actualizaCB(AjaxBehaviorEvent event) {
        initializaEstados();
        initializaMunicipios();
    }

    public void listarObjetos() {
        DaoUsuarios daoUsuarios = new DaoUsuarios();
        setListaUsuarios(daoUsuarios.listarUsuariosActivoInActivo());
        setListaPerfiles(obtenerPerfiles());
    }

    public String editar() {
        setUsuarioSeleccionado((DtoUsuarios) getHtmlDataTable().getRowData());
        return "Edit";
    }

    public String actualizar() {
        DaoUsuarios daoUsuarios = new DaoUsuarios();
        MensajesValidaciones infoTrans = new MensajesValidaciones();
        if (daoUsuarios.editarUsuario(getUsuarioSeleccionado())) {
            setObjTransacion(infoTrans.ActualizarCorrecto());
        } else {
            setObjTransacion(infoTrans.ActualizarError());
        }
        listarObjetos();
        return "List";
    }

    public String nuevo() {
        setListaPerfiles(obtenerPerfiles());
        getListaEstados();
        return "Create";
    }

    public String guardar() {
        DaoUsuarios daoUsuarios = new DaoUsuarios();
        MensajesValidaciones infoTrans = new MensajesValidaciones();
        if (daoUsuarios.agregarUsuario(getUsuario())) {
            setObjTransacion(infoTrans.GuardarCorrecto());
        } else {
            setObjTransacion(infoTrans.GuardarError());
        }
        listarObjetos();
        return "List";
    }

    public void activar() {
        DaoUsuarios daoUsuarios = new DaoUsuarios();
        MensajesValidaciones infoTrans = new MensajesValidaciones();
        setUsuarioSeleccionado((DtoUsuarios) getHtmlDataTable().getRowData());        
        if (daoUsuarios.eliminarUsuario(getUsuarioSeleccionado())) {
            setObjTransacion(infoTrans.ActivarCorrecto());
        } else {
            setObjTransacion(infoTrans.ActivarError());
        }
        listarObjetos();
    }

    public ArrayList<SelectItem> obtenerPerfiles() {
        DaoPerfiles daoPerfil = new DaoPerfiles();
        ArrayList<SelectItem> items = new ArrayList<SelectItem>();
        ArrayList<DtoPerfiles> categoryList = daoPerfil.listarPerfiles();
        for (DtoPerfiles category : categoryList) {
            items.add(new SelectItem(category.getIdPerfil(), category.getNombre()));
        }
        return items;
    }

    public void initializaEstados() {
        ArrayList<SelectItem> ListEstado = new ArrayList<SelectItem>();
        DaoUbicacion daoUbicacion = new DaoUbicacion();
        ArrayList<DtoEstado> categoryList = daoUbicacion.listarEstados();
        for (DtoEstado category : categoryList) {
            ListEstado.add(new SelectItem(category.getIdEstado(), category.getNombre()));
        }
        setListaEstados(ListEstado);
    }

    public void initializaMunicipios() {
        Object masterValue = null;
        if (uiSelectEstado != null) {
            masterValue = uiSelectEstado.getValue();
        }
        ArrayList<SelectItem> ListMunicipio = new ArrayList<SelectItem>();
        DaoUbicacion daoUbicacion = new DaoUbicacion();
        int i = 1;
        if (masterValue != null) {
            i = Integer.parseInt(masterValue.toString());
            if (i <= 0) {
                i = 1;
            }
        }
        ArrayList<DtoMunicipio> categoryList = daoUbicacion.listarMunicipios(i);
        for (DtoMunicipio category : categoryList) {
            ListMunicipio.add(new SelectItem(category.getIdMunicipio(), category.getNombre()));
        }
        setListaMunicipios(ListMunicipio);
    }

    /**
     * @return the listaEstados
     */
    public ArrayList<SelectItem> getListaEstados() {
        if (listaEstados == null) {
            initializaEstados();
        }
        return listaEstados;
    }

    /**
     * @param listaEstados the listaEstados to set
     */
    public void setListaEstados(ArrayList<SelectItem> listaEstados) {
        this.listaEstados = listaEstados;
    }

    /**
     * @return the listaMunicipios
     */
    public ArrayList<SelectItem> getListaMunicipios() {
        if (listaMunicipios == null) {
            initializaMunicipios();
        }
        return listaMunicipios;
    }

    /**
     * @param listaMunicipios the listaMunicipios to set
     */
    public void setListaMunicipios(ArrayList<SelectItem> listaMunicipios) {
        this.listaMunicipios = listaMunicipios;
    }

    /**
     * @return the listaPerfiles
     */
    public ArrayList<SelectItem> getListaPerfiles() {
        return listaPerfiles;
    }

    /**
     * @param listaPerfiles the listaPerfiles to set
     */
    public void setListaPerfiles(ArrayList<SelectItem> listaPerfiles) {
        this.listaPerfiles = listaPerfiles;
    }

    /**
     * @return the listaUsuarios
     */
    public ArrayList<DtoUsuarios> getListaUsuarios() {
        return listaUsuarios;
    }

    /**
     * @param listaUsuarios the listaUsuarios to set
     */
    public void setListaUsuarios(ArrayList<DtoUsuarios> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
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
     * @return the usuarioSeleccionado
     */
    public DtoUsuarios getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    /**
     * @param usuarioSeleccionado the usuarioSeleccionado to set
     */
    public void setUsuarioSeleccionado(DtoUsuarios usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    /**
     * @return the usuario
     */
    public DtoUsuarios getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(DtoUsuarios usuario) {
        this.usuario = usuario;
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
     * @return the uiSelectEstado
     */
    public HtmlSelectOneMenu getUiSelectEstado() {
        return uiSelectEstado;
    }

    /**
     * @param uiSelectEstado the uiSelectEstado to set
     */
    public void setUiSelectEstado(HtmlSelectOneMenu uiSelectEstado) {
        this.uiSelectEstado = uiSelectEstado;
    }

    /**
     * @return the uiSelectMunicipio
     */
    public HtmlSelectOneMenu getUiSelectMunicipio() {
        return uiSelectMunicipio;
    }

    /**
     * @param uiSelectMunicipio the uiSelectMunicipio to set
     */
    public void setUiSelectMunicipio(HtmlSelectOneMenu uiSelectMunicipio) {
        this.uiSelectMunicipio = uiSelectMunicipio;
    }    
}
