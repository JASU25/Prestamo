package com.api.prestamos.Persistencia;

public class InformacionBD {
    /*
    *@ Informacion de la bases de datos
    *@ Usuario , contraseña , base de datos ( BD)
    */
    public final String BD = "prestamos";
    public final String Url = "jdbc:mysql://localhost:3306/";
    // public final String Driver = "org.gjt.mm.mysql.Driver";
    public final String Driver= "com.mysql.jdbc.Driver";
    // public final String Driver= "ccom.mysql.cj.jdbc.Driver";
    public final String Usuario = "root";
    public final String Contrasena = "12345";
}
