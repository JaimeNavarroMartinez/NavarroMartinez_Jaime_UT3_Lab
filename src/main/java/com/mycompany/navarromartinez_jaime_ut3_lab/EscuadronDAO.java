/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.navarromartinez_jaime_ut3_lab;

import java.util.List;

/**
 *
 * @author Jaime Navarro Martínez
 */
public interface EscuadronDAO {
     // Crear la tabla si todavía no existe
    void inicializarTabla();
    
    // Insertar en la base de datos el escuadrón recibido
    void insertar(EscuadronDTO escuadron);
    
    // Devolver todos los escuadrones en una lista
    List<EscuadronDTO> obtenerDatos();
}
