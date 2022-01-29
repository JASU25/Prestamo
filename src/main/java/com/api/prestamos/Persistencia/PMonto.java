package com.api.prestamos.Persistencia;

public class PMonto {

    public String id = "idmontos";
    public String monto = "monto";
    public String plazo =  "plazo";   
    
    public final String DB = "prestamos";
    public final String Tabla = "montos";
    public final String Parametros =" idmontos , monto , plazo ";
    public final String ParametrosInsert ="  monto , plazo ";
    public final String Valores = "?,?";
    
}
