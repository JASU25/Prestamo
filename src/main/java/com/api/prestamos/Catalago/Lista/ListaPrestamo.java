package com.api.prestamos.Catalago.Lista;

import com.api.prestamos.Catalago.CPrestamo;
import java.util.ArrayList;

public class ListaPrestamo {

    public ArrayList<CPrestamo> lista =null;
    public ListaPrestamo(){
        lista = new ArrayList<CPrestamo>();
    }
    
    public ArrayList<CPrestamo> getLista(){
        return lista;
    }

    public void setLista(ArrayList<CPrestamo> lista){
        this.lista = lista;
    }
}