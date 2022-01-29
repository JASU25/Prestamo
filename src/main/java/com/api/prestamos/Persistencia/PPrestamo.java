package com.api.prestamos.Persistencia;

public class PPrestamo {

        public String id = "idPrestamos";
        public String idCliente = "idCliente";
        public String idMonto = "idMonto";
        
        public final String DB = "prestamos";
        public final String Tabla = "prestamos";
        public final String Parametros =" idprestamos , idCliente , idMonto ";
        public final String Valores = "?,?,?";
    }