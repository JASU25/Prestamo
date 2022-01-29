package com.api.prestamos.Dal;

import com.api.prestamos.Catalago.CMontos;
import com.api.prestamos.Catalago.Lista.ListaMonto;
import com.api.prestamos.Dal.Modelo.MMonto;

public class DMonto  extends MMonto {
    public CMontos buscar(CMontos data) throws Exception {
        data = super.selectUno(data); 
        if ( data.isInstanceSQLBoolean() == true ){
            data.setMensage("Bienvenido "+data.getId() );
        }else{
            data.setError("Datos no Encontrados");
            data.setMensage("Perfil no Existe");
        }
        return data;
    }

    public ListaMonto buscaLista() throws Exception {
        return super.selectTodo();
    }

    public CMontos registro(CMontos data)throws Exception{
        try {
            if(buscar(data).isInstanceSQLBoolean() == true){
                data.setError("exitente");
                data.setMensage("El Perfil ya existe elija otro Porfavor.");
            }else{
                super.insertar(data);
                data = buscar(data);
                data.setMensage("Registro Exitoso");
            }
        } catch (Exception e) {
            throw e;
        }
        return data;
    }
    public CMontos modificar(CMontos data) throws Exception {
        try {
            data.setInstanceBoolean(true);
            if( buscar(data).isInstanceSQLBoolean() == false ){
                data.setError("Datos No encontrado");
                data.setMensage("Perfil No encontrado o Imposible de modificar");
            }else{
                data = super.update(data);
                data.setMensage("Actualizado Correctamente ");
            }
        } catch (Exception e) {
            //TODO: handle exception
            throw e;
        }
        return data;
    }

    public CMontos eliminiar(CMontos data) throws Exception {
        try {
            if( buscar(data).isInstanceSQLBoolean() == false ){
                data.setError("Datos No encontrado");
                data.setMensage("Perfil No encontrado o Imposible de Borrar");
            }else{
                super.Delete(data);
                data = buscar(data);
                data.setMensage("Borrado Correctamente ");
            }
        } catch (Exception e) {
            //TODO: handle exception
            throw e;
        }
        return data;
    }
}
