/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDto;

/**
 *
 * @author ULISES.VIEYRA
 */
public class DtoTransaccionBD {

    private String mensajeAlert = "";
    private String classButton = "hidden";
    private String classDivContainer = "hidden";
    private String classDiv = "hidden";
    private boolean muestraMensaje = false;

    public DtoTransaccionBD() {
    }

    /**
     * @return the mensajeAlert
     */
    public String getMensajeAlert() {
        return mensajeAlert;
    }

    /**
     * @param mensajeAlert the mensajeAlert to set
     */
    public void setMensajeAlert(String mensajeAlert) {
        this.mensajeAlert = mensajeAlert;
    }

    /**
     * @return the classButton
     */
    public String getClassButton() {
        return classButton;
    }

    /**
     * @param classButton the classButton to set
     */
    public void setClassButton(String classButton) {
        this.classButton = classButton;
    }

    /**
     * @return the classDivContainer
     */
    public String getClassDivContainer() {
        return classDivContainer;
    }

    /**
     * @param classDivContainer the classDivContainer to set
     */
    public void setClassDivContainer(String classDivContainer) {
        this.classDivContainer = classDivContainer;
    }

    /**
     * @return the classDiv
     */
    public String getClassDiv() {
        return classDiv;
    }

    /**
     * @param classDiv the classDiv to set
     */
    public void setClassDiv(String classDiv) {
        this.classDiv = classDiv;
    }

    /**
     * @return the muestraMensaje
     */
    public boolean isMuestraMensaje() {
        return muestraMensaje;
    }

    /**
     * @param muestraMensaje the muestraMensaje to set
     */
    public void setMuestraMensaje(boolean muestraMensaje) {
        this.muestraMensaje = muestraMensaje;
    }

}
