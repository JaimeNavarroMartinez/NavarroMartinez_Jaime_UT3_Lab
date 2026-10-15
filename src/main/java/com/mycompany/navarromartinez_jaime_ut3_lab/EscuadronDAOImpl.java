/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.navarromartinez_jaime_ut3_lab;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jaime Navarro Martínez
 */
public class EscuadronDAOImpl implements EscuadronDAO {

    // Datos de conexión que utilizarán los métodos DAO
    private static final String URL = "jdbc:postgresql://localhost:5432/imperio_db";
    private static final String USER = "openpg";
    private static final String PASS = "openpgpwd";

    @Override
    public void inicializarTabla() {
        // Sentencia para crear la tabla si todavía no existe
        String sql = "CREATE TABLE IF NOT EXISTS escuadrones_imperiales ("
                + "id_escuadron VARCHAR(10) PRIMARY KEY, "
                + "nombre VARCHAR(100) NOT NULL, "
                + "sector_base VARCHAR(100) NOT NULL, "
                + "numero_cazas INT NOT NULL"
                + ");";

        // Abrimos la conexión y creamos el Statement
        try (Connection conexion = DriverManager.getConnection(URL, USER, PASS); Statement stmt = conexion.createStatement()) {

            // Ejecutamos la sentencia de creación
            stmt.execute(sql);

            System.out.println("Tabla creada o ya existente.");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    }

    @Override
    public void insertar(EscuadronDTO escuadron) {
        // Cada ? representa uno de los datos del escuadrón
        String sql = "INSERT INTO escuadrones_imperiales "
                + "(id_escuadron, nombre, sector_base, numero_cazas) "
                + "VALUES (?, ?, ?, ?);";

        // Abrimos la conexión y preparamos la sentencia
        try (Connection conexion = DriverManager.getConnection(URL, USER, PASS); PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            // Obtenemos los datos del objeto y los asignamos a los ?
            pstmt.setString(1, escuadron.getIdEscuadron());
            pstmt.setString(2, escuadron.getNombre());
            pstmt.setString(3, escuadron.getSectorBase());
            pstmt.setInt(4, escuadron.getNumeroCazas());

            // Ejecutamos el INSERT y recogemos las filas insertadas
            int filas = pstmt.executeUpdate();

            System.out.println("Escuadrones insertados: " + filas);

        } catch (SQLException e) {

            // Mostramos el motivo si falla la inserción
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    @Override
    public List<EscuadronDTO> obtenerDatos() {
        // Consultamos los cuatro campos de todos los escuadrones
        String sql = "SELECT id_escuadron, nombre, sector_base, numero_cazas "
                + "FROM escuadrones_imperiales;";

        // Lista donde guardaremos los objetos recuperados
        List<EscuadronDTO> escuadrones = new ArrayList<>();

        // Abrimos la conexión y preparamos la consulta
        try (Connection conexion = DriverManager.getConnection(URL, USER, PASS); PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            // Ejecutamos el SELECT y recogemos sus resultados
            try (ResultSet rs = pstmt.executeQuery()) {

                // Avanzamos fila a fila mientras queden resultados
                while (rs.next()) {

                    // Leemos los datos de la fila actual
                    String id = rs.getString("id_escuadron");
                    String nombre = rs.getString("nombre");
                    String sector = rs.getString("sector_base");
                    int cazas = rs.getInt("numero_cazas");

                    // Creamos un objeto con esos datos y lo añadimos a la lista
                    escuadrones.add(new EscuadronDTO(id, nombre, sector, cazas));
                }
            }

        } catch (SQLException e) {

            // Mostramos el motivo si falla la consulta
            System.out.println("Error al consultar: " + e.getMessage());
        }

        // Devolvemos la lista con los escuadrones encontrados
        return escuadrones;
    }
}
