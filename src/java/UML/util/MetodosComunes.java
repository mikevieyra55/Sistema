/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML.util;

import ModeloDto.DtoTransaccionBD;
import BancoDeMensajes.MensajesInformativos;

/**
 *
 * @author ULISES.VIEYRA
 */
public class MetodosComunes {

//    DtoTransaccionBD objetoTransaccion = new DtoTransaccionBD();
    public DtoTransaccionBD GuardarCorrecto() {
        DtoTransaccionBD objetoTransaccion = new DtoTransaccionBD();
        objetoTransaccion.setClassButton(MensajesInformativos.classButton);
        objetoTransaccion.setClassDiv(MensajesInformativos.classDivAlertSuccess);
        objetoTransaccion.setClassDivContainer(MensajesInformativos.classDivContainer);
        objetoTransaccion.setMensajeAlert(MensajesInformativos.GuardadoCorrecto);
        objetoTransaccion.setMuestraMensaje(true);
        return objetoTransaccion;

    }

    public DtoTransaccionBD GuardarError() {
        DtoTransaccionBD objetoTransaccion = new DtoTransaccionBD();
        objetoTransaccion.setClassButton(MensajesInformativos.classButton);
        objetoTransaccion.setClassDiv(MensajesInformativos.classDivAlertDanger);
        objetoTransaccion.setClassDivContainer(MensajesInformativos.classDivContainer);
        objetoTransaccion.setMensajeAlert(MensajesInformativos.GuardadoError);
        objetoTransaccion.setMuestraMensaje(true);
        return objetoTransaccion;
    }

    public DtoTransaccionBD ActualizarCorrecto() {
        DtoTransaccionBD objetoTransaccion = new DtoTransaccionBD();
        objetoTransaccion.setClassButton(MensajesInformativos.classButton);
        objetoTransaccion.setClassDiv(MensajesInformativos.classDivAlertSuccess);
        objetoTransaccion.setClassDivContainer(MensajesInformativos.classDivContainer);
        objetoTransaccion.setMensajeAlert(MensajesInformativos.ActualizadoCorrecto);
        objetoTransaccion.setMuestraMensaje(true);
        return objetoTransaccion;
    }

    public DtoTransaccionBD ActualizarError() {
        DtoTransaccionBD objetoTransaccion = new DtoTransaccionBD();
        objetoTransaccion.setClassButton(MensajesInformativos.classButton);
        objetoTransaccion.setClassDiv(MensajesInformativos.classDivAlertDanger);
        objetoTransaccion.setClassDivContainer(MensajesInformativos.classDivContainer);
        objetoTransaccion.setMensajeAlert(MensajesInformativos.ActualizadoError);
        objetoTransaccion.setMuestraMensaje(true);
        return objetoTransaccion;
    }

    public DtoTransaccionBD EliminarCorrecto() {
        DtoTransaccionBD objetoTransaccion = new DtoTransaccionBD();
        objetoTransaccion.setClassButton(MensajesInformativos.classButton);
        objetoTransaccion.setClassDiv(MensajesInformativos.classDivAlertSuccess);
        objetoTransaccion.setClassDivContainer(MensajesInformativos.classDivContainer);
        objetoTransaccion.setMensajeAlert(MensajesInformativos.EliminarCorrecto);
        objetoTransaccion.setMuestraMensaje(true);
        return objetoTransaccion;
    }

    public DtoTransaccionBD EliminarError() {
        DtoTransaccionBD objetoTransaccion = new DtoTransaccionBD();
        objetoTransaccion.setClassButton(MensajesInformativos.classButton);
        objetoTransaccion.setClassDiv(MensajesInformativos.classDivAlertDanger);
        objetoTransaccion.setClassDivContainer(MensajesInformativos.classDivContainer);
        objetoTransaccion.setMensajeAlert(MensajesInformativos.EliminarError);
        objetoTransaccion.setMuestraMensaje(true);
        return objetoTransaccion;
    }

    public DtoTransaccionBD ActivarCorrecto() {
        DtoTransaccionBD objetoTransaccion = new DtoTransaccionBD();
        objetoTransaccion.setClassButton(MensajesInformativos.classButton);
        objetoTransaccion.setClassDiv(MensajesInformativos.classDivAlertSuccess);
        objetoTransaccion.setClassDivContainer(MensajesInformativos.classDivContainer);
        objetoTransaccion.setMensajeAlert(MensajesInformativos.ActivarCorrecto);
        objetoTransaccion.setMuestraMensaje(true);
        return objetoTransaccion;
    }

    public DtoTransaccionBD ActivarError() {
        DtoTransaccionBD objetoTransaccion = new DtoTransaccionBD();
        objetoTransaccion.setClassButton(MensajesInformativos.classButton);
        objetoTransaccion.setClassDiv(MensajesInformativos.classDivAlertDanger);
        objetoTransaccion.setClassDivContainer(MensajesInformativos.classDivContainer);
        objetoTransaccion.setMensajeAlert(MensajesInformativos.ActivarError);
        objetoTransaccion.setMuestraMensaje(true);
        return objetoTransaccion;
    }

}
