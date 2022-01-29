package com.api.prestamos.Persistencia;

public class PAmortizacion {
    public String id = "idPrestamos";
    public String pago = "npago";
    public String fehca =  "fehca"; 
    public String prestamo =  "prestamo"; 
    public String interes =  "interes"; 
    public String abono =  "abono"; 


    
    public final String DB = "prestamos";
    public final String Tabla = "amortizacion";
    public final String Parametros =" idPrestamos , npago , fehca, prestamo, interes, abono";
    public final String ParametrosInsert ="idPrestamos , npago, fehca, prestamo, interes, abono ";
    public final String Valores = "?,?,?,?,?,?";
}
