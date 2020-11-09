/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ULISES.VIEYRA
 */
public class Fecha {

    private int dia;
    private int mes;
    private int anio;
    private String separador = "-";

    public Fecha(String valor) {
        String[] arrSplit = valor.split("-");
        setAnio(Integer.parseInt(arrSplit[0].toString()));
        setMes(Integer.parseInt(arrSplit[1].toString()));
        setDia(Integer.parseInt(arrSplit[2].toString()));
    }

    public Fecha(Date valor, boolean isNuevo) {
        if (isNuevo) {
            getDateToString(valor);
        }
    }

    private String getDateToString(Date valor) {
        String fecha = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(valor);
        String[] arrSplit = formattedDate.split("-");// rs.getString("ISSSTE").split("/");
        setAnio(Integer.parseInt(arrSplit[0].toString()));
        setMes(Integer.parseInt(arrSplit[1].toString()));
        setDia(Integer.parseInt(arrSplit[2].toString()));
        validaAjustarDia(Integer.parseInt(arrSplit[0].toString()), Integer.parseInt(arrSplit[1].toString()), Integer.parseInt(arrSplit[2].toString()));
        return getAnio() + getSeparador() + getDosDigitos(getMes()) + getSeparador() + getDosDigitos(getDia());
    }

    private String getDosDigitos(int valor) {
        return valor < 10 ? "0" + valor : String.valueOf(valor);
    }

    private void validaAjustarDia(int FechaAnio, int FechaMes, int FechaDia) {
        switch (FechaMes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: {
                if (FechaDia >= 31) {
                    setDia(1);
                    if (FechaMes == 12) {
                        setMes(1);
                        setAnio(FechaAnio + 1);
                    } else {
                        setMes(FechaMes + 1);
                    }
                } else {
                    setDia(FechaDia + 1);
                }
            }
            break;
            case 2:
            case 4:
            case 6:
            case 9:
            case 11: {
                if (FechaDia >= 30) {
                    setDia(1);
                    setMes(FechaMes + 1);
                } else {
                    setDia(FechaDia + 1);
                }

            }
            break;
        }
    }

    public String fechaFormateada() {
        return getAnio() + getSeparador() + getDosDigitos(getMes()) + getSeparador() + getDosDigitos(getDia());
    }

    /**
     * @return the separador
     */
    public String getSeparador() {
        return separador;
    }

    /**
     * @param separador the separador to set
     */
    public void setSeparador(String separador) {
        this.separador = separador;
    }

    /**
     * @return the dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return the anio
     */
    public int getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }
}
