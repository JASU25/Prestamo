package com.api.prestamos.Bo;


import com.api.prestamos.Catalago.CPrestamo;
import com.api.prestamos.Catalago.Lista.ListaPrestamo;
import com.api.prestamos.Dal.DPrestamo;

public class BPrestamo  {
public BPrestamo(){}

    public CPrestamo buscarPrestamo(CPrestamo data) throws Exception {
        DPrestamo dPrestamo = new DPrestamo();
        return dPrestamo.buscar(data);
    }

    public ListaPrestamo mostarPrestamo(CPrestamo data) throws Exception {
        DPrestamo dPrestamo = new DPrestamo();
        return dPrestamo.buscaLista(data);
    }

    public CPrestamo registPrestamo(CPrestamo data) throws Exception {
        DPrestamo dPrestamo = new DPrestamo();
        try {
           // data.setId(data.getIdUsuario());
            data.setInstance(true);
            data = dPrestamo.registro(data);
        } catch (Exception e) {
            //TODO: handle exception
            throw e;
        }
        return data;
    }

    public CPrestamo modificarPrestamo(CPrestamo data) throws Exception {
        DPrestamo dPerfil = new DPrestamo();
        return dPerfil.modificar(data);
    }
    public CPrestamo borrarPrestamo(CPrestamo data) throws Exception {
        DPrestamo dPerfil = new DPrestamo();
        return dPerfil.eliminiar(data);
    }
}