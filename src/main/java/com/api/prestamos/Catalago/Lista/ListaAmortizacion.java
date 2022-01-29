package com.api.prestamos.Catalago.Lista;

import com.api.prestamos.Catalago.CAmortizacion;
import java.util.ArrayList;

public class ListaAmortizacion {
    public ArrayList<CAmortizacion> lista =null;

    public ListaAmortizacion(){
        lista = new ArrayList<CAmortizacion>();
    }
    
    public ArrayList<CAmortizacion> getLista(){
        return lista;
    }

    public void setLista(ArrayList<CAmortizacion> lista){
        this.lista = lista;
    }
}
