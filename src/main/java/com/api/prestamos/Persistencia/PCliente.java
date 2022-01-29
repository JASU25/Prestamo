package com.api.prestamos.Persistencia;

public class PCliente {
   
    public String id = "idcliente";
    public String nombre = "nombre";
    
    public final String DB = "prestamos";
    public final String Tabla = "clientes";
    public final String Parametros =" idcliente , nombre ";
    public final String Valores = "?,?";

}
