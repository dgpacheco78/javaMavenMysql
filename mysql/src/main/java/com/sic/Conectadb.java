package com.sic;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conectadb {
    private final String driver = "com.mysql.cj.jdbc.Driver";// mysql
    private String url = "jdbc:mysql://localhost:3306/datos";// mysql local

    private String user;
    private String paswd;
    private Connection mysqlCon = null;
    private Statement stmt;
    private ResultSet res;

    public Conectadb() {
        //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datos", "siciot", "iot123");
        user = "siciot";
        paswd = "iot123";
    }

    public boolean setConexion() {
        try {
            Class.forName(driver);
            mysqlCon = DriverManager.getConnection(url, user, paswd);
            stmt = mysqlCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " ", "Conexión", 2);
            return false;
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, " ", "Del driver", 2);
            return false;
        }
        return true;
    }

    public Connection getConection() {
        return mysqlCon;
    }

    public void setDato(String sqlDato) {
        setConexion();
        try {
            stmt.execute(sqlDato);
            stmt.close();
            mysqlCon.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "1 ", "El método set", 2);
            Logger.getLogger(Conectadb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getDato(String sqlDato) {
        setConexion();
        try {
            res = stmt.executeQuery(sqlDato);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "2 ", "El método Get", 2);
            Logger.getLogger(Conectadb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public void setCerrar() {
        try {
            mysqlCon.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema tipo: \n " + ex.toString());
            Logger.getLogger(Conectadb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
