package com.api.prestamos.Bo;

import com.api.prestamos.Catalago.CAmortizacion;
import com.api.prestamos.Catalago.Lista.ListaAmortizacion;
import com.api.prestamos.Dal.DAmortizacion;

public class BAmortizacion {
    public BAmortizacion(){}

    public ListaAmortizacion mostarRegistros(CAmortizacion data) throws Exception {
        DAmortizacion dCliente = new DAmortizacion();
        return dCliente.buscaLista(data);
    }

    public CAmortizacion registAmortizacion(CAmortizacion data) throws Exception {
        DAmortizacion dCliente = new DAmortizacion();
        try {
            data = dCliente.registro(data);
        } catch (Exception e) {
            //TODO: handle exception
            throw e;
        }
        return data;
    }

    
    public CAmortizacion borraraAmortizacion(CAmortizacion data) throws Exception {
        DAmortizacion dCliente = new DAmortizacion();
        return dCliente.eliminiar(data);
    }
}
