package com.api.prestamos.Catalago.Lista;

import com.api.prestamos.Catalago.CClientes;
import java.util.ArrayList;

public class ListaCliente {

    public ArrayList<CClientes> lista =null;

    public ListaCliente(){
        lista = new ArrayList<CClientes>();
    }
    
    public ArrayList<CClientes> getLista(){
        return lista;
    }

    public void setLista(ArrayList<CClientes> lista){
        this.lista = lista;
    }
    
}
