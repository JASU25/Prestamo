package com.api.prestamos.Catalago.Lista;

import com.api.prestamos.Catalago.CMontos;
import java.util.ArrayList;

public class ListaMonto {

    public ArrayList<CMontos> lista =null;

    public ListaMonto(){
        lista = new ArrayList<CMontos>();
    }
    
    public ArrayList<CMontos> getLista(){
        return lista;
    }

    public void setLista(ArrayList<CMontos> lista){
        this.lista = lista;
    }
}
