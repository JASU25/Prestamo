package com.api.prestamos.Catalago;

import lombok.Data;
@Data//Decorador para get y set constructor 
public class CAmortizacion extends InstanceClass {

    private int idPrestamo ;
    private int iPago;
    private String sFecha;
    private int iPrestamo;
    private int iInteres;
    private int iAbono;
}