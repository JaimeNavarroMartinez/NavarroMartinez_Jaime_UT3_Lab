/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.navarromartinez_jaime_ut3_lab;

/**
 *
 * @author Jaime Navarro Martínez
 */
public class EscuadronDTO {

    // Atributos privados proporcionados por el profesor
    private String idEscuadron;
    private String nombre;
    private String sectorBase;
    private int numeroCazas;

    // Constructor vacío 
    public EscuadronDTO() {
    }

    // Constructor para crear un escuadron con todos sus datos
    public EscuadronDTO(String idEscuadron, String nombre, String sectorBase, int numeroCazas) {
        this.idEscuadron = idEscuadron;
        this.nombre = nombre;
        this.sectorBase = sectorBase;
        this.numeroCazas = numeroCazas;
    }

    // Getters y setters
    /**
     * @return the idEscuadron
     */
    public String getIdEscuadron() {
        return idEscuadron;
    }

    /**
     * @param idEscuadron the idEscuadron to set
     */
    public void setIdEscuadron(String idEscuadron) {
        this.idEscuadron = idEscuadron;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the sectorBase
     */
    public String getSectorBase() {
        return sectorBase;
    }

    /**
     * @param sectorBase the sectorBase to set
     */
    public void setSectorBase(String sectorBase) {
        this.sectorBase = sectorBase;
    }

    /**
     * @return the numeroCazas
     */
    public int getNumeroCazas() {
        return numeroCazas;
    }

    /**
     * @param numeroCazas the numeroCazas to set
     */
    public void setNumeroCazas(int numeroCazas) {
        this.numeroCazas = numeroCazas;
    }

    // Texto que aparece al imprimir el objeto
    @Override
    public String toString() {
        return "ID: " + idEscuadron
                + " | Nombre: " + nombre
                + " | Sector base: " + sectorBase
                + " | Número de cazas: " + numeroCazas;
    }
}
