package com.api.prestamos.Bo;

import com.api.prestamos.Catalago.CMontos;
import com.api.prestamos.Catalago.Lista.ListaMonto;
import com.api.prestamos.Dal.DMonto;

public class BMonto {
    public BMonto(){}
    public CMontos buscarMonto(CMontos data) throws Exception {
        DMonto dCliente = new DMonto();
        return dCliente.buscar(data);
    }

    public ListaMonto mostarMonto() throws Exception {
        DMonto dMonto = new DMonto();
        return dMonto.buscaLista();
    }

    public CMontos registMonto(CMontos data) throws Exception {
        DMonto dMonto = new DMonto();
        try {
            data = dMonto.registro(data);  
            
        } catch (Exception e) {
            //TODO: handle exception
            throw e;
        }
        return data;
    }

    public CMontos modificarMonto(CMontos data) throws Exception {
        DMonto dMonto = new DMonto();
        return dMonto.modificar(data);
    }
    
    public CMontos borrarmonto(CMontos data) throws Exception {
        DMonto dMonto = new DMonto();
        return dMonto.eliminiar(data);
    }
}
