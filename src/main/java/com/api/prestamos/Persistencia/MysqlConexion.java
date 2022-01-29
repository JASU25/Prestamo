package com.api.prestamos.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConexion {

    public MysqlConexion() {
    }

    InformacionBD informacionBD = new InformacionBD();

    public Connection abri() throws SQLException, ClassNotFoundException {
        // create a mysql database connection
        String Driver = informacionBD.Driver;
        String Url = informacionBD.Url+informacionBD.BD;
        Class.forName(Driver);
        Connection conn = DriverManager.getConnection( Url , informacionBD.Usuario , informacionBD.Contrasena);
        return conn;
    }
}