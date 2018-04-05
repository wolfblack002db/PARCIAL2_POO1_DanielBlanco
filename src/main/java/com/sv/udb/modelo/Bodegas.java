/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author Estudiante
 */
public class Bodegas {
    private int codiBode;
    private Piezas codiPiez; // la referencia -Llave foránea-
    private Proveedores codiProv; // la referencia -Llave foránea-
    private int cant;
    private String fecha;

    public Bodegas() {
    }

    public Bodegas(int codiBode, Piezas codiPiez, Proveedores codiProv, int cant, String fecha) {
        this.codiBode = codiBode;
        this.codiPiez = codiPiez;
        this.codiProv = codiProv;
        this.cant = cant;
        this.fecha = fecha;
    }

    public int getCodiBode() {
        return codiBode;
    }

    public void setCodiBode(int codiBode) {
        this.codiBode = codiBode;
    }

    public Piezas getCodiPiez() {
        return codiPiez;
    }

    public void setCodiPiez(Piezas codiPiez) {
        this.codiPiez = codiPiez;
    }

    public Proveedores getCodiProv() {
        return codiProv;
    }

    public void setCodiProv(Proveedores codiProv) {
        this.codiProv = codiProv;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return this.fecha; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
