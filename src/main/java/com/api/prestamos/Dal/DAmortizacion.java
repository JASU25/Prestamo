package com.api.prestamos.Dal;

import com.api.prestamos.Catalago.CAmortizacion;
import com.api.prestamos.Catalago.Lista.ListaAmortizacion;
import com.api.prestamos.Dal.Modelo.MAmortizacion;

public class DAmortizacion extends MAmortizacion {

    public ListaAmortizacion buscaLista(CAmortizacion data) throws Exception {
        return super.selectTodo(data);
    }

    public CAmortizacion registro(CAmortizacion data)throws Exception{
        try {
            data.setInstanceBoolean(true);
            super.insertar(data);    
        } catch (Exception e) {
            throw e;
        }
        return data;
    }

    public CAmortizacion eliminiar(CAmortizacion data) throws Exception {
        try {
            super.Delete(data);
            data.setMensage("Borrado Correctamente ");
            
        } catch (Exception e) {
            //TODO: handle exception
            throw e;
        }
        return data;
    }
}
