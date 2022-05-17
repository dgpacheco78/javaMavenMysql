package com.sic;

import java.sql.*;
//import com.sic.Conectadb;
import javax.swing.JOptionPane;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("mySQL");

        int id = 2;
        String nombre = "Alejandro", apellido = "Santiago", matricula = "4545898";

        ResultSet res;
        Conectadb accedeDb = new Conectadb();

        //accedeDb.setDato("INSERT INTO alumnos VALUES(" + id + ",'" + nombre + "','" + apellido + "','" + matricula + "');");
        //accedeDb.setDato("DELETE FROM alumnos WHERE id = " + id + ";");

        res = accedeDb.getDato("select * from alumnos;");
        try {
            while (res.next()) {
                System.out.println(
                        res.getInt(1) + "  " + res.getString(2) + "  " + res.getString(3) + " " + res.getString(4));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "De buscar: \n " + ex.toString());
        } finally {
            accedeDb.setCerrar();
        }
    }
}
