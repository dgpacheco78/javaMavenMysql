package com.sic;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("mySQL");
        //mostrar();
        //int id = 1;
        //String nombre = "David", apellido = "Garcia", matricula = "76554898";
        //insertar(id, nombre, apellido, matricula);
        //eliminar(3);
        mostrar();
    }

    public static void insertar(int id, String nombre, String apellido, String matricula) {
        try {
            // Llamada a la libreria mysql conector
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Nueva conexión conexión a localhost | nombre de bd | ususario mysql |
            // contraseña
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datos", "siciot", "iot123");
            // Nuevo statement para crear datos
            Statement stmt = con.createStatement();
            // Creación de Query | Insertar valores
            // Estos valores deben coincidir con los tipos de datos que se asignaron durante
            // la creación de la tabla
            stmt.executeUpdate("INSERT INTO alumnos VALUES("+ id +",'"+ nombre +"','"+ apellido +"','"+ matricula +"')");
            // Se cierra la conexión
            con.close();
        } catch (Exception e) {
            // Imprimir errores
            System.out.println(e);
        }
    }

    public static void eliminar(int id) {
        try {
            // Llamada a la libreria mysql conector
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Nueva conexión conexión a localhost | nombre de bd | ususario mysql |
            // contraseña
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datos", "siciot", "iot123");
            // Nuevo statement para eliminar datos
            PreparedStatement st = con.prepareStatement("DELETE FROM alumnos WHERE id = "+ id +";");
            // Ejecutar statement
            st.executeUpdate();
            // Se cierra la conexión
            con.close();
        } catch (Exception e) {
            // Imprimir errores
            System.out.println(e);
        }
    }

    public static void mostrar() {
        try {
            // Llamada a la libreria mysql conector
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Nueva conexión conexión a localhost | nombre de bd | ususario mysql |
            // contraseña
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datos", "siciot", "iot123");
            // Nuevo statement para llamada de datos
            Statement stmt = con.createStatement();
            // Creación de Query | llamada a todos los datos de la tabla alumnos
            ResultSet rs = stmt.executeQuery("select * from alumnos");
            // Ciclo de todos los elementos obtenidos por el query
            while (rs.next())
                // Impresión de los valores
                System.out.println(
                        rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + " " + rs.getString(4));
            // Se cierra la conexión
            con.close();
        } catch (Exception e) {
            // Imprimir errores
            System.out.println(e);
        }
    }
}
