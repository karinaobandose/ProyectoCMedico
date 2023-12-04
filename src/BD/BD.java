/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

/**
 *
 * @author emalo
 */
public class BD {

    private String driver;
    private String api;
    private String motor;
    private String servidor;
    private String baseD;
    private String usuario;
    private String contraseña;
    private String error;

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet datos;

    public BD(String driver, String api, String motor, String servidor, String baseD, String usuario, String contraseña) {
        this.driver = driver;
        this.api = api;
        this.motor = motor;
        this.servidor = servidor;
        this.baseD = baseD;
        this.usuario = usuario;
        this.contraseña = contraseña;
        if (!this.conectar()) {
            throw new NullPointerException();
        }

    }

    public String getBaseD() {
        return baseD;
    }

    public String getError() {
        return error;
    }

    private boolean conectar() {
        try {
            this.error = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexion = DriverManager.getConnection(this.api + ":" + this.motor + "://" + this.servidor + "/" + this.baseD, this.usuario, this.contraseña);
            return true;
        } catch (ClassNotFoundException ex) {
            this.error = ex.toString();
            System.out.print(error);
            return false;
        } catch (SQLException ex) {
            this.error = ex.toString();
            return false;
        }
    }

    public boolean prepararSentencia(String sql) {
        this.error = null;
        try {
            this.sentencia = this.conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            return true;
        } catch (SQLException ex) {
            this.error = ex.toString();
            return false;
        }
    }

    public Object[][] seleccionar(Object[] parametros) {
        this.error = null;
        try {
            this.cargar(parametros);
            this.datos = this.sentencia.executeQuery();
            return this.toArray(this.datos);
        } catch (SQLException ex) {
            this.error = ex.toString();
            return null;
        }
    }

    public boolean ejecutar(Object[] parametros) {
        this.error = null;
        try {
            cargar(parametros);
            return this.sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            this.error = ex.toString();
            return false;
        }
    }

    private void cargar(Object[] lista) throws SQLException {
        int i = 1;
        for (Object valor : lista) {
            if (valor instanceof Integer) {
                this.sentencia.setInt(i, (int) valor);
            }
            if (valor instanceof Double) {
                this.sentencia.setDouble(i, (double) valor);
            }
            if (valor instanceof String) {
                this.sentencia.setString(i, (String) valor);
            }
            if (valor instanceof Date) {
                this.sentencia.setDate(i, (Date) valor);
            }
            if (valor instanceof Time) {
                this.sentencia.setTime(i, (Time) valor);
            }
            i++;
        }

    }

    private Object[][] toArray(ResultSet rs) throws SQLException {
        rs.last();
        Object[][] datos = new Object[rs.getRow()][rs.getMetaData().getColumnCount()];
        rs.beforeFirst();
        int f = 0;
        while (rs.next()) {
            for (int c = 0; c < rs.getMetaData().getColumnCount(); c++) {
                datos[f][c] = rs.getObject(c + 1);
            }
            f++;
        }
        return datos;
    }

    public boolean eliminarRegistro(String tabla, String condicion, Object[] parametros) {
        this.error = null;
        try {
            String sql = "DELETE FROM " + tabla + " WHERE " + condicion;
            this.prepararSentencia(sql);
            cargar(parametros);
            return this.sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            this.error = ex.toString();
            return false;
        }
    }

    public boolean actualizarRegistro(String tabla, String setValues, String condicion, Object[] parametros) {
        this.error = null;
        try {
            String sql = "UPDATE " + tabla + " SET " + setValues + " WHERE " + condicion;
            this.prepararSentencia(sql);
            cargar(parametros);
            return this.sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            this.error = ex.toString();
            return false;
        }
    }

    public Object[][] Devolver() throws SQLException {
        ResultSet rs = this.datos;
        rs.last();
        Object[][] datos = new Object[rs.getRow()][rs.getMetaData().getColumnCount()];
        rs.beforeFirst();
        int f = 0;
        while (rs.next()) {
            for (int c = 0; c < rs.getMetaData().getColumnCount(); c++) {
                datos[f][c] = rs.getObject(c + 1);
            }
            f++;
        }
        return datos;
    }

    public Object[][] mostrarTodosRegistros(String tabla) {
        this.error = null;
        try {
            String sql = "SELECT * FROM " + tabla;
            this.prepararSentencia(sql);
            this.datos = this.sentencia.executeQuery();
            return this.toArray(this.datos);
        } catch (SQLException ex) {
            this.error = ex.toString();
            return null;
        }
    }

    public Object[] seleccionarUnRegistro(String tabla, String condicion, Object[] parametros) {
        this.error = null;
        try {
            String sql = "SELECT * FROM " + tabla + " WHERE " + condicion;
            this.prepararSentencia(sql);
            cargar(parametros);
            this.datos = this.sentencia.executeQuery();
            Object[][] resultado = this.toArray(this.datos);
            if (resultado != null && resultado.length > 0) {
                return resultado[0];
            } else {
                return null;
            }
        } catch (SQLException ex) {
            this.error = ex.toString();
            return null;
        }
    }

    public boolean insertarRegistro(String tabla, String columnas, String valores, Object[] parametros) {
        this.error = null;
        try {
            String sql = "INSERT INTO " + tabla + " (" + columnas + ") VALUES (" + valores + ")";
            this.prepararSentencia(sql);
            cargar(parametros);
            return this.sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            this.error = ex.toString();
            return false;
        }
    }
}
