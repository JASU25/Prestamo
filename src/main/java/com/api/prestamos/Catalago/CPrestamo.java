package com.api.prestamos.Catalago;

import lombok.Data;
@Data//Decorador para get y set constructor 
public class CPrestamo extends InstanceClass{

    private int id ;
    private int idCliente;
    private int idMonto;
}