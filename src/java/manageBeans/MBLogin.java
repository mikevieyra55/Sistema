/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageBeans;

import ModeloDao.DaoLogin;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import ModeloDto.DtoUsuarios;
import Seguridad.SessionUtils;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


/**
 *
 * @author ULISES.VIEYRA
 */
@ManagedBean(name = "mbLogin")
@SessionScoped
public class MBLogin implements Serializable {

    private String usuario = "";
    private String password = "";
//    private Session Login;

    /**
     * Creates a new instance of MBLogin
     */
    public MBLogin() {
//        if (!FacesContext.getCurrentInstance().isPostback()) {
//            init();
//        }
    }

//    @PostConstruct
//    private void init() {
//
//    }

    public String validarUsuario() {
        String direccion = "";
        DtoUsuarios usuario = new DtoUsuarios();
        DaoLogin daoLogin = new DaoLogin();
        usuario = daoLogin.ValidarUsuario(getUsuario(), getPassword());
        if (usuario != null) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("usuarioLogueado", usuario);
            direccion = "Home";
        } else {
              FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            direccion = "Index";
        }

        return direccion;
    }

//    public String validateUsernamePassword() {
//        boolean valid = LoginDAO.validate(user, pwd);
//        if (valid) {
//            HttpSession session = SessionUtils.getSession();
//            session.setAttribute("username", user);
//            return "admin";
//        } else {
//            FacesContext.getCurrentInstance().addMessage(
//                    null,
//                    new FacesMessage(FacesMessage.SEVERITY_WARN,
//                            "Incorrect Username and Passowrd",
//                            "Please enter correct username and Password"));
//            return "login";
//        }
//    }

    //logout event, invalidate session
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "Index";
    }

//    public class SessionUtils {
//
//        public static HttpSession getSession() {
//            return (HttpSession) FacesContext.getCurrentInstance()
//                    .getExternalContext().getSession(false);
//        }
//
//        public static HttpServletRequest getRequest() {
//            return (HttpServletRequest) FacesContext.getCurrentInstance()
//                    .getExternalContext().getRequest();
//        }
//
//        public static String getUserName() {
//            HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
//                    .getExternalContext().getSession(false);
//            return session.getAttribute("username").toString();
//        }
//
//        public static String getUserId() {
//            HttpSession session = getSession();
//            if (session != null) {
//                return (String) session.getAttribute("userid");
//            } else {
//                return null;
//            }
//        }
//    }

//    public String logout() {
//        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//        return "login?faces-redirect=true";
//    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
