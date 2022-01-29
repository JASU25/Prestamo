package com.api.prestamos.Bo;

import com.api.prestamos.Catalago.CClientes;
import com.api.prestamos.Catalago.Lista.ListaCliente;
import com.api.prestamos.Dal.DCliente;

public class BClinete {
    public BClinete(){}
    public CClientes buscarCliente(CClientes data) throws Exception {
        DCliente dCliente = new DCliente();
        return dCliente.buscar(data);
    }

    public ListaCliente mostarCliente() throws Exception {
        DCliente dCliente = new DCliente();
        return dCliente.buscaLista();
    }

    public CClientes registClientes(CClientes data) throws Exception {
        DCliente dCliente = new DCliente();
        try {
           // data.setId(data.getIdUsuario());
            data.setInstance(true);
            if(buscarCliente(data).isInstanceSQLBoolean() == false ){
                data = dCliente.registro(data);
            }else {
                data.setError("Datos No Registrados");
                data.setMensage("no se encontro el usuario registrado verifique sus datos");
                data.setCodigoError(0001);
                
            }
        } catch (Exception e) {
            //TODO: handle exception
            throw e;
        }
        return data;
    }

    public CClientes modificarClientes(CClientes data) throws Exception {
        DCliente dCliente = new DCliente();
        return dCliente.modificar(data);
    }
    
    public CClientes borrarClientes(CClientes data) throws Exception {
        DCliente dCliente = new DCliente();
        return dCliente.eliminiar(data);
    }
    
}
