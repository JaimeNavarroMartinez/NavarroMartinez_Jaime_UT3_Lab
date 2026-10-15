/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.navarromartinez_jaime_ut3_lab;

/**
 *
 * @author Jaime Navarro Martínez
 */
public class HoloNet {

    public static void main(String[] args) {
        // Creamos el objeto que realizará las operaciones con PostgreSQL
        EscuadronDAO dao = new EscuadronDAOImpl();

        // Llamamos al método que crea la tabla si todavía no existe
        dao.inicializarTabla();

        /* Ya está guardado, lo dejo comentado para no insertalo de nuevo con el mismo id
        // Creamos un escuadron con sus cuatro datos, los 4 datos me los ha generado la IA
        EscuadronDTO escuadron = new EscuadronDTO("ESC-001", "Escuadrón Alfa", "Borde exterior", 12);

        // Enviamos el objeto al DAO para guardarlo en la tabla
        dao.insertar(escuadron);
        */
        
        for (EscuadronDTO escuadron : dao.obtenerDatos()) {
            System.out.println(escuadron);
        }
    }
}
